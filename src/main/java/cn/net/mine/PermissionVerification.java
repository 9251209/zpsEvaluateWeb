package cn.net.mine;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * 权限验证测试类
 * @author chenhg
 *
 */
@Component  
public class PermissionVerification implements Filter {  
	
  
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PermissionVerification.class);  
  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException { 
//    	System.out.println("开始权限验证了  ： ");
//    	Jurisdiction jurisdiction = Jurisdiction.getInstance();
//    	Map<String,SessionBean> jurisdictionMap = jurisdiction.getJurisdictionMap();
////      HttpServletResponse response = (HttpServletResponse) res;  
//	    HttpServletRequest request = (HttpServletRequest) req;  
//	    String path = request.getRequestURI();
//	    
//	    SessionBean sb = jurisdictionMap.get(path);
//        if(sb == null){//应该是去作查询的这里模拟一下吧
//        	System.out.println("SB == null ");
//        	sb = new SessionBean();
//        	sb.setCountNMB(1);
//        	sb.setName(path);
//        	sb.setTime(System.currentTimeMillis());
//        	sb.setSex("男");
//        }else{
//        	sb.setCountNMB(sb.getCountNMB() + 1);
//        	sb.setTime(System.currentTimeMillis());
//        	sb.setSex(sb.getCountNMB()% 2 == 0 ? "女" : "男");
//        	sb.setName(path);
//        }
//        jurisdictionMap.put(path, sb);
//        System.out.println(path);
//        System.out.println(sb.toString());
        chain.doFilter(req, res);  
        
    }  
    
    public void destroy() {}
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}  
}
