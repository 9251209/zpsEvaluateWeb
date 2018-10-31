package cn.net.mine.common.util;

public class PageUtil {

	/**
	 * 查询当前处于第几条 ---  limit 的第一个参数
	 * @param pagenum
	 * @param pagesize
	 * @return
	 */
	public static int getcurrpage(Integer pagenum, Integer pagesize){
		return (pagenum-1)*pagesize;
	}
	
	/**
	 * 查询一个有多少页
	 * @param totalcount
	 * @param pagesize
	 * @return
	 */
	public static int gettotalpagenum(Integer totalcount,Integer pagesize ){
		return totalcount % pagesize == 0 ? (totalcount/pagesize) : (totalcount/pagesize + 1);
	}
	
}
