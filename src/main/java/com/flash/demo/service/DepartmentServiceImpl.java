//package com.flash.demo.service;
//
//import com.flash.demo.dao.DepartmentDao;
//import com.flash.demo.pojo.Department;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//
//
//@Service
//public class DepartmentServiceImpl implements DepartmentService{
//
//    @Autowired
//    private DepartmentDao departmentDao;
//
//
//
//    public void setDepartmentDao(DepartmentDao departmentDao) {
//        this.departmentDao = departmentDao;
//    }
//
//
//
////    public DepartmentServiceImpl() {
////        System.out.println("实例化DepartmentServiceImpl");
////    }
//
//    @Override
//    public Collection<Department> getDepartments() {
//
//        System.out.println("进入getDepartments");
//        return departmentDao.getDepartments();
//    }
//
//    @Override
//    public Department getDepartmentById(Integer id) {
//
//
//        System.out.println("进入getDepartmentById");
//
//        return departmentDao.getDepartmentById(id);
//    }
//
//
//    @Test
//    public void test(){
//        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
////        Collection<Department> allDepartments = departmentService.getAllDepartments();
////        System.out.println(allDepartments);
//
//        Department department = departmentService.getDepartmentById(101);
//        System.out.println(department);
//    }
//}
