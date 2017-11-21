package com.jmm.www.change;

/**
 * Created by dugaolong on 17/11/19.
 */

public class Info {
    public String screenWidth;//1080
    public String screenHeight;//1920
    public String screenDensity;//3.0
    public String model;//Redmi Note 3   型号
    public String device;//kenzo
    public String androidVersion;//6.0.1
    public String miuiVersion;//V8.5.5.0.MHOCNED
//    public String bc;//S
    public String make;//xiaomi  厂商
//    public String isInter;//false
//    public String os;//android

    public String imei;//da6fc986c0ecbb4530f746c5c6d22d36
    public String mac;//A35C496B735A30C69F880E179F1BC457
    public String language;//zh
    public String country;//CN
    public String connectionType;//wifi
    public String ip;//192.168.170.12
    public String androidId;//d1b32108050901eb


    public Info() {
    }

    public Info(String screenWidth, String screenHeight, String screenDensity, String model, String device, String androidVersion, String miuiVersion, String make, String imei, String mac, String language, String country, String connectionType, String ip, String androidId) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenDensity = screenDensity;
        this.model = model;
        this.device = device;
        this.androidVersion = androidVersion;
        this.miuiVersion = miuiVersion;
        this.make = make;
//        this.isInter = isInter;
//        this.os = os;
        this.imei = imei;
        this.mac = mac;
        this.language = language;
        this.country = country;
        this.connectionType = connectionType;
        this.ip = ip;
        this.androidId = androidId;
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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    /**
     * 手机型号
     *
     * Xiaomi：
     *
     * MI 2S
     * MI 3
     * MI 4LTE
     * Mi-4c
     * MI 4S
     * MI 5
     * MI MAX
     * MI NOTE LTE
     * MI NOTE 2
     * MI NOTE Pro
     * Redmi Note 3
     *
     * HUAWEI：
     * HUAWEI GRA-UL10
     * Nexus 6P
     * HUAWEI CRR-CL00
     * HUAWEI NXT-AL10
     * HUAWEIY310-T10
     * HUAWEI MT7-TL00
     * HUAWEI CRR-UL00
     * EVA-AL10
     * H60-L21
     * PLK-TL01H
     * ATH-AL00
     * HUAWEI TAG-AL00
     * H60-L01
     * PE-TL10
     *
     * Meizu:
     * M040
     * M355
     * MX4
     * MX4 Pro
     * M575M
     * PRO 6
     * m1 note
     * m3
     * m3 note
     * m1 metal
     *
     */

    /**
     *  内网ip地址
     *
     *  A类：
            10.0.0.0-10.255.255.255
        B类：
            172.16.0.0—172.31.255.255
        C类：
            192.168.0.0-192.168.255.255
     *
     */


    /***
     * mac地址
     *
     *
     70:F0:87:A4:D1:F4
     88:d5:0c:dd:cc:f1
     68:3E:34:9C:86:5B
     48:D7:05:11:A2:F8
     50:01:D9:B3:F0:16
     f4:8b:32:63:51:92
     90:27:E4:33:DD:50
     2c:5b:b8:de:21:91
     64:cc:2e:43:9b:5c
     14:F6:5A:8E:D6:E1
     bc:3a:ea:f5:c8:24
     EC:CB:30:67:8D:E2
     b0:e2:35:29:5d:99
     FC:FC:48:A1:B8:2F
     bc:3a:ea:72:05:35
     2c:5b:b8:a3:4e:91
     C0:9F:05:A7:FF:92
     CC:08:8D:5E:28:56
     18:F6:43:1F:58:AD
     CC:08:8D:09:E1:C5
     60:D9:C7:5D:41:22
     CC:08:8D:05:04:66
     BC:75:74:DA:48:76
     74:51:ba:54:e0:8d
     DC:2B:2A:77:0C:6A
     cc:2d:83:68:86:3e
     74:1B:B2:B9:09:B3
     48:D7:05:11:A2:F8
     A0:86:C6:96:05:01
     10:2a:b3:c5:ee:c4
     54:dc:1d:22:5b:a6
     14:9D:09:6C:D5:AF
     14:5f:94:5d:09:3d
     f4:8b:32:63:51:92
     68:3E:34:0C:23:94
     54:dc:1d:29:ad:a4
     7c:7d:3d:f0:d2:6f
     70:F0:87:A4:D1:F4
     90:27:E4:33:DD:50
     74:23:44:b7:2c:81
     50:01:D9:B3:F0:16
     4C:FB:45:97:50:52
     fc:3f:7c:cb:90:eb
     b0:e2:35:f7:83:e2
     CC:08:8D:14:93:FB
     A4:44:D1:DB:6C:EF
     24:61:5a:0f:6f:15
     10:2a:b3:10:fa:eb
     68:96:7B:83:D8:B9
     75:f5:fd:4f:03:c0
     20:82:c0:6f:17:94
     8c:3a:e3:6c:e1:1b
     cc:08:8d:31:4e:85
     cc:2d:83:68:86:3e
     24:E3:14:0B:04:15
     68:df:dd:98:9d:10
     fc:1a:11:d9:12:4b
     38:BC:1A:B3:5F:EC
     CC:08:8D:5E:28:56
     ec:1d:7f:d4:78:ae
     4C:FB:45:97:50:52
     b0:e2:35:9e:f5:f0
     b0:e2:35:f7:83:e2
     40:4d:7f:c2:70:bf
     98:F1:70:56:F8:C4
     A0:8D:16:29:92:90
     60:92:17:AA:1D:00
     D8:BB:2C:A5:54:4A
     9C:4F:DA:30:74:C2
     D0:03:4B:87:E2:41
     28:A0:2B:16:18:26
     00:CD:FE:43:BD:13
     F0:99:BF:78:89:C8
     68:96:7B:83:D8:B9
     58:55:CA:C1:A8:48
     7c:7d:3d:f0:d2:6f
     CC:08:8D:05:04:66
     10:2a:b3:10:fa:eb
     24:61:5a:0f:6f:15
     74:1B:B2:B9:09:B3
     68:3E:34:30:4F:A1
     68:3E:34:A8:EB:85
     54:EA:A8:37:A6:3D
     54:dc:1d:22:5b:a6
     98:ff:d0:10:08:cb
     38:BC:1A:C0:3B:9A
     E0:A3:AC:2F:76:20
     a0:8d:16:9d:10:e0
     78:f5:fd:4f:03:c0
     e0:19:1d:4f:d1:d0
     40:4d:7f:c2:70:bf
     e8:bb:a8:a3:74:9e
     e4:47:90:8f:b7:3f
     7c:7d:3e:79:e5:ff
     24:1f:a0:cd:b2:a9
     CC:08:8D:09:E1:C5
     A4:44:D1:DB:6C:EF
     ec:5a:86:06:f8:d0
     DC:2B:2A:77:0C:6A
     b4:0b:44:31:60:5c
     38:71:DE:2E:B9:B8
     78:7E:61:40:47:F7
     74:23:44:8f:e3:1f
     fc:1a:11:d9:12:4b
     6C:72:E7:71:BB:F9
     78:7E:61:5E:6C:F1
     20:AB:37:21:CB:5A
     14:5f:94:5d:09:3d
     cc:08:8d:31:4e:85
     68:3E:34:0C:23:94
     60:D9:C7:5D:41:22
     BC:75:74:DA:48:76
     10:2a:b3:c5:ee:c4
     f3:3f:7c:cb:90:eb
     F4:31:C3:E5:F1:C7
     F4:E3:FB:99:C4:D2
     68:96:7B:CD:58:6E
     BC:4C:C4:F3:49:60
     a8:a6:68:0f:c6:b9
     84:41:67:6B:B6:77
     D0:7A:B5:40:FF:C0
     7c:7d:3d:f0:d2:6f
     d4:97:0b:88:38:0a
     54:dc:1d:29:ad:a4
     24:AB:81:C2:25:12
     C8:F2:30:57:45:C5


     */
}
