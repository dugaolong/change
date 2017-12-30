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
    public String sdk_int;//19


    public Info() {
    }

    public Info(String screenWidth, String screenHeight, String screenDensity, String model, String device, String androidVersion, String miuiVersion, String make, String imei, String mac, String language, String country, String connectionType, String ip, String androidId,String sdk_int) {
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
        this.sdk_int = sdk_int;
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

    public String getSdk_int() {
        return sdk_int;
    }

    public void setSdk_int(String sdk_int) {
        this.sdk_int = sdk_int;
    }

    /**
     * 手机型号
     *
     {
     "360": {
     "360手机F4": "1501_M02",
     "360手机N4": "1509_A00"
     },
     "BlackBerry": {
     "黑莓Priv": "STV100-3"
     },
     "HTC": {
     "HTC One M9": "HTC M9e",
     "HTC One A9": "HTC One A9",
     "HTC One X9": "HTC X9u",
     "HTC One E9+": "HTC E9pw",
     "HTC One M8": "HTC M8St",
     "Google Nexus 9": "Nexus 9",
     "HTC One X": "HTC S720e",
     "HTC One S": "HTC Z520e",
     "HTC One V": "HTC T320e",
     "HTC灵感": "HTC Z710t",
     "HTC微客": "HTC C510e",
     "HTC倾心": "HTC S510"
     },
     "HUAWEI": {
     "Google Nexus 6P": "Nexus 6P",
     "荣耀7i": "ATH-AL00",
     "Mate S": "HUAWEI CRR-CL00",
     "P8": "HUAWEI GRA-UL10",
     "Mate 8": "HUAWEI NXT-AL10",
     "荣耀7": "PLK-TL01H",
     "荣耀6至尊版": "H60-L21",
     "荣耀6 plus": "PE-TL10",
     "畅享5s": "HUAWEI TAG-AL00",
     "Y310": "HUAWEIY310-T10",
     "荣耀畅享5S": "HUAWEI TAG-AL00",
     "荣耀6": "H60-L01",
     "华为荣耀6至尊版": "H60-L21",
     "华为荣耀7": "PLK-TL01H",
     "华为荣耀7i": "ATH-AL00",
     "华为 Mate 8": "HUAWEI NXT-AL10",
     "华为 Mate 7": "HUAWEI MT7-TL00",
     "华为 Mate S": "HUAWEI CRR-UL00",
     "华为P9 全网通64G高配": "EVA-AL10"
     },
     "Lenovo": {
     "S8": "Lenovo A7600-m",
     "A8": "Lenovo A3580",
     "Note8": "Lenovo A938t",
     "K3": "Lenovo K30-T",
     "K3 Note": "Lenovo K50-t3s",
     "LeMeng3": "Lenovo K32C36",
     "VIBE Shot": "Lenovo Z90-3"
     },
     "LeMobile": {
     "乐2": "Le X620",
     "乐2 Pro": "Le X525",
     "乐Max 2 64G ": "Le X820"
     },
     "Letv": {
     "乐1": "X600",
     "乐1 Pro": "X800+",
     "乐1S": "Letv X500",
     "乐1S 太子妃版": "Letv X501",
     "乐Max 全网通": "X900+",
     "乐Max Pro(工程机)": "Letv X910"
     },
     "Nokia": {
     "lumia 930": "RM-1087",
     "lumia Icon 929": "RM-927",
     "lumia 920": "RM-867",
     "lumia 1520": "RM-937",
     "lumia 1020": "RM-875",
     "lumia 925": "RM-892",
     "Nokia X": "Nokia_X"
     },
     "OPPO": {
     "OPPO R7S": "OPPO R7S",
     "OPPO R7": "OPPO R7",
     "OPPO R7Plus": "OPPO R7Plus",
     "OPPO A53": "OPPO A53",
     "OPPO U3": "6607",
     "R9 Plus": "R9 Plus",
     "OPPO Find7": "x9007",
     "OPPO Find5": "x909t",
     "OPPO R9": "OPPO R9m"
     },
     "Smartisan": {
     "T1": "SM705",
     "T2": "SM801",
     "坚果": "YQ601"
     },
     "Sony": {
     "Xperia Z3": "L55t",
     "Xperia Z5 Premium": "E6883",
     "Xperia Z5": "E6683",
     "Xperia Z3+": "E6533",
     "Xperia C4": "E5363",
     "Xperia C5": "E5563",
     "Xperia M5": "E5663",
     "Xperia Z5 Compact": "E5823",
     "Xperia M4 Aqua Dual": "E2363",
     "Xperia Z3 Dual TD": "D6683",
     "Xperia M4 Aqua": "E2312",
     "Sony Z5+": "E6883"
     },
     "Xiaomi": {
     "小米2S": "MI 2S",
     "小米3": "MI 3",
     "小米4": "MI 4LTE",
     "小米4C": "Mi-4c",
     "小米4S": "MI 4S",
     "小米5": "MI 5",
     "小米MAX": "MI MAX",
     "小米Note": "MI NOTE LTE",
     "小米Note 2": "MI NOTE 2",
     "小米Note 顶配版": "MI NOTE Pro",
     "红米Note3": "Redmi Note 3",
     "小米平板2": "MI Pad 2"
     },
     "vivo": {
     "vivo X6": "vivo X6D",
     "vivo X6 Plus": "vivo X6PlusL",
     "vivo X6S": "vivo X6S",
     "vivo X6S Plus": "vivo X6SPlus",
     "vivo Xplay5": "vivo Xplay5A"
     },
     "OnePlus": {
     "一加手机1": "A1001",
     "一加手机2": "ONE A2001",
     "一加手机3": "OnePlus A3000",
     "一加手机X(oneplus x)": "ONE E1001"
     },
     "ZTE": {
     "中兴 AXON 天机 MAX": "ZTE C2016",
     "中兴 AXON 天机 MINI": "ZTE B2015",
     "中兴 AXON 天机": "ZTE A2015",
     "中兴 星星2号": "ZTE G720C",
     "努比亚Z11 mini全网通": "NX529J",
     "努比亚大牛 Z9 Max": "NX512J",
     "努比亚小牛4 Z9 Mini": "NX511J",
     "努比亚 Z9": "NX508J ",
     "努比亚 My布拉格": "NX513J ",
     "努比亚 布拉格S": "NX513J",
     "ZTE国民指纹机BladeA1": "ZTE C880U",
     "ZTE国民指纹机BladeA1全网通版 ": "ZTE C880A"
     },
     "nubia": {
     "大牛 Z9 Max": "NX512J",
     "小牛4 Z9 Mini": "NX511J",
     "Z9": "NX508J",
     "My 布拉格": "NX513J",
     "布拉格S": "NX513J",
     "nubia Z5S Mini LTE": "NX403A"
     },
     "QiKU": {
     "奇酷（QiKU) 旗舰极客版 铂金": "8692-A00",
     "大神Note3": "8676-M01",
     "大神Note3（高配版/全网通）": "8676-A01"
     },
     "ZUK": {
     "ZUK Z2 PRO": "Z2121",
     "ZUK Z1": "Z1221"
     },
     "GiONEE": {
     "ELIFE S5.5": "GN9000",
     "金立S8（全网通）": "GN9011",
     "金立天鉴W909（全网通）": "GiONEE W909"
     },
     "GREE": {
     "格力手机1": "G0111",
     "格力手机1s": "G0121",
     "格力手机2": "G0128"
     },
     "CMDC": {
     "中国移动手机M811": "M811",
     "中国移动手机M812": "M812",
     "中国移动 N1": "M821",
     "中国移动 N1 MAX": "M823"
     },
     "LGE": {
     "Google Nexus 5X": "Nexus 5X",
     "Google Nexus 4": "Nexus 4",
     "LG G5": "LG-H868",
     "LG G3港版": "LG-D855"
     },
     "Meizu": {
     "MX2": "M040",
     "MX3": "M355",
     "MX4": "MX4",
     "MX4 Pro": "MX4 Pro",
     "MX5": "M575M",
     "PRO 6": "PRO 6",
     "魅蓝3": "m3",
     "魅蓝 note": "m1 note",
     "魅蓝3 note": "m3 note",
     "魅蓝metal": "m1 metal"
     },
     "samsung": {
     "Galaxy S6 Edge+": "SM-G9280",
     "Galaxy A9": "SM-A9000",
     "Galaxy On7": "SM-G6000",
     "Galaxy A7": "SM-A7100",
     "Galaxy A5": "SM-A5100",
     "Galaxy J3": "SM-J3109",
     "Galaxy Note5": "SM-N9200",
     "Galaxy On5": "SM-G5500",
     "领世旗舰Ⅲ": "SM-G9198",
     "Galaxy J7": "SM-J7008",
     "Galaxy J5": "SM-J5008",
     "Galaxy A8": "SM-A8000",
     "Galaxy S6": "SM-G9208",
     "W2015": "SM-W2015",
     "Galaxy S7": "SM-G9300",
     "Galaxy S7 Edge": "SM-G9350",
     "W2016 装逼之王": "W2016",
     "Galaxy note10.1": "SM-T320",
     "Galaxy Tab": "GT-N8000",
     "Galaxy Tab S T805C": "SM-T805c",
     "N5100": "N5100",
     "Galaxy Tab S": "SM-T800",
     "GALAXY S6 Active": "SM-G890A"
     }
     }
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
     *  真实的
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

    /**
     * imei
     *
     860167989935131
     863004076510187
     861900488494427
     861343888708619
     869858337627047
     868629828557006
     865354881472406
     865480424694501
     867099558096115
     860620481636300
     864028851797361
     862165454608272
     864406828707301
     863286727289887
     868253660647120
     866472022683332
     867896326453662
     869893028770566
     863285365583270
     863270255490919
     867398746301886
     869677945038631
     866290362070476
     860920540388350
     864008424978482
     864123872258160
     866128863597433
     863588142414960
     865306822624107
     861241966043653
     861137698099411
     862495460797409
     866819516742166
     865934455621395
     861157680047632
     861356522054612
     861336043980461
     862388179498692
     863207244332141
     860181936147443
     864842071013783
     864134685356513
     865041681664114
     869900123938210
     863027747486446
     869589254722996
     866071474918525
     867766724830169
     865520379029672
     862914641877641
     867920378563937
     869600976005923
     867268581869885
     863249399045755
     866446648441911
     863883553590683
     867619554738228
     864772686123703
     860721766626998
     863052352814229
     861153058900577
     864894743249741
     867272193044473
     866918343901845
     861082378312439
     860378687358399
     865658745858075
     864310379026253
     869090724667879
     869290140393973
     863121371978412
     865743295013584
     864212196973784
     866822499041663
     864269510608819
     860963559877764
     861842251007152
     865586610224810
     865379481198002
     867112946912438
     869402258246824
     869524732061550
     869167066588226
     865707974978698
     860632757728695
     865956114757690
     865506028916765
     861343289595219
     866099519368786
     869061278669520
     863146526573958
     861517581314540
     868411386568133
     867824267716129
     866543368133387
     861716089172737
     861459393814179
     862062066966455
     862450767751542
     868986321790629
     */

    /**
     * android_id
     *
     * 6vvep6t5r1oeumh
     * kzymu31btitkzoi
     * hfzncobmmriaa7g
     * vmlnxegk0l0492m
     * y0801s7iejcig7l
     * n7umiwui42o03q2
     * 8k2x3z5ocn11mbb
     * 2qxx3mj6qq7zfl9
     *
     */
}
