package cn.jc.controller;

import cn.jc.entity.Login;
import cn.jc.service.LoginService;

import cn.jc.utli.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping("/listlogin")
    @ResponseBody
    public ResultMap listLogin(String username, String password){

        Login login = service.listLogin(new Login(username,password));

        if (login != null){
            return ResultMap.ok(null);
        }else {
            return ResultMap.fail(null);
        }
    }

}
