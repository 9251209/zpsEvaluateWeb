package cn.net.mine.score.dao;

import java.util.List;
import java.util.Map;


import cn.net.mine.common.dao.SuperDao;

public interface ScoreDao extends SuperDao {

    // 添加
    Object scoreAdd(String prono, String unitno, String sectionno, String type, String tablename, String score ,String scorename,String weightnew );

    // 修改
    Object scoreUpdate(String id, String prono, String unitno, String sectionno, String type, String tablename, String score ,String scorename,String weightnew );

    // 删除
    Object scoreDel(String id);


    //列表
    List<Map<String, Object>> selectScoreList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String type, String tablename, String score,String scorename );

    //查询总条数
    Integer count(String prono, String unitno, String sectionno, String type, String tablename, String score ,String scorename);

    //查询单条
    List<Map<String, Object>> selectScore(String id);


    //不分页列表
    List<Map<String, Object>> selectGetScoreList(String prono, String unitno, String sectionno, String type, String tablename, String score ,String scorename);

    //删除历史纪录
    Object Del(String prono, String unitno, String sectionno);
}
