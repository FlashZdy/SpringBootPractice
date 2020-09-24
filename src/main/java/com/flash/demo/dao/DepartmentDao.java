package com.flash.demo.dao;

import com.flash.demo.pojo.Department;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.crypto.interfaces.PBEKey;
import java.security.PublicKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    //模拟数据库
    private static Map<Integer, Department> departments = null;

    static {

        System.out.println("实例化Dao开始");
        departments = new HashMap<Integer,Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));

        System.out.println("实例化Dao结束");
    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){

        System.out.println("进入DAO的getDepartments");
        return departments.values();
    }

    //由id得到部门
    public Department getDepartmentById(Integer id){
        System.out.println("进入DAO的getDepartmentById");
        return departments.get(id);
    }

    @Test
    public void test(){
        DepartmentDao departmentDao = new DepartmentDao();
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
    }
}
