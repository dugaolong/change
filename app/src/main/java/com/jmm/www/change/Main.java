package com.jmm.www.change;

import android.telephony.TelephonyManager;
import android.util.Log;

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
        final XC_LoadPackage.LoadPackageParam lpp = loadPackageParam;
        //获得Sharedpreference保存的数据
        XSharedPreferences pre = new XSharedPreferences(this.getClass().getPackage().getName(), "prefs");
        String imei = pre.getString("imei", "860847420878608");
        HookMethod(TelephonyManager.class, "getDeviceId", imei,lpp);
        Log.d("pre", "handleLoadPackage() returned: " + imei);
    }

    private void HookMethod(final Class cl, final String method, final String result,final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedBridge.log("拦截的app名称: " + lpp.packageName);
            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(result);
                    XposedBridge.log("修改后的IMEI：" + result);
                }
            }});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
