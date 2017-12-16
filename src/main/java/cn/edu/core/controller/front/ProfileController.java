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
 * ��ת����¼ҳ�� ��¼ �������� �ջ���ַ
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
	private ProvinceService provinceService; // ʡ
	@Autowired
	private CityService cityService; // ��
	@Autowired
	private TownService townService; // ��

	/**
	 * GET�ύ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.GET)
	public String login() {
		return "buyer/login";
	}

	/**
	 * POST�ύ 1.��֤���Ƿ�Ϊ�� 2.��֤���Ƿ���ȷ 3.�û����Ƿ�Ϊ�� 4.�����Ƿ�Ϊ�� 5.�û����Ƿ���ȷ 6.�����Ƿ���ȷ Md5
	 * ����Md5 �Ž�session�С�
	 * 
	 * @param returnUrl
	 * @return
	 */
	@RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.POST)
	public String login(Buyer buyer, String captcha, String returnUrl, ModelMap model, HttpServletRequest request) {
		System.out.println(captcha+":"+buyer.getUsername()+":"+buyer.getPassword());
		// ��֤
		if (StringUtils.isNotBlank(captcha)) {
			// JSESSIONID
			// ��֤��
			if (imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request), captcha)) {
				if (null != buyer && StringUtils.isNotBlank(buyer.getUsername())) {
					if (StringUtils.isNotBlank(buyer.getPassword())) {
						Buyer buyerByKey = buyerService.getBuyerByKey(buyer.getUsername());
						if (null != buyerByKey) {
							if (buyerByKey.getPassword().equals(md5Pwd.encode(buyer.getPassword()))) {
								sessionProvider.setAttribute(request, Constans.BUYER_SESSION, buyerByKey);
								if (StringUtils.isNotBlank(returnUrl)&&!returnUrl.equals("null")) {
									// ���ص�¼ǰҳ��
									return "redirect:" + returnUrl;
								} else {
									// ����������
									return "buyer/index";
								}
							} else {
								model.addAttribute("error", "�������");
								return "buyer/login";
							}
						} else {
							model.addAttribute("error", "�û����������");
							return "buyer/login";
						}
					} else {
						model.addAttribute("error", "����������");
						return "buyer/login";
					}
				} else {
					model.addAttribute("error", "�������û���");
					return "buyer/login";
				}
			} else {
				model.addAttribute("error", "��֤�����");
				return "buyer/login";
			}
		} else {
			model.addAttribute("error", "����д��֤��");
			return "buyer/login";
		}
	}

	/**
	 * ��������
	 */
	@RequestMapping(value = "/buyer/index.shtml")
	public String index() {
		System.out.println(110);
		return "buyer/index";
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	@RequestMapping(value = "/buyer/profile.shtml")
	public String profile(HttpServletRequest request, ModelMap model) {
		// �����û�
		Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
		Buyer buyerByKey = buyerService.getBuyerByKey(buyer.getUsername());
		model.addAttribute("buyer", buyerByKey);
		// ʡ
		List<Province> provinceList = provinceService.getProvinceList(null);
		model.addAttribute("provinceList", provinceList);
		// ��
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(buyerByKey.getProvince());
		List<City> cityList = cityService.getCityList(cityQuery);
		model.addAttribute("cityList", cityList);
		// ��
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
	 * �ջ���ַ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/buyer/deliver_address.shtml")
	public String address() {
		return "buyer/deliver_address";
	}

}
