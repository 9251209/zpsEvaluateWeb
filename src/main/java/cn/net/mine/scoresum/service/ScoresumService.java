package cn.net.mine.scoresum.service;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface ScoresumService extends SuperService {

    // 添加
    Object scoresumAdd(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno);

    // 修改
    Object scoresumUpdate(String id, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno);

    // 删除
    Object scoresumDel(String id);


    //列表
    List<Map<String, Object>> selectScoresumList(Integer pageNo, Integer pagesize, String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno);

    //查询总条数
    Integer count(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno);

    //查询单条
    List<Map<String, Object>> selectScoresum(String id);

    //不分页列表
    List<Map<String, Object>> selectGetScoresumList(String prono, String unitno, String sectionno, String resourcevalue, String energyvalue, String manpowervalue, String totalvalue, String starlevel, String resourcenum, String energynum, String manpowernum,String scorename,String userno);

    //删除历史纪录
    Object Del(String prono, String unitno, String sectionno);


    //验证计算名称是否重复
    int findBtName(String scorename);
}
