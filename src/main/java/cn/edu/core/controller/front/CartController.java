package cn.edu.core.controller.front;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.common.web.session.SessionProvider;
import cn.edu.core.bean.BuyCart;
import cn.edu.core.bean.BuyItem;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.bean.user.Addr;
import cn.edu.core.bean.user.Buyer;
import cn.edu.core.query.user.AddrQuery;
import cn.edu.core.service.product.SkuService;
import cn.edu.core.service.user.AddrService;
import cn.edu.core.web.Constans;

/**
 * 购物车
 * 
 * @author asus
 *
 */
@Controller
public class CartController {

	@Autowired
	private SkuService skuService;
	@Autowired
	private AddrService addService;     //收货地址
	@Autowired
	private SessionProvider sessionProvider;

	/**
	 * 购买按钮
	 * 
	 * @return
	 */
	@RequestMapping(value = "/shopping/buyCart.shtml")
	public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
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
		if (null == buyCart) {
			// 购物车
			buyCart = new BuyCart();
		}
		if (null != skuId) {
			Sku sku = new Sku();
			sku.setId(skuId);
			// 购买限制
			if(null != buyLimit){
				sku.setSkuUpperLimit(buyLimit);
			}
			// 创建购物项
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);
			// 数量
			buyItem.setAmount(amount);
			// 声明
			// 添加购物项
			buyCart.addItem(buyItem);
			// 最后一项商品id
			if(null != productId){
				buyCart.setProductId(productId);
			}

			// springmvc
			ObjectMapper obj = new ObjectMapper();
			obj.setSerializationInclusion(Inclusion.NON_NULL);

			// 字符串输出流
			StringWriter str = new StringWriter();

			// 对象转Json 写的过程 Json时字符串流
			try {
				obj.writeValue(str, buyCart);

			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 购物车装进cookie中,对象转成Json
			Cookie cookie = new Cookie(Constans.BUYERCART_COOKIE, str.toString());
			// 关闭浏览器也存在
			// 默认是 -1 即关闭浏览器就会销毁
			// 销毁 0 就是立即销毁
			// 这里设置为保存一天
			cookie.setMaxAge(60 * 60 * 24);
			// cookie路径
			// 由于当前路径为/shopping/buyCart.shtml
			// 所以默认路径为/shopping
			cookie.setPath("/");
			// 发送到前台浏览器
			response.addCookie(cookie);

		}
		// 装满购物车
		List<BuyItem> itemList = buyCart.getItemList();
		for (BuyItem item : itemList) {
			Sku s = skuService.getSkuByKey(item.getSku().getId());
			item.setSku(s);
		}
		model.addAttribute("buyCart", buyCart);
		return "product/cart";
	}
	
	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/shopping/clearCart.shtml")
	public String clearCart(HttpServletRequest request,HttpServletResponse response){
		Cookie cookie=new Cookie(Constans.BUYERCART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/shopping/buyCart.shtml";
	}
	
	/**
	 * 删除一个购物项
	 * @param skuId
	 * @return
	 */
	@RequestMapping("/shopping/deleteItem.shtml")
	public String delProduct(Integer skuId,HttpServletRequest request,HttpServletResponse response){
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
		if(null != buyCart){
			Sku sku = new Sku();
			sku.setId(skuId);
			// 创建购物项
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);
			buyCart.deleteItem(buyItem);
			// 字符串输出流
			StringWriter str = new StringWriter();

			// 对象转Json 写的过程 Json时字符串流
			try {
				om.writeValue(str, buyCart);

			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 购物车装进cookie中,对象转成Json
			Cookie cookie = new Cookie(Constans.BUYERCART_COOKIE, str.toString());
			// 关闭浏览器也存在
			// 默认是 -1 即关闭浏览器就会销毁
			// 销毁 0 就是立即销毁
			// 这里设置为保存一天
			cookie.setMaxAge(60 * 60 * 24);
			// cookie路径
			// 由于当前路径为/shopping/buyCart.shtml
			// 所以默认路径为/shopping
			cookie.setPath("/");
			// 发送到前台浏览器
			response.addCookie(cookie);
		}
		return "redirect:/shopping/buyCart.shtml";
	}
	
	/**
	 * 结算
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/buyer/trueBuy.shtml")
	public String trueBuy(HttpServletRequest request,HttpServletResponse response,ModelMap model){
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
		if(null != buyCart){
			//判断购物车中是否还有库存
			List<BuyItem> itemList = buyCart.getItemList();
			if(null != itemList&& itemList.size()>0){
				Integer startSize=itemList.size();
				//进行遍历所有商品判断
				for(BuyItem item:itemList){
					Sku sku = skuService.getSkuByKey(item.getSku().getId());
					if(sku.getStockInventory()<item.getAmount()){
						//清理购物车此商品
						buyCart.deleteItem(item);
					}
				}
				Integer endSize=itemList.size();
				if(startSize>endSize){
					//修改Cookie中购物车数据
					// 字符串输出流
					StringWriter str = new StringWriter();

					// 对象转Json 写的过程 Json时字符串流
					try {
						om.writeValue(str, buyCart);

					} catch (JsonGenerationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 购物车装进cookie中,对象转成Json
					Cookie cookie = new Cookie(Constans.BUYERCART_COOKIE, str.toString());
					// 关闭浏览器也存在
					// 默认是 -1 即关闭浏览器就会销毁
					// 销毁 0 就是立即销毁
					// 这里设置为保存一天
					cookie.setMaxAge(60 * 60 * 24);
					// cookie路径
					// 由于当前路径为/shopping/buyCart.shtml
					// 所以默认路径为/shopping
					cookie.setPath("/");
					// 发送到前台浏览器
					response.addCookie(cookie);
					return "redirect:/shopping/buyCart.shtml";
				}else{
					//加载收货地址
					Buyer buyer = (Buyer)sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
					AddrQuery addrQuery=new AddrQuery();
					addrQuery.setBuyerId(buyer.getUsername());
					//默认是1
					addrQuery.setIsDef(1);
					List<Addr> addrs = addService.getAddrList(addrQuery);
					model.addAttribute("addr", addrs.get(0));
					// 装满购物车
					List<BuyItem> items = buyCart.getItemList();
					for (BuyItem item : items) {
						Sku s = skuService.getSkuByKey(item.getSku().getId());
						item.setSku(s);
					}
					model.addAttribute("buyCart", buyCart);
					//正常
					return "product/productOrder";
				}
			}else{
				return "redirect:/shopping/buyCart.shtml";
			}
			
		}else{
			//如果购物车没有商品，将重定向到购物车页面。
			return "redirect:/shopping/buyCart.shtml";
		}
	}
	
}
