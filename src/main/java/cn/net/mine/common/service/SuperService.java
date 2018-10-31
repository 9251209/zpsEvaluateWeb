package cn.net.mine.common.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * Common log4j Service
 * 
 * @creator xumj
 * @createdate 2014-10-30 下午1:39:15
 * @note
 */
public interface SuperService {
	public final Logger logger = LogManager.getRootLogger();
}
