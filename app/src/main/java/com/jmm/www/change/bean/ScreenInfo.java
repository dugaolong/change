package com.jmm.www.change.bean;

/**
 * Created by dugaolong on 17/11/21.
 */

public class ScreenInfo {

    public String screenWidth;//1080
    public String screenHeight;//1920
    public String screenDensity;//3.0

    public ScreenInfo(String screenWidth, String screenHeight, String screenDensity) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenDensity = screenDensity;
    }

    public ScreenInfo() {
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        this.screenHeight = screenHeight;
    }

    public String getScreenDensity() {
        return screenDensity;
    }

    public void setScreenDensity(String screenDensity) {
        this.screenDensity = screenDensity;
    }
}
