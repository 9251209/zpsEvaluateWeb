package cn.net.mine.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.mine.common.util.CommonUtils;
import cn.net.mine.common.util.ReturnObject;
import cn.net.mine.user.service.UserService;

/**
* @program:
*
* @description: 用户
*
* @author: √   99
*
* @create:
**/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加
     * @param response
     * @param userno
     * @param password
     * @param phone
     * @param status
     * @param flag
     * @param realname
     * @param sex
     * @param age
     * @param education
     * @param position
     * @return
     */
    @RequestMapping(value = "/userAdd")
    @ResponseBody
    public ReturnObject userAdd(HttpServletResponse response, @RequestParam(value = "userno") String userno,
                                @RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone,
                                @RequestParam(value = "status") String status, @RequestParam(value = "flag") Integer flag,
                                @RequestParam(value = "realname") String realname, @RequestParam(value = "sex") String sex,
                                @RequestParam(value = "age") Integer age, @RequestParam(value = "education") String education,
                                @RequestParam(value = "position") String position) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = userService.findBtName(userno);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("用户名已存在请重新添加！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.userService.userAdd(userno, password, phone, status, flag, realname, sex, age, education,
                    position));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }

    /**
     * 修改
     * @param response
     * @param id
     * @param userno
     * @param password
     * @param phone
     * @param status
     * @param flag
     * @param realname
     * @param sex
     * @param age
     * @param education
     * @param position
     * @return
     */
    @RequestMapping(value = "/userUpdate")
    @ResponseBody
    public ReturnObject userUpdate(HttpServletResponse response, @RequestParam(value = "id") String id,
                                   @RequestParam(value = "userno") String userno, @RequestParam(value = "password") String password,
                                   @RequestParam(value = "phone") String phone, @RequestParam(value = "status") String status,
                                   @RequestParam(value = "flag") Integer flag, @RequestParam(value = "realname") String realname,
                                   @RequestParam(value = "sex") String sex, @RequestParam(value = "age") Integer age,
                                   @RequestParam(value = "education") String education, @RequestParam(value = "position") String position) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = userService.findBtName(userno, id);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("用户名已存在请重新编辑！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.userService.userUpdate(id, userno, password, phone, status, flag, realname, sex, age,
                    education, position));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }

    /**
     * 删除
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/userDel")
    @ResponseBody
    public ReturnObject userDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.userService.userDel(id));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }

    /**
     * 登录
     *
     * @return ReturnObject
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ReturnObject login(HttpServletResponse response, @RequestParam(value = "userName") String userName,
                              @RequestParam(value = "passWord") String passWord) {
        ReturnObject ro = new ReturnObject();
        try {
            Map<String, Object> map = this.userService.login(userName, passWord);
            if (map == null) {
                ro.setCode("0");
                ro.setMsg("用户名或密码不正确！！！");
                ro.setData(null);
                return ro;
            }
            // 等待審核通過才能登陸
            if (map.get("status").equals("0")) {
                ro.setCode("1");
                ro.setMsg("等待审核！");
                ro.setData(map);
            }
            // 添加session
            CommonUtils.setCurrentUserInfo(map);
            ro.setCode("1");
            ro.setMsg("查询成功！");
            ro.setData(map);
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }

    /**
     * 注銷
     *
     * @return ReturnObject
     */
    @RequestMapping(value = "/getLogout")
    @ResponseBody
    public ReturnObject getLogout(HttpServletResponse response) {

        ReturnObject ro = new ReturnObject();

        CommonUtils.getLogout();
        ro.setCode("1");
        ro.setMsg("注销成功！");
        ro.setData(null);
        return ro;
    }

    /**
     * 分页查询
     * @param response
     * @param pageNo
     * @param pagesize
     * @param userno
     * @param status
     * @return
     */
    @RequestMapping(value = "/selectUserList")
    @ResponseBody
    public ReturnObject selectUserList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                       @RequestParam(value = "pagesize") Integer pagesize, @RequestParam(value = "userno") String userno,
                                       @RequestParam(value = "status") String status) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = userService.selectUserList(pageNo, pagesize, userno, status);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }

    /**
     * 查询总页数
     *
     * @param response
     * @param pagesize
     * @param userno
     * @param status
     * @return
     */
    @RequestMapping(value = "/selectUserCount")
    @ResponseBody
    public ReturnObject selectUserCount(HttpServletResponse response,
                                        @RequestParam(value = "pagesize") Integer pagesize, @RequestParam(value = "userno") String userno,
                                        @RequestParam(value = "status") String status) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        Integer count = userService.count(userno, status);
        Integer b = (int) Math.ceil(count / pagesize);
        ro.setCode("1");
        ro.setMsg("查询总页数！");
        ro.setData(b);
        return ro;
    }


    /**
     * 查询单条
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectUser")
    @ResponseBody
    public ReturnObject selectUser(HttpServletResponse response,
                                   @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = userService.selectUser(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }

}