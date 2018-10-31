package cn.net.mine.login.log.service;


import java.util.List;
import java.util.Map;

import cn.net.mine.common.service.SuperService;

public interface LoginLogService extends SuperService{
	//list
	public Map<String, Object> list(String pageSize,String pageNum);
	//count
	public Map<String, Object> count(String pageSize);
	//添加
	public Map<String, Object> add(String userId,String date,String shift);
	//修改
	public Map<String, Object> update(String id,String userId,String date,String shift);
	//删除
	public Map<String, Object> delete(String... id);
	//detail
	public Map<String, Object> detail(String id);
	/**
	 * 查询消息列表
	 * @return
	 */
	public List<Map<String,Object>> queryList();
	
	//删除所有
	Map<String, Object> deleteAll();
}
