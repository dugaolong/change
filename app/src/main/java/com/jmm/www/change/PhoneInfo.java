package com.jmm.www.change;

/**
 * Created by dugaolong on 17/11/21.
 */

public class PhoneInfo {

    public String make;//xiaomi  厂商
    public String model;//Redmi Note 3   型号
    public String device;//kenzo
    public String androidVersion;//6.0.1
    public String miuiVersion;//V8.5.5.0.MHOCNED

    /**
     * 如果是 xiaomi   Build.VERSION.INCREMENTAL: V8.5.5.0.MHOCNED
     * oppo miuiVersion是 Build.VERSION.INCREMENTAL: eng.root.20160130.230736
     */

    public PhoneInfo() {
    }

    public PhoneInfo(String model, String device, String androidVersion, String miuiVersion, String make) {
        this.model = model;
        this.device = device;
        this.androidVersion = androidVersion;
        this.miuiVersion = miuiVersion;
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getMiuiVersion() {
        return miuiVersion;
    }

    public void setMiuiVersion(String miuiVersion) {
        this.miuiVersion = miuiVersion;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
