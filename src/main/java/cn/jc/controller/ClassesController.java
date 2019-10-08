package cn.jc.controller;



import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.service.ClassesService;
import cn.jc.utli.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService service;

    // 查询全部
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap listClasses(String page, String limit, String name) {
        int page1 = Integer.valueOf(page);
        int limit1 = Integer.valueOf(limit);
        PageBean<Classes> employeesPageBean =  service.listClasses(page1,limit1,name);
        return ResultMap.ok(employeesPageBean.getData(), employeesPageBean.getCount());
    }


    // 查询指定信息
    @RequestMapping("/load")
    public String loadClasses(int id, Model model) {
        Classes employees = service.loadClasses(id);
        model.addAttribute("list",employees);
        return "/loadClasses";
    }


    //删除
    @GetMapping("/deleteClasses")
    @ResponseBody
    public ResultMap deleteClasses(int id) {

        return ResultMap.ok(service.deleteClasses(id));
    }


    //修改
    @RequestMapping("/updateClasses")
    @ResponseBody
    public ResultMap updateClasses(Classes classes) {

        boolean b = service.updateClasses(classes);
        if (b){

            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    //添加
    @RequestMapping("/addClasses")
    @ResponseBody
    public ResultMap addClasses(Classes classes) {
        return ResultMap.ok(service.addClasses(classes));
    }


}
