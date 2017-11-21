package com.jmm.www.change;

import android.content.ContentResolver;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.util.Locale;

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

    public static String meth;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        try {
            final XC_LoadPackage.LoadPackageParam lpp = loadPackageParam;
            XposedBridge.log("packageName: " + lpp.processName);
            if (lpp.packageName.equals("com.jmm.www.calendar") || lpp.packageName.equals("com.jmm.www.change")
                    || lpp.packageName.equals("com.gtr.system.information.activity")) {
                //获得Sharedpreference保存的数据
                XSharedPreferences pre = new XSharedPreferences(this.getClass().getPackage().getName(), "prefs");
                String imei = pre.getString("imei", "860847420878608");
                HookMethod(TelephonyManager.class, "getDeviceId", imei, lpp);
                HookMethodNetworkCountryIso(TelephonyManager.class, "getNetworkCountryIso", imei, lpp);
                HookMethodCountry(Locale.class, "getCountry", imei, lpp);
                HookMethodSettings("android.provider.Settings.Secure", "getString", lpp);
//                HookMethodDisplayWidth("android.view.Display", "getWidth", lpp);
//                HookMethodDisplayHeight("android.view.Display", "getHeight", lpp);
                HookMethodDisplayMetrics("android.content.res.Resources", "getDisplayMetrics", lpp);
//                HookMethodDisplayGetMetrics("android.view.Display", "getMetrics", lpp);
                HookMethodMacAddress("android.net.wifi.WifiInfo", "getMacAddress", lpp);
//                HookMethodIpAddress("android.net.wifi.WifiInfo", "getIpAddress", lpp);
                HookMethodHostAddress("java.net.InetAddress", "getHostAddress", lpp);
                HookMethodSimCountryIso("android.telephony.TelephonyManager", "getSimCountryIso", lpp);
                HookMethodConnectionType("android.net.NetworkInfo", "getType", lpp);

                XposedHelpers.setStaticObjectField(android.os.Build.class, "HARDWARE", "qcom");//设备硬件名称
                XposedHelpers.setStaticObjectField(android.os.Build.class, "MANUFACTURER", "Xiaomi");//设备制造商
                XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", "Xiaomi");
                XposedHelpers.setStaticObjectField(android.os.Build.class, "DEVICE", "kenzo");
                XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "MI 2S");//设备型号
                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "INCREMENTAL", "V8.2");
                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE", "5.0.2LRX22G");
                XposedHelpers.setStaticObjectField(android.os.Build.class, "CPU_ABI", "arm64-v8a,armeabi-v7a,armeabi");
//                Log.d("pre", "handleLoadPackage() returned: " + imei);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void HookMethod(final Class cl, final String method, final String result, final XC_LoadPackage.LoadPackageParam lpp) {
        try {

            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    if (method.equals("getDeviceId")) {
                        param.setResult("860847420878608");
                    }
                    if (method.equals("getLanguage")) {
                        param.setResult("zh");
                    }
                    XposedBridge.log("此方法返回的结果: " + param.getResult());
                }
            }});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodNetworkCountryIso(final Class cl, final String method, final String result, final XC_LoadPackage.LoadPackageParam lpp) {
        try {

            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult("CN");
                    XposedBridge.log("NetworkCountryIso的结果: " + param.getResult());
                }
            }});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodCountry(final Class cl, final String method, final String result, final XC_LoadPackage.LoadPackageParam lpp) {
        try {

            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("HookMethodCountry的结果: " + param.getResult());
                    param.setResult("CN");
                    XposedBridge.log("HookMethodCountry的结果: " + param.getResult());
                }
            }});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void HookMethodSettings(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, ContentResolver.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("拦截的方法名称: " + method);
                    XposedBridge.log("getString的第二个参数: " + param.args[1]);
                    if (param.args[1].equals("android_id")) {//ANDROID_ID
                        meth = "android_id";
                    }
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    if (meth.equals("android_id")) {
                        param.setResult("d6c4079d52554c09");
                    }
                    meth = "";
                    XposedBridge.log("此方法返回的结果: " + param.getResult());
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void HookMethodDisplayWidth(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult((Integer) 1080);
                    XposedBridge.log("此方法返回的结果: " + param.getResult());
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void HookMethodDisplayHeight(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult((Integer) 1920);
//                    param.args[0]=1920;
                    XposedBridge.log("此方法返回的结果: " + param.getResult());
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void HookMethodDisplayMetrics(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    DisplayMetrics dm = new DisplayMetrics();
                    dm.heightPixels = 1920;
                    dm.widthPixels = 1080;
                    dm.density = 3.0f;
                    param.setResult((DisplayMetrics) dm);
//                    param.args[0]=1920;
//                    XposedBridge.log("此方法返回的结果: " + param.getResult());
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void HookMethodDisplayGetMetrics(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, DisplayMetrics.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    DisplayMetrics dm = new DisplayMetrics();
                    dm.heightPixels = 1920;
                    dm.widthPixels = 1080;
                    param.setResult(dm);
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodMacAddress(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult("00:24:7C:2C:A9:75");
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodIpAddress(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    //35104960=193.168.23.2
                    //51882176=192.168.23.3
                    XposedBridge.log("ipAddress string:192.168.100.203");
                    XposedBridge.log("ipAddress int:"+ipToInt("192.168.100.203"));
                    param.setResult(ipToInt("192.168.100.203"));
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodHostAddress(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("Enumeration.ipAddress string:192.168.0.21");
                    param.setResult("192.168.0.21");
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodSimCountryIso(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("SimCountryIso:"+param.getResult());
                    param.setResult("CN");
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodConnectionType(final String className, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {
            XposedHelpers.findAndHookMethod(className, lpp.classLoader, method, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult((Integer)1);
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static int ipToInt(String ip) {
        String[] ips = ip.split("\\.");
        return (Integer.parseInt(ips[0]) << 24) + (Integer.parseInt(ips[1]) << 16)
                + (Integer.parseInt(ips[2]) << 8) + Integer.parseInt(ips[3]);
//        return Integer.parseInt(ips[0] +(Integer.parseInt(ips[1]) << 8)+
//                (Integer.parseInt(ips[2]) << 16)+(Integer.parseInt(ips[3]) << 24));
    }

    /**
     * 第一次的历史
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "BOARD", "msm8952");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "BOOTLOADER", "unknown");
     XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", "Xiaomi");
     XposedHelpers.setStaticObjectField(android.os.Build.class, "DEVICE", "");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "DISPLAY", "MMB29M");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "FINGERPRINT", "Xiaomi/kenzo/kenzo:6.0.1/MMB29M/V8.5.5.0.MHOCNED:user/release-keys");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "HARDWARE", "qcom");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "HOST", "c3-miui-ota-bd74.bj");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "ID", "MMB29M");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "MANUFACTURER", "Xiaomi");
     XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "Redmi Note 3");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "PRODUCT", "kenzo");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "SERIAL", "1fa92116");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "TAGS", "release-keys");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "TYPE", "user");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "UNKNOWN", "unknown");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "USER", "builder");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "CPU_ABI", "arm64-v8a");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "CPU_ABI2", "armeabi-v7a");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "RADIO", "unknown");
     //                XposedHelpers.setStaticObjectField(android.os.Build.class, "TIME", 1503638322);
     //                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "CODENAME", "REL");
     XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "INCREMENTAL", "V8.5.5.0.MHOCNED");
     XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE", "6.0.1");
     //                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "SDK", "23");
     //                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "SDK_INT", 23);

     */
}
