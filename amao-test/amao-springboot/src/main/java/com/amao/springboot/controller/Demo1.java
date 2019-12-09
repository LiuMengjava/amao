package com.amao.springboot.controller;

import com.amao.springboot.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Demo1 {

    @Autowired(required = true)
    private DroolsService droolsService;
    @RequestMapping(value="/sendmsg",method = RequestMethod.GET)
    public String getString(){
        return droolsService.fireRule();
    }
}
