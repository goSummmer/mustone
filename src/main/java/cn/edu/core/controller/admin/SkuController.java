package cn.edu.core.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.common.web.ResponseUtils;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.query.product.SkuQuery;
import cn.edu.core.service.product.SkuService;

/**
 * 库存管理
 * 修改库存
 * @author asus
 *
 */
@Controller
public class SkuController {
	
	@Autowired
	private SkuService skuService;
	
	/**
	 * 跳转到库存管理页面
	 * @param productId
	 * @param pno
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sku/list.do")
	public String list(Integer productId,String pno,ModelMap model){
		//回显到库存管理页面
		model.addAttribute("pno",pno);
		//最小销售单元
		SkuQuery skuQuery=new SkuQuery();
		skuQuery.setProductId(productId);
		List<Sku> skus=skuService.getSkuList(skuQuery);
		//销售单元回显
		model.addAttribute("skus", skus);
		
		return "sku/list";
	}
	
	/**
	 * 保存修改
	 * @param sku
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sku/add.do")
	public void add(Sku sku,ModelMap model,HttpServletResponse response){
		//保存修改信息
		skuService.updateSkuByKey(sku);
		//返回提示信息
		JSONObject jo=new JSONObject();
		jo.put("message", "保存成功！");
		
		ResponseUtils.renderJson(response,jo.toString());
	}

}
