package cn.net.mine.unitsection.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.unitsection.service.UnitsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.mine.common.util.ReturnObject;


@Controller
@RequestMapping(value = "/unitsection")
public class UnitsectionController {

    @Autowired
    private UnitsectionService unitsectionService;

    /**
     * 用户添加
     *
     * @return √ 99 ,method = RequestMethod.POST
     */
    @RequestMapping(value = "/unitsectionAdd")
    @ResponseBody
    public ReturnObject unitsectionAdd(HttpServletResponse response, @RequestParam(value = "sectionno") String sectionno,
                                       @RequestParam(value = "sectionname") String sectionname, @RequestParam(value = "unitno") String unitno
                                       ) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = unitsectionService.findBtName(sectionno);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("用户名已存在请重新添加！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.unitsectionService.unitsectionAdd(sectionno, sectionno, sectionno));
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
     * 用户编辑
     *
     * @return √ 99 ,method = RequestMethod.POST
     */
    @RequestMapping(value = "/unitsectionUpdate")
    @ResponseBody
    public ReturnObject unitsectionUpdate(HttpServletResponse response, @RequestParam(value = "id") String id,
                                          @RequestParam(value = "sectionno") String sectionno,
                                          @RequestParam(value = "sectionname") String sectionname, @RequestParam(value = "unitno") String unitno) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = unitsectionService.findBtName(sectionno, id);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("用户名已存在请重新编辑！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.unitsectionService.unitsectionUpdate(id,sectionno, sectionname, unitno));
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
     * 用户删除
     *
     * @return √ 99 ,method = RequestMethod.POST
     */
    @RequestMapping(value = "/unitsectionDel")
    @ResponseBody
    public ReturnObject unitsectionDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.unitsectionService.unitsectionDel(id));
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
     *
     * @return ReturnObject
     */
    @RequestMapping(value = "/selectUnitsectionList")
    @ResponseBody
    public ReturnObject selectUnitsectionList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                              @RequestParam(value = "pagesize") Integer pagesize,  @RequestParam(value = "sectionno") String sectionno,
                                              @RequestParam(value = "sectionname") String sectionname, @RequestParam(value = "unitno") String unitno) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = unitsectionService.selectUnitsectionList(pageNo, pagesize, sectionno, sectionname ,unitno);

        ro.setCode("1");
        ro.setMsg("注销成功！");
        ro.setData(list);
        return ro;
    }

    /**
     * 查询总页数
     *
     * @param response
     * @param pagesize
     * @param unitsectionno
     * @param status
     * @return
     */
    @RequestMapping(value = "/selectUnitsectionCount")
    @ResponseBody
    public ReturnObject selectUnitsectionCount(HttpServletResponse response,
                                               @RequestParam(value = "pagesize") Integer pagesize,  @RequestParam(value = "sectionno") String sectionno,
                                               @RequestParam(value = "sectionname") String sectionname, @RequestParam(value = "unitno") String unitno) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        Integer count = unitsectionService.count(sectionno, sectionname ,unitno);
        Integer b = (int) Math.ceil(count / pagesize);
        ro.setCode("1");
        ro.setMsg("查询总页数！");
        ro.setData(b);
        return ro;
    }


    /**
     * 查询单条
     */
    @RequestMapping(value = "/selectUnitsection")
    @ResponseBody
    public ReturnObject selectUnitsection(HttpServletResponse response,
                                          @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = unitsectionService.selectUnitsection(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }

}