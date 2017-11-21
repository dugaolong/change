package com.jmm.www.change;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by dugaolong on 17/11/21.
 */

public class IndexActivity extends Activity {

    private EditText imei, screenWidth, screenHeight, screenDensity, model, device, androidVersion, miuiVersion, make, mac, language, country, connectionType, ip, androidId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.index);
        initView();

        ((Button) findViewById(R.id.button_index)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomData();
            }
        });
    }

    private void initView() {
        imei= (EditText) findViewById(R.id.imei);
        screenWidth= (EditText) findViewById(R.id.screenWidth);
        screenHeight= (EditText) findViewById(R.id.screenHeight);
        screenDensity= (EditText) findViewById(R.id.screenDensity);
        model= (EditText) findViewById(R.id.model);
        device= (EditText) findViewById(R.id.device);
        androidVersion= (EditText) findViewById(R.id.androidVersion);
        miuiVersion= (EditText) findViewById(R.id.miuiVersion);
        make= (EditText) findViewById(R.id.make);
        mac= (EditText) findViewById(R.id.mac);
        language= (EditText) findViewById(R.id.language);
        country= (EditText) findViewById(R.id.country);
        connectionType= (EditText) findViewById(R.id.connectionType);
        ip= (EditText) findViewById(R.id.ip);
        androidId= (EditText) findViewById(R.id.androidId);
    }

    /**
     * 使用Sharedpreferences保存数据
     */
    private void randomData() {
        Info info = SystemUtil.infoList.get(new Random().nextInt(9)+1);
        imei.setText(info.getImei());
        screenWidth.setText(info.getScreenWidth());
        screenHeight.setText(info.getScreenHeight());
        screenDensity.setText(info.getScreenDensity());
        model.setText(info.getModel());
        device.setText(info.getDevice());
        androidVersion.setText(info.getAndroidVersion());
        miuiVersion.setText(info.getMiuiVersion());
        make.setText(info.getMake());
        mac.setText(info.getMac());
        language.setText(info.getLanguage());
        country.setText(info.getCountry());
        connectionType.setText(info.getConnectionType());
        ip.setText(info.getIp());
        androidId.setText(info.getAndroidId());
        try {
            SharedPreferences sh = this.getSharedPreferences("prefs", Context.MODE_WORLD_READABLE);
            SharedPreferences.Editor pre = sh.edit();
            pre.putString("imei", info.getImei());
            pre.putString("screenWidth", info.getImei());
            pre.putString("screenHeight", info.getScreenWidth());
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
            pre.apply();
            Toast.makeText(IndexActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
