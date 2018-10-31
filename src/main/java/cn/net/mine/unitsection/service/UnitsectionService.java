package cn.net.mine.unitsection.service;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface UnitsectionService extends SuperService {

    // 添加
    Object unitsectionAdd(String sectionno, String sectionname, String unitno);

    // 修改
    Object unitsectionUpdate(String id, String sectionno, String sectionname, String unitno);

    // 删除
    Object unitsectionDel(String id);

    int findBtName(String sectionno);

    int findBtName(String sectionno, String id);


    //列表
    List<Map<String, Object>> selectUnitsectionList(Integer pageNo, Integer pagesize, String sectionno, String sectionname ,String unitno);

    //查询总条数
    Integer count(String sectionno, String sectionname ,String unitno);

    //查询单条
    List<Map<String, Object>> selectUnitsection(String id);
}
