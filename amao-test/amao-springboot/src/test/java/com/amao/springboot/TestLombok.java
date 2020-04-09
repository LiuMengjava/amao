package com.amao.springboot;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.*;


public class TestLombok {

    // 斐波那契数列
    @Test
    public void recursive(){
        System.out.println(getSum(10));
    }

    public int getSum(int a){
        if (a == 1 || a == 2){
            return 1;
        }
        return getSum(a-1) + getSum(a-2);
    }

    @Test
    public void getBit(){
        String str = "test||test111||twst222";
        String[] split = str.split("\\|\\|");
        for (String s : split) {
            System.out.println(s);
        }
    }
    @Test
    public  void splitTest(){
        String str = "自测包-1.0.0.1.zip";
        System.out.println(str.substring(str.lastIndexOf("-")+1,str.lastIndexOf(".")));
    }
    @Test
    public void testJson(){
        String str = "{}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
        if (jsonObject!=null){
            System.out.println(1);
        }else {
            System.out.println(2);
        }
    }

    @Test
    public void testJson1(){
        // 空指针
        Integer b =11;
        Integer a = null;
        Integer c = 11;
        //System.out.println(a == null); //true
        //System.out.println(a == 111); //空指针
        //System.out.println(a != 111); //空指针
        //System.out.println(a != null); // false
        //System.out.println(a != b); // true
        //System.out.println(a == b); // false
        System.out.println(b == c);
        System.out.printf("你好%s%d","laji",12);
    }

    @Test
    public void testArrayList(){
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list1.add("a");
        list2.add("b");
        list1=list2;
        System.out.println(list1);

    }
    @Test
    public void TestInteger(){
        pojo pojo = new pojo();
        pojo.setAge(12);
        Integer a = 12;

        ArrayList<TestLombok.pojo> pojos = new ArrayList<>();
        pojos.add(pojo);
        for (TestLombok.pojo pojo2 : pojos) {
            if (a == pojo2.getAge()){
                System.out.println("验证");
            }else {
                System.out.println(a == pojo2.getAge());
            }
        }
    }
    @Data
    class pojo{
       private Integer age;
    }

    @Test
    public void testRule(){
        String key = "testing/ota/ihu/错误码接口代码_ceb80b270f8e595bbb3feb77eeeb8d91.zip";
        String bolbName = key.substring(0, key.indexOf(".")) + "_" + 1 + key.substring(key.indexOf("."));
        System.out.println(bolbName);
    }

    @Test
    public void testList(){
        String aaa = "{}";
        JSONObject jsonObject = JSONObject.parseObject(aaa);
        System.out.println(jsonObject != null);
        System.out.println(jsonObject);
        String aa = jsonObject.getString("aa");
        System.out.println(aa != null);
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("0.8");
        System.out.println(1-0.8);
        System.out.println(a.subtract(b));
    }

    @Test
    public void testUrl() throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("aa_()");

        String decode = URLDecoder.decode("%2F");
        System.out.println(decode);
    }
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    private static final ArrayList<String> LIST = new ArrayList();

    @Test
    public void testThreadLocal1(){
        String requestId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        requestId+=UUID.randomUUID().toString();
        System.out.println(requestId);
        THREAD_LOCAL.set(requestId);
    }
    @Test
    public void testThreadLocal(){
        /*String requestId = THREAD_LOCAL.get();
        if (StringUtils.isEmpty(THREAD_LOCAL.get())) {
            requestId = UUID.randomUUID().toString();
        }
        System.out.println(requestId);*/
        String decode = URLDecoder.decode("\u0004"); // \u0003
        System.out.println(decode);

    }
    @Test
    public void testThreadLocal2() throws UnknownHostException {
       String jo = "{\\\"appId\\\":1,\\\"dataType\\\":5,\\\"installationInstruction\\\":{\\\"instructions\\\":[{\\\"installationInstructionsVersion\\\":\\\"020000\\\",\\\"area1112SecurityCode\\\":\\\"f6d9669e8c078e5087d3f0ffa53a7b1b\\\",\\\"expectedInstallationTime\\\":213,\\\"ecuInstructions\\\":{\\\"queuedRequest\\\":0,\\\"sblnotpresent\\\":false,\\\"ecuAddress\\\":\\\"1634\\\",\\\"securityKey\\\":\\\"f6d9669e8c078e5087d3f0ffa53a7b1b\\\",\\\"softwarePartInstallationInstructions\\\":[{\\\"filename\\\":\\\"8890574266A\\\",\\\"estimatedInstallationtime\\\":2},{\\\"filename\\\":\\\"8890945220A\\\",\\\"estimatedInstallationtime\\\":189},{\\\"filename\\\":\\\"8890945221A\\\",\\\"estimatedInstallationtime\\\":22}]},\\\"assignmentValidations\\\":[{\\\"validationkeyHW\\\":\\\"F1AA\\\",\\\"ecuAddress\\\":\\\"1634\\\",\\\"validationType\\\":\\\"PRE\\\",\\\"validationkeySW\\\":\\\"F1AE\\\",\\\"partidentifiers\\\":[\\\"0\\\",\\\"8890945220\\\",\\\"8890945221\\\"]},{\\\"validationkeyHW\\\":\\\"F1AA\\\",\\\"ecuAddress\\\":\\\"1634\\\",\\\"validationType\\\":\\\"POST\\\",\\\"validationkeySW\\\":\\\"F1AE\\\",\\\"partidentifiers\\\":[\\\"0\\\",\\\"8890945220\\\",\\\"8890945221\\\"]}],\\\"ecuRemaining\\\":0,\\\"requiredPreparationTime\\\":90}],\\\"installationOrderId\\\":\\\"b2e16d7e-5e69-bd74-f1fe-e400015dfaa8\\\"},\\\"vin\\\":\\\"L6T7824Z2KW000594\\\"}";
        JSONObject jsonObject = JSONObject.parseObject(jo);
        System.out.println(jsonObject);
    }

    /**
     *  callable的方式实现多线程
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "thread";
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<String> s1 = es.submit(stringCallable);
        Future<String> s2 = es.submit(stringCallable);

        String s = s1.get();
        String s3 = s2.get();

        System.out.println(s == s3);

    }
}
