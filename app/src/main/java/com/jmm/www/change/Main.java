package com.jmm.www.change;

import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by dugaolong on 17/11/17.
 */

public class Main implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        //获得Sharedpreference保存的数据
        XSharedPreferences pre = new XSharedPreferences(this.getClass()
                .getPackage().getName(), "prefs");
        HookMethod(TelephonyManager.class, "getDeviceId",
                pre.getString("imei", null));
        String imei = pre.getString("imei", null);
        Log.d("pre", "handleLoadPackage() returned: " + imei);
//        final XC_LoadPackage.LoadPackageParam lpp = loadPackageParam;
//        hookImei(loadPackageParam, lpp);
//        hook(loadPackageParam, lpp);
    }

    private void HookMethod(final Class cl, final String method,
                            final String result) {
        try {
            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param)
                        throws Throwable {
                    param.setResult(result);
                }

            }});
        } catch (Throwable e) {
        }
    }

    public void hookImei(XC_LoadPackage.LoadPackageParam loadPackageParam, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            hook_method("android.telephony.TelephonyManager", loadPackageParam.classLoader, "getDeviceId", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("进入方法了~");
                    XposedBridge.log("Load app: " + lpp.packageName);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("it get IMEI：" + param.getResult());
//                    String imei = getSp();
                    String imei = Utils.deserializeInfoImei();
                    param.setResult(imei);
                    XposedBridge.log("change IMEI：" + imei);
                    XposedBridge.log("劫持结束了~");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSp() {
        String sp = "";
        try {
            XposedBridge.log("pkgname:" + this.getClass().getPackage().getName());
            XSharedPreferences xSharedPreferences = new XSharedPreferences(this.getClass().getPackage().getName());
            sp = xSharedPreferences.getString("imei", "861112288888888");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    private void hook_method(String className, ClassLoader classLoader, String methodName,
                             Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
        } catch (Exception e) {
            XposedBridge.log(e);
        }
    }


    private void hook_methods(String className, String methodName, XC_MethodHook xc_methodHook) {
        try {
            Class<?> clazz = Class.forName(className);
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().equals(methodName)
                        && !Modifier.isAbstract(method.getModifiers())
                        && Modifier.isPublic(method.getModifiers())) {
                    XposedBridge.hookMethod(method, xc_methodHook);
                }
            }
        } catch (Exception e) {
            XposedBridge.log(e);
        }
    }
}
