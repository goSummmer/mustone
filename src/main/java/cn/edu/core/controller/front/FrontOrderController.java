package cn.edu.core.controller.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.common.web.session.SessionProvider;
import cn.edu.core.bean.BuyCart;
import cn.edu.core.bean.BuyItem;
import cn.edu.core.bean.order.Order;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.bean.user.Buyer;
import cn.edu.core.service.order.OrderService;
import cn.edu.core.service.product.SkuService;
import cn.edu.core.web.Constans;

/**
 * 提交订单   前台
 * @author asus
 *
 */
@Controller
public class FrontOrderController {
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SkuService skuService;
	
	@RequestMapping(value="/buyer/confirmOrder.shtml")
	public String confirmOrder(Order order,HttpServletRequest request,HttpServletResponse response){
		// 第一步
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		BuyCart buyCart = null;
		// 判断cookie中是否有购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies&&cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constans.BUYERCART_COOKIE.equals(cookie.getName())) {
					// 如果cookies中有使用此购物车
					String value = cookie.getValue();
					try {
						buyCart = om.readValue(value, BuyCart.class);
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
		// 装满购物车
		List<BuyItem> items = buyCart.getItemList();
		for (BuyItem item : items) {
			Sku s = skuService.getSkuByKey(item.getSku().getId());
			item.setSku(s);
		}
		Buyer buyer = (Buyer)sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
		//保存订单    订单详情
		order.setBuyerId(buyer.getUsername());
		orderService.addOrder(order,buyCart);
		//清空购物车
		Cookie cookie=new Cookie(Constans.BUYERCART_COOKIE,null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "product/confirmOrder";
	}
}
