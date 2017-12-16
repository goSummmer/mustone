package cn.edu.core.controller.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.bean.product.Color;
import cn.edu.core.bean.product.Feature;
import cn.edu.core.bean.product.Product;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.bean.product.Type;
import cn.edu.core.query.product.BrandQuery;
import cn.edu.core.query.product.FeatureQuery;
import cn.edu.core.query.product.ProductQuery;
import cn.edu.core.query.product.TypeQuery;
import cn.edu.core.service.product.BrandService;
import cn.edu.core.service.product.FeatureService;
import cn.edu.core.service.product.ProductService;
import cn.edu.core.service.product.SkuService;
import cn.edu.core.service.product.TypeService;
import cn.itcast.common.page.Pagination;

/**
 * 前台商品列表管理
 * 商品详情页
 * @author asus
 *
 */
@Controller
public class FrontProductController {
	
	@Autowired
	private BrandService brandService;       //品牌
	@Autowired
	private ProductService productService;   //商品
	@Autowired
	private TypeService typeService;    	 //类型
	@Autowired
	private FeatureService featureService;   //属性
	@Autowired
	private SkuService skuService;           //
	
	//商品详情列表页面
	@RequestMapping(value="/product/display/list.shtml")
	public String list(Integer pageNo,Integer brandId,Integer typeId,String typeName,String brandName,ModelMap model){
		
		//加载商品属性
		//商品属性对象
		FeatureQuery featureQuery=new FeatureQuery();
		//加载商品属性
		List<Feature> featureList = featureService.getFeatureList(featureQuery);
		//显示在界面
		model.addAttribute("featureList", featureList);
		
		//分页参数
		StringBuilder params=new StringBuilder();
		ProductQuery productQuery=new ProductQuery();
		//设置页号
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//设置每页数
		productQuery.setPageSize(Product.FRONT＿PAGE_SIZE);
		//设置按照品牌ID进行倒序排列
		productQuery.orderbyBrandId(false);
		
		//条件 TODO
		//隐藏已选条件
		boolean flag=false;
		//条件Map窗口
		Map<String,String> query=new HashMap<String, String>();
		//品牌ID
		if(null != brandId){
			productQuery.setBrandId(brandId);
			model.addAttribute("brandName", brandName);
			flag=true;
			query.put("品牌", brandName);
			params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
		}else{
			//加载商品品牌
			//品牌条件对象
			BrandQuery brandQuery=new BrandQuery();
			//设置查询字段
			brandQuery.setFields("id,name");
			//设置可见
			brandQuery.setIsDisplay(1);
			//加载品牌
			List<Brand> brandList = brandService.getBrandList(brandQuery);
			//品牌显示在界面
			model.addAttribute("brandList", brandList);
		}
		//类型ID
		if(null != typeId){
			productQuery.setTypeId(typeId);
			query.put("类型", typeName);
			//显示在页面
			model.addAttribute("typeId", typeId);
			model.addAttribute("typeName", typeName);
			params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);
			flag=true;
		}else{
			//加载商品类型
			TypeQuery typeQuery=new TypeQuery();
			//查询字段
			typeQuery.setFields("id,name");
			typeQuery.setIsDisplay(1);
			List<Type> typeList=typeService.getTypeList(typeQuery);
			//商品属性显示在界面
			model.addAttribute("typeList", typeList);
		}
		model.addAttribute("flag", flag);
		
		//条件
		model.addAttribute("query", query);
		//加载带有分页的商品
		Pagination productListWithPage = productService.getProductListWithPage(productQuery);
		//页面显示
		String url="/product/display/list.shtml";
		productListWithPage.pageView(url, params.toString());
		//页面显示
		model.addAttribute("productListWithPage", productListWithPage);
		
		return "product/product";
	}
	
	
	@RequestMapping(value="/product/detail.shtml")
	public String detail(Integer id,ModelMap model){
		//商品加载
		Product product = productService.getProductByKey(id);
		model.addAttribute("product", product);
		//skus
		List<Sku> skus = skuService.getStock(id);
		model.addAttribute("skus",skus);
		//去重复
		List<Color> colors=new ArrayList<Color>();
		//遍历Sku
		for(Sku sku:skus){
			if(!colors.contains(sku.getColor())){
				colors.add(sku.getColor());
			}
			
		}
		model.addAttribute("colors", colors);
		return "product/productDetail";
	}
}
