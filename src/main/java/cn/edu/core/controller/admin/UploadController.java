package cn.edu.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.edu.common.web.ResponseUtils;
import cn.edu.core.web.Constans;
import net.fckeditor.response.UploadResponse;

/**
 * �ϴ�ͼƬ
 * ��Ʒ
 * Ʒ��
 * ��Ʒ����Fck
 * @author asus
 *
 */
@Controller
public class UploadController {
	
	//�ϴ�ͼƬ
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required=false) MultipartFile pic,HttpServletResponse response){
		//ͼƬ���ɲ��� ʹ�������������Ե�����뼶
		DateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//�ϴ�ͼƬ��չ��
		String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
		//ͼƬ����һ����
		String format=dataFormat.format(new Date());
		//�����λ��
		Random random=new Random();
		for(int i=0;i<3;i++){
			format+=random.nextInt(10);
		}
		//ʵ����jersey
		Client client = new Client();
		//�洢·��  
		//�������ݿ�
		String path="upload/"+format+"."+extension;
		String url = Constans.IMAGE_URL+path;
		WebResource resource = client.resource(url);
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��������·��
		JSONObject jo=new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		//ʹ��Utils������
		ResponseUtils responseUtils=new ResponseUtils();
		responseUtils.renderJson(response, jo.toString());
	}
	//�ϴ�FCKͼƬ
	@RequestMapping(value="/upload/uploadFCK.do")
	public void uploadFck(HttpServletRequest request,HttpServletResponse response){
		//ǿתrequest    ֧�ֶ��
		MultipartHttpServletRequest mr =(MultipartHttpServletRequest)request;
		//��ȡֵ     ֧�ֶ��
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		//���� Map
		Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
		for(Entry<String, MultipartFile> entry:entrySet){
			MultipartFile pic = entry.getValue();
			//ͼƬ���ɲ��� ʹ�������������Ե�����뼶
			DateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			//�ϴ�ͼƬ��չ��
			String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
			//ͼƬ����һ����
			String format=dataFormat.format(new Date());
			//�����λ��
			Random random=new Random();
			for(int i=0;i<3;i++){
				format+=random.nextInt(10);
			}
			//ʵ����jersey
			Client client = new Client();
			//�洢·��  
			//�������ݿ�
			String path="upload/"+format+"."+extension;
			String url = Constans.IMAGE_URL+path;
			WebResource resource = client.resource(url);
			try {
				resource.put(String.class, pic.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//����url��fck
			UploadResponse ok = UploadResponse.getOK(url);
			//response���ض���
			try{
				//ʹ��response��print��������       write �� print ����һ�����ַ��� �� һ�����ֽ�����
				response.getWriter().print(ok);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
