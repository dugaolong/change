package com.jmm.www.change;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    public static final int REQUESTCODE_READ_PHONE_STATE = 1;

//    private EditText imeitx;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imeitx = ((EditText) findViewById(R.id.input));
        button = ((Button) findViewById(R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    /**
     * 使用Sharedpreferences保存数据
     */
    private void saveData() {
        Info info = SystemUtil.infoList.get(new Random().nextInt(100));
        try {
            SharedPreferences sh = this.getSharedPreferences("prefs", Context.MODE_WORLD_READABLE);
            SharedPreferences.Editor pre = sh.edit();

            pre.putString("imei", info.getImei());
            pre.putString("screenWidth", info.getScreenWidth());
            pre.putString("screenHeight", info.getScreenHeight());
            pre.putString("screenDensity", info.getScreenDensity());
            pre.putString("model", info.getModel());
            pre.putString("device", info.getDevice());
            pre.putString("androidVersion", info.getAndroidVersion());
            pre.putString("miuiVersion", info.getMiuiVersion());
            pre.putString("make", info.getMake());
            pre.putString("mac", info.getMac());
            pre.putString("language", info.getLanguage());
            pre.putString("country", info.getCountry());
            pre.putString("connectionType", info.getConnectionType());
            pre.putString("ip", info.getIp());
            pre.putString("androidId", info.getAndroidId());
            pre.putString("sdk_int", info.getSdk_int());
            pre.apply();
            Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            ((TextView) findViewById(R.id.info)).setText(getChangedInfo());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        ((TextView) findViewById(R.id.info)).setText(getDeviceInfo() + getSystemInfo());
        ((TextView) findViewById(R.id.info)).setText(getChangedInfo()+"1111"+getMac()+"\n"+
                "2222"+getLocalMacAddressFromWifiInfo(this)+"\n"+
                "3333"+getLocalMacAddressFromBusybox()+"\n"+
//                "4444"+getLocalMacAddressFromIp(this)+"\n"+
                "5555"+tryGetWifiMac(this)+"\n"+
                "6666"+getNewMac());
//        System.out.println(getDeviceInfo() + getSystemInfo());
//        this.printDeviceHardwareInfo();
//        this.printScreen();

//        for (int i = 0; i < 100; i++) {
//
////            SystemUtil.screenInfoList.get(i).getScreenWidth();
////            SystemUtil.screenInfoList.get(i).getScreenHeight();
////            SystemUtil.screenInfoList.get(i).getScreenDensity();
////            SystemUtil.phoneInfoList.get(i).getModel();
////            SystemUtil.phoneInfoList.get(i).getDevice();
////            SystemUtil.versionList.get(i).getVersion();
////            SystemUtil.phoneInfoList.get(i).getMiuiVersion();
////            SystemUtil.phoneInfoList.get(i).getMake();
////            SystemUtil.imeiList.get(i);
////            SystemUtil.macList.get(i);
////            SystemUtil.ipList.get(i);
////            SystemUtil.androididList.get(i);
////            SystemUtil.versionList.get(i).getSdkInt();
//            System.out.println("add(new Info(\""+SystemUtil.screenInfoList.get(i).getScreenWidth()+"\"," +
//                    "\""+SystemUtil.screenInfoList.get(i).getScreenHeight()+"\"," +
//                    "\""+SystemUtil.screenInfoList.get(i).getScreenDensity()+"\"," +
//                    "\""+SystemUtil.phoneInfoList.get(i).getModel()+"\"," +
//                    "\""+SystemUtil.phoneInfoList.get(i).getDevice()+"\"," +
//                    "\""+SystemUtil.versionList.get(i).getVersion()+"\"," +
//                    "\""+SystemUtil.phoneInfoList.get(i).getMiuiVersion()+"\"," +
//                    "\""+SystemUtil.phoneInfoList.get(i).getMake()+"\"," +
//                    "\""+SystemUtil.imeiList.get(i)+"\"," +
//                    "\""+SystemUtil.macList.get(i)+"\"," +
//                    "\"zh\"," +
//                    "\"CN\"," +
//                    "\"1\"," +
//                    "\""+SystemUtil.ipList.get(i)+"\"," +
//                    "\""+SystemUtil.androididList.get(i)+"\"," +
//                    "\""+SystemUtil.versionList.get(i).getSdkInt()+"\"));");
////            System.out.println("add(new Info(\"1080\",\"1920\",\"3.0\",\"MI 2S\",\"kenzo\",\"5.0.2LRX22G\",\"V8.2\",\"xiaomi\",
//// \"860847420878608\",\"00:24:7C:2C:A9:75\",\"zh\",\"CN\",\"1\",\"192.168.0.21\",\"d1b32108050901eb\",\"19\"));");
//        }

    }

    private String getChangedInfo() {
        StringBuffer sb = new StringBuffer();
        // 通过Resources获取
        DisplayMetrics dm2 = getResources().getDisplayMetrics();
        sb.append("heigth : " + dm2.heightPixels+ "\n");
        sb.append("width : " + dm2.widthPixels+ "\n");
        sb.append("density : " + dm2.density+ "\n");
        sb.append("版本MODEL：" + Build.MODEL + "\n");
        sb.append("设备参数DEVICE： " + Build.DEVICE + "\n");
        sb.append("Build.VERSION.RELEASE:androidVersion: " + Build.VERSION.RELEASE+ "\n");
        sb.append("Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT+ "\n");
        sb.append("Build.VERSION.INCREMENTAL:miuiVersion: " + Build.VERSION.INCREMENTAL+ "\n");
        sb.append("硬件制造商MANUFACTURER：make:" + Build.MANUFACTURER + "\n");
        sb.append("imei： " + SystemUtil.getIMEI(this) + "\n");
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        sb.append("MacAddress： " + info.getMacAddress() + "\n");
        sb.append("SystemLanguage： " + SystemUtil.getSystemLanguage() + "\n");
        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        sb.append("NetworkCountryIso：" + tm.getNetworkCountryIso()+ "\n");
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        sb.append("connectionType :" + networkInfo.getType()+ "\n");//范围1-17
        sb.append("IpAddress :" + info.getIpAddress()+ "\n");
        sb.append("Build.androidId: " + Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID)+ "\n");

        return sb.toString();
    }
    public static String getDeviceInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("主板BOARD： " + Build.BOARD + "\n");
        sb.append("系统启动程序版本号BOOTLOADER： " + Build.BOOTLOADER + "\n");
        sb.append("系统定制商BRAND：" + Build.BRAND + "\n");
        sb.append("cpu指令集CPU_ABI： " + Build.CPU_ABI + "\n");
        sb.append("cpu指令集2CPU_ABI2 " + Build.CPU_ABI2 + "\n");
        sb.append("设备参数DEVICE： " + Build.DEVICE + "\n");
        sb.append("显示屏参数DISPLAY：" + Build.DISPLAY + "\n");
        sb.append("无线电固件版本：" + Build.getRadioVersion() + "\n");
        sb.append("硬件识别码FINGERPRINT：" + Build.FINGERPRINT + "\n");
        sb.append("硬件名称HARDWARE：" + Build.HARDWARE + "\n");
        sb.append("HOST: " + Build.HOST + "\n");
        sb.append("修订版本列表ID：" + Build.ID + "\n");
        sb.append("硬件制造商MANUFACTURER：" + Build.MANUFACTURER + "\n");
        sb.append("版本MODEL：" + Build.MODEL + "\n");
        sb.append("硬件序列号SERIAL：" + Build.SERIAL + "\n");
        sb.append("手机制造商PRODUCT：" + Build.PRODUCT + "\n");
        sb.append("描述Build的标签TAGS：" + Build.TAGS + "\n");
        sb.append("TIME: " + Build.TIME + "\n");
        sb.append("builder类型TYPE：" + Build.TYPE + "\n");
        sb.append("USER: " + Build.USER + "\n");
        sb.append("FINGERPRINT: " + Build.FINGERPRINT + "\n");
        sb.append("Build.VERSION.INCREMENTAL: " + Build.VERSION.INCREMENTAL+ "\n");
        return sb.toString();
    }

    public void printDeviceHardwareInfo() {
        Log.d("zz", "---------------Build------------");
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String HTTP_PROXY = Settings.Secure.getString(getContentResolver(), Settings.Secure.HTTP_PROXY);
        Log.d("zz", "Build.HTTP_PROXY: " + HTTP_PROXY);
        Log.d("zz", "Build.androidId: " + androidId);
        Log.d("zz", "Build.BOARD: " + Build.BOARD);
        Log.d("zz", "Build.BOOTLOADER: " + Build.BOOTLOADER);
        Log.d("zz", "Build.BRAND: " + Build.BRAND);//设备牌子
        Log.d("zz", "Build.DEVICE: " + Build.DEVICE);//设备名
        Log.d("zz", "Build.DISPLAY: " + Build.DISPLAY);//显示设备号
        Log.d("zz", "Build.FINGERPRINT: " + Build.FINGERPRINT);//设备指纹
        Log.d("zz", "Build.HARDWARE: " + Build.HARDWARE);
        Log.d("zz", "Build.HOST: " + Build.HOST);
        Log.d("zz", "Build.ID: " + Build.ID);//设备硬件id
        Log.d("zz", "Build.MANUFACTURER: " + Build.MANUFACTURER);//厂商
        Log.d("zz", "Build.MODEL: " + Build.MODEL);//设备型号
        Log.d("zz", "Build.PRODUCT: " + Build.PRODUCT);//产品名，和DEVICE一样
        Log.d("zz", "Build.SERIAL: " + Build.SERIAL);//设备序列号
        Log.d("zz", "Build.TAGS: " + Build.TAGS);
        Log.d("zz", "Build.TYPE: " + Build.TYPE);
        Log.d("zz", "Build.UNKNOWN: " + Build.UNKNOWN);
        Log.d("zz", "Build.USER: " + Build.USER);
        Log.d("zz", "Build.CPU_ABI: " + Build.CPU_ABI);
        Log.d("zz", "Build.CPU_ABI2: " + Build.CPU_ABI2);
        Log.d("zz", "Build.RADIO: " + Build.RADIO);
        Log.d("zz", "Build.TIME: " + Build.TIME);//出厂时间
        Log.d("zz", "Build.VERSION.CODENAME: " + Build.VERSION.CODENAME);
        Log.d("zz", "Build.VERSION.INCREMENTAL: " + Build.VERSION.INCREMENTAL);//不详，重要
        Log.d("zz", "Build.VERSION.RELEASE: " + Build.VERSION.RELEASE);//系统版本号
        Log.d("zz", "Build.VERSION.SDK: " + Build.VERSION.SDK);//api级数
        Log.d("zz", "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);//api级数，int型返回
        Log.d("zz", "---------------Build------------");
        try {
            Class systemProperties = Class.forName("android.os.SystemProperties");
            Method get = systemProperties.getDeclaredMethod("get", String.class);
            String fingerprint = (String) get.invoke(null, "ro.build.fingerprint");
            Log.d("zz", "Fingerprint:" + fingerprint);
        } catch (Exception e) {

        }
    }


    public String getSystemInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("SystemLanguage： " + SystemUtil.getSystemLanguage() + "\n");
        sb.append("DeviceBrand： " + SystemUtil.getDeviceBrand() + "\n");
        sb.append("imei： " + SystemUtil.getIMEI(this) + "\n");
        sb.append("SystemModel： " + SystemUtil.getSystemModel() + "\n");
        sb.append("SystemVersion： " + SystemUtil.getSystemVersion() + "\n");
        return sb.toString();
    }


    public void printScreen() {
        // 通过WindowManager获取
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        System.out.println("heigth : " + dm.heightPixels);
        System.out.println("width : " + dm.widthPixels);
        // 通过Resources获取
        DisplayMetrics dm2 = getResources().getDisplayMetrics();
        System.out.println("heigth2 : " + dm2.heightPixels);
        System.out.println("width2 : " + dm2.widthPixels);
        // 获取屏幕的默认分辨率
        Display display = getWindowManager().getDefaultDisplay();
        System.out.println("width-display :" + display.getWidth());
        System.out.println("heigth-display :" + display.getHeight());

        float density = getResources().getDisplayMetrics().density;
        System.out.println("density :" + density);

        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        System.out.println("MacAddress :" + info.getMacAddress());
        int ipipip = info.getIpAddress();
        String ipip = intToIp(ipipip);
        System.out.println("IpAddress :" + ipip);//35104960--到--51882176
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        System.out.println("networkType :" + networkInfo.getType());//范围1-17
//        ConnectivityManager.TYPE_WIFI;
//        TelephonyManager.NETWORK_TYPE_LTE;
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)
            {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress())
                    {
                        System.out.println("Enumeration.IpAddress:" +  inetAddress.getHostAddress());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        System.out.println("CountryID--->>>" + Locale.getDefault().getCountry());
        System.out.println("Language()--->>>" + Locale.getDefault().getLanguage());
        System.out.println("NetworkCountryIso--->>>" + tm.getNetworkCountryIso());
        System.out.println("SimCountryIso--->>>" + tm.getSimCountryIso());
        System.out.println("SubscriberId--->>>" + tm.getSubscriberId());
        System.out.println("CPU_ABI--->>>" + android.os.Build.CPU_ABI);
//        getDeviceInfo2();

    }

    private String intToIp(int i) {
//        return (i & 0xFF ) + "." + ((i >> 8 ) & 0xFF) + "." + ((i >> 16 ) & 0xFF) + "." + ( i >> 24 & 0xFF) ;
        return (i >> 24 & 0xFF) + "." + ((i >> 16 ) & 0xFF) + "." +
                ((i >> 8 ) & 0xFF) + "." +  (i & 0xFF ) ;
    }

    /**
     * 通过反射获取所有的字段信息
     * @return
     */
    public String getDeviceInfo2(){
        StringBuilder sbBuilder = new StringBuilder();
        Field[] fields = Build.class.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            try {
                System.out.println("--->>"+field.getName()+":"+field.get(null).toString());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sbBuilder.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static String getMac() {
        String str = "";
        String macSerial = "";
        try {
            java.lang.Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (macSerial == null || "".equals(macSerial)) {
            try {
                return loadFileAsString("/sys/class/net/eth0/address")
                        .toUpperCase().substring(0, 17);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }
        return macSerial;
    }
    public static String loadFileAsString(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        String text = loadReaderAsString(reader);
        reader.close();
        return text;
    }
    public static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        int readLength = reader.read(buffer);
        while (readLength >= 0) {
            builder.append(buffer, 0, readLength);
            readLength = reader.read(buffer);
        }
        return builder.toString();
    }

    public static String getLocalMacAddressFromWifiInfo(Context context){
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }
    public static String getLocalMacAddressFromBusybox(){
        String result = "";
        String Mac = "";
        result = callCmd("busybox ifconfig","HWaddr");

        //如果返回的result == null，则说明网络不可取
        if(result==null){
            return "网络出错，请检查网络";
        }

        //对该行数据进行解析
        //例如：eth0      Link encap:Ethernet  HWaddr 00:16:E8:3E:DF:67
        if(result.length()>0 && result.contains("HWaddr")==true){
            Mac = result.substring(result.indexOf("HWaddr")+6, result.length()-1);
            Log.i("test","Mac:"+Mac+" Mac.length: "+Mac.length());
            result = Mac;
            Log.i("test",result+" result.length: "+result.length());
        }
        return result;
    }
    private static String callCmd(String cmd,String filter) {
        String result = "";
        String line = "";
        try {
            java.lang.Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader (is);

            //执行命令cmd，只取结果中含有filter的这一行
            while ((line = br.readLine ()) != null && line.contains(filter)== false) {
                //result += line;
                Log.i("test","line: "+line);
            }

            result = line;
            Log.i("test","result: "+result);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getLocalMacAddressFromIp(Context context) {
        String mac_s= "";
        try {
            byte[] mac;
            NetworkInterface ne=NetworkInterface.getByInetAddress(InetAddress.getByName(getLocalIpAddress()));
            mac = ne.getHardwareAddress();
            mac_s = byte2hex(mac);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mac_s;
    }

    public static  String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer(b.length);
        String stmp = "";
        int len = b.length;
        for (int n = 0; n < len; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs.append("0").append(stmp);
            else {
                hs = hs.append(stmp);
            }
        }
        return String.valueOf(hs);
    }
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("WifiPreferIpAddress:", ex.toString());
        }

        return null;
    }

    /**
     * 通过WiFiManager获取mac地址
     * @param context
     * @return
     */
    private static String tryGetWifiMac(Context context) {
        WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wi = wm.getConnectionInfo();
        if (wi == null || wi.getMacAddress() == null) {
            return null;
        }
        if ("02:00:00:00:00:00".equals(wi.getMacAddress().trim())) {
            return null;
        } else {
            return wi.getMacAddress().trim();
        }
    }

    /**
     * 通过网络接口取
     * @return
     */
    private static String getNewMac() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return null;
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    Log.i("getNewMac","b: "+b);
                    Log.i("getNewMac.format",String.format("%02X:", b));
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
