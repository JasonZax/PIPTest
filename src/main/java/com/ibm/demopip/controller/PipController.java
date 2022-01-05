package com.ibm.demopip.controller;

import com.ibm.demopip.entity.Demo;
import com.ibm.demopip.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @description:  demo
* @author: zxuan
* @date: 2021/12/22 10:13
* @path: com.ibm.demopip.controller.TestController
* @version: 1.0
*/
@RestController
@RequestMapping(value = "/test")
public class PipController {
    @Autowired
    private DemoRepository demoService;


    //查询
    @RequestMapping(value = "/query")
    public Map query(){
        Map map_res = new HashMap();
        Demo search = new Demo();
//        search.setState("1");
        Example<Demo> example = Example.of(search);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable page = PageRequest.of(0,5,sort);
        Page pages = demoService.findAll(example,page);
        List<Demo> content = pages.getContent();
        map_res.put("total",pages.getTotalElements());
        map_res.put("list",content);
        return map_res;
    }




}
