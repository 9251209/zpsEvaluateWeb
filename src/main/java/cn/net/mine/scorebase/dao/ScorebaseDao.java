package cn.net.mine.scorebase.dao;

import java.util.List;
import java.util.Map;


import cn.net.mine.common.dao.SuperDao;

public interface ScorebaseDao extends SuperDao {

    // 添加
    Object scorebaseAdd(String type, String tablename, String formulaid, String weight, String weightnew,String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula );

    // 修改
    Object scorebaseUpdate(String id, String type, String tablename, String formulaid, String weight,String weightnew, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula );

    // 删除
    Object scorebaseDel(String id);



    //列表
    List<Map<String, Object>> selectScorebaseList(Integer pageNo, Integer pagesize, String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula );

    //查询总条数
    Integer count(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula );

    //查询单条
    List<Map<String, Object>> selectScorebase(String id);

    //不分页列表
    List<Map<String, Object>> selectGetScorebaseList(String type, String tablename, String formulaid, String weight, String parama, String paramb, String paramc, String paramd, String paramy, String paramformula, String ua, String ub, String uc, String ud, String uy, String uformula, String explaina, String explainb, String explainc, String explaind, String explainy, String explainformula);
}
