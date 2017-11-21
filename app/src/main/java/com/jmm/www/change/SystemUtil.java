package com.jmm.www.change;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.Locale;

/**
 * 系统工具类
 * Created by zhuwentao on 2016-07-18.
 */
public class SystemUtil {

    public static ArrayList<Info> infoList = new ArrayList<Info>(){{
//       add(new Info("1080","1920","3.0","MI 2S","kenzo","5.0.2LRX22G","V8.2","xiaomi","860847420878608","00:24:7C:2C:A9:75","zh","CN","1","192.168.0.21","d1b32108050901eb"));
//       add(new Info("720","1280","2.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","866073431438928","C8:F2:30:57:45:C5","zh","CN","1","192.168.3.21","9774d56d682e549c"));
//       add(new Info("720","1280","2.0","MI 3","kenzo","5.0.0","V7.0","xiaomi","860167989935131","24:AB:81:C2:25:12","zh","CN","1","192.168.2.21","d1b32108050901eb"));
//       add(new Info("720","1280","2.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","865919120891242","54:dc:1d:29:ad:a4","zh","CN","1","192.168.0.110","d1b32108050901eb"));
//       add(new Info("720","1280","2.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","864755482137399","d4:97:0b:88:38:0a","zh","CN","1","10.10.110.12","d1b32108050901eb"));
//       add(new Info("1080","1920","3.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","864515450342524","7c:7d:3d:f0:d2:6f","zh","CN","1","192.168.0.23","d1b32108050901eb"));
//       add(new Info("1080","1920","3.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","868300814458282","D0:7A:B5:40:FF:C0","zh","CN","1","192.168.0.54","d1b32108050901eb"));
//       add(new Info("1080","1920","3.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","861984238082906","84:41:67:6B:B6:77","zh","CN","1","192.168.0.35","d1b32108050901eb"));
//       add(new Info("1080","1920","3.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","863470560318660","a8:a6:68:0f:c6:b9","zh","CN","1","192.168.0.26","d1b32108050901eb"));
//       add(new Info("1080","1920","3.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","864840639288459","BC:4C:C4:F3:49:60","zh","CN","1","192.168.0.107","d1b32108050901eb"));
//       add(new Info("1080","1920","3.0","Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi","863961443700595","68:96:7B:CD:58:6E","zh","CN","1","192.168.0.107","d1b32108050901eb"));
    }};

    public static ArrayList<String> imeiList = new ArrayList<String>(){{
        add("868174753859283");
        add("867188673278755");
        add("863041354750416");
        add("865304271909434");
        add("869899899548122");
        add("860172333765804");
        add("861727330641818");
        add("868617271654768");
        add("865448474875635");
        add("860363296530828");
        add("866045550969289");
        add("865897347405220");
        add("866098637297471");
        add("861995816152689");
        add("862644244966919");
        add("867905153691342");
        add("869833452539897");
        add("865106081065350");
        add("860091857661118");
        add("864613724974774");
        add("868590259950302");
        add("865864374414574");
        add("867401170999934");
        add("863829697884698");
        add("864515297576615");
        add("861171719225515");
        add("862204266814958");
        add("863660463654118");
        add("860806539218205");
        add("862452627462765");
        add("864174785810860");
        add("866288516623216");
        add("864366375961653");
        add("866498061302278");
        add("861725718518772");
        add("868100214957580");
        add("863653926389232");
        add("860657539238648");
        add("861408910262768");
        add("868473235275898");
        add("865271958476989");
        add("864565414398104");
        add("860653050385264");
        add("860690222485655");
        add("861295339071981");
        add("863048612516570");
        add("865575236641820");
        add("865839498346472");
        add("865750240672166");
        add("865860011826477");
        add("861594951178946");
        add("863315070016710");
        add("863417044432575");
        add("862507916355135");
        add("864822421015209");
        add("869813131259406");
        add("862559362231104");
        add("869870570760518");
        add("864781289252959");
        add("862817597676729");
        add("860389967265766");
        add("868524719823932");
        add("867268286634535");
        add("862660439425818");
        add("865978593155592");
        add("868200967184372");
        add("864641319316762");
        add("860080994004043");
        add("868208738788918");
        add("866352327915631");
        add("865562158418353");
        add("867678089793942");
        add("863991813272297");
        add("862051754445591");
        add("866075645456885");
        add("860554221090868");
        add("869204591317134");
        add("868702592981973");
        add("860410118174408");
        add("866504268520131");
        add("863152132970224");
        add("864502946878568");
        add("868843399590169");
        add("863286292958965");
        add("863051840579709");
        add("865648495821571");
        add("862164351554531");
        add("860710078814590");
        add("865625949401150");
        add("865930152749620");
        add("865520981168322");
        add("864083318121358");
        add("868339068351793");
        add("860635473314948");
        add("862957370535302");
        add("869266856313785");
        add("864675229122217");
        add("861873846294054");
        add("862937097472419");
        add("865645234534671");
    }};
    public static ArrayList<String> versionList = new ArrayList<String>(){{
        add("5.0.2");
        add("6.0.1");
        add("4.4.4");
        add("6.0");
        add("5.0.1");
        add("5.1.1");
        add("4.4.4");
        add("4.4.4");
        add("5.0.1");
        add("5.0.1");
        add("6.0");
        add("5.0.1");
        add("4.4.4");
        add("4.4.4");
        add("5.0.2");
        add("5.0.1");
        add("6.0");
        add("5.1.1");
        add("6.0");
        add("6.0.1");
        add("7.0");
        add("4.4.4");
        add("6.0");
        add("5.0.2");
        add("5.1.1");
        add("6.0.1");
        add("4.4.4");
        add("5.0.1");
        add("5.0.1");
        add("5.0.1");
        add("4.4.4");
        add("5.1.1");
        add("7.0");
        add("6.0");
        add("5.0.2");
        add("5.1.1");
        add("7.0");
        add("7.0");
        add("4.4.4");
        add("5.1.1");
        add("6.0.1");
        add("4.4.4");
        add("5.0.2");
        add("7.0");
        add("4.4.4");
        add("6.0");
        add("6.0");
        add("5.0.1");
        add("5.1.1");
        add("6.0");
        add("6.0");
        add("4.4.4");
        add("5.1.1");
        add("5.0.1");
        add("5.0.2");
        add("6.0");
        add("7.0");
        add("7.0");
        add("6.0");
        add("5.0.1");
        add("4.4.4");
        add("5.1.1");
        add("6.0.1");
        add("5.1.1");
        add("5.0.1");
        add("4.4.4");
        add("5.1.1");
        add("6.0");
        add("5.0.2");
        add("5.0.1");
        add("5.1.1");
        add("5.0.2");
        add("7.0");
        add("5.1.1");
        add("4.4.4");
        add("4.4.4");
        add("5.1.1");
        add("6.0");
        add("5.1.1");
        add("6.0");
        add("5.0.2");
        add("5.1.1");
        add("5.0.1");
        add("6.0.1");
        add("6.0.1");
        add("4.4.4");
        add("5.0.2");
        add("5.0.1");
        add("4.4.4");
        add("5.1.1");
        add("4.4.4");
        add("5.0.1");
        add("7.0");
        add("6.0");
        add("6.0.1");
        add("6.0.1");
        add("6.0.1");
        add("4.4.4");
        add("4.4.4");
        add("4.4.4");
    }};
    public static ArrayList<String> androididList = new ArrayList<String>(){{
        add("367v4fbe55u0b5v6");
        add("yaf6xnq0a83264q8");
        add("511mhe2ifq2ek03o");
        add("6tk93dt53x6m4684");
        add("k3v144hc7r54ax63");
        add("h66g1a2pr8c0hz18");
        add("60l4beinb7tj8q6w");
        add("pas2fbdlm081xot3");
        add("5d51y348k5e6ghp2");
        add("s3dxyly8w743473p");
        add("rf3l21500ye4j7od");
        add("15p4px5dwf7rh7px");
        add("416r8836qh80prp9");
        add("96nip4pfc3n6aqks");
        add("dl8sb291819d3trn");
        add("jc70h1ysea86frm1");
        add("86u7zx2ryph4f92j");
        add("jif9vfo029wn98jt");
        add("7e4nggqx6f2s695j");
        add("suvkce8379t0g809");
        add("0r2u2it31n2m447l");
        add("k86k2k38y89941o5");
        add("m6afgllst575z659");
        add("prg0u368228345de");
        add("8cvweg0snery5w81");
        add("m0qm0g6rc6mwv9nx");
        add("kej947bir9hfk98x");
        add("865u4fbencnu84m7");
        add("9g4z6v4p6eq1i0d7");
        add("en8285452a5g87s8");
        add("5q09f29to2fbhp1x");
        add("0d46kw85669uy0d6");
        add("l2q228b4x7a53s5f");
        add("138vy3l3250h63pm");
        add("dd36wvk26261cex1");
        add("yts9x5w09zq4u3d8");
        add("f3878ot5c0yb4v6x");
        add("8ex626e0g18bu5nk");
        add("0753a051y699kq0k");
        add("x6x6q71qx1w7z80w");
        add("2ytrn329679kr7tn");
        add("j4u113el4m79yi3u");
        add("7602bs7u67mi1kmw");
        add("8rego8v2g2ecp0ms");
        add("l0nrqbkioo847j1x");
        add("l320xo817vgu6t08");
        add("w74wjr856250456z");
        add("39z3ils32155j6u7");
        add("qwhxp6822321bwe1");
        add("5o0q7052m8441164");
        add("fsu5f19e9gqj45bh");
        add("ive8f3h849xni69s");
        add("j00545dn520nr8i4");
        add("8g19lgj2m5rq76ua");
        add("m76vx5c0p66j2h8k");
        add("nhhh22e47c31k386");
        add("w1p8b27s591fec49");
        add("2i9i6d9z74rff0eh");
        add("0p3z48123ldq0z1z");
        add("aj7o7a9iyqu55529");
        add("j5zv19ka38arrif1");
        add("1u787vds95duyciz");
        add("7gx139z9851d53c2");
        add("m0q23d56676dekci");
        add("6p875xwf757vq7z5");
        add("a0sr7y1xptw3956s");
        add("6ezpv2zqtuki0kg1");
        add("j8ki6tt919c0xnnj");
        add("0h98mims3n1s40ne");
        add("6meg6509jhzl73ni");
        add("v7k6syn8kfrw9w6q");
        add("xq25rr3xqmnp8761");
        add("ievqwdlw21c360i5");
        add("0n945753z52h9r80");
        add("t0k83od338iok4zy");
        add("69w03hvt0540fv42");
        add("724kl3v8q621v256");
        add("1pd7d657xf6p34b2");
        add("0djr1737ac0xh0jd");
        add("lo4384gx9n0371x9");
        add("1hgwg90iyu3s1qkb");
        add("x898rr79yzag36j2");
        add("tto74h8h2ct6u4w2");
        add("727i509c8b0ach19");
        add("a26t344t6vl9vqr4");
        add("mj4mlefr56xi6h37");
        add("sdj2y4xoz94zbik4");
        add("my7w0u4ou7j1p5a4");
        add("i7ats2475m0j7rhj");
        add("401s37j4x935g708");
        add("upx0f264k39mfi3z");
        add("nb97uqxx5o936h4m");
        add("ju732nfy1o531hcy");
        add("mr665m8afo3y9tjp");
        add("8j6zfd1j8qx002ab");
        add("r9u14g1p5le480cz");
        add("982zzx5g533r35xk");
        add("7v0bpl4xu9tga2z4");
        add("woasxox26zg61l9z");
        add("n4v489lh6b2ma24b");
    }};
    public static ArrayList<ScreenInfo> screenInfoList = new ArrayList<ScreenInfo>(){{
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("720","1280","2.0"));
        add(new ScreenInfo("1080","1920","3.0"));
        add(new ScreenInfo("720","1280","2.0"));
    }};
    public static ArrayList<PhoneInfo> phoneInfoList = new ArrayList<PhoneInfo>(){{
        add(new PhoneInfo("Redmi Note 3","kenzo","6.0.1","V8.5.5.0.MHOCNED","xiaomi"));
    }};

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return 手机IMEI
     */
    public static String getIMEI(Context ctx) {
        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getDeviceId();
        }
        return null;
    }
}