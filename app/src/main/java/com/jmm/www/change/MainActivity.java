package com.jmm.www.change;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final int REQUESTCODE_READ_PHONE_STATE = 1;

    private EditText imeitx;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imeitx = ((EditText)findViewById(R.id.input));
        button = ((Button)findViewById(R.id.button));
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
    private void saveData(){
        try {
            SharedPreferences sh = this.getSharedPreferences("prefs", Context.MODE_WORLD_READABLE);
            SharedPreferences.Editor pre = sh.edit();
            pre.putString("imei",imeitx.getText().toString());
            pre.apply();
            Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((TextView)findViewById(R.id.info)).setText(getDeviceInfo()+getSystemInfo());
        this.printDeviceHardwareInfo();
    }
    public static String getDeviceInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("主板： "+ Build.BOARD+"\n");
        sb.append("系统启动程序版本号： " + Build.BOOTLOADER+"\n");
        sb.append("系统定制商：" + Build.BRAND+"\n");
        sb.append("cpu指令集： " + Build.CPU_ABI+"\n");
        sb.append("cpu指令集2 "+ Build.CPU_ABI2+"\n");
        sb.append("设置参数： "+ Build.DEVICE+"\n");
        sb.append("显示屏参数：" + Build.DISPLAY+"\n");
        sb.append("无线电固件版本：" + Build.getRadioVersion()+"\n");
        sb.append("硬件识别码：" + Build.FINGERPRINT+"\n");
        sb.append("硬件名称：" + Build.HARDWARE+"\n");
        sb.append("HOST: " + Build.HOST+"\n");
        sb.append("修订版本列表：" + Build.ID+"\n");
        sb.append("硬件制造商：" + Build.MANUFACTURER+"\n");
        sb.append("版本：" + Build.MODEL+"\n");
        sb.append("硬件序列号：" + Build.SERIAL+"\n");
        sb.append("手机制造商：" + Build.PRODUCT+"\n");
        sb.append("描述Build的标签：" + Build.TAGS+"\n");
        sb.append("TIME: " + Build.TIME+"\n");
        sb.append("builder类型：" + Build.TYPE+"\n");
        sb.append("USER: " + Build.USER+"\n");
        return sb.toString();
    }

    public void printDeviceHardwareInfo(){
        Log.d("zz", "---------------Build------------");
        Log.d("zz", "Build.BOARD: "+Build.BOARD);
        Log.d("zz", "Build.BOOTLOADER: "+Build.BOOTLOADER);
        Log.d("zz", "Build.BRAND: "+Build.BRAND);//设备牌子
        Log.d("zz", "Build.DEVICE: "+Build.DEVICE);//设备名
        Log.d("zz", "Build.DISPLAY: "+Build.DISPLAY);//显示设备号
        Log.d("zz", "Build.FINGERPRINT: "+Build.FINGERPRINT);//设备指纹
        Log.d("zz", "Build.HARDWARE: "+Build.HARDWARE);
        Log.d("zz", "Build.HOST: "+Build.HOST);
        Log.d("zz", "Build.ID: "+Build.ID);//设备硬件id
        Log.d("zz", "Build.MANUFACTURER: "+Build.MANUFACTURER);//厂商
        Log.d("zz", "Build.MODEL: "+Build.MODEL);//设备型号
        Log.d("zz", "Build.PRODUCT: "+Build.PRODUCT);//产品名，和DEVICE一样
        Log.d("zz", "Build.SERIAL: "+Build.SERIAL);//设备序列号
        Log.d("zz", "Build.TAGS: "+Build.TAGS);
        Log.d("zz", "Build.TYPE: "+Build.TYPE);
        Log.d("zz", "Build.UNKNOWN: "+Build.UNKNOWN);
        Log.d("zz", "Build.USER: "+Build.USER);
        Log.d("zz", "Build.CPU_ABI: "+Build.CPU_ABI);
        Log.d("zz", "Build.CPU_ABI2: "+Build.CPU_ABI2);
        Log.d("zz", "Build.RADIO: "+Build.RADIO);
        Log.d("zz", "Build.TIME: "+Build.TIME);//出厂时间
        Log.d("zz", "Build.VERSION.CODENAME: "+Build.VERSION.CODENAME);
        Log.d("zz", "Build.VERSION.INCREMENTAL: "+Build.VERSION.INCREMENTAL);//不详，重要
        Log.d("zz", "Build.VERSION.RELEASE: "+Build.VERSION.RELEASE);//系统版本号
        Log.d("zz", "Build.VERSION.SDK: "+Build.VERSION.SDK);//api级数
        Log.d("zz", "Build.VERSION.SDK_INT: "+Build.VERSION.SDK_INT);//api级数，int型返回
        Log.d("zz", "---------------Build------------");
        try{
            Class systemProperties=Class.forName("android.os.SystemProperties");
            Method get=systemProperties.getDeclaredMethod("get", String.class);
            String fingerprint=(String)get.invoke(null, "ro.build.fingerprint");
            Log.d("zz", "Fingerprint:"+fingerprint);
        }catch (Exception e){

        }
    }




    public String getSystemInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("SystemLanguage： "+ SystemUtil.getSystemLanguage()+"\n");
        sb.append("DeviceBrand： "+ SystemUtil.getDeviceBrand()+"\n");
        sb.append("imei： "+ SystemUtil.getIMEI(this)+"\n");
        sb.append("SystemModel： "+ SystemUtil.getSystemModel()+"\n");
        sb.append("SystemVersion： "+ SystemUtil.getSystemVersion()+"\n");
        return sb.toString();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (requestCode == REQUESTCODE_READ_PHONE_STATE) {
                    if(grantResults.length>0){
                        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            // Permission Granted
//                        Toast.makeText(this,"You Granted the permission",Toast.LENGTH_LONG).show();
                        } else {
                            // Permission Denied
//                        Toast.makeText(this,"You denied the permission",Toast.LENGTH_LONG).show();
                            Toast.makeText(this,"您禁止了DUQU权限!",Toast.LENGTH_LONG).show();
                        }
                    }

                }
                break;
            default:
        }
    }

}
