package cn.net.mine.common.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Common log4j Dao
 * 
 * @creator xumj
 * @createdate 2014-10-30 下午1:39:15
 * @note
 */
public interface SuperDao {
	public final Logger logger = LogManager.getRootLogger();
}
