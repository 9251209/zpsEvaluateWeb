package cn.net.mine.scorebase.service.impl;



import cn.net.mine.scorebase.dao.ScorebaseDao;
import cn.net.mine.scorebase.service.ScorebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ScorebaseServiceImpl implements ScorebaseService {

    @Autowired
    private ScorebaseDao scorebaseDao;

    @Override
    public Object scorebaseAdd(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        return this.scorebaseDao.scorebaseAdd(type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);
    }

    @Override
    public Object scorebaseUpdate(String id, String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        return this.scorebaseDao.scorebaseUpdate(id,type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);
    }

    @Override
    public Object scorebaseDel(String id) {
        return this.scorebaseDao.scorebaseDel(id);
    }

    @Override
    public List<Map<String, Object>> selectScorebaseList(Integer pageNo, Integer pagesize, String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        return this.scorebaseDao.selectScorebaseList(pageNo ,pagesize,type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);
    }

    @Override
    public Integer count(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        return this.scorebaseDao.count(type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);
    }

    @Override
    public List<Map<String, Object>> selectScorebase(String id) {
        return this.scorebaseDao.selectScorebase(id);
    }

    @Override
    public List<Map<String, Object>> selectGetScorebaseList(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula) {
        return this.scorebaseDao.selectGetScorebaseList(type, tablename, formulaid, weight, parama, paramb, paramc, paramd, paramy, paramformula, ua, ub, uc, ud, uy, uformula, explaina, explainb, explainc, explaind, explainy, explainformula);
    }
}
