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
 * ���ﳵ
 * 
 * @author asus
 *
 */
@Controller
public class CartController {

	@Autowired
	private SkuService skuService;
	@Autowired
	private AddrService addService;     //�ջ���ַ
	@Autowired
	private SessionProvider sessionProvider;

	/**
	 * ����ť
	 * 
	 * @return
	 */
	@RequestMapping(value = "/shopping/buyCart.shtml")
	public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		// ��һ��
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		BuyCart buyCart = null;
		// �ж�cookie���Ƿ��й��ﳵ
		Cookie[] cookies = request.getCookies();
		if (null != cookies&&cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constans.BUYERCART_COOKIE.equals(cookie.getName())) {
					// ���cookies����ʹ�ô˹��ﳵ
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
			// ���ﳵ
			buyCart = new BuyCart();
		}
		if (null != skuId) {
			Sku sku = new Sku();
			sku.setId(skuId);
			// ��������
			if(null != buyLimit){
				sku.setSkuUpperLimit(buyLimit);
			}
			// ����������
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);
			// ����
			buyItem.setAmount(amount);
			// ����
			// ��ӹ�����
			buyCart.addItem(buyItem);
			// ���һ����Ʒid
			if(null != productId){
				buyCart.setProductId(productId);
			}

			// springmvc
			ObjectMapper obj = new ObjectMapper();
			obj.setSerializationInclusion(Inclusion.NON_NULL);

			// �ַ��������
			StringWriter str = new StringWriter();

			// ����תJson д�Ĺ��� Jsonʱ�ַ�����
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

			// ���ﳵװ��cookie��,����ת��Json
			Cookie cookie = new Cookie(Constans.BUYERCART_COOKIE, str.toString());
			// �ر������Ҳ����
			// Ĭ���� -1 ���ر�������ͻ�����
			// ���� 0 ������������
			// ��������Ϊ����һ��
			cookie.setMaxAge(60 * 60 * 24);
			// cookie·��
			// ���ڵ�ǰ·��Ϊ/shopping/buyCart.shtml
			// ����Ĭ��·��Ϊ/shopping
			cookie.setPath("/");
			// ���͵�ǰ̨�����
			response.addCookie(cookie);

		}
		// װ�����ﳵ
		List<BuyItem> itemList = buyCart.getItemList();
		for (BuyItem item : itemList) {
			Sku s = skuService.getSkuByKey(item.getSku().getId());
			item.setSku(s);
		}
		model.addAttribute("buyCart", buyCart);
		return "product/cart";
	}
	
	/**
	 * ��չ��ﳵ
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
	 * ɾ��һ��������
	 * @param skuId
	 * @return
	 */
	@RequestMapping("/shopping/deleteItem.shtml")
	public String delProduct(Integer skuId,HttpServletRequest request,HttpServletResponse response){
		// ��һ��
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		BuyCart buyCart = null;
		// �ж�cookie���Ƿ��й��ﳵ
		Cookie[] cookies = request.getCookies();
		if (null != cookies&&cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constans.BUYERCART_COOKIE.equals(cookie.getName())) {
					// ���cookies����ʹ�ô˹��ﳵ
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
			// ����������
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);
			buyCart.deleteItem(buyItem);
			// �ַ��������
			StringWriter str = new StringWriter();

			// ����תJson д�Ĺ��� Jsonʱ�ַ�����
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

			// ���ﳵװ��cookie��,����ת��Json
			Cookie cookie = new Cookie(Constans.BUYERCART_COOKIE, str.toString());
			// �ر������Ҳ����
			// Ĭ���� -1 ���ر�������ͻ�����
			// ���� 0 ������������
			// ��������Ϊ����һ��
			cookie.setMaxAge(60 * 60 * 24);
			// cookie·��
			// ���ڵ�ǰ·��Ϊ/shopping/buyCart.shtml
			// ����Ĭ��·��Ϊ/shopping
			cookie.setPath("/");
			// ���͵�ǰ̨�����
			response.addCookie(cookie);
		}
		return "redirect:/shopping/buyCart.shtml";
	}
	
	/**
	 * ����
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/buyer/trueBuy.shtml")
	public String trueBuy(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		// ��һ��
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		BuyCart buyCart = null;
		// �ж�cookie���Ƿ��й��ﳵ
		Cookie[] cookies = request.getCookies();
		if (null != cookies&&cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constans.BUYERCART_COOKIE.equals(cookie.getName())) {
					// ���cookies����ʹ�ô˹��ﳵ
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
			//�жϹ��ﳵ���Ƿ��п��
			List<BuyItem> itemList = buyCart.getItemList();
			if(null != itemList&& itemList.size()>0){
				Integer startSize=itemList.size();
				//���б���������Ʒ�ж�
				for(BuyItem item:itemList){
					Sku sku = skuService.getSkuByKey(item.getSku().getId());
					if(sku.getStockInventory()<item.getAmount()){
						//�����ﳵ����Ʒ
						buyCart.deleteItem(item);
					}
				}
				Integer endSize=itemList.size();
				if(startSize>endSize){
					//�޸�Cookie�й��ﳵ����
					// �ַ��������
					StringWriter str = new StringWriter();

					// ����תJson д�Ĺ��� Jsonʱ�ַ�����
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

					// ���ﳵװ��cookie��,����ת��Json
					Cookie cookie = new Cookie(Constans.BUYERCART_COOKIE, str.toString());
					// �ر������Ҳ����
					// Ĭ���� -1 ���ر�������ͻ�����
					// ���� 0 ������������
					// ��������Ϊ����һ��
					cookie.setMaxAge(60 * 60 * 24);
					// cookie·��
					// ���ڵ�ǰ·��Ϊ/shopping/buyCart.shtml
					// ����Ĭ��·��Ϊ/shopping
					cookie.setPath("/");
					// ���͵�ǰ̨�����
					response.addCookie(cookie);
					return "redirect:/shopping/buyCart.shtml";
				}else{
					//�����ջ���ַ
					Buyer buyer = (Buyer)sessionProvider.getAttribute(request, Constans.BUYER_SESSION);
					AddrQuery addrQuery=new AddrQuery();
					addrQuery.setBuyerId(buyer.getUsername());
					//Ĭ����1
					addrQuery.setIsDef(1);
					List<Addr> addrs = addService.getAddrList(addrQuery);
					model.addAttribute("addr", addrs.get(0));
					// װ�����ﳵ
					List<BuyItem> items = buyCart.getItemList();
					for (BuyItem item : items) {
						Sku s = skuService.getSkuByKey(item.getSku().getId());
						item.setSku(s);
					}
					model.addAttribute("buyCart", buyCart);
					//����
					return "product/productOrder";
				}
			}else{
				return "redirect:/shopping/buyCart.shtml";
			}
			
		}else{
			//������ﳵû����Ʒ�����ض��򵽹��ﳵҳ�档
			return "redirect:/shopping/buyCart.shtml";
		}
	}
	
}
