package cn.net.mine.scoreformula.service;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface ScoreformulaService extends SuperService {

    // 添加
    Object scoreformulaAdd(String formula, String type, String explain);

    // 修改
    Object scoreformulaUpdate(String id, String formula, String type, String explain);

    // 删除
    Object scoreformulaDel(String id);


    //列表
    List<Map<String, Object>> selectScoreformulaList(Integer pageNo, Integer pagesize, String formula, String type, String explain);

    //查询总条数
    Integer count( String formula, String type, String explain);

    //查询单条
    List<Map<String, Object>> selectScoreformula(String id);

    //不分页列表
    List<Map<String, Object>> selectGetScoreformulaList( String formula, String type, String explain);
}
