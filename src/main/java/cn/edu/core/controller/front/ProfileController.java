package cn.edu.core.controller.front;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.octo.captcha.service.image.ImageCaptchaService;

import cn.edu.common.encode.Md5Pwd;
import cn.edu.common.web.ResponseUtils;
import cn.edu.common.web.session.SessionProvider;
import cn.edu.core.bean.country.City;
import cn.edu.core.bean.country.Province;
import cn.edu.core.bean.country.Town;
import cn.edu.core.bean.user.Buyer;
import cn.edu.core.query.country.CityQuery;
import cn.edu.core.query.country.TownQuery;
import cn.edu.core.service.country.CityService;
import cn.edu.core.service.country.ProvinceService;
import cn.edu.core.service.country.TownService;
import cn.edu.core.service.user.BuyerService;
import cn.edu.core.web.Constans;

/**
 * 跳转到登录页面 登录 个人资料 收货地址
 * 
 * @author asus
 *
 */
@Controller
public class ProfileController {

	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private Md5Pwd md5Pwd;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private ImageCaptchaService imageCaptchaService;
	@Autowired
	private ProvinceService provinceService; // 省
	@Autowired
	private CityService cityService; // 市
	@Autowired
	private TownService townService; // 县

	/**
	 * GET提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.GET)
	public String login() {
		return "buyer/login";
	}

	/**
	 * POST提交 1.验证码是否为空 2.验证码是否正确 3.用户名是否为空 4.密码是否为空 5.用户名是否正确 6.密码是否正确 Md5
	 * 纯生Md5 放进session中。
	 * 
	 * @param returnUrl
	 * @return
	 */
	@RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.POST)
	public String login(Buyer buyer, String captcha, String returnUrl, ModelMap model, HttpServletRequest request) {
		System.out.println(captcha+":"+buyer.getUsername()+":"+buyer.getPassword());
		// 验证
		if (StringUtils.isNotBlank(captcha)) {
			// JSESSIONID
			// 验证码
			if (imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request), captcha)) {
				if (null != buyer && StringUtils.isNotBlank(buyer.getUsername())) {
					if (StringUtils.isNotBlank(buyer.getPassword())) {
						Buyer buyerByKey = buyerService.getBuyerByKey(buyer.getUsername());
						if (null != buyerByKey) {
							if (buyerByKey.getPassword().equals(md5Pwd.encode(buyer.getPassword()))) {
								sessionProvider.setAttribute(request, Constans.BUYER_SESSION, buyerByKey);
								if (StringUtils.isNotBlank(returnUrl)&&!returnUrl.equals("null")) {
									// 返回登录前页面
									return "redirect:" + returnUrl;
								} else {
									// 到个人中心
									return "buyer/index";
								}
							} else {
								model.addAttribute("error", "密码错误");
								return "buyer/login";
							}
						} else {
							model.addAttribute("error", "用户名输入错误");
							return "buyer/login";
						}
					} else {
						model.addAttribute("error", "请输入密码");
						return "buyer/login";
					}
				} else {
					model.addAttribute("error", "请输入用户名");
					return "buyer/login";
				}
			} else {
				model.addAttribute("error", "验证码错误");
				return "buyer/login";
			}
		} else {
			model.addAttribute("error", "请填写验证码");
			return "buyer/login";
		}
	}

	/**
	 * 个人中心
	 */
	@RequestMapping(value = "/buyer/index.shtml")
	public String index() {
		System.out.println(110);
		return "buyer/index";
	}

	/**
	 * 个人资料
	 * 
	 * @return
	 */
	@RequestMapping(value = "/buyer/profile.shtml")
	public String profile(HttpServletRequest request, ModelMap model) {
		// 加载用户
		Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
		Buyer buyerByKey = buyerService.getBuyerByKey(buyer.getUsername());
		model.addAttribute("buyer", buyerByKey);
		// 省
		List<Province> provinceList = provinceService.getProvinceList(null);
		model.addAttribute("provinceList", provinceList);
		// 市
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(buyerByKey.getProvince());
		List<City> cityList = cityService.getCityList(cityQuery);
		model.addAttribute("cityList", cityList);
		// 县
		TownQuery townQuery = new TownQuery();
		townQuery.setCity(buyerByKey.getCity());
		List<Town> townList = townService.getTownList(townQuery);
		model.addAttribute("townList", townList);
		return "buyer/profile";
	}
	
	@RequestMapping(value="/buyer/city.shtml")
	public void city(String code,HttpServletResponse response){
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(code);
		List<City> cityList = cityService.getCityList(cityQuery);
		
		JSONObject jo=new JSONObject();
		jo.put("city", cityList);
		ResponseUtils.renderJson(response, jo.toString());
	}
	
	/**
	 * 收货地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "/buyer/deliver_address.shtml")
	public String address() {
		return "buyer/deliver_address";
	}

}
