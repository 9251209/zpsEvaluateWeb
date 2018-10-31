package cn.net.mine.project.service.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.project.dao.ProjectDao;
import cn.net.mine.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public Object projectAdd(String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.projectAdd( prono,  proname,  type,  userno,  totalInvestmentAmount,  coveredArea,  purpose,  brief,  leader,  address,  consCompany,  buildCompany,  superCompany,  designCompany,  prospectCompany);
    }

    @Override
    public Object projectUpdate(String id, String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.projectUpdate(id,prono,  proname,  type,  userno,  totalInvestmentAmount,  coveredArea,  purpose,  brief,  leader,  address,  consCompany,  buildCompany,  superCompany,  designCompany,  prospectCompany);
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
        return this.projectDao.selectProjectList(pageNo,pagesize, prono,  proname,  type,  userno,  totalInvestmentAmount,  coveredArea,  purpose,  brief,  leader,  address,  consCompany,  buildCompany,  superCompany,  designCompany,  prospectCompany);
    }

    @Override
    public Integer count(String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany) {
        return this.projectDao.count( prono,  proname,  type,  userno,  totalInvestmentAmount,  coveredArea,  purpose,  brief,  leader,  address,  consCompany,  buildCompany,  superCompany,  designCompany,  prospectCompany);
    }

    @Override
    public List<Map<String, Object>> selectProject(String id) {
        return this.projectDao.selectProject(id);
    }
}
