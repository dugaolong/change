package com.jmm.www.change;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by dugaolong on 17/11/17.
 */

public class Main implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        final XC_LoadPackage.LoadPackageParam lpp = loadPackageParam;
        hookImei(loadPackageParam, lpp);
    }

    public void hookImei(XC_LoadPackage.LoadPackageParam loadPackageParam, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            hook_method("android.telephony.TelephonyManager", loadPackageParam.classLoader, "getDeviceId" , new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("Load app: " + lpp.packageName);
                    XposedBridge.log("开始劫持了~");
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(randomIMEI());
                    XposedBridge.log("劫持结束了~");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void hook_method(String className, ClassLoader classLoader, String methodName,
                             Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
        } catch (Exception e) {
            XposedBridge.log(e);
        }
    }

    /**随机生成imei****/
    private static String randomIMEI() {// calculator IMEI
        int r1 = 1000000 + new java.util.Random().nextInt(9000000);
        int r2 = 1000000 + new java.util.Random().nextInt(9000000);
        String input1 = r1 + "" + r2;
        String input2 = input1.substring(2, 14);
        String input3 = "86" + input2;
        char[] ch = input3.toCharArray();
        int a = 0, b = 0;
        for (int i = 0; i < ch.length; i++) {
            int tt = Integer.parseInt(ch[i] + "");
            if (i % 2 == 0) {
                a = a + tt;
            } else {
                int temp = tt * 2;
                b = b + temp / 10 + temp % 10;
            }
        }
        int last = (a + b) % 10;
        if (last == 0) {
            last = 0;
        } else {
            last = 10 - last;
        }
        return input3 + last;
    }

    private void hook_methods(String className, String methodName, XC_MethodHook xc_methodHook) {
        try {
            Class<?> clazz = Class.forName(className);
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().equals(methodName)
                        &&!Modifier.isAbstract(method.getModifiers())
                        &&Modifier.isPublic(method.getModifiers())) {
                    XposedBridge.hookMethod(method,xc_methodHook);
                }
            }
        } catch (Exception e) {
            XposedBridge.log(e);
        }
    }
}
