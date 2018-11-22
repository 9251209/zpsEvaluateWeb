package cn.net.mine.scorebase.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.scorebase.service.ScorebaseService;
import cn.net.mine.scorezone.service.ScorezoneService;
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
@RequestMapping(value = "/scorebase")
public class ScorebaseController {

    @Autowired
    private ScorebaseService scorebaseService;

    @Autowired
    private ScorezoneService scorezoneService;


    /**
     * 添加
     *
     * @param response
     * @param type           固定三类（资源消耗、能源消耗、劳动力消耗)
     * @param tablename      表名
     * @param formulaid      引用公式id
     * @param weight         权重
     * @param weightnew      权重
     * @param parama         定义参数
     * @param paramb         定义参数
     * @param paramc         定义参数
     * @param paramd         定义参数
     * @param paramy         定义参数
     * @param paramformula   定义公式
     * @param ua             定义参数单位
     * @param ub             定义参数单位
     * @param uc             定义参数单位
     * @param ud             定义参数单位
     * @param uy             定义参数单位
     * @param uformula       定义公式单位
     * @param explaina       定义参数注释
     * @param explainb       定义参数注释
     * @param explainc       定义参数注释
     * @param explaind       定义参数注释
     * @param explainy       定义参数注释
     * @param explainformula 定义公式注释
     * @return
     */
    @RequestMapping(value = "/scorebaseAdd")
    @ResponseBody
    public ReturnObject ScorebaseAdd(HttpServletResponse response, String type, String tablename, String formulaid, String weight,String weightnew, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        ReturnObject ro = new ReturnObject();
        try {
            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.scorebaseService.scorebaseAdd(type, tablename, formulaid, weight, weightnew, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula));
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
     * @param type           固定三类（资源消耗、能源消耗、劳动力消耗)
     * @param tablename      表名
     * @param formulaid      引用公式id
     * @param weight         权重
     * @param weightnew      权重
     * @param parama         定义参数
     * @param paramb         定义参数
     * @param paramc         定义参数
     * @param paramd         定义参数
     * @param paramy         定义参数
     * @param paramformula   定义公式
     * @param ua             定义参数单位
     * @param ub             定义参数单位
     * @param uc             定义参数单位
     * @param ud             定义参数单位
     * @param uy             定义参数单位
     * @param uformula       定义公式单位
     * @param explaina       定义参数注释
     * @param explainb       定义参数注释
     * @param explainc       定义参数注释
     * @param explaind       定义参数注释
     * @param explainy       定义参数注释
     * @param explainformula 定义公式注释
     * @return
     */
    @RequestMapping(value = "/scorebaseUpdate")
    @ResponseBody
    public ReturnObject scorebaseUpdate(HttpServletResponse response, String id, String type, String tablename, String formulaid, String weight,String weightnew, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        ReturnObject ro = new ReturnObject();
        try {
            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.scorebaseService.scorebaseUpdate(id, type, tablename, formulaid, weight, weightnew, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula));
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
    @RequestMapping(value = "/scorebaseDel")
    @ResponseBody
    public ReturnObject scorebaseDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.scorebaseService.scorebaseDel(id));
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
     * @param pageNo         页数
     * @param pagesize       条数
     * @param type           固定三类（资源消耗、能源消耗、劳动力消耗)
     * @param tablename      表名
     * @param formulaid      引用公式id
     * @param weight         权重
     * @param parama         定义参数
     * @param paramb         定义参数
     * @param paramc         定义参数
     * @param paramd         定义参数
     * @param paramy         定义参数
     * @param paramformula   定义公式
     * @param ua             定义参数单位
     * @param ub             定义参数单位
     * @param uc             定义参数单位
     * @param ud             定义参数单位
     * @param uy             定义参数单位
     * @param uformula       定义公式单位
     * @param explaina       定义参数注释
     * @param explainb       定义参数注释
     * @param explainc       定义参数注释
     * @param explaind       定义参数注释
     * @param explainy       定义参数注释
     * @param explainformula 定义公式注释
     * @return
     */
    @RequestMapping(value = "/selectScorebaseList")
    @ResponseBody
    public ReturnObject selectScorebaseList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                            @RequestParam(value = "pagesize") Integer pagesize,
                                            String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = scorebaseService.selectScorebaseList(pageNo, pagesize, type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);

        for (Map<String,Object> map:list){
            List<Map<String, Object>> scorezoneList =new ArrayList<>();
            scorezoneList=this.scorezoneService.selectGetScorezoneList(null, null, null,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,map.get("id").toString() );
            map.put("scorezoneList", scorezoneList);
        }

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
     * @param type
     * @param tablename
     * @param formulaid
     * @param weight
     * @param parama
     * @param paramb
     * @param paramc
     * @param paramd
     * @param paramy
     * @param paramformula
     * @param ua
     * @param ub
     * @param uc
     * @param ud
     * @param uy
     * @param uformula
     * @param explaina
     * @param explainb
     * @param explainc
     * @param explaind
     * @param explainy
     * @param explainformula
     * @return
     */
    @RequestMapping(value = "/selectScorebaseCount")
    @ResponseBody
    public ReturnObject selectScorebaseCount(HttpServletResponse response,
                                             @RequestParam(value = "pagesize") Integer pagesize, String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        double count = new BigDecimal(scorebaseService.count(type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula)).divide(new BigDecimal(1)).doubleValue();

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
    @RequestMapping(value = "/selectScorebase")
    @ResponseBody
    public ReturnObject selectScorebase(HttpServletResponse response,
                                        @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = scorebaseService.selectScorebase(id).get(0);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }


    /**
     * 不分页查询
     *
     * @param response
     * @param type           固定三类（资源消耗、能源消耗、劳动力消耗)
     * @param tablename      表名
     * @param formulaid      引用公式id
     * @param weight         权重
     * @param parama         定义参数
     * @param paramb         定义参数
     * @param paramc         定义参数
     * @param paramd         定义参数
     * @param paramy         定义参数
     * @param paramformula   定义公式
     * @param ua             定义参数单位
     * @param ub             定义参数单位
     * @param uc             定义参数单位
     * @param ud             定义参数单位
     * @param uy             定义参数单位
     * @param uformula       定义公式单位
     * @param explaina       定义参数注释
     * @param explainb       定义参数注释
     * @param explainc       定义参数注释
     * @param explaind       定义参数注释
     * @param explainy       定义参数注释
     * @param explainformula 定义公式注释
     * @return
     */
    @RequestMapping(value = "/selectGetScorebaseList")
    @ResponseBody
    public ReturnObject selectGetScorebaseList(HttpServletResponse response,
                                               String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {

        ReturnObject ro = new ReturnObject();


        List<Map<String, Object>> list = scorebaseService.selectGetScorebaseList(type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


}