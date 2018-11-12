package cn.net.mine.score.service.impl;

import java.util.List;
import java.util.Map;


import cn.net.mine.score.dao.ScoreDao;
import cn.net.mine.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public Object scoreAdd(String prono, String unitno, String sectionno, String type, String tablename, String score  ) {
        return this.scoreDao.scoreAdd(prono, unitno, sectionno, type, tablename, score);
    }

    @Override
    public Object scoreUpdate(String id, String prono, String unitno, String sectionno, String type, String tablename, String score  ) {
        return this.scoreDao.scoreUpdate(id, prono, unitno, sectionno, type, tablename, score);
    }

    @Override
    public Object scoreDel(String id) {
        return this.scoreDao.scoreDel(id);
    }

    @Override
    public List<Map<String, Object>> selectScoreList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String type, String tablename, String score   ) {
        return this.scoreDao.selectScoreList(pageNo, pagesize, prono, unitno, sectionno, type, tablename, score);
    }

    @Override
    public Integer count(String prono, String unitno, String sectionno, String type, String tablename, String score   ) {
        return this.scoreDao.count(prono, unitno, sectionno, type, tablename, score);
    }

    @Override
    public List<Map<String, Object>> selectScore(String id) {
        return this.scoreDao.selectScore(id);
    }

    @Override
    public List<Map<String, Object>> selectGetScoreList(String prono, String unitno, String sectionno, String type, String tablename, String score   ) {
        return this.scoreDao.selectGetScoreList(prono, unitno, sectionno, type, tablename, score);
    }
}
