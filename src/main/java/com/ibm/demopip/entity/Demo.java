package com.ibm.demopip.entity;


import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

/**
* @description:
* @author: zxuan
* @date: 2021/12/22
* @path: com.ibm.demopip.entity.User
* @version: 1.0
*/
@Entity
@Data //get和set
@Table(appliesTo = "demo")
public class Demo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String date;
    @Column
    private String type;

////    @JsonIgnore
////    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @OneToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "state",referencedColumnName = "code" , insertable = false, updatable = false)
////    @JSONField(serialize = false)
//    private Demo dm;

}
