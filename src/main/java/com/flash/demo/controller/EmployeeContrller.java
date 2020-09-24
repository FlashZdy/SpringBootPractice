package com.flash.demo.controller;


import com.flash.demo.dao.DepartmentDao;
import com.flash.demo.dao.EmployeeDao;
import com.flash.demo.pojo.Department;
import com.flash.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@Controller
    public class EmployeeContrller {

        @Autowired
        EmployeeDao employeeDao;
        @Autowired
        DepartmentDao departmentDao;

        @RequestMapping("/emps")
        public String list(Model model){
            Collection<Employee> emps = employeeDao.getAllEmployees();
            model.addAttribute("emps",emps);
            return "/emp/list";
        }

        @RequestMapping("/update")
        public String update(@RequestParam("employeeId")Integer id){

            return "redirect:/emps";
        }


        @GetMapping("/emp")
        public String toAdd(Model model){
            Collection<Department> departments = departmentDao.getDepartments();
            model.addAttribute("departments",departments);
            return "/emp/add";
        }

//        @PostMapping("/emp")

//        public String add(String lastName, String email, Integer gender, Integer department){
//            employeeDao.saveEmployee(new Employee(null,lastName,email,gender,departmentDao.getDepartmentById(department)));
//
//            return "redirect:/emps";
//        }

    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.saveEmployee(employee);

        return "redirect:/emps";
    }

    @GetMapping("/update/{id}")
    public String toUpdate(Model model, @PathVariable("id")Integer id){
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/emp/update";
    }

    @PostMapping("/update")
    public String update(Employee employee){
        System.out.println("进入update方法");

        employeeDao.updateEmployee(employee);

        return "redirect:/emps";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("employeeId")Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }

    //restful风格,对应list.html中被注释的a标签
//        @RequestMapping("/delete/{employeeId}")
//    public String delete(@PathVariable("employeeId")Integer id){
//            employeeDao.deleteEmployee(id);
//            return "redirect:/emps";
//        }


}
