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
    public String screenWidth;//1080
    public String screenHeight;//1920
    public String screenDensity;//3.0
    public String model;//Redmi Note 3   型号
    public String device;//kenzo
    public String androidVersion;//6.0.1
    public String miuiVersion;//V8.5.5.0.MHOCNED
    public String make;//xiaomi  厂商
    public String imei;//da6fc986c0ecbb4530f746c5c6d22d36
    public String mac;//A35C496B735A30C69F880E179F1BC457
    public String language;//zh
    public String country;//CN
    public String connectionType;//wifi
    public String ip;//192.168.170.12
    public String androidId;//d1b32108050901eb
    public String sdk_int;//19

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        try {
            final XC_LoadPackage.LoadPackageParam lpp = loadPackageParam;
            XposedBridge.log("packageName: " + lpp.processName);
            if (lpp.packageName.equals("com.jmm.www.calendar") || lpp.packageName.equals("com.jmm.www.change")
                    || lpp.packageName.equals("com.gtr.system.information.activity")) {
                //获得Sharedpreference保存的数据
                XSharedPreferences pre = new XSharedPreferences(this.getClass().getPackage().getName(), "prefs");
                imei = pre.getString("imei", "");
                screenWidth = pre.getString("screenWidth", "");
                screenHeight = pre.getString("screenHeight", "");
                screenDensity = pre.getString("screenDensity", "");
                model = pre.getString("model", "");
                device = pre.getString("device", "");
                androidVersion = pre.getString("androidVersion", "");
                miuiVersion = pre.getString("miuiVersion", "");
                make = pre.getString("make", "");
                mac = pre.getString("mac", "");
                language = pre.getString("language", "");
                country = pre.getString("country", "");
                connectionType = pre.getString("connectionType", "");
                ip = pre.getString("ip", "");
                androidId = pre.getString("androidId", "");
                sdk_int = pre.getString("sdk_int", "");
                XposedBridge.log("info: " +"\n" + imei
                        +"\n" + screenWidth
                        +"\n" + screenHeight
                        +"\n" + screenDensity
                        +"\n" + model
                        +"\n" + device
                        +"\n" + androidVersion
                        +"\n" + miuiVersion
                        +"\n" + make
                        +"\n" + mac
                        +"\n" + language
                        +"\n" + country
                        +"\n" + connectionType
                        +"\n" + ip
                        +"\n" + androidId
                        +"\n" + sdk_int);

                HookMethod(TelephonyManager.class, "getDeviceId", lpp);
                HookMethodNetworkCountryIso(TelephonyManager.class, "getNetworkCountryIso", lpp);
                HookMethodCountry(Locale.class, "getCountry", lpp);
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

//                XposedHelpers.setStaticObjectField(android.os.Build.class, "HARDWARE", "qcom");//设备硬件名称
                XposedHelpers.setStaticObjectField(android.os.Build.class, "MANUFACTURER", make);//设备制造商
                XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", make);
                XposedHelpers.setStaticObjectField(android.os.Build.class, "DEVICE", device);
                XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", model);//设备型号
                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "INCREMENTAL", miuiVersion);
                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "RELEASE",androidVersion);
                XposedHelpers.setStaticObjectField(android.os.Build.VERSION.class, "SDK_INT", sdk_int);
                XposedHelpers.setStaticObjectField(android.os.Build.class, "CPU_ABI", "arm64-v8a,armeabi-v7a,armeabi");
//                Log.d("pre", "handleLoadPackage() returned: " + imei);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void HookMethod(final Class cl, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {

            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    if (method.equals("getDeviceId")) {
                        param.setResult(imei);
                    }
                    if (method.equals("getLanguage")) {
                        param.setResult(language);
                    }
                    XposedBridge.log("此方法返回的结果: " + param.getResult());
                }
            }});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodNetworkCountryIso(final Class cl, final String method , final XC_LoadPackage.LoadPackageParam lpp) {
        try {

            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(country);
                    XposedBridge.log("NetworkCountryIso的结果: " + param.getResult());
                }
            }});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private void HookMethodCountry(final Class cl, final String method, final XC_LoadPackage.LoadPackageParam lpp) {
        try {

            XposedHelpers.findAndHookMethod(cl, method, new Object[]{new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("HookMethodCountry的结果: " + param.getResult());
                    param.setResult(country);
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
                        param.setResult(androidId);
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
                    dm.heightPixels = Integer.parseInt(screenHeight) ;
                    dm.widthPixels = Integer.parseInt(screenWidth);
                    dm.density = Float.parseFloat(screenDensity);
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
                    XposedBridge.log("mac:"+param.getResult());
                    param.setResult(mac);
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
                    XposedBridge.log("ip:"+param.getResult());
                    param.setResult(ipToInt(ip));
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
                    XposedBridge.log("ip:"+param.getResult());
                    param.setResult(ip);
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
                    param.setResult(country);
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
                    XposedBridge.log("connectionType:"+param.getResult());
                    param.setResult(Integer.parseInt(connectionType));
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
