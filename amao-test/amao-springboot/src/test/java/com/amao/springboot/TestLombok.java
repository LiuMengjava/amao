package com.amao.springboot;

import com.amao.pojo.OrderDO;
import org.junit.Test;


public class TestLombok {
    @Test
    public void pojoTest() {
        OrderDO orderDO = new OrderDO();
        orderDO.setDesc("111");
        Integer a = 12;
        orderDO.setSe(Boolean.parseBoolean(a+""));
        //orderDO.setSex(((Boolean) 123));
        System.out.println(orderDO);
    }

    // 斐波那契数列
    @Test
    public void recursive(){
        System.out.println(getSum(24));
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
        String str = "EDS自测包-1.0.0.1.zip";
        System.out.println(str.substring(str.lastIndexOf("-")+1,str.lastIndexOf(".")));
    }
}
