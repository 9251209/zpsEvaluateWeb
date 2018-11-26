package cn.net.mine.project.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.net.mine.project.service.ProjectService;
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
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 添加
     *
     * @param response
     * @param prono 项目编号
     * @param proname   项目名称
     * @param type  项目类型
     * @param userno    所属用户
     * @param totalInvestmentAmount 总投资额
     * @param coveredArea   建筑面积
     * @param purpose   项目功能
     * @param brief 工程概括
     * @param leader    项目负责人
     * @param address   地址
     * @param consCompany   施工单位
     * @param buildCompany  建设单位
     * @param superCompany  监理单位
     * @param designCompany 设计单位
     * @param prospectCompany   勘察单位
     * @return
     */
    @RequestMapping(value = "/projectAdd")
    @ResponseBody
    public ReturnObject projectAdd(HttpServletResponse response, String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                   String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany,String [] projectImage ,String leaderPhone) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = projectService.findBtName(prono);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("编号已存在请重新添加！！！");
                ro.setData(null);
                return ro;
            }
            if (totalInvestmentAmount != null && !totalInvestmentAmount.equals("")) {

            } else {
                totalInvestmentAmount = "0";
            }

            if (coveredArea != null && !coveredArea.equals("")) {

            } else {
                coveredArea = "0";
            }


            ro.setCode("1");
            ro.setMsg("添加成功！");
            ro.setData(this.projectService.projectAdd(prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany, projectImage, leaderPhone));
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
     * @param prono 项目编号
     * @param proname   项目名称
     * @param type  项目类型
     * @param userno    所属用户
     * @param totalInvestmentAmount 总投资额
     * @param coveredArea   建筑面积
     * @param purpose   项目功能
     * @param brief 工程概括
     * @param leader    项目负责人
     * @param address   地址
     * @param consCompany   施工单位
     * @param buildCompany  建设单位
     * @param superCompany  监理单位
     * @param designCompany 设计单位
     * @param prospectCompany   勘察单位
     * @return
     */
    @RequestMapping(value = "/projectUpdate")
    @ResponseBody
    public ReturnObject projectUpdate(HttpServletResponse response, String id, String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                      String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany,String [] projectImage,String leaderPhone) {
        ReturnObject ro = new ReturnObject();
        try {
            int i = projectService.findBtName(prono, id);
            if (i > 0) {
                ro.setCode("0");
                ro.setMsg("项目编号已存在请重新编辑！！！");
                ro.setData(null);
                return ro;
            }
            ro.setCode("1");
            ro.setMsg("编辑成功！");
            ro.setData(this.projectService.projectUpdate(id, prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany, projectImage, leaderPhone));
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
    @RequestMapping(value = "/projectDel")
    @ResponseBody
    public ReturnObject projectDel(HttpServletResponse response, @RequestParam(value = "id") String id) {
        ReturnObject ro = new ReturnObject();
        try {

            ro.setCode("1");
            ro.setMsg("删除成功！");
            ro.setData(this.projectService.projectDel(id));
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
     * @param proname   项目名称
     * @param type  项目类型
     * @param userno    所属用户
     * @param totalInvestmentAmount 总投资额
     * @param coveredArea   建筑面积
     * @param purpose   项目功能
     * @param brief 工程概括
     * @param leader    项目负责人
     * @param address   地址
     * @param consCompany   施工单位
     * @param buildCompany  建设单位
     * @param superCompany  监理单位
     * @param designCompany 设计单位
     * @param prospectCompany   勘察单位
     * @return
     */
    @RequestMapping(value = "/selectProjectList")
    @ResponseBody
    public ReturnObject selectProjectList(HttpServletResponse response, @RequestParam(value = "pageNo") Integer pageNo,
                                          @RequestParam(value = "pagesize") Integer pagesize,
                                          String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                          String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {

        ReturnObject ro = new ReturnObject();
        if (pageNo == null || pageNo.equals("")) {
            pageNo = 1;
        }
        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        List<Map<String, Object>> list = projectService.selectProjectList(pageNo, pagesize, prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


    /**
     * 分页查询总页数
     *
     * @param response
     * @param pagesize
     * @param prono
     * @param proname   项目编号
     * @param type  项目名称
     * @param userno    项目类型
     * @param totalInvestmentAmount 所属用户
     * @param coveredArea   总投资额
     * @param purpose   建筑面积
     * @param brief 项目功能
     * @param leader    工程概括
     * @param address   项目负责人
     * @param consCompany   地址
     * @param buildCompany  施工单位
     * @param superCompany  建设单位
     * @param designCompany 监理单位
     * @param prospectCompany   设计单位
     * @return
     */
    @RequestMapping(value = "/selectProjectCount")
    @ResponseBody
    public ReturnObject selectProjectCount(HttpServletResponse response,
                                           @RequestParam(value = "pagesize") Integer pagesize, String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                           String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {

        ReturnObject ro = new ReturnObject();

        if (pagesize == null || pagesize.equals("")) {
            pagesize = 1;
        }

        double count = new BigDecimal(projectService.count(prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany)).divide(new BigDecimal(1)).doubleValue();

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
    @RequestMapping(value = "/selectProject")
    @ResponseBody
    public ReturnObject selectProject(HttpServletResponse response,
                                      @RequestParam(value = "id") String id) {

        ReturnObject ro = new ReturnObject();

        Map<String, Object> map = projectService.selectProject(id);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(map);
        return ro;
    }


    /**
     * 不分页查询
     *
     * @param response
     * @param prono 项目编号
     * @param proname   项目名称
     * @param type  项目类型
     * @param userno    所属用户
     * @param totalInvestmentAmount 总投资额
     * @param coveredArea   建筑面积
     * @param purpose   项目功能
     * @param brief 工程概括
     * @param leader    项目负责人
     * @param address   地址
     * @param consCompany   施工单位
     * @param buildCompany  建设单位
     * @param superCompany  监理单位
     * @param designCompany 设计单位
     * @param prospectCompany   勘察单位
     * @return
     */
    @RequestMapping(value = "/selectGetProjectList")
    @ResponseBody
    public ReturnObject selectGetProjectList(HttpServletResponse response,
                                             String prono, String proname, String type, String userno, String totalInvestmentAmount,
                                             String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {

        ReturnObject ro = new ReturnObject();


        List<Map<String, Object>> list = projectService.selectGetProjectList(prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


    /**
     * 根据用户 查询所有
     *
     * @param response
     * @param userno
     * @return
     */
    @RequestMapping(value = "/GetProjectList")
    @ResponseBody
    public ReturnObject GetProjectList(HttpServletResponse response,
                                       String userno) {

        ReturnObject ro = new ReturnObject();


        List<Map<String, Object>> list = projectService.GetProjectList(userno);

        ro.setCode("1");
        ro.setMsg("查询成功！");
        ro.setData(list);
        return ro;
    }


}