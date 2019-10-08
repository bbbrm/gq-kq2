package cn.jc.controller;


import cn.jc.entity.Classes;
import cn.jc.entity.Employees;
import cn.jc.entity.PageBean;
import cn.jc.service.EmployeesService;
import cn.jc.utli.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService service;

    // 查询全部
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap listProduct(String page, String limit, String name) {
        int page1 = Integer.valueOf(page);
        int limit1 = Integer.valueOf(limit);
        PageBean<Employees> employeesPageBean =  service.listEmployees(page1,limit1,name);
        return ResultMap.ok(employeesPageBean.getData(), employeesPageBean.getCount());
    }






    // 查询指定信息
    @RequestMapping("/load")
    public String loadProduct(int id,Model model) {
        Employees employees = service.loadEmployees(id);
        model.addAttribute("list",employees);
        return "/loadEmployees";
    }


    //删除
    @GetMapping("/delete")
    @ResponseBody
    public ResultMap deleteProduct(int id) {

        List<Classes> b = service.deleteEmployees(id);
        return ResultMap.ok(b);
    }


    //修改
    @RequestMapping("/update")
    @ResponseBody
    public ResultMap updateEmployees(Employees employees) {

        boolean b = service.updateEmployees(employees);
        if (b){

            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    //添加
    @RequestMapping("/add")
    @ResponseBody
    public ResultMap addEmployeest(Employees employees) {
        return ResultMap.ok(service.addEmployeest(employees));
    }



}
