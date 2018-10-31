package cn.net.mine.projectunit.dao;

import java.util.List;
import java.util.Map;


import cn.net.mine.common.dao.SuperDao;

public interface ProjectunitDao extends SuperDao {


    // 添加
    Object projectunitAdd(String unitno, String unitname, String prono);

    // 修改
    Object projectunitUpdate(String id, String unitno, String unitname, String prono);

    // 删除
    Object projectunitDel(String id);

    int findBtName(String unitno);

    int findBtName(String unitno, String id);


    //用户列表
    List<Map<String, Object>> selectProjectunitList(Integer pageNo, Integer pagesize, String unitno, String unitname, String prono);

    //查询总条数
    Integer count(String unitno, String unitname, String prono);

    //查询单条
    List<Map<String, Object>> selectProjectunit(String id);

}
