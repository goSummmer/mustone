package cn.edu.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public interface SessionProvider {

	/**
	 * ��Session����ֵ
	 * name Constants buyer_session
	 *  value �û�����
	 * @param request
	 * @param name
	 * @param value
	 */
	public void setAttribute(HttpServletRequest request, String name, Object value);

	/**
	 * ��Session��ȡֵ
	 * @param request
	 * @param name
	 * @return
	 */
	public Serializable getAttribute(HttpServletRequest request, String name);
	
	/**
	 * �˳�
	 * @param request
	 */
	public void logout(HttpServletRequest request);
	
	/**
	 * ��ȡsessionId
	 * @param request
	 */
	public String getSessionId(HttpServletRequest request);
}
