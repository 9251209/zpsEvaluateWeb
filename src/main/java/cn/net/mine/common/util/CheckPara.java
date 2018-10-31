package cn.net.mine.common.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author zhouy
 * 校验参数
 */
public class CheckPara {
	
	public static Map<String,Object> check(Map<String, String> map) {
		String timestampstr = map.get("timestamp")+"";
		String sign = map.get("sign")+"";
		String nonce = map.get("nonce")+"";
		Map<String,Object> mapre = new HashMap<String,Object>();
		if(!"null".equals(timestampstr) && !"null".equals(sign) && !"null".equals(nonce)){
			//判断接口只有在一分钟有效
			long cuurtimestamp = System.currentTimeMillis();//毫秒时间戳
			long timestamp = Long.parseLong(timestampstr);
			timestamp = timestamp + Long.parseLong("60000");
			if(cuurtimestamp < timestamp || cuurtimestamp == timestamp){
				StringBuffer sb = new StringBuffer();
				Set<String> keySet = maporderkeyAsc(map).keySet();
				Iterator<String> iter = keySet.iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					sb.append(key);//key
					sb.append(map.get(key));//value
				}
				System.out.println("排序后的："+sb.toString());
				String md5Hex = DigestUtils.md5Hex(sb.toString());
				System.out.println("加密后的字符串："+md5Hex);
				if(md5Hex.equals(sign)){
					mapre.put("code", "1");
					mapre.put("msg", "SUCCESS!");
				}else{
					mapre.put("code", "0");
					mapre.put("msg", "签名错误！");
				}
			}else{
				mapre.put("code", "0");
				mapre.put("msg", "接口访问超时");
			}
		}else{
			mapre.put("code", "0");
			mapre.put("msg", "参数为空！");
		}
		
		return mapre;
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("b", "ccccc");
        map.put("d", "aaaaa");
        map.put("c", "bbbbb");
        map.put("bcc", "ddddd");
        map.put("sign", "1fffcae3560cb55ff55911e061568af9");
        map.put("timestamp", "1503908661613");
        System.out.println(CheckPara.check(map).toString());
	}
	
	/**
	 * 按照map的key值进行排序
	 * @param mappa
	 * @return
	 */
	private static Map<String,String> maporderkeyAsc(Map<String,String> mappa){
		Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareTo(obj2 );
                    }
                });
        Set<String> keySet = mappa.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
        	String key = iter.next();
        	if(!"sign".equals(key)){
        		map.put(key, map.get(key));
        	}
        }
        return map;
	}
	
	
}
