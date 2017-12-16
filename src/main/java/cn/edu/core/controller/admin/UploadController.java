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
 * 上传图片
 * 商品
 * 品牌
 * 商品介绍Fck
 * @author asus
 *
 */
@Controller
public class UploadController {
	
	//上传图片
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required=false) MultipartFile pic,HttpServletResponse response){
		//图片生成策略 使用日期命名策略到达毫秒级
		DateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//上传图片扩展名
		String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
		//图片名称一部分
		String format=dataFormat.format(new Date());
		//随机三位数
		Random random=new Random();
		for(int i=0;i<3;i++){
			format+=random.nextInt(10);
		}
		//实例化jersey
		Client client = new Client();
		//存储路径  
		//保存数据库
		String path="upload/"+format+"."+extension;
		String url = Constans.IMAGE_URL+path;
		WebResource resource = client.resource(url);
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回两个路径
		JSONObject jo=new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		//使用Utils工具类
		ResponseUtils responseUtils=new ResponseUtils();
		responseUtils.renderJson(response, jo.toString());
	}
	//上传FCK图片
	@RequestMapping(value="/upload/uploadFCK.do")
	public void uploadFck(HttpServletRequest request,HttpServletResponse response){
		//强转request    支持多个
		MultipartHttpServletRequest mr =(MultipartHttpServletRequest)request;
		//获取值     支持多个
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		//遍历 Map
		Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
		for(Entry<String, MultipartFile> entry:entrySet){
			MultipartFile pic = entry.getValue();
			//图片生成策略 使用日期命名策略到达毫秒级
			DateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			//上传图片扩展名
			String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
			//图片名称一部分
			String format=dataFormat.format(new Date());
			//随机三位数
			Random random=new Random();
			for(int i=0;i<3;i++){
				format+=random.nextInt(10);
			}
			//实例化jersey
			Client client = new Client();
			//存储路径  
			//保存数据库
			String path="upload/"+format+"."+extension;
			String url = Constans.IMAGE_URL+path;
			WebResource resource = client.resource(url);
			try {
				resource.put(String.class, pic.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//返回url给fck
			UploadResponse ok = UploadResponse.getOK(url);
			//response返回对象
			try{
				//使用response的print传出对象，       write 与 print 区别：一个是字符流 、 一个是字节流。
				response.getWriter().print(ok);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
