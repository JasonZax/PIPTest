package com.ibm.demopip.controller;

import com.ibm.demopip.entity.Demo;
import com.ibm.demopip.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    private DemoRepository demoRepository;


    //insert
    @RequestMapping(value = "/insert")
    public Demo insert(){


        String csvFile = "";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Demo demo = new Demo();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] dm = line.split(cvsSplitBy);
                String id = dm[0];
                String name = dm[1];
                String date = dm[2];
                String type = dm[3];
                int ins = demoRepository.insertAll(id,name,date,type);
                System.out.println("Demo [id= " + dm[0] + " , name=" + dm[1] + "]");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return demo;
    }

//    //insert
//    @RequestMapping(value = "/query")
//    public Demo query(String id){
//
//    Demo demo = new Demo();
//    demo = demoRepository.findAll(id);
//
//    return demo;
//    }



}
