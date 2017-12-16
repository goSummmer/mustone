package cn.edu.core.service.staticpage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * ���ɾ�̬ҳ
 * @author asus
 *
 */
public class StaticPageServiceImpl implements StaticPageService,ServletConfigAware{
	
	private Configuration conf;
	
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.conf = freeMarkerConfigurer.getConfiguration();
	}


	//��̬������
	public void productIndex(Map<String,Object> root,Integer id){
		//String dir = "C:\Users\lx\workspace\babasport12\";
		//����ģ���Ŀ¼
		//conf.setDirectoryForTemplateLoading(dir);
		
		//�����   ���ڴ�д��ȥ  ������
		Writer out = null;
		try {
			//������  UTF-8  �ڴ���
			Template template = conf.getTemplate("productDetail.html");
			//��ȡHtml��·��
			String path = getPath("/html/product/" + id +  ".html");//278.html
			
			File f = new File(path);
			File parentFile = f.getParentFile();
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			//�����
			out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
			//����ģ��
			template.process(root, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//��ȡ·��
	public String getPath(String name){
		return servletContext.getRealPath(name);
	}

	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}


	public void setServletConfig(ServletConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}
