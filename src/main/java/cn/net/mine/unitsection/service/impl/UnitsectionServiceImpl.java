package cn.net.mine.unitsection.service.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.unitsection.dao.UnitsectionDao;
import cn.net.mine.unitsection.service.UnitsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UnitsectionServiceImpl implements UnitsectionService {

    @Autowired
    private UnitsectionDao unitsectionDao;

    @Override
    public Object unitsectionAdd(String sectionno, String sectionname, String unitno) {
        return this.unitsectionDao.unitsectionAdd(sectionno, sectionname, unitno);
    }

    @Override
    public Object unitsectionUpdate(String id, String sectionno, String sectionname, String unitno) {
        return this.unitsectionDao.unitsectionUpdate(id, sectionno, sectionname, unitno);
    }

    @Override
    public Object unitsectionDel(String id) {
        return this.unitsectionDao.unitsectionDel(id);
    }

    @Override
    public int findBtName(String sectionno) {
        return this.unitsectionDao.findBtName(sectionno);
    }

    @Override
    public int findBtName(String sectionno, String id) {
        return this.unitsectionDao.findBtName(sectionno, id);
    }

    @Override
    public List<Map<String, Object>> selectUnitsectionList(Integer pageNo, Integer pagesize, String sectionno, String sectionname, String unitno) {
        return this.unitsectionDao.selectUnitsectionList(pageNo, pagesize, sectionno, sectionname, unitno);
    }

    @Override
    public Integer count(String sectionno, String sectionname, String unitno) {
        return this.unitsectionDao.count(sectionno, sectionname, unitno);
    }

    @Override
    public List<Map<String, Object>> selectUnitsection(String id) {
        return this.unitsectionDao.selectUnitsection(id) ;
    }
}
