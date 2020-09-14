package com.amao.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;


public  class  TestLombok<T> {

    // 斐波那契数列
    @Test
    public void  recursive(){
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
        //System.out.println(b == c); // true
        //System.out.println(b.equals(c)); // true

        Integer d = 1000,e = 1000;
        Integer f = 100,g = 100;
        System.out.println(d == e); // false 这里为false的原因是：Integer 会默认吧 -128到127加载带cache中，== 比较的是地址值，在这个范围外的，就会开辟新的内存空间，所以地址值不相等
        System.out.println(f == g); // true

       // System.out.printf("你好%s%d","laji",12);
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

        String biz = "admin123456";
        byte[] encode = Base64.getEncoder().encode(biz.getBytes());
        System.out.println(new String(encode));

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
    @Test
    public void getJson() throws ParseException {
        JSONObject json = new JSONObject();
        json.put("cpuRate","16");

        Double cpuRate = json.getDouble("cpuRate");
        System.out.println(cpuRate);//16.0

        HashMap<String, Object> hashMap = new HashMap<>();
        //hashMap.putAll(json);

        for (Iterator it = json.keySet().iterator();it.hasNext();){
            String next = (String) it.next();
            hashMap.put(next,json.get(next));
        }
        System.out.println(hashMap); // {cpuRate=16}
    }

    // base64编码
    @Test
    public void testArray() throws IOException {
        String str = "C:";
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(str.getBytes()).replace("=","_"));

        BASE64Decoder base64Decoder = new BASE64Decoder();
        String sr = new String(base64Decoder.decodeBuffer("Og__".replace("_","=")));
        System.out.println(sr);
    }

    // json 转实体类
    @Test
    public void testInit() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type","2");
        jsonObject.put("index","2");
        jsonObject.put("timestamp","1621131332");
        JSONObject json = new JSONObject();
        json.put("cpuRate",23);
        jsonObject.put("value",json);

        StatsStaticInfo statsStaticInfo = jsonObject.toJavaObject(StatsStaticInfo.class);
        System.out.println(statsStaticInfo);
        changeValue(jsonObject);
        System.out.println(jsonObject);

        JSONObject js = null ;
        String s = JSON.toJSONString(js);
        System.out.println(s);
    }

    void changeValue(JSONObject json){
        json.put("value",34.2);
    }


    @Test
    public void testOOO(){
        User user = new User();
        user.setName("aa");
        //user.setAge(0);
        if (0 == user.getGender()){
            System.out.println(user);
        }
        if (0 == user.getAge()){ // 空指针
            System.out.println(user);
        }
    }

    @Data
    class User {
        Integer age;
        int gender;
        String name;
    }
}
