package com.jmm.www.change;

/**
 * Created by dugaolong on 17/11/17.
 */

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Tutorial implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        // 标记目标app包名
        if (!lpparam.packageName.equals("www.dugaolong.com.androidfive"))
            return;
        XposedBridge.log("Loaded app: " + lpparam.packageName);

        // Hook MainActivity中的isCorrectInfo(String,String)方法
        // findAndHookMethod(hook方法的类名，classLoader，hook方法名，hook方法参数...，XC_MethodHook)
        XposedHelpers.findAndHookMethod("www.dugaolong.com.androidfive.brage.BrageActivity", lpparam.classLoader, "getIMEI", Context.class,new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("开始hook:getIMEI");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("结束hook：getIMEI");

                    }
                });


    }
}