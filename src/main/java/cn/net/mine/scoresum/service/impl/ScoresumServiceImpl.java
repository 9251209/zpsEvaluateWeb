package cn.net.mine.scoresum.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.net.mine.project.dao.ProjectDao;
import cn.net.mine.project.service.ProjectService;
import cn.net.mine.projectunit.dao.ProjectunitDao;
import cn.net.mine.score.dao.ScoreDao;
import cn.net.mine.scoresum.dao.ScoresumDao;
import cn.net.mine.scoresum.service.ScoresumService;
import cn.net.mine.unitsection.dao.UnitsectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoresumServiceImpl implements ScoresumService {

    @Autowired
    private ScoresumDao scoresumDao;
    @Autowired
    private ScoreDao scoreDao;

    @Override
    public Object scoresumAdd(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno) {
        return this.scoresumDao.scoresumAdd(prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum,scorename, userno);
    }

    @Override
    public Object scoresumUpdate(String id, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno) {
        return this.scoresumDao.scoresumUpdate(id, prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum,scorename, userno);
    }

    @Override
    public Object scoresumDel(String id) {
        return this.scoresumDao.scoresumDel(id);
    }

    @Override
    public List<Map<String, Object>> selectScoresumList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno) {
        return this.scoresumDao.selectScoresumList(pageNo, pagesize, prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum,scorename, userno);
    }

    @Override
    public Integer count(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno) {
        return this.scoresumDao.count(prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum,scorename, userno);
    }

    @Override
    public List<Map<String, Object>> selectScoresum(String id) {
        return this.scoresumDao.selectScoresum(id);
    }

    @Override
    public List<Map<String, Object>> selectGetScoresumList(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno) {
        return this.scoresumDao.selectGetScoresumList(prono, unitno, sectionno, resourcevalue, energyvalue, manpowervalue, totalvalue, starlevel, resourcenum, energynum, manpowernum,scorename,userno);
    }

    @Override
    public Object Del(String prono, String unitno, String sectionno,String scorename) {
        this.scoresumDao.Del(prono, unitno, sectionno, scorename);
        this.scoreDao.Del(prono, unitno, sectionno, scorename);

        return "删除成功";
    }

    @Override
    public int findBtName(String scorename) {
        return this.scoresumDao.findBtName(scorename);
    }
}
