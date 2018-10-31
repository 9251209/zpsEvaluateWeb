package cn.net.mine.login.log.dao.jdbc.impl;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.transaction.Transactional;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import cn.net.mine.common.SuperJdbcTemplate;
import cn.net.mine.login.log.dao.jdbc.LoginLogDao;

@Repository
public class LoginLogDaoJdbcImpl extends SuperJdbcTemplate implements LoginLogDao{

	@Override
	public Map<String, Object> list(String pageSize,String pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sqlTemp = new StringBuffer();
		int start = !StringUtils.isEmpty(pageSize)&&!StringUtils.isEmpty(pageNum)?(Integer.parseInt(pageNum.trim())-1)*Integer.parseInt(pageSize)+1:0;
		int end = !StringUtils.isEmpty(pageSize)&&!StringUtils.isEmpty(pageNum)?Integer.parseInt(pageNum.trim())*Integer.parseInt(pageSize):0;
		sqlTemp.append(" SELECT N.ID,N.USERNAME,N.TYPE,N.LONIN_IP,TO_CHAR(N.LOGIN_TIME,'YYYY-MM-DD HH24:MI:SS') LOGIN_TIME,ROWNUM RN FROM LOGIN_LOG N ");
		String tempSql = sqlTemp.toString();
		String sql = StringUtils.isEmpty(pageSize)||StringUtils.isEmpty(pageNum)?tempSql:"SELECT N.* FROM ("+tempSql+") N WHERE RN BETWEEN "+start+" AND "+end+"";
		List<Map<String, Object>> list = jdbcTemplateCsms.queryForList(sql);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}else{
			map.put("list", list);
		}
		 return map;
	}

	@Override
	public Map<String, Object> count(String pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(*) COUNT FROM LOGIN_LOG ");
		List<Map<String, Object>> list = jdbcTemplateCsms.queryForList(sql.toString());
		if(CollectionUtils.isEmpty(list)){
			map.put("count", 0);
		}else{
			int parseInt = 0;
			int count = 0;
			int pageNumSum = 0;
			if(!StringUtils.isEmpty(pageSize)){
				parseInt = Integer.parseInt(pageSize);
				count = Integer.parseInt(list.get(0).get("COUNT").toString());
				pageNumSum = count%parseInt==0?(count/parseInt):(count /parseInt + 1);
			}
			map.put("count", StringUtils.isEmpty(pageSize)?list.get(0).get("COUNT"):pageNumSum);
			
		}
		 return map;
	}

	@Transactional
	@Override
	public Map<String, Object> add(String userId,String date,String shift) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		String id = UUID.randomUUID().toString().replace("-", "");
		sql.append(" INSERT INTO KS_LDDB_JH(KS_LDDB_JH_KEY, A0190, A0101, LDDB_DATE, LDDB_JH_BC) VALUES ( ")
		.append("'"+UUID.randomUUID().toString()+"'"+",")
		.append("'"+userId+"'"+",")
		.append(" (SELECT FIRSTNAME FROM TUSER WHERE USERID = '"+userId+"') "+",")
		.append(StringUtils.isEmpty(date)?" SYSDATE, ": "TO_DATE('"+date.trim()+"','yyyy-MM-dd'),")
		.append("'"+shift+"'")
		.append(")");
		try {
			jdbcTemplateCsms.execute(sql.toString());
			map.put("state", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", e);
			throw new RuntimeException(e);
		}
		 return map;
	}
	@Override
	public Map<String, Object> update(String id,String userId,String date,String shift) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(id)){
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE KS_LDDB_JH SET ");
			if(StringUtils.isNotEmpty(userId)){
				sql
				.append(" A0190= ")
				.append("'"+userId+"',");
			}
			if(StringUtils.isNotEmpty(date)){
				sql
				.append(" LDDB_DATE = ")
				.append(" TO_DATE('"+date.trim()+"','yyyy-MM-dd') ,");
			}
			if(StringUtils.isNotEmpty(shift)){
				sql
				.append(" LDDB_JH_BC= ")
				.append("'"+shift+"',");
			}
			
			try {
				if(StringUtils.isEmpty(userId)&&StringUtils.isEmpty(date)&&StringUtils.isEmpty(shift)){
					map.put("state", "failed");
				}else{
					String substring = sql.toString().substring(0, sql.toString().length()-1);
					substring+=" WHERE KS_LDDB_JH_KEY = '"+id+"' ";
					jdbcTemplateCsms.execute(substring);
					map.put("state", "success");
				}
			} catch (Exception e) {
				e.printStackTrace();
				map.put("state", e);
				throw new RuntimeException(e);
			}
		}else{
			map.put("state", "failed");
		}
		 return map;
	}
	@Transactional
	@Override
	public Map<String, Object> delete(String... id) {
		Map<String, Object> map = new HashMap<String, Object>();
		final String[] fid = id;
		String sql = " DELETE FROM LOGIN_LOG WHERE ID = ? ";
		try {
			jdbcTemplateCsms.batchUpdate(sql, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, fid[i]);
				}
				@Override
				public int getBatchSize() {
					return fid.length;
				}
			});
			map.put("state", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "failed");
			throw new RuntimeException(e);
		}
		
		
		 return map;
	}
	@Transactional
	@Override
	public Map<String, Object> deleteAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" TRUNCATE TABLE LOGIN_LOG ");
		try {
			jdbcTemplateCsms.execute(sql.toString());
			map.put("state", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "failed");
			throw new RuntimeException(e);
		}
		 return map;
	}
	@Override
	public Map<String, Object> detail(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT N.ID FROM USER N WHERE N.ID = ").append("'"+id+"'");
		List<Map<String, Object>> list = jdbcTemplateCsms.queryForList(sql.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}else{
			map.put("list", list);
		}
		 return map;
	}
	@Override
	public List<Map<String, Object>> queryList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT N.A0190,N.A0101,TR.DEPARTMENT,TO_CHAR(N.LDDB_DATE,'YYYY-MM-DD') LDDB_DATE,N.LDDB_JH_BC FROM KS_LDDB_JH N LEFT JOIN TUSER TR ON N.A0190=TR.USERID ORDER BY N.LDDB_DATE DESC ");
		return jdbcTemplateCsms.queryForList(sql.toString());
	}

}
