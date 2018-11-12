package cn.net.mine.scoreformula.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.scoreformula.service.ScoreformulaService;
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
@RequestMapping(value = "/scoreformula")
public class ScoreformulaController {

    @Autowired
    private ScoreformulaService scoreformulaService;

    /**
     * 添加
     *
     * @param response
     * @param formula  varchar 	公式
     * @param type     varchar 	三大类
     * @param explain  varchar 	说明
     * @return
     */
    @RequestMapping(value = "/scoreformulaAdd")
    @ResponseBody
    public ReturnObject scoreformulaAdd(HttpServletResponse response, String formula, String type, String explain) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.scoreformulaService.scoreformulaAdd(formula, type, explain));
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
     * @param id       int
     * @param formula  varchar 	公式
     * @param type     varchar 	三大类
     * @param explain  varchar 	说明
     * @return
     */
    @RequestMapping(value = "/scoreformulaUpdate")
    @ResponseBody
    public ReturnObject scoreformulaUpdate(HttpServletResponse response, String id, String formula, String type, String explain) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.scoreformulaService.scoreformulaUpdate(id, formula, type, explain));
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
    @RequestMapping(value = "/scoreformulaDel")
    @ResponseBody
    public ReturnObject scoreformulaDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.scoreformulaService.scoreformulaDel(id));
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
     * 分页
     *
     * @param response
     * @param pageNo
     * @param pagesize
     * @param formula  varchar 	公式
     * @param type     varchar 	三大类
     * @param explain  varchar 	说明
     * @return
     */
    @RequestMapping(value = "/selectScoreformulaList")
    @ResponseBody
    public ReturnObject selectScoreformulaList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                               @RequestParam(value = "pagesize") Integer pagesize,
                                               String formula, String type, String explain) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = scoreformulaService.selectScoreformulaList(pageNo, pagesize, formula, type, explain);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


    /**
     * 分页总页数
     *
     * @param response
     * @param pagesize
     * @param formula  varchar 	公式
     * @param type     varchar 	三大类
     * @param explain  varchar 	说明
     * @return
     */
    @RequestMapping(value = "/selectScoreformulaCount")
    @ResponseBody
    public ReturnObject selectScoreformulaCount(HttpServletResponse response,
                                                @RequestParam(value = "pagesize") Integer pagesize, String formula, String type, String explain) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        double count = new BigDecimal(scoreformulaService.count(formula, type, explain)).divide(new BigDecimal(1)).doubleValue();

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
    @RequestMapping(value = "/selectScoreformula")
    @ResponseBody
    public ReturnObject selectScoreformula(HttpServletResponse response,
                                           @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = scoreformulaService.selectScoreformula(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }


    /**
     * 不分页查询
     *
     * @param response
     * @param formula  varchar 	公式
     * @param type     varchar 	三大类
     * @param explain  varchar 	说明
     * @return
     */
    @RequestMapping(value = "/selectGetScoreformulaList")
    @ResponseBody
    public ReturnObject selectGetScoreformulaList(HttpServletResponse response,
                                                  String formula, String type, String explain) {

        ReturnObject ro = new ReturnObject();


        List<Map<String, Object>> list = scoreformulaService.selectGetScoreformulaList(formula, type, explain);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }

}