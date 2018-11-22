package cn.net.mine.newinfo.service.impl;


import cn.net.mine.newinfo.dao.NewinfoDao;
import cn.net.mine.newinfo.service.NewinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class NewinfoServiceImpl implements NewinfoService {

    @Autowired
    private NewinfoDao newinfoDao;

    @Override
    public Object newinfoAdd(String infoTitle, String infoType, String infoContent, String [] infoImg) {
        return this.newinfoDao.newinfoAdd(infoTitle, infoType, infoContent, infoImg);
    }

    @Override
    public Object newinfoUpdate(String id, String infoTitle, String infoType, String infoContent, String [] infoImg,String type) {
        return this.newinfoDao.newinfoUpdate(id, infoTitle, infoType, infoContent, infoImg, type);
    }

    @Override
    public Object newinfoDel(String id) {
        return this.newinfoDao.newinfoDel(id);
    }

    @Override
    public List<Map<String, Object>> selectNewinfoList(Integer pageNo, Integer pagesize, String infoTitle, String infoType, String infoContent,String type) {
        return this.newinfoDao.selectNewinfoList(pageNo, pagesize, infoTitle, infoType, infoContent, type);
    }

    @Override
    public Integer count(String infoTitle, String infoType, String infoContent,String type) {
        return this.newinfoDao.count(infoTitle, infoType, infoContent, type);
    }

    @Override
    public List<Map<String, Object>> selectNewinfo(String id) {
        return this.newinfoDao.selectNewinfo(id);
    }

    @Override
    public List<Map<String, Object>> selectGetNewinfoList(String infoTitle, String infoType, String infoContent) {
        return this.newinfoDao.selectGetNewinfoList(infoTitle, infoType, infoContent);
    }
}
