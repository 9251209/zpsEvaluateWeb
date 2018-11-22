package cn.net.mine.project.service.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.project.dao.ProjectDao;
import cn.net.mine.project.service.ProjectService;
import cn.net.mine.projectunit.dao.ProjectunitDao;
import cn.net.mine.scoresum.dao.ScoresumDao;
import cn.net.mine.unitsection.dao.UnitsectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectunitDao projectunitDao;
    @Autowired
    private UnitsectionDao unitsectionDao;


    @Override
    public Object projectAdd(String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.projectAdd(prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);
    }

    @Override
    public Object projectUpdate(String id, String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.projectUpdate(id, prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);
    }

    @Override
    public Object projectDel(String id) {
        return this.projectDao.projectDel(id);
    }

    @Override
    public int findBtName(String prono) {
        return this.projectDao.findBtName(prono);
    }

    @Override
    public int findBtName(String prono, String id) {
        return this.projectDao.findBtName(prono, id);
    }

    @Override
    public List<Map<String, Object>> selectProjectList(Integer pageNo, Integer pagesize, String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.selectProjectList(pageNo, pagesize, prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);
    }

    @Override
    public Integer count(String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.count(prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);
    }

    @Override
    public Map<String, Object> selectProject(String id) {
        Map<String, Object> project= this.projectDao.selectProject(id).get(0);
        //获取项目下所有单体
        if (project.get("prono").toString() != null || !project.get("prono").toString().equals("")) {
            List<Map<String, Object>> projectunitList = this.projectunitDao.selectGetProjectunitList(null, null, project.get("prono").toString());

            for (Map<String, Object> projectunit : projectunitList) {
                //获取单体下所有阶段
                if (projectunit.get("unitno").toString() != null && !projectunit.get("unitno").toString().equals("")) {
                    List<Map<String, Object>> unitsectionList = this.unitsectionDao.selectGetUnitsectionList(null, null, projectunit.get("unitno").toString());
                    //为当前单体添加阶段
                    projectunit.put("unitsectionList", unitsectionList);
                } else {
                    projectunit.put("unitsectionList", null);
                }
            }

            //为当前项目添加单体
            project.put("projectunitList", projectunitList);
        } else {
            //为当前项目添加单体
            project.put("projectunitList", null);
        }
        return   project;
    }


    @Override
    public List<Map<String, Object>> selectGetProjectList(String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.selectGetProjectList(prono, proname, type, userno, totalInvestmentAmount, coveredArea, purpose, brief, leader, address, consCompany, buildCompany, superCompany, designCompany, prospectCompany);
    }


    @Override
    public List<Map<String, Object>> GetProjectList(String userno) {
        //获取用户下所有项目
        List<Map<String, Object>> projectList = this.projectDao.selectGetProjectList(null, null, null, userno, null, null, null, null, null, null, null, null, null, null, null);
        for (Map<String, Object> project : projectList) {
            //获取项目下所有单体
            if (project.get("prono").toString() != null || !project.get("prono").toString().equals("")) {
                List<Map<String, Object>> projectunitList = this.projectunitDao.selectGetProjectunitList(null, null, project.get("prono").toString());

                for (Map<String, Object> projectunit : projectunitList) {
                    //获取单体下所有阶段
                    if (projectunit.get("unitno").toString() != null && !projectunit.get("unitno").toString().equals("")) {
                        List<Map<String, Object>> unitsectionList = this.unitsectionDao.selectGetUnitsectionList(null, null, projectunit.get("unitno").toString());
                        //为当前单体添加阶段
                        projectunit.put("unitsectionList", unitsectionList);
                    } else {
                        projectunit.put("unitsectionList", null);
                    }
                }

                //为当前项目添加单体
                project.put("projectunitList", projectunitList);
            } else {
                //为当前项目添加单体
                project.put("projectunitList", null);
            }
        }

        return projectList;
    }


}
