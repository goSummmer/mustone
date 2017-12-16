package cn.edu.core.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.common.web.session.SessionProvider;
import cn.edu.core.bean.user.Buyer;

/**
 * 
 * @author asus
 *
 */
public class SpringmvcInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SessionProvider sessionProvider;
	//常量
	private static final String INTERCEPTOR_URL = "/buyer/";
	
	private Integer adminId;
	
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	//方法前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Buyer buyer =(Buyer) sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
		Boolean flag=false;
		if(null != buyer){
			flag=true;
		}
		request.setAttribute("isLogin", flag);
		//是否拦截   
		String requestURI=request.getRequestURI();
		if(requestURI.startsWith(INTERCEPTOR_URL)){
			if(null != buyer){
				return true;
			}else{
				System.out.println(110);
				response.sendRedirect("/shopping/login.shtml?returnUrl="+request.getParameter("returnUrl"));
				return false;
			}
		}
		return true;
	}
	//方法后
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//页面渲染后
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
