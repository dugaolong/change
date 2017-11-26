import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by dugaolong on 17/11/18.
 */

public class Test {

    public static String aaa;

    public static void main(String[] args) {
//        aaa = "111";
//        System.out.println("aaa:"+aaa);
//        aaa = "222";
//        System.out.println("aaa:"+aaa);
//        for (int i = 0; i < 100; i++) {
//            System.out.println("add(\""+randomIMEI()+"\");");
//           createRandomCharData(16);
//            createRandomScreen();
//            createRandomVersion();
//            createRandomPhone();
//            createRandomIp();
//        }
//        getNewMac();
//        changeMac2byte();

//        createRandomMac();
//        getMethodInfo("android.telephony.TelephonyManager");
        String hexString = "E0:A3:AC:2F:76:20";
        mac2Array(hexString);

    }

    /**
     * 传入全类名获得对应类中所有方法名和参数名
     */
    @SuppressWarnings("rawtypes")
    private static void getMethodInfo(String pkgName) {
        try {
            Class clazz = Class.forName(pkgName);
            Method[] methods = clazz.getMethods();
            int iii = 0;
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("add(\"" + methodName + "\");");
//                Class<?>[] parameterTypes = method.getParameterTypes();
//                for (Class<?> clas : parameterTypes) {
//                    String parameterName = clas.getName();
//                    System.out.println("参数名称:" + parameterName);
//                }
//                System.out.println("*****************************");
                iii++;
            }
            System.out.println("count:" + iii);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    //根据指定长度生成字母和数字的随机数
    //0~9的ASCII为48~57
    //A~Z的ASCII为65~90
    //a~z的ASCII为97~122
    public static void createRandomCharData(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();//随机用以下三个随机生成器
        Random randdata = new Random();
        int data = 0;
        for (int i = 0; i < length; i++) {
//            int index=rand.nextInt(3);
            int index = rand.nextInt(2);
            //目的是随机选择生成数字，大小写字母
            switch (index) {
                case 0:
                    data = randdata.nextInt(10);//仅仅会生成0~9
                    sb.append(data);
                    break;
//                case 1:
//                    data=randdata.nextInt(26)+65;//保证只会产生65~90之间的整数
//                    sb.append((char)data);
//                    break;
                case 1:
                    data = randdata.nextInt(26) + 97;//保证只会产生97~122之间的整数
                    sb.append((char) data);
                    break;
            }
        }
        String result = sb.toString();
        System.out.println("add(\"" + result + "\");");
    }

    public static void createRandomScreen() {
        Random rand = new Random();//随机用以下三个随机生成器
        int index = rand.nextInt(2);
        //目的是随机选择生成数字，大小写字母
        switch (index) {
            case 0:
                System.out.println("add(new ScreenInfo(\"1080\",\"1920\",\"3.0\"));");
                break;
            case 1:
                System.out.println("add(new ScreenInfo(\"720\",\"1280\",\"2.0\"));");
                break;
        }
    }

    public static void createRandomVersion() {
        Random rand = new Random();//随机用以下三个随机生成器
        int indexVersion = rand.nextInt(8);
        //目的是随机选择生成数字，大小写字母
        switch (indexVersion) {
            case 0://
                System.out.println("add(new VersionInfo(\"4.2\",\"17\"));");
                break;
            case 1://
                System.out.println("add(new VersionInfo(\"4.4.4\",\"19\"));");
                break;
            case 2://
                System.out.println("add(new VersionInfo(\"5.0.1\",\"21\"));");
                break;
            case 3://
                System.out.println("add(new VersionInfo(\"5.0.2\",\"21\"));");
                break;
            case 4://
                System.out.println("add(new VersionInfo(\"5.1.1\",\"22\"));");
                break;
            case 5://
                System.out.println("add(new VersionInfo(\"6.0\",\"19\"));");
                break;
            case 6://
                System.out.println("add(new VersionInfo(\"6.0.1\",\"23\"));");
                break;
            case 7://
                System.out.println("add(new VersionInfo(\"7.0\",\"24\"));");
                break;
        }

    }

    public static void createRandomPhone() {
        Random rand = new Random();//随机用以下三个随机生成器
        int indexPhone = rand.nextInt(3);
        //目的是随机选择生成数字，大小写字母
        switch (indexPhone) {
            case 0://xiaomi
                int indexModel1 = rand.nextInt(11);
                switch (indexModel1) {
                    case 0://MI 2S
                        System.out.println("add(new PhoneInfo(\"MI 2S\",\"MI2S\",\"7.5.5\",\"xiaomi\"));");
                        break;
                    case 1://MI 3
                        System.out.println("add(new PhoneInfo(\"MI 3\",\"MI3\",\"4.7.4\",\"xiaomi\"));");
                        break;
                    case 2://MI 4LTE
                        System.out.println("add(new PhoneInfo(\"MI 4LTE\",\"MI4LTE\",\"5.7.7\",\"xiaomi\"));");
                        break;
                    case 3://MI 4S
                        System.out.println("add(new PhoneInfo(\"MI 4S\",\"MI4S\",\"3.9.5\",\"xiaomi\"));");
                        break;
                    case 4://MI 5
                        System.out.println("add(new PhoneInfo(\"MI 5\",\"MI5\",\"4.4.6\",\"xiaomi\"));");
                        break;
                    case 5://MI MAX
                        System.out.println("add(new PhoneInfo(\"MI MAX\",\"MIMAX\",\"7.8.7\",\"xiaomi\"));");
                        break;
                    case 6://MI NOTE LTE
                        System.out.println("add(new PhoneInfo(\"MI NOTE LTE\",\"MINOTELTE\",\"7.7.9\",\"xiaomi\"));");
                        break;
                    case 7://MI NOTE 2
                        System.out.println("add(new PhoneInfo(\"MI NOTE 2\",\"MINOTE2\",\"7.3.7\",\"xiaomi\"));");
                        break;
                    case 8://MI NOTE Pro
                        System.out.println("add(new PhoneInfo(\"MI NOTE Pro\",\"MINOTEPro\",\"9.2.15\",\"xiaomi\"));");
                        break;
                    case 9://Redmi Note 3
                        System.out.println("add(new PhoneInfo(\"Redmi Note 3\",\"kenzo\",\"8.5.5\",\"xiaomi\"));");
                        break;
                    case 10://Redmi 4
                        System.out.println("add(new PhoneInfo(\"Redmi 4\",\"Redmi4\",\"7.3.31\",\"xiaomi\"));");
                        break;
                }
                break;
            case 1://huawei
                int indexModel2 = rand.nextInt(11);
                switch (indexModel2) {
                    case 0://
                        System.out.println("add(new PhoneInfo(\"JMM-AL00\",\"C00B132\",\"HWJMM-Q\",\"HUAWEI\"));");
                        break;
                    case 1://
                        System.out.println("add(new PhoneInfo(\"PRA-AL00X\",\"C00B190\",\"HWPRA-H\",\"HUAWEI\"));");
                        break;
                    case 2://
                        System.out.println("add(new PhoneInfo(\"HUAWEI GRA-UL10\",\"C00B134\",\"5.7.7\",\"HUAWEI\"));");
                        break;
                    case 3://
                        System.out.println("add(new PhoneInfo(\"HUAWEI NXT-AL10\",\"C00B156\",\"3.9.5\",\"HUAWEI\"));");
                        break;
                    case 4://
                        System.out.println("add(new PhoneInfo(\"PLK-TL01H\",\"C00B137\",\"4.4.6\",\"HUAWEI\"));");
                        break;
                    case 5://
                        System.out.println("add(new PhoneInfo(\"H60-L21\",\"C00B167\",\"7.8.7\",\"HUAWEI\"));");
                        break;
                    case 6://MI NOTE LTE
                        System.out.println("add(new PhoneInfo(\"PE-TL10\",\"C00B178\",\"7.7.9\",\"HUAWEI\"));");
                        break;
                    case 7://MI NOTE 2
                        System.out.println("add(new PhoneInfo(\"HUAWEI TAG-AL00\",\"C00B115\",\"7.3.7\",\"HUAWEI\"));");
                        break;
                    case 8://MI NOTE Pro
                        System.out.println("add(new PhoneInfo(\"H60-L01\",\"C00B183\",\"9.2.15\",\"HUAWEI\"));");
                        break;
                    case 9://Redmi Note 3
                        System.out.println("add(new PhoneInfo(\"HUAWEI MT7-TL00\",\"C00B172\",\"8.5.5\",\"HUAWEI\"));");
                        break;
                    case 10://Redmi 4
                        System.out.println("add(new PhoneInfo(\"HUAWEI CRR-UL00\",\"C00B147\",\"HWPRA-W\",\"HUAWEI\"));");
                        break;
                }
                break;
            case 2://oppo
                int indexModel3 = rand.nextInt(9);
                switch (indexModel3) {
                    /**
                     *  "OPPO R7S": "OPPO R7S",
                     "OPPO R7": "OPPO R7",
                     "OPPO R7Plus": "OPPO R7Plus",
                     "OPPO A53": "OPPO A53",
                     "OPPO U3": "6607",
                     "R9 Plus": "R9 Plus",
                     "OPPO Find7": "x9007",
                     "OPPO Find5": "x909t",
                     "OPPO R9": "OPPO R9m"
                     */
                    case 0://
                        System.out.println("add(new PhoneInfo(\"OPPO R7S\",\"eng.root.20160130.230736\",\"7.5.6\",\"oppo\"));");
                        break;
                    case 1://
                        System.out.println("add(new PhoneInfo(\"OPPO R7\",\"R7\",\"4.7.5\",\"oppo\"));");
                        break;
                    case 2://
                        System.out.println("add(new PhoneInfo(\"OPPO R7Plus\",\"R7Plus\",\"5.7.8\",\"oppo\"));");
                        break;
                    case 3://
                        System.out.println("add(new PhoneInfo(\"OPPO A53\",\"A53\",\"3.9.6\",\"oppo\"));");
                        break;
                    case 4://
                        System.out.println("add(new PhoneInfo(\"6607\",\"6607\",\"4.4.7\",\"oppo\"));");
                        break;
                    case 5://
                        System.out.println("add(new PhoneInfo(\"R9 Plus\",\"Plus\",\"7.8.8\",\"oppo\"));");
                        break;
                    case 6://
                        System.out.println("add(new PhoneInfo(\"x9007\",\"x9007\",\"7.7.0\",\"oppo\"));");
                        break;
                    case 7://
                        System.out.println("add(new PhoneInfo(\"x909t\",\"x909t\",\"7.3.8\",\"oppo\"));");
                        break;
                    case 8://
                        System.out.println("add(new PhoneInfo(\"OPPO R9m\",\"R9m\",\"9.2.2\",\"oppo\"));");
                        break;
                }
                break;
        }
    }

    public static void createRandomMac() {
        System.out.println("add(\"70:F0:87:A4:D1:F4\");");
        System.out.println("add(\"88:d5:0c:dd:cc:f1\");");
        System.out.println("add(\"68:3E:34:9C:86:5B\");");
        System.out.println("add(\"48:D7:05:11:A2:F8\");");
        System.out.println("add(\"50:01:D9:B3:F0:16\");");
        System.out.println("add(\"f4:8b:32:63:51:92\");");
        System.out.println("add(\"90:27:E4:33:DD:50\");");
        System.out.println("add(\"2c:5b:b8:de:21:91\");");
        System.out.println("add(\"64:cc:2e:43:9b:5c\");");
        System.out.println("add(\"14:F6:5A:8E:D6:E1\");");
        System.out.println("add(\"bc:3a:ea:f5:c8:24\");");
        System.out.println("add(\"EC:CB:30:67:8D:E2\");");
        System.out.println("add(\"b0:e2:35:29:5d:99\");");
        System.out.println("add(\"FC:FC:48:A1:B8:2F\");");
        System.out.println("add(\"bc:3a:ea:72:05:35\");");
        System.out.println("add(\"2c:5b:b8:a3:4e:91\");");
        System.out.println("add(\"C0:9F:05:A7:FF:92\");");
        System.out.println("add(\"CC:08:8D:5E:28:56\");");
        System.out.println("add(\"18:F6:43:1F:58:AD\");");
        System.out.println("add(\"CC:08:8D:09:E1:C5\");");
        System.out.println("add(\"60:D9:C7:5D:41:22\");");
        System.out.println("add(\"CC:08:8D:05:04:66\");");
        System.out.println("add(\"BC:75:74:DA:48:76\");");
        System.out.println("add(\"74:51:ba:54:e0:8d\");");
        System.out.println("add(\"DC:2B:2A:77:0C:6A\");");
        System.out.println("add(\"cc:2d:83:68:86:3e\");");
        System.out.println("add(\"74:1B:B2:B9:09:B3\");");
        System.out.println("add(\"48:D7:05:11:A2:F8\");");
        System.out.println("add(\"A0:86:C6:96:05:01\");");
        System.out.println("add(\"10:2a:b3:c5:ee:c4\");");
        System.out.println("add(\"54:dc:1d:22:5b:a6\");");
        System.out.println("add(\"14:9D:09:6C:D5:AF\");");
        System.out.println("add(\"14:5f:94:5d:09:3d\");");
        System.out.println("add(\"f4:8b:32:63:51:92\");");
        System.out.println("add(\"68:3E:34:0C:23:94\");");
        System.out.println("add(\"54:dc:1d:29:ad:a4\");");
        System.out.println("add(\"7c:7d:3d:f0:d2:6f\");");
        System.out.println("add(\"70:F0:87:A4:D1:F4\");");
        System.out.println("add(\"90:27:E4:33:DD:50\");");
        System.out.println("add(\"74:23:44:b7:2c:81\");");
        System.out.println("add(\"50:01:D9:B3:F0:16\");");
        System.out.println("add(\"4C:FB:45:97:50:52\");");
        System.out.println("add(\"fc:3f:7c:cb:90:eb\");");
        System.out.println("add(\"b0:e2:35:f7:83:e2\");");
        System.out.println("add(\"CC:08:8D:14:93:FB\");");
        System.out.println("add(\"A4:44:D1:DB:6C:EF\");");
        System.out.println("add(\"24:61:5a:0f:6f:15\");");
        System.out.println("add(\"10:2a:b3:10:fa:eb\");");
        System.out.println("add(\"68:96:7B:83:D8:B9\");");
        System.out.println("add(\"75:f5:fd:4f:03:c0\");");
        System.out.println("add(\"20:82:c0:6f:17:94\");");
        System.out.println("add(\"8c:3a:e3:6c:e1:1b\");");
        System.out.println("add(\"cc:08:8d:31:4e:85\");");
        System.out.println("add(\"cc:2d:83:68:86:3e\");");
        System.out.println("add(\"24:E3:14:0B:04:15\");");
        System.out.println("add(\"68:df:dd:98:9d:10\");");
        System.out.println("add(\"fc:1a:11:d9:12:4b\");");
        System.out.println("add(\"38:BC:1A:B3:5F:EC\");");
        System.out.println("add(\"CC:08:8D:5E:28:56\");");
        System.out.println("add(\"ec:1d:7f:d4:78:ae\");");
        System.out.println("add(\"4C:FB:45:97:50:52\");");
        System.out.println("add(\"b0:e2:35:9e:f5:f0\");");
        System.out.println("add(\"b0:e2:35:f7:83:e2\");");
        System.out.println("add(\"40:4d:7f:c2:70:bf\");");
        System.out.println("add(\"98:F1:70:56:F8:C4\");");
        System.out.println("add(\"A0:8D:16:29:92:90\");");
        System.out.println("add(\"60:92:17:AA:1D:00\");");
        System.out.println("add(\"D8:BB:2C:A5:54:4A\");");
        System.out.println("add(\"9C:4F:DA:30:74:C2\");");
        System.out.println("add(\"D0:03:4B:87:E2:41\");");
        System.out.println("add(\"28:A0:2B:16:18:26\");");
        System.out.println("add(\"00:CD:FE:43:BD:13\");");
        System.out.println("add(\"F0:99:BF:78:89:C8\");");
        System.out.println("add(\"68:96:7B:83:D8:B9\");");
        System.out.println("add(\"58:55:CA:C1:A8:48\");");
        System.out.println("add(\"7c:7d:3d:f0:d2:6f\");");
        System.out.println("add(\"CC:08:8D:05:04:66\");");
        System.out.println("add(\"10:2a:b3:10:fa:eb\");");
        System.out.println("add(\"24:61:5a:0f:6f:15\");");
        System.out.println("add(\"74:1B:B2:B9:09:B3\");");
        System.out.println("add(\"68:3E:34:30:4F:A1\");");
        System.out.println("add(\"68:3E:34:A8:EB:85\");");
        System.out.println("add(\"54:EA:A8:37:A6:3D\");");
        System.out.println("add(\"54:dc:1d:22:5b:a6\");");
        System.out.println("add(\"98:ff:d0:10:08:cb\");");
        System.out.println("add(\"38:BC:1A:C0:3B:9A\");");
        System.out.println("add(\"E0:A3:AC:2F:76:20\");");
        System.out.println("add(\"a0:8d:16:9d:10:e0\");");
        System.out.println("add(\"78:f5:fd:4f:03:c0\");");
        System.out.println("add(\"e0:19:1d:4f:d1:d0\");");
        System.out.println("add(\"40:4d:7f:c2:70:bf\");");
        System.out.println("add(\"e8:bb:a8:a3:74:9e\");");
        System.out.println("add(\"e4:47:90:8f:b7:3f\");");
        System.out.println("add(\"7c:7d:3e:79:e5:ff\");");
        System.out.println("add(\"24:1f:a0:cd:b2:a9\");");
        System.out.println("add(\"CC:08:8D:09:E1:C5\");");
        System.out.println("add(\"A4:44:D1:DB:6C:EF\");");
        System.out.println("add(\"ec:5a:86:06:f8:d0\");");
        System.out.println("add(\"DC:2B:2A:77:0C:6A\");");
        System.out.println("add(\"b4:0b:44:31:60:5c\");");
    }

    public static void createRandomIp() {
        Random rand = new Random();//随机用以下三个随机生成器
        int indexIp = rand.nextInt(3);
        /**
         *  A类：
         10.0.0.0-10.255.255.255
         B类：
         172.16.0.0—172.31.255.255
         C类：
         192.168.0.0-192.168.255.255
         */
        switch (indexIp) {
            case 0://
                System.out.println("add(\"10." + rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255) + "\");");
                break;
            case 1://
                System.out.println("add(\"172." + (16 + rand.nextInt(15)) + "." + rand.nextInt(255) + "." + rand.nextInt(255) + "\");");
                break;
            case 2://
                System.out.println("add(\"192.168." + rand.nextInt(255) + "." + rand.nextInt(255) + "\");");
                break;
        }
    }

    /**
     * @return
     */
    private static void getNewMac() {
        try {
            byte[] macBytes = new byte[]{12, 23, 34, 45, 56, 67};
            StringBuilder res1 = new StringBuilder();
            for (byte b : macBytes) {
                System.out.println("b: " + b);
                System.out.println(String.format("%02X:", b));
                res1.append(String.format("%02X:", b));
            }
            if (res1.length() > 0) {
                res1.deleteCharAt(res1.length() - 1);
            }
            System.out.println(res1.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //16进制转二进制
    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(hexString
                    .substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }
    //二进制转16进制
    public static String binaryString2hexString(String bString)
    {
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)
            return null;
        StringBuffer tmp = new StringBuffer();
        int iTmp = 0;
        for (int i = 0; i < bString.length(); i += 4)
        {
            iTmp = 0;
            for (int j = 0; j < 4; j++)
            {
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
            }
            tmp.append(Integer.toHexString(iTmp));
        }
        return tmp.toString();
    }

    /**
     * 将mac地址转换为byte数组
     * @return
     */
    public static byte[] mac2Array(String mac) {
        byte[] macBytes = new byte[6];
        try {
            String[] strings = mac.split(":");
            for (int i = 0;i<strings.length;i++){
                macBytes[i] = Integer.valueOf(strings[i],16).byteValue();
            }
            System.out.println(macBytes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return macBytes;
    }

    public static byte[] conver16HexToByte(String hex16Str)
    {
        char [] c = hex16Str.toCharArray();
        byte [] b = new byte[c.length/2];
        for(int i = 0;i<b.length;i++)
        {
            int pos = i * 2;
            b[i] = (byte)("0123456789ABCDEF".indexOf(c[pos]) << 4 | "0123456789ABCDEF".indexOf(c[pos+1]));
        }
        return b;
    }
}
