package com.flash.demo.pojo;


import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;

    private Department department;
    private Date birth;


    //自己写有参构造，在构造函数里写好birth，默认创建日期
    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
