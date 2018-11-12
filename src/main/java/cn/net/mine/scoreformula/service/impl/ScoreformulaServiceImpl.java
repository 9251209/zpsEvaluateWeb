package cn.net.mine.scoreformula.service.impl;

import java.util.List;
import java.util.Map;

import cn.net.mine.scoreformula.dao.ScoreformulaDao;
import cn.net.mine.scoreformula.service.ScoreformulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreformulaServiceImpl implements ScoreformulaService {

    @Autowired
    private ScoreformulaDao scoreformulaDao;


    @Override
    public Object scoreformulaAdd(String formula, String type, String explain) {
        return this.scoreformulaDao.scoreformulaAdd(formula, type, explain);
    }

    @Override
    public Object scoreformulaUpdate(String id, String formula, String type, String explain) {
        return this.scoreformulaDao.scoreformulaUpdate(id, formula, type, explain) ;
    }

    @Override
    public Object scoreformulaDel(String id) {
        return this.scoreformulaDao.scoreformulaDel(id) ;
    }

    @Override
    public List<Map<String, Object>> selectScoreformulaList(Integer pageNo, Integer pagesize, String formula, String type, String explain) {
        return this.scoreformulaDao.selectScoreformulaList(pageNo, pagesize, formula, type, explain) ;
    }

    @Override
    public Integer count(String formula, String type, String explain) {
        return this.scoreformulaDao.count(formula, type, explain) ;
    }

    @Override
    public List<Map<String, Object>> selectScoreformula(String id) {
        return this.scoreformulaDao.selectScoreformula(id) ;
    }

    @Override
    public List<Map<String, Object>> selectGetScoreformulaList(String formula, String type, String explain) {
        return this.scoreformulaDao.selectGetScoreformulaList(formula, type, explain) ;
    }
}
