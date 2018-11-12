package cn.net.mine.score.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.score.service.ScoreService;
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
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    /**
     * 添加
     *
     * @param response
     * @param prono     项目编号
     * @param unitno    单体编号
     * @param sectionno 阶段编号
     * @param type      三大类
     * @param tablename 基础表名
     * @param score     分值
     * @return
     */
    @RequestMapping(value = "/scoreAdd")
    @ResponseBody
    public ReturnObject scoreAdd(HttpServletResponse response, String prono, String unitno, String sectionno, String type, String tablename, String score) {
        ReturnObject ro = new ReturnObject();
        try {


            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.scoreService.scoreAdd(prono, unitno, sectionno, type, tablename, score));
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
     * @param prono     项目编号
     * @param unitno    单体编号
     * @param sectionno 阶段编号
     * @param type      三大类
     * @param tablename 基础表名
     * @param score     分值
     * @return
     */
    @RequestMapping(value = "/scoreUpdate")
    @ResponseBody
    public ReturnObject scoreUpdate(HttpServletResponse response, String id, String prono, String unitno, String sectionno, String type, String tablename, String score) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.scoreService.scoreUpdate(id, prono, unitno, sectionno, type, tablename, score));
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
    @RequestMapping(value = "/scoreDel")
    @ResponseBody
    public ReturnObject scoreDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.scoreService.scoreDel(id));
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
     * @param prono     项目编号
     * @param unitno    单体编号
     * @param sectionno 阶段编号
     * @param type      三大类
     * @param tablename 基础表名
     * @param score     分值
     * @return
     */
    @RequestMapping(value = "/selectScoreList")
    @ResponseBody
    public ReturnObject selectScoreList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                        @RequestParam(value = "pagesize") Integer pagesize,
                                        String prono, String unitno, String sectionno, String type, String tablename, String score) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = scoreService.selectScoreList(pageNo, pagesize, prono, unitno, sectionno, type, tablename, score);

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
     * @param prono     项目编号
     * @param unitno    单体编号
     * @param sectionno 阶段编号
     * @param type      三大类
     * @param tablename 基础表名
     * @param score     分值
     * @return
     */
    @RequestMapping(value = "/selectScoreCount")
    @ResponseBody
    public ReturnObject selectScoreCount(HttpServletResponse response,
                                         @RequestParam(value = "pagesize") Integer pagesize, String prono, String unitno, String sectionno, String type, String tablename, String score) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        double count = new BigDecimal(scoreService.count(prono, unitno, sectionno, type, tablename, score)).divide(new BigDecimal(1)).doubleValue();

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
    @RequestMapping(value = "/selectScore")
    @ResponseBody
    public ReturnObject selectScore(HttpServletResponse response,
                                    @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = scoreService.selectScore(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }

    /**
     * 不分页查询全部
     *
     * @param response
     * @param prono     项目编号
     * @param unitno    单体编号
     * @param sectionno 阶段编号
     * @param type      三大类
     * @param tablename 基础表名
     * @param score     分值
     * @return
     */
    @RequestMapping(value = "/selectGetScoreList")
    @ResponseBody
    public ReturnObject selectGetScoreList(HttpServletResponse response,
                                           String prono, String unitno, String sectionno, String type, String tablename, String score) {

        ReturnObject ro = new ReturnObject();


        List<Map<String, Object>> list = scoreService.selectGetScoreList(prono, unitno, sectionno, type, tablename, score);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


}