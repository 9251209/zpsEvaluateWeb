package cn.net.mine.score.service;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface ScoreService extends SuperService {


    // 添加
    Object scoreAdd(String prono, String unitno, String sectionno, String type, String tablename, String score  );

    // 修改
    Object scoreUpdate(String id, String prono, String unitno, String sectionno, String type, String tablename, String score   );

    // 删除
    Object scoreDel(String id);

    //列表
    List<Map<String, Object>> selectScoreList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String type, String tablename, String score   );

    //查询总条数
    Integer count(String prono, String unitno, String sectionno, String type, String tablename, String score );

    //查询单条
    List<Map<String, Object>> selectScore(String id);


    //不分页列表
    List<Map<String, Object>> selectGetScoreList(String prono, String unitno, String sectionno, String type, String tablename, String score );
}
