package cn.net.mine.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.apache.commons.lang.StringUtils;
import cn.net.mine.common.dao.SuperDao;

/**
 * 
 * 多数据库连接配置
 * 
 * @creator luanp
 * @createdate 2014-10-30 下午1:49:09
 * @note
 */
@Component
public class SuperJdbcTemplate implements SuperDao{
	
	/**
	 * 系统数据库
	 */
	@Autowired
	@Qualifier("jdbcTemplateCsms")
	public JdbcTemplate jdbcTemplateCsms;
	
	/**
	 * 添加的方法 int String Date Double 都能上传 详情见禅道demo
	 * @param tablename
	 * @param map
	 */
	public void insert(String tablename,Map<String,Object> map){
		StringBuffer sql = new StringBuffer();
		List<String> listinsert = getkv(map,"insert");
		sql.append("insert into "+tablename+" ("+listinsert.get(0) +") values ("+listinsert.get(1)+")");
		logger.info(sql.toString());
		this.jdbcTemplateCsms.execute(sql.toString());
	}
	
	/**
	 * 修改的方法 int String Date Double 都能上传 详情见禅道demo
	 * @param tablename
	 * @param map
	 */
	public void update(String tablename,Map<String,Object> mapset,Map<String,Object> mapwhere ){
		StringBuffer sql = new StringBuffer();
		List<String> listset = getkv(mapset,"set");
		if(!mapwhere.isEmpty()){
			List<String> listwhere = getkv(mapwhere,"where");
			sql.append("update "+tablename+" set " +listset.get(0)+"  where 1=1  and "+listwhere.get(0));
		}else{
			sql.append("update "+tablename+" set " +listset.get(0));
		}
		logger.info(sql.toString());
		this.jdbcTemplateCsms.execute(sql.toString());
	}
	
	/**
	 * 添加的方法
	 * @param tablename
	 * @param map
	 */
	public Integer save(String tablename,Map<String,Object> map){
		StringBuffer sql = new StringBuffer();
		StringBuffer key = new StringBuffer();
		StringBuffer value = new StringBuffer();
		key.append("(");
		value.append("(");
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			key.append(next+",");
			value.append(map.get(next)+",");
		}
		String strkey = key.toString();
		strkey = strkey.substring(0, strkey.length()-1);
		strkey+=")";
		String strvalue = value.toString();
		strvalue = strvalue.substring(0, strvalue.length()-1);
		strvalue+=")";
		sql.append("insert into "+tablename+" "+strkey +" values "+strvalue);
		logger.info(sql.toString());
		return this.jdbcTemplateCsms.update(sql.toString());
	}
	
	/**
	 * 修改的方法
	 * mapwhere 不能有日期类型的key value 其他的都可以
	 * @param tablename
	 * @param map
	 */
	public Integer updateMethod(String tablename,Map<String,Object> mapset,Map<String,Object> mapwhere){
		StringBuffer sql = new StringBuffer();
		String strwhere = "";
//		if(mapset != null){
//			for(String key : mapset.keySet()){
//				mapset.put(key, "'" + mapset.get(key)+"'");
//			}
//		}
		String strset = mapset.toString();
		strset = strset.substring(1, strset.length()-1);
		if(!mapwhere.isEmpty()){
			strwhere = mapwhere.toString();
			strwhere = strwhere.substring(1, strwhere.length()-1);
			strwhere = strwhere.replaceAll(",", " and ");
			sql.append("update "+tablename+" set " +strset+"  where 1=1  and "+strwhere);
		}else{
			sql.append("update "+tablename+" set " +strset);
		}
		logger.info(sql.toString());//update test set contend=好好的 where 1=1  id=7 and 
		return this.jdbcTemplateCsms.update(sql.toString());
	}
	
	
	
	/**
	 * delete的方法 int String Date Double 都能上传 详情见禅道demo
	 * @param tablename
	 * @param map
	 */
	public void delete(String tablename,Map<String,Object> mapwhere){
		StringBuffer sql = new StringBuffer();
		if(!mapwhere.isEmpty()){
			List<String> listwhere= getkv(mapwhere,"where");
			sql.append("delete from "+tablename+"  where 1=1 and "+listwhere.get(0));
		}else{
			sql.append("delete from "+tablename);
		}
		logger.info(sql.toString());
		this.jdbcTemplateCsms.execute(sql.toString());
	}
	
	/**
	 * 查询总的条数
	 * @param sql
	 * @return
	 */
	public int gettotalcount(String sql){
		StringBuffer sqltotal = new StringBuffer();
		sqltotal.append(" select count(*) as cou from ( "+sql+" ) aa ");
		String cou = this.jdbcTemplateCsms.queryForObject(sqltotal.toString(),String.class);
		if(StringUtils.isEmpty(cou)){
			return 0;
		}else{
			return Integer.parseInt(cou);
		}
	}
	
	public List<String> getkv(Map<String,Object> map,String type){
		List<String> list = new ArrayList<String>();
		StringBuffer str = new StringBuffer();
		StringBuffer str2 = new StringBuffer();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			Object value = map.get(key);
			if("set".equals(type)){
				str.append(key+"="+value+",");
			}else if("where".equals(type)){
				str.append(key+"="+value+" and ");
			}else{
				str.append(key+",");
				str2.append(value+",");
			}
		}
		String string = str.toString();
		if("set".equals(type)){
			list.add(string.substring(0, string.length()-1));
			return list;
		}else if("where".equals(type)){
			list.add(string.substring(0, string.length()-4));
			return list;
		}else{
			String string2 = str2.toString();
			list.add(string.substring(0, string.length()-1));
			list.add(string2.substring(0, string2.length()-1));
			return list;
		}
	}
	
	/**
	 * 插入返回ID
	 * @param tablename
	 * @param map
	 * @return
	 */
	public Integer insertreid(String tablename,Map<String,Object> map){
		StringBuffer sql = new StringBuffer();
		List<String> listinsert = getkv(map,"insert");
		sql.append("insert into "+tablename+" ("+listinsert.get(0) +") values ("+listinsert.get(1)+")");
		logger.info(sql.toString());
		final String bb= sql.toString();
	      KeyHolder keyHolder = new GeneratedKeyHolder();
	      jdbcTemplateCsms.update(
	            new PreparedStatementCreator() {
	                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
	                    PreparedStatement ps = jdbcTemplateCsms.getDataSource().getConnection().prepareStatement(bb, Statement.RETURN_GENERATED_KEYS);
	                    return ps;
	                }
	            }, keyHolder);
	       return keyHolder.getKey().intValue();
	}
	
}
