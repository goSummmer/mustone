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
	//����
	private static final String INTERCEPTOR_URL = "/buyer/";
	
	private Integer adminId;
	
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	//����ǰ
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Buyer buyer =(Buyer) sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
		Boolean flag=false;
		if(null != buyer){
			flag=true;
		}
		request.setAttribute("isLogin", flag);
		//�Ƿ�����   
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
	//������
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//ҳ����Ⱦ��
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
