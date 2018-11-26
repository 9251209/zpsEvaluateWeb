package cn.net.mine.project.dao;

import java.util.List;
import java.util.Map;


import cn.net.mine.common.dao.SuperDao;

public interface ProjectDao extends SuperDao {

    // 添加
    Object projectAdd(String prono, String proname, String type, String userno,  String totalInvestmentAmount,
                      String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany ,String prospectCompany ,String []projectImage,String leaderPhone);

    // 修改
    Object projectUpdate(String id,String prono, String proname, String type, String userno,  String totalInvestmentAmount,
                         String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany ,String prospectCompany ,String []projectImage,String leaderPhone);

    // 删除
    Object projectDel(String id);

    int findBtName(String prono);

    int findBtName(String prono, String id);


    //列表
    List<Map<String, Object>> selectProjectList(Integer pageNo, Integer pagesize,String prono, String proname, String type, String userno,  String totalInvestmentAmount,
                                                String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany ,String prospectCompany );

    //查询总条数
    Integer count(String prono, String proname, String type, String userno,  String totalInvestmentAmount,
                  String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany ,String prospectCompany );

    //查询单条
    List<Map<String, Object>> selectProject(String id);

    //不分页列表
    public List<Map<String, Object>> selectGetProjectList( String prono, String proname, String type, String userno, String totalInvestmentAmount, String coveredArea, String purpose, String brief, String leader, String address, String consCompany, String buildCompany, String superCompany, String designCompany, String prospectCompany);
}
