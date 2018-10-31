package cn.net.mine;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
/**
 * 支持全局跨域配置类
 * @author chenhg
 *
 */
@Component  
public class CrossDomainConfiguration implements Filter {  
  
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CrossDomainConfiguration.class);  
  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        HttpServletResponse response = (HttpServletResponse) res;  
  
        HttpServletRequest reqs = (HttpServletRequest) req;  
  
        response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));  
        response.setHeader("Access-Control-Allow-Credentials", "true");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");  
        chain.doFilter(req, res);  
    }  
    
    public void destroy() {}
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}  
}
