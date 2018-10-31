package cn.net.mine.user.service;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface UserService extends SuperService {

    // 添加
    Object userAdd(String userno, String password, String phone, String status, Integer flag, String realname,
                   String sex, Integer age, String education, String position);

    // 修改
    Object userUpdate(String id, String userno, String password, String phone, String status, Integer flag,
                      String realname, String sex, Integer age, String education, String position);

    // 删除
    Object userDel(String id);

    int findBtName(String userno);

    int findBtName(String userno, String id);

    // 登陆
    Map<String, Object> login(String userno, String pawwsord);

    // 用户列表
    List<Map<String, Object>> selectUserList(Integer pageNo, Integer pagesize, String userno, String status);

    // 查询总条数
    Integer count(String userno, String status);

    //查询单条
    List<Map<String, Object>> selectUser(String id);
}