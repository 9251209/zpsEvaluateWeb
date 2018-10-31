package cn.net.mine.login.log.dao.jdbc;

import java.util.List;
import java.util.Map;

import cn.net.mine.common.dao.SuperDao;
/**
 * 登录日志持久层
 * @author JinYue
 *
 */
public interface LoginLogDao extends SuperDao{
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
	
	public List<Map<String, Object>> queryList();
	//删除所有
	Map<String, Object> deleteAll();
}
