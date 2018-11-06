package cn.net.mine.projectunit.service.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.projectunit.dao.ProjectunitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.net.mine.projectunit.service.ProjectunitService;


@Service
public class ProjectunitServiceImpl implements ProjectunitService {

    @Autowired
    private ProjectunitDao projectunitDao;

    @Override
    public Object projectunitAdd(String unitno, String unitname, String prono) {
        // TODO Auto-generated method stub
        return projectunitDao.projectunitAdd(unitno, unitname, prono);
    }

    @Override
    public Object projectunitUpdate(String id, String unitno, String unitname, String prono) {
        // TODO Auto-generated method stub
        return projectunitDao.projectunitUpdate(id, unitno, unitname, prono);
    }

    @Override
    public Object projectunitDel(String id) {
        // TODO Auto-generated method stub
        return projectunitDao.projectunitDel(id);
    }

    @Override
    public int findBtName(String unitno) {
        // TODO Auto-generated method stub
        return projectunitDao.findBtName(unitno);
    }

    @Override
    public int findBtName(String unitno, String id) {
        // TODO Auto-generated method stub
        return projectunitDao.findBtName(unitno, id);
    }


    @Override
    public List<Map<String, Object>> selectProjectunitList(Integer pageNo, Integer pagesize, String unitno, String unitname, String prono) {
        // TODO Auto-generated method stub
        return projectunitDao.selectProjectunitList(pageNo, pagesize, unitno, unitname, prono);
    }

    @Override
    public Integer count(String unitno, String unitname, String prono) {
        // TODO Auto-generated method stub
        return projectunitDao.count(unitno, unitname, prono);
    }

    @Override
    public List<Map<String, Object>> selectProjectunit(String id) {
        // TODO Auto-generated method stub
        return projectunitDao.selectProjectunit(id);
    }

    @Override
    public List<Map<String, Object>> selectGetProjectunitList(String unitno, String unitname, String prono) {
        return this.projectunitDao.selectGetProjectunitList(unitno, unitname, prono);
    }

}
