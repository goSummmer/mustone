package cn.edu.common.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * ���ظ��ָ�ʽ
 * json
 * xml
 * text
 * @author asus
 *
 */
public class ResponseUtils {
	
	//�������� ��ʽ����
	public static void render(HttpServletResponse response,String contentType,String text){
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����json
	public static void renderJson(HttpServletResponse response,String text){
		render(response,"application/json;charset=UTF-8",text);
	}
	//����xml
	public static void renderXml(HttpServletResponse response,String text){
		render(response,"text/xml;charset=UTF-8",text);
	}
	//����text
	public static void renderText(HttpServletResponse response,String text){
		render(response,"text/plain;charset=UTF-8",text);
	}

}
