package cn.edu.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public interface SessionProvider {

	/**
	 * 往Session中设值
	 * name Constants buyer_session
	 *  value 用户对象
	 * @param request
	 * @param name
	 * @param value
	 */
	public void setAttribute(HttpServletRequest request, String name, Object value);

	/**
	 * 从Session中取值
	 * @param request
	 * @param name
	 * @return
	 */
	public Serializable getAttribute(HttpServletRequest request, String name);
	
	/**
	 * 退出
	 * @param request
	 */
	public void logout(HttpServletRequest request);
	
	/**
	 * 获取sessionId
	 * @param request
	 */
	public String getSessionId(HttpServletRequest request);
}
