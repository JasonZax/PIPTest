package com.ibm.demopip.entity;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
* @description:  代码
* @author: zhouzhong
* @date: 2021/07/10 21:46
* @path: com.example.demo.entity.Dm
* @version: 1.0
*/
@Entity
@Data //get和set
@Table(appliesTo = "dm")
public class Dm implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String code;

    private String name;

    private String type;
}
