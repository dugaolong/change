package com.jmm.www.change;

/**
 * Created by dugaolong on 17/11/22.
 */

public class VersionInfo {
    private String version;
    private String sdkInt;

    public VersionInfo(String version, String sdkInt) {
        this.version = version;
        this.sdkInt = sdkInt;
    }

    public VersionInfo() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSdkInt() {
        return sdkInt;
    }

    public void setSdkInt(String sdkInt) {
        this.sdkInt = sdkInt;
    }
}
