package cn.net.mine.scoresum.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.scoresum.service.ScoresumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.mine.common.util.ReturnObject;

/**
 * @program:
 * @description:
 * @author: √   99
 * @create:
 **/

@Controller
@RequestMapping(value = "/scoresum")
public class ScoresumController {

    @Autowired
    private ScoresumService scoresumService;

    /**
     * 添加
     *
     * @param response
     * @param prono         项目编号
     * @param unitno        单体编号
     * @param sectionno     阶段编号
     * @param resourcevalue 资源值
     * @param energyvalue   能量值
     * @param manpowervalue 劳动力值
     * @param totalvalue    总值
     * @param starlevel     星级
     * @param resourcenum   资源项数
     * @param energynum     能量项数
     * @param manpowernum   劳动力项数
     * @return
     */
    @RequestMapping(value = "/scoresumAdd")
    @ResponseBody
    public ReturnObject scoresumAdd(HttpServletResponse response, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.scoresumService.scoresumAdd(prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum, scorename, userno));
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
     * @param prono         项目编号
     * @param unitno        单体编号
     * @param sectionno     阶段编号
     * @param resourcevalue 资源值
     * @param energyvalue   能量值
     * @param manpowervalue 劳动力值
     * @param totalvalue    总值
     * @param starlevel     星级
     * @param resourcenum   资源项数
     * @param energynum     能量项数
     * @param manpowernum   劳动力项数
     * @return
     */
    @RequestMapping(value = "/scoresumUpdate")
    @ResponseBody
    public ReturnObject scoresumUpdate(HttpServletResponse response, String id, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {
        ReturnObject ro = new ReturnObject();
        try {
            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.scoresumService.scoresumUpdate(id, prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum, scorename, userno));
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
    @RequestMapping(value = "/ScoresumDel")
    @ResponseBody
    public ReturnObject ScoresumDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.scoresumService.scoresumDel(id));
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
     * @param prono         项目编号
     * @param unitno        单体编号
     * @param sectionno     阶段编号
     * @param resourcevalue 资源值
     * @param energyvalue   能量值
     * @param manpowervalue 劳动力值
     * @param totalvalue    总值
     * @param starlevel     星级
     * @param resourcenum   资源项数
     * @param energynum     能量项数
     * @param manpowernum   劳动力项数
     * @return
     */
    @RequestMapping(value = "/selectScoresumList")
    @ResponseBody
    public ReturnObject selectScoresumList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                           @RequestParam(value = "pagesize") Integer pagesize,
                                           String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = scoresumService.selectScoresumList(pageNo, pagesize, prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum, scorename, userno);

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
     * @param prono         项目编号
     * @param unitno        单体编号
     * @param sectionno     阶段编号
     * @param resourcevalue 资源值
     * @param energyvalue   能量值
     * @param manpowervalue 劳动力值
     * @param totalvalue    总值
     * @param starlevel     星级
     * @param resourcenum   资源项数
     * @param energynum     能量项数
     * @param manpowernum   劳动力项数
     * @return
     */
    @RequestMapping(value = "/selectScoresumCount")
    @ResponseBody
    public ReturnObject selectScoresumCount(HttpServletResponse response,
                                            @RequestParam(value = "pagesize") Integer pagesize, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        double count = new BigDecimal(scoresumService.count(prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum, scorename, userno)).divide(new BigDecimal(1)).doubleValue();

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
    @RequestMapping(value = "/selectScoresum")
    @ResponseBody
    public ReturnObject selectScoresum(HttpServletResponse response,
                                       @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = scoresumService.selectScoresum(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }


    /**
     * 不分页查询
     *
     * @param response
     * @param prono         项目编号
     * @param unitno        单体编号
     * @param sectionno     阶段编号
     * @param resourcevalue 资源值
     * @param energyvalue   能量值
     * @param manpowervalue 劳动力值
     * @param totalvalue    总值
     * @param starlevel     星级
     * @param resourcenum   资源项数
     * @param energynum     能量项数
     * @param manpowernum   劳动力项数
     * @return
     */
    @RequestMapping(value = "/selectGetScoresumList")
    @ResponseBody
    public ReturnObject selectGetScoresumList(HttpServletResponse response,
                                              String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum, String scorename, String userno) {

        ReturnObject ro = new ReturnObject();


        List<Map<String, Object>> list = scoresumService.selectGetScoresumList(prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum, scorename, userno);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }

    /**
     * //删除历史纪录
     *
     * @param response
     * @param prono
     * @param unitno
     * @param sectionno
     * @return
     */
    @RequestMapping(value = "/Del")
    @ResponseBody
    public ReturnObject Del(HttpServletResponse response, String prono, String unitno, String sectionno,String scorename) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.scoresumService.Del(prono, unitno, sectionno, scorename));
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
     * 验证计算名是否重复
     *
     * @param response
     * @param scorename
     * @return
     */
    @RequestMapping(value = "/findBtName")
    @ResponseBody
    public ReturnObject findBtName(HttpServletResponse response, String scorename) {
        ReturnObject ro = new ReturnObject();
        try {
            Integer a = this.scoresumService.findBtName(scorename);
            if (a > 0) {
                ro.setCode("1");
                ro.setMsg("计算名重复！");
                ro.setData("1");
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("");
            ro.setData("0");
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