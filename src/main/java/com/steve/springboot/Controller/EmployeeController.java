package com.steve.springboot.Controller;

import com.steve.springboot.dao.DepartmentDao;
import com.steve.springboot.dao.EmployeeDao;
import com.steve.springboot.entities.Department;
import com.steve.springboot.entities.Employee;
import com.sun.webkit.Timer;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model m){

        Collection<Employee> employees = employeeDao.getAll();
        m.addAttribute("emps", employees);
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model m){
        Collection<Department> departments = departmentDao.getDepartments();
        m.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        System.out.println("保存的员工信息 " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model m){
        Employee employee = employeeDao.get(id);
        m.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        m.addAttribute("depts", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工信息" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PostMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
