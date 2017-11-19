import java.lang.reflect.Method;

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
//        System.out.println("randomIMEI:"+randomIMEI());
        getMethodInfo("android.telephony.TelephonyManager");
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
}
