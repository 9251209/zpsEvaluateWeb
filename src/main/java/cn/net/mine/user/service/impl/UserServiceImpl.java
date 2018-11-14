package cn.net.mine.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.mine.user.dao.UserDao;
import cn.net.mine.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Object userAdd(String userno, String password, String telphone, String status, Integer flag, String realname,
                          String sex, Integer age, String education, String position) {
        return userDao.userAdd(userno, password, telphone, status, flag, realname, sex, age, education, position);
    }

    @Override
    public Object userUpdate(String id, String userno, String password, String telphone, String status, Integer flag,
                             String realname, String sex, Integer age, String education, String position) {
        return userDao.userUpdate(id, userno, password, telphone, status, flag, realname, sex, age, education, position);
    }

    @Override
    public Object userDel(String id) {
        return userDao.userDel(id);
    }

    @Override
    public int findBtName(String userno) {
        return userDao.findBtName(userno);
    }

    @Override
    public int findBtName(String userno, String id) {
        return userDao.findBtName(userno, id);
    }

    @Override
    public Map<String, Object> login(String userno, String pawwsord) {
        // TODO Auto-generated method stub
        return userDao.login(userno, pawwsord);
    }

    @Override
    public List<Map<String, Object>> selectUserList(Integer pageNo, Integer pagesize, String userno, String status) {
        // TODO Auto-generated method stub
        return userDao.selectUserList(pageNo, pagesize, userno, status);
    }

    @Override
    public Integer count(String userno, String status) {
        // TODO Auto-generated method stub
        return userDao.count(userno, status);
    }
    @Override
    public List<Map<String, Object>> selectUserLists(Integer pageNo, Integer pagesize, String userno, String status) {
        // TODO Auto-generated method stub
        return userDao.selectUserLists(pageNo, pagesize, userno, status);
    }

    @Override
    public Integer counts(String userno, String status) {
        // TODO Auto-generated method stub
        return userDao.counts(userno, status);
    }
    @Override
    public List<Map<String, Object>> selectUser(String id) {
        // TODO Auto-generated method stub
        return userDao.selectUser(id);
    }

    @Override
    public Object statusUpdate(String id,String status) {
        return this.userDao.statusUpdate(id,status);
    }
}
