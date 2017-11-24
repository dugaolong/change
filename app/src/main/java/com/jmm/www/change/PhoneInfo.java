package com.jmm.www.change;

/**
 * Created by dugaolong on 17/11/21.
 */

public class PhoneInfo {

    public String make;//xiaomi  厂商
    public String model;//Redmi Note 3   型号
    public String device;//kenzo
    public String miuiVersion;//版本增量）

    /**
     * 如果是 xiaomi   Build.VERSION.INCREMENTAL: V8.5.5.0.MHOCNED
     * oppo miuiVersion是 Build.VERSION.INCREMENTAL: eng.root.20160130.230736
     *
     * eng.buildbot.20111124.040059
     * eng.buildbot.20110619.060228
     * 47975B3A
     * V1.11
     * 2.2.1
     * 7.6.15  小米5
     * JLB21.0   mi2
     * 2.5.18    MI-ONE Plus

     */

    public PhoneInfo() {
    }

    public PhoneInfo(String model, String device, String miuiVersion, String make) {
        this.model = model;
        this.device = device;
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
