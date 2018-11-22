package cn.net.mine.newinfo.service;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface NewinfoService extends SuperService {

    // 添加
    Object newinfoAdd(String infoTitle, String infoType, String infoContent, String[] infoImg);

    // 修改
    Object newinfoUpdate(String id, String infoTitle, String infoType, String infoContent, String[] infoImg,String type);

    // 删除
    Object newinfoDel(String id);


    //列表
    List<Map<String, Object>> selectNewinfoList(Integer pageNo, Integer pagesize, String infoTitle, String infoType, String infoContent,String type);

    //查询总条数
    Integer count(String infoTitle, String infoType, String infoContent,String type);

    //查询单条
    List<Map<String, Object>> selectNewinfo(String id);


    //不分页列表
    List<Map<String, Object>> selectGetNewinfoList(String infoTitle, String infoType, String infoContent);
}
