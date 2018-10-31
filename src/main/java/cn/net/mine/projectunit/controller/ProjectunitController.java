package cn.net.mine.projectunit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.mine.common.util.CommonUtils;
import cn.net.mine.common.util.ReturnObject;
import cn.net.mine.projectunit.service.ProjectunitService;

/**
 * 单体管理
 *
 * @author guoyp
 * @date 2018-4-8
 */
@Controller
@RequestMapping(value = "/projectunit")
public class ProjectunitController {

    @Autowired
    private ProjectunitService projectunitService;

    /**
     * 添加
     * @param response
     * @param unitno
     * @param unitname
     * @param prono
     * @return
     */
    @RequestMapping(value = "/projectunitAdd")
    @ResponseBody
    public ReturnObject projectunitAdd(HttpServletResponse response,
                                       @RequestParam(value = "unitno") String unitno,
                                       @RequestParam(value = "unitname") String unitname,
                                       @RequestParam(value = "prono") String prono
    ) {
        ReturnObject ro = new ReturnObject();


        try {
            int i = projectunitService.findBtName(unitno);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("单体编号已存在请重新添加！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.projectunitService.projectunitAdd(unitno, unitname, prono));
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
     * @param unitno
     * @param unitname
     * @param prono
     * @return
     */
    @RequestMapping(value = "/projectunitUpdate")
    @ResponseBody
    public ReturnObject projectunitUpdate(HttpServletResponse response, @RequestParam(value = "id") String id, @RequestParam(value = "unitno") String unitno,
                                          @RequestParam(value = "unitname") String unitname,
                                          @RequestParam(value = "prono") String prono) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = projectunitService.findBtName(unitno, id);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("单体编号已存在请重新编辑！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.projectunitService.projectunitUpdate(id, unitno, unitname, prono));
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
    @RequestMapping(value = "/projectunitDel")
    @ResponseBody
    public ReturnObject projectunitDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.projectunitService.projectunitDel(id));
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
     * 分页查询
     * @param response
     * @param pageNo
     * @param pagesize
     * @param unitno
     * @param unitname
     * @param prono
     * @return
     */
    @RequestMapping(value = "/selectProjectunitList")
    @ResponseBody
    public ReturnObject selectProjectunitList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                              @RequestParam(value = "pagesize") Integer pagesize, @RequestParam(value = "unitno") String unitno,
                                              @RequestParam(value = "unitname") String unitname,
                                              @RequestParam(value = "prono") String prono
    ) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = projectunitService.selectProjectunitList(pageNo, pagesize, unitno, unitname, prono);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }

    /***
     * 获取全部条数
     * @param response
     * @param pagesize
     * @param unitno
     * @param unitname
     * @param prono
     * @return
     */
    @RequestMapping(value = "/selectProjectunitCount")
    @ResponseBody
    public ReturnObject selectProjectunitCount(HttpServletResponse response,
                                               @RequestParam(value = "pagesize") Integer pagesize, @RequestParam(value = "unitno") String unitno,
                                               @RequestParam(value = "unitname") String unitname,
                                               @RequestParam(value = "prono") String prono) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        Integer count = projectunitService.count(unitno, unitname, prono);
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
    @RequestMapping(value = "/selectProjectunit")
    @ResponseBody
    public ReturnObject selectProjectunit(HttpServletResponse response,
                                          @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = projectunitService.selectProjectunit(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }

}