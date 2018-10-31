package cn.net.mine.login.log.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.mine.login.log.dao.jdbc.LoginLogDao;
import cn.net.mine.login.log.service.LoginLogService;
@Service
public class LoginLogServiceImpl implements LoginLogService{
	@Autowired
	private LoginLogDao loginLogDao;
	
	@Override
	public Map<String, Object> list(String pageSize,String pageNum) {
		return loginLogDao.list(pageSize, pageNum);
	}

	@Override
	public Map<String, Object> count(String pageSize) {
		return loginLogDao.count(pageSize);
	}

	@Override
	public Map<String, Object> add(String userId,String date,String shift) {
		return loginLogDao.add( userId, date, shift);
	}

	@Override
	public Map<String, Object> update(String id,String userId,String date,String shift) {
		return loginLogDao.update( id, userId, date, shift);
	}

	@Override
	public Map<String, Object> delete(String... id) {
		return loginLogDao.delete(id);
	}

	@Override
	public Map<String, Object> detail(String id) {
		return loginLogDao.detail(id);
	}

	@Override
	public List<Map<String, Object>> queryList() {
		return loginLogDao.queryList();
	}

	@Override
	public Map<String, Object> deleteAll() {
		return loginLogDao.deleteAll();
	}

}
