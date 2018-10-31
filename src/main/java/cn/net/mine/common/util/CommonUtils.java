package cn.net.mine.common.util;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class CommonUtils {
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getCurrentUserInfo(){
		 RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//		 String str = (String) requestAttributes.getAttribute("userInfo",RequestAttributes.SCOPE_SESSION);
//		 UserInfo strdd = (UserInfo) requestAttributes.getAttribute("sessionUserInfo",RequestAttributes.SCOPE_SESSION);
//		 System.out.println(strdd);
		 HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//		return (UserInfo) requestAttributes.getAttribute("sessionUserInfo",RequestAttributes.SCOPE_SESSION);
		return (Map<String, Object>) requestAttributes.getAttribute("sessionUserInfo",RequestAttributes.SCOPE_SESSION);
	}
	public static HttpSession getCurrentSession(){
		//两个方法在没有使用JSF的项目中是没有区别的
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//                                            RequestContextHolder.getRequestAttributes();
        //从session里面获取对应的值
//        String str = (String) requestAttributes.getAttribute("userInfo",RequestAttributes.SCOPE_SESSION);
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        HttpSession session = request.getSession();
//        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
		return session;
	}
	
	
	
	public static void getLogout(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if(Optional.ofNullable(requestAttributes).isPresent()){
			requestAttributes.setAttribute("sessionUserInfo", null, RequestAttributes.SCOPE_SESSION);
		}
	}
	
	public static void setCurrentUserInfo(Map<String, Object> map){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		requestAttributes.setAttribute("sessionUserInfo", map, RequestAttributes.SCOPE_SESSION);
	}
	
	
	
	
//	 //两个方法在没有使用JSF的项目中是没有区别的
//    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
////                                        RequestContextHolder.getRequestAttributes();
//    //从session里面获取对应的值
//    String str = (String) requestAttributes.getAttribute("name",RequestAttributes.SCOPE_SESSION);
}
