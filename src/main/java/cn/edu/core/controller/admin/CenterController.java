package cn.edu.core.controller.admin;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 * @author asus
 *
 */
@Controller
@RequestMapping(value="/control")
public class CenterController {
	
	//测试springmvc
	@RequestMapping("/test/springmvc.do")
	public String test(String name,Date birthday) throws UnsupportedEncodingException{
		System.out.println(birthday);
		return "index";
	}
	//局部只可以使用在本类中
//	@InitBinder
//	public void initBinder(WebDataBinder binder,WebRequest request){
//		//转换日期格式
//		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}
	//跳转到入口页面
	@RequestMapping(value="/index.do")
	public String index(){
		return "index";
	}
	//跳转到头页面
	@RequestMapping(value="/top.do")
	public String top(){
		return "top";
	}
	//跳转到主页面
	@RequestMapping(value="/main.do")
	public String main(){
		return "main"; 
	}
	//跳转到左页面
	@RequestMapping(value="/left.do")
	public String left(){
		return "left";
	}
	@RequestMapping(value="/right.do")
	public String right(){
		return "right";
	}
}
