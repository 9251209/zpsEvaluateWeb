package cn.net.mine.scorezone.dao;

import java.util.List;
import java.util.Map;


import cn.net.mine.common.dao.SuperDao;

public interface ScorezoneDao extends SuperDao {


     // 添加
    Object scorezoneAdd(double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid);

    // 修改
    Object scorezoneUpdate(String id, double onepartmax, double twopartmin, double twopartmax, double threepartmin, double threepartmax, double fourpartmin, double fourpartmax, double fivepartmin, double onevalue, double twovalue, double threevalue, double fourvalue, double fivevalue, String baseid);

    // 删除
    Object scorezoneDel(String id);


    //查询单条
    List<Map<String, Object>> selectScorezone(String id);

    //不分页列表
    List<Map<String, Object>> selectGetScorezoneList(String onepartmax, String twopartmin, String twopartmax, String threepartmin, String threepartmax, String fourpartmin, String fourpartmax, String fivepartmin, String onevalue, String twovalue, String threevalue, String fourvalue, String fivevalue, String baseid);

}
