package cn.net.mine.user.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.net.mine.common.util.CommonUtils;
import cn.net.mine.common.util.ReturnObject;
import cn.net.mine.user.service.UserService;

/**
 * @program:
 * @description: 用户
 * @author: √   99
 * @create:
 **/
@Component
@CrossOrigin
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加
     *
     * @param response
     * @param userno    用户名
     * @param password  密码
     * @param telphone  电话
     * @param status    状态0未审核1通过
     * @param flag  区分管理员1、普通用户0
     * @param realname  真实姓名
     * @param sex   性别
     * @param age   年龄
     * @param education 教育程度
     * @param position  职务
     * @return
     */
    @RequestMapping(value = "/userAdd")
    @ResponseBody
    public ReturnObject userAdd(HttpServletResponse response, @RequestParam(value = "userno") String userno,
                                @RequestParam(value = "password") String password, @RequestParam(value = "telphone") String telphone,
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
            ro.setData(this.userService.userAdd(userno, password, telphone, status, flag, realname, sex, age, education,
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
     *
     * @param response
     * @param id
     * @param userno    用户名
     * @param password  密码
     * @param telphone  电话
     * @param status    状态0未审核1通过
     * @param flag  区分管理员1、普通用户0
     * @param realname  真实姓名
     * @param sex   性别
     * @param age   年龄
     * @param education 教育程度
     * @param position  职务
     * @return
     */
    @RequestMapping(value = "/userUpdate")
    @ResponseBody
    public ReturnObject userUpdate(HttpServletResponse response, String id,
                                   String userno, String password,
                                   String telphone, String status,
                                   Integer flag, String realname,
                                   String sex, Integer age,
                                   String education, String position) {
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
            ro.setMsg("修改成功！");
            ro.setData(this.userService.userUpdate(id, userno, password, telphone, status, flag, realname, sex, age,
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
     *
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
    @PostMapping(value = "/login")
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
                ro.setData(null);
                return ro;
            }
            // 添加session
            CommonUtils.setCurrentUserInfo(map);
            Map<String, Object> maps = CommonUtils.getCurrentUserInfo();
            ro.setCode("1");
            ro.setMsg("登陆成功！");
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
     *
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

        double count = new BigDecimal(userService.count(userno, status)).divide(new BigDecimal(1)).doubleValue();
        Integer b = (int) Math.ceil(count / pagesize);
        ro.setCode("1");
        ro.setMsg("查询总页数！");
        ro.setData(b);
        return ro;
    }


    /**
     * 查询单条
     *
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

    /**
     * 审核
     *
     * @param response
     * @param id
     * @return
     */

    @PostMapping(value = "/statusUpdate")
    @ResponseBody
    public ReturnObject statusUpdate(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {
            ro.setCode("1");
            ro.setMsg("审核成功！");
            ro.setData(this.userService.statusUpdate(id));
            return ro;
        } catch (Exception e) {
            e.printStackTrace();
            ro.setCode("0");
            ro.setMsg("系统繁忙请稍后再试！！！");
            ro.setData(null);
            return ro;
        }
    }
}