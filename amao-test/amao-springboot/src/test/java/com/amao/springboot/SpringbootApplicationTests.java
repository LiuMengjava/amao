package com.amao.springboot;

import com.amao.springboot.dao.ItemMapper;
import com.amao.springboot.domain.Item;
import com.amao.springboot.domain.Message;
import com.drools.core.KieTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    KieTemplate kieTemplate;

    @Autowired
    ItemMapper itemMapper;
    @Test
    public void contextLoads() {
    }

    @Before
    public void beforeTest() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Test
    public void testDrools(){
        KieSession kieSession = kieTemplate.getKieSession("rule1.drl");
        List<Item> items = itemMapper.findAll();
        for (Item item : items) {
            // 通过规则筛选
            kieSession.insert(item);
            kieSession.fireAllRules();
        }
    }

    @Test
    public void testJpa() {
        Item item = new Item();
        item.setItemName("大保健");
        item.setItemPrice(666);
        itemMapper.save(item);
    }


}
