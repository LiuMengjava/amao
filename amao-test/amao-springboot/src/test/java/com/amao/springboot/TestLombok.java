package com.amao.springboot;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;


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
        //System.out.println(a == null); //true
        //System.out.println(a == 111); //空指针
        //System.out.println(a != 111); //空指针
        //System.out.println(a != null); // false
        //System.out.println(a != b); // true
        //System.out.println(a == b); // false
    }
}
