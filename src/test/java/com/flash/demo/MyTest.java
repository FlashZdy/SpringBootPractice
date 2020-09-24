package com.flash.demo;


import com.flash.demo.pojo.Department;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.IRObject;

import java.lang.reflect.Array;
import java.util.*;

public class MyTest {

    @Test
    public void test00(){
        HashMap<Integer, Department> map = new HashMap<>();
        map.put(101,new Department(101,"sss"));
        map.put(102,new Department(102,"aaa"));
        map.put(103,new Department(103,"ggg"));
        map.put(104,new Department(104,"yyy"));

        Collection<Department> departments =null;
        departments = map.values();
        System.out.println(departments);

        Set<Integer> set = null;
        set = map.keySet();
        System.out.println(set);
    }





}
