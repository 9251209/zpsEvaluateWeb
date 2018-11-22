package cn.net.mine.newinfo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.newinfo.service.NewinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.mine.common.util.ReturnObject;

/**
 *
 *广告位管理
 * @author √ 99
 * @date
 */

@Controller
@RequestMapping(value = "/newinfo")
public class NewinfoController {

    @Autowired
    private NewinfoService newinfoService;

    /**
     * 添加
     *
     * @param response
     * @param infoTitle   标题名称
     * @param infoType    主题类别
     * @param infoContent 内容
     * @param infoImg     图片
     * @return
     */
    @RequestMapping(value = "/newinfoAdd")
    @ResponseBody
    public ReturnObject newinfoAdd(HttpServletResponse response, String infoTitle, String infoType, String infoContent, String [] infoImg) {
        ReturnObject ro = new ReturnObject();
        try {


            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.newinfoService.newinfoAdd(infoTitle, infoType, infoContent, infoImg));
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
     * @param infoTitle   标题名称
     * @param infoType    主题类别
     * @param infoContent 内容
     * @param infoImg     图片
     * @return
     */
    @RequestMapping(value = "/newinfoUpdate")
    @ResponseBody
    public ReturnObject newinfoUpdate(HttpServletResponse response, String id, String infoTitle, String infoType, String infoContent, String[] infoImg,String type) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.newinfoService.newinfoUpdate(id, infoTitle, infoType, infoContent, infoImg, type));
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
    @RequestMapping(value = "/newinfoDel")
    @ResponseBody
    public ReturnObject newinfoDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.newinfoService.newinfoDel(id));
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
     * @param response
     * @param pageNo
     * @param pagesize
     * @param infoTitle   标题名称
     * @param infoType    主题类别
     * @param infoContent 内容
     * @return
     */
    @RequestMapping(value = "/selectNewinfoList")
    @ResponseBody
    public ReturnObject selectNewinfoList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                          @RequestParam(value = "pagesize") Integer pagesize,
                                          String infoTitle, String infoType, String infoContent,String type) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = newinfoService.selectNewinfoList(pageNo, pagesize, infoTitle, infoType, infoContent,type);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


    /**
     * 分页 查询总页数
     *
     * @param response
     * @param pagesize
     * @param infoTitle   标题名称
     * @param infoType    主题类别
     * @param infoContent 内容
     * @return
     */
    @RequestMapping(value = "/selectNewinfoCount")
    @ResponseBody
    public ReturnObject selectNewinfoCount(HttpServletResponse response,
                                           @RequestParam(value = "pagesize") Integer pagesize, String infoTitle, String infoType, String infoContent,String type) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        double count = new BigDecimal(newinfoService.count(infoTitle, infoType, infoContent, type)).divide(new BigDecimal(1)).doubleValue();

        int b = (int) Math.ceil(count / pagesize);
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
    @RequestMapping(value = "/selectNewinfo")
    @ResponseBody
    public ReturnObject selectNewinfo(HttpServletResponse response,
                                      @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = newinfoService.selectNewinfo(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }

    /**
     * 不分页查询全部
     *
     * @param response
     * @param infoTitle   标题名称
     * @param infoType    主题类别
     * @param infoContent 内容
     * @return
     */
    @RequestMapping(value = "/selectGetNewinfoList")
    @ResponseBody
    public ReturnObject selectGetNewinfoList(HttpServletResponse response,
                                             String infoTitle, String infoType, String infoContent) {

        ReturnObject ro = new ReturnObject();
        List<Map<String, Object>> list = newinfoService.selectGetNewinfoList(infoTitle, infoType, infoContent);
        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


}