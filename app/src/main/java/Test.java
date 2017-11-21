import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by dugaolong on 17/11/18.
 */

public class Test {

    public static String aaa;
    public static void main(String[] args){
//        aaa = "111";
//        System.out.println("aaa:"+aaa);
//        aaa = "222";
//        System.out.println("aaa:"+aaa);
        for (int i = 0; i<100;i++){
//            System.out.println("add(\""+randomIMEI()+"\");");
//           createRandomCharData(16);
//            createRandomScreen();
            createRandomVersion();
        }
//        getMethodInfo("android.telephony.TelephonyManager");
    }

    /**
     * 传入全类名获得对应类中所有方法名和参数名
     */
    @SuppressWarnings("rawtypes")
    private static void getMethodInfo(String pkgName) {
        try {
            Class clazz = Class.forName(pkgName);
            Method[] methods = clazz.getMethods();
            int iii=0;
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("add(\""+methodName+"\");");
//                Class<?>[] parameterTypes = method.getParameterTypes();
//                for (Class<?> clas : parameterTypes) {
//                    String parameterName = clas.getName();
//                    System.out.println("参数名称:" + parameterName);
//                }
//                System.out.println("*****************************");
                iii++;
            }
            System.out.println("count:"+iii);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**随机生成imei****/
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
    public static void createRandomCharData(int length)
    {
        StringBuilder sb=new StringBuilder();
        Random rand=new Random();//随机用以下三个随机生成器
        Random randdata=new Random();
        int data=0;
        for(int i=0;i<length;i++)
        {
//            int index=rand.nextInt(3);
            int index=rand.nextInt(2);
            //目的是随机选择生成数字，大小写字母
            switch(index)
            {
                case 0:
                    data=randdata.nextInt(10);//仅仅会生成0~9
                    sb.append(data);
                    break;
//                case 1:
//                    data=randdata.nextInt(26)+65;//保证只会产生65~90之间的整数
//                    sb.append((char)data);
//                    break;
                case 1:
                    data=randdata.nextInt(26)+97;//保证只会产生97~122之间的整数
                    sb.append((char)data);
                    break;
            }
        }
        String result=sb.toString();
        System.out.println("add(\""+result+"\");");
    }
    public static void createRandomScreen()
    {
        Random rand=new Random();//随机用以下三个随机生成器
        int index=rand.nextInt(2);
        //目的是随机选择生成数字，大小写字母
        switch(index)
        {
            case 0:
                System.out.println("add(new ScreenInfo(\"1080\",\"1920\",\"3.0\"));"); break;
            case 1:
                System.out.println("add(new ScreenInfo(\"720\",\"1280\",\"2.0\"));"); break;
        }
    }

    public static void createRandomVersion()
    {
        Random rand=new Random();//随机用以下三个随机生成器
        int indexVersion=rand.nextInt(7);
        //目的是随机选择生成数字，大小写字母
        switch(indexVersion)
        {
            case 0://
                System.out.println("add(\"4.4.4\");"); break;
            case 1://
                System.out.println("add(\"5.0.1\");"); break;
            case 2://
                System.out.println("add(\"5.0.2\");"); break;
            case 3://
                System.out.println("add(\"5.1.1\");"); break;
            case 4://
                System.out.println("add(\"6.0\");"); break;
            case 5://
                System.out.println("add(\"6.0.1\");"); break;
            case 6://
                System.out.println("add(\"7.0\");"); break;
        }

    }
    public static void createRandomPhone()
    {
        Random rand=new Random();//随机用以下三个随机生成器
        int indexMake=rand.nextInt(2);
        //目的是随机选择生成数字，大小写字母
        switch(indexMake)
        {
            case 0://xiaomi
                System.out.println("add(new PhoneInfo(\"Redmi Note 3\",\"kenzo\",\"6.0.1\",\"V8.5.5.0.MHOCNED\",\"xiaomi\"));");
                break;
            case 1://huawei
                System.out.println("add(new PhoneInfo(\"Nexus 6P\",\"kenzo\",\"6.0.1\",\"V8.5.5.0.MHOCNED\",\"HUAWEI\"));");
                break;
        }
    }

}
