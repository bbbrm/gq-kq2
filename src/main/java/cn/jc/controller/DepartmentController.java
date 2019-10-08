package cn.jc.controller;



import cn.jc.entity.Classes;
import cn.jc.entity.Department;
import cn.jc.entity.PageBean;
import cn.jc.service.DepartmentService;
import cn.jc.utli.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // 查询全部
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap listDepartment(String page, String limit, String name) {
        int page1 = Integer.valueOf(page);
        int limit1 = Integer.valueOf(limit);
        PageBean<Department> employeesPageBean =  service.listDepartment(page1,limit1,name);
        return ResultMap.ok(employeesPageBean.getData(), employeesPageBean.getCount());
    }

    // 查询指定信息
    @RequestMapping("/load")
    public String loadDepartment(int id, Model model) {
        Department department = service.loadDepartment(id);
        model.addAttribute("list",department);
        return "/loadDepartment";
    }

    //删除
    @GetMapping("/deletedepartment")
    @ResponseBody
    public ResultMap deleteDepartment(int id) {

        List<Classes> b = service.deleteDepartment(id);
        return ResultMap.ok(b);
    }

    //修改
    @RequestMapping("/updatedepartment")
    @ResponseBody
    public ResultMap updateDepartment(Department department) {

        boolean b = service.updateDepartment(department);
        if (b){

            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    //添加
    @RequestMapping("/adddepartment")
    @ResponseBody
    public ResultMap addDepartment(Department department) {
        return ResultMap.ok(service.addDepartment(department));
    }
}
