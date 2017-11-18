package com.jmm.www.change;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by dugaolong on 17/11/17.
 */

public class Utils {

    /**
     * 随机生成imei
     ****/
    public static String randomIMEI() {// calculator IMEI
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

    // IMEI码
    private static String getIMIEStatus(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        return deviceId;
    }

    // Mac地址
    private static String getLocalMac(Context context) {
        WifiManager wifi = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }

    // Android Id
    private static String getAndroidId(Context context) {
        String androidId = Settings.Secure.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }

    /**
     * hexiaodong
     * 将当前角色信息写到本地文件
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void serializeInfo(String jsonStr) throws FileNotFoundException, IOException {
        // ObjectOutputStream  对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
//        File dir = new File(context.getFilesDir().getAbsolutePath(), context.getPackageName());
        File dir = new File("/data/data/com.jmm.www.change/files/com.jmm.www.change");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, "info.txt");
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file));
        oo.writeObject(jsonStr);
        oo.close();
    }

    /**
     * 从本地文件读取imei
     *
     * @return
     * @throws Exception
     * @throws IOException
     */
    public static String deserializeInfoImei() throws Exception, IOException {
//        File dir = new File(context.getFilesDir().getAbsolutePath(), context.getPackageName());
        File dir = new File("/data/data/com.jmm.www.change/files/com.jmm.www.change");
        if (!dir.exists()) {
            Log.e("ddd","地址不存在");
            return null;
        } else {
            Log.e("ddd","地址存在");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(dir, "info.txt")));
            String str = (String) ois.readObject();
//            Info info = JSON.parseObject(str, Info.class);
//            return info.getImei();
            return str;
        }
    }

}
