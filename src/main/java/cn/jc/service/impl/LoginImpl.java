package cn.jc.service.impl;

import cn.jc.dao.LoginDao;
import cn.jc.entity.Login;
import cn.jc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements LoginService {

    @Autowired

    private LoginDao mapper;
    @Override
    public Login listLogin(Login login) {
        return mapper.listLogin(login);
    }
}
