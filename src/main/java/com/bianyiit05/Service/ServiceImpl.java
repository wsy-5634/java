package com.bianyiit05.Service;

import com.bianyiit05.dao.IUserDao;
import com.bianyiit05.dao.impl.UserDaoImpl;

public class ServiceImpl {
    IUserDao dao = new UserDaoImpl();

    public void saveUser(){
        dao.saveUser();
    }

}
