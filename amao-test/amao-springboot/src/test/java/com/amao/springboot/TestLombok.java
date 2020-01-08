package com.amao.springboot;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.HashMap;


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
        String str = null;
        JSONObject jsonObject = JSONObject.parseObject(str);
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
        String rule = "a_b_c_d";
        //String[] member = {"a","b","c",""};
        HashMap<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("d","");
        StringBuilder pcode = new StringBuilder();
        //动态组装pcode
        if (StringUtils.isBlank(pcode)) {
            String[] rules = rule.split("_");
            for (int i = 0; i < rules.length; i++) {
                String str = rules[i];
                if (i == rules.length - 1) {
                    pcode.append(map.get(str));
                    break;
                }
                pcode.append(map.get(str) + "_");
            }
        }
        System.out.println(pcode);
    }

    @Test
    public void testList(){
        ArrayList<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());

    }
}
