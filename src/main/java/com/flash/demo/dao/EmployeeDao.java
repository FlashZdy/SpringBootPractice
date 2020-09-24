package com.flash.demo.dao;

import com.flash.demo.pojo.Department;
import com.flash.demo.pojo.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    //模拟数据库
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();

        employees.put(1001,new Employee(1001,"AA","ss@email.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","ss@email.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","ss@email.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","ss@email.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","ss@email.com",1,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void saveEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工和
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void deleteEmployee(Integer id){
        System.out.println("进入DAO的deleteEmployee方法");
        employees.remove(id);
        System.out.println("离开DAO的deleteEmployee方法");
    }

    public void updateEmployee(Employee employee){

        System.out.println("进入DAO的updateEmployee方法");

//        Employee newEmployee = null;
//        newEmployee.setId(employee.getId());
//        newEmployee.setLastName(employee.getLastName());
//        newEmployee.setEmail(employee.getEmail());
//        newEmployee.setDepartment(employee.getDepartment());
//        newEmployee.setBirth(employee.getBirth());

       saveEmployee(employee);

        System.out.println("离开DAO的updateEmployee方法");
    }

    @Test
    public void test(){
        EmployeeDao employeeDao = new EmployeeDao();
        Collection<Employee> employees = employeeDao.getAllEmployees();
        System.out.println(employees);
    }

}
