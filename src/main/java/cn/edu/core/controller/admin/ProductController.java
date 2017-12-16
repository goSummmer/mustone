package cn.edu.core.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.bean.product.Color;
import cn.edu.core.bean.product.Feature;
import cn.edu.core.bean.product.Img;
import cn.edu.core.bean.product.Product;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.bean.product.Type;
import cn.edu.core.query.product.BrandQuery;
import cn.edu.core.query.product.ColorQuery;
import cn.edu.core.query.product.FeatureQuery;
import cn.edu.core.query.product.ProductQuery;
import cn.edu.core.query.product.TypeQuery;
import cn.edu.core.service.product.BrandService;
import cn.edu.core.service.product.ColorService;
import cn.edu.core.service.product.FeatureService;
import cn.edu.core.service.product.ProductService;
import cn.edu.core.service.product.SkuService;
import cn.edu.core.service.product.TypeService;
import cn.edu.core.service.staticpage.StaticPageService;
import cn.itcast.common.page.Pagination;

/**
 * 后台商品管理
 * 商品列表
 * 商品添加
 * 商品管理
 * @author asus
 *
 */
@Controller
public class ProductController {
	@Autowired
	private BrandService brandService;       //品牌
	@Autowired
	private ProductService productService;   //商品
	@Autowired
	private TypeService typeService;    	 //类型
	@Autowired
	private FeatureService featureService;   //属性
	@Autowired
	private ColorService colorService; 		 //颜色
	@Autowired
	private StaticPageService staticPageService; //静态化
	@Autowired
	private SkuService skuService;
	
	//商品管理
	@RequestMapping(value="/product/list.do")
	public String list(Integer pageNo,String name,Integer brandId,Integer isShow,ModelMap model){
		BrandQuery brandQuery=new BrandQuery();
		brandQuery.setFields("id,name");
		//加载品牌
		List<Brand> brandList=brandService.getBrandList(brandQuery);
		model.addAttribute("brandList",brandList);
		
		//分页参数
		StringBuilder params=new StringBuilder();
		
		//商品查询对象
		ProductQuery productQuery=new ProductQuery();
		//判断条件是否为空
		if(StringUtils.isNotBlank(name)){
			productQuery.setName(name);
			//要求模糊查询
			productQuery.setNameLike(true);
			params.append("&name="+name);
			
			//回显条件
			model.addAttribute("name", name);
		}
		//判断品牌ID
		if(null!=brandId){
			productQuery.setBrandId(brandId);
			params.append("&").append("brandId=").append(brandId);
			model.addAttribute("brandId",brandId);
		}
		//判断上不上架
		if(null!=isShow){
			productQuery.setIsShow(isShow);
			params.append("&").append("isShow=").append(isShow);
			model.addAttribute("isShow",isShow);
		}else{
			//默认显示下架
			productQuery.setIsShow(0);
			params.append("&").append("isShow=").append(0);
			model.addAttribute("isShow",0);
		}
		//设置页号
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//设置每页数
		productQuery.setPageSize(5);
		//按照ID到排法
		productQuery.orderbyId(false);
		//加载带有分页商品
		Pagination productListWithPage = productService.getProductListWithPage(productQuery);
		//页面显示
		String url="/product/list.do";
		productListWithPage.pageView(url, params.toString());
		//页面显示
		model.addAttribute("productListWithPage", productListWithPage);
		return "product/list";
	}
	
	//商品添加
	@RequestMapping("/product/toAdd.do")
	public String toAdd(ModelMap model){
		//加载商品类型
		TypeQuery typeQuery=new TypeQuery();
		//查询字段
		typeQuery.setFields("id,name");
		typeQuery.setIsDisplay(1);
		List<Type> typeList=typeService.getTypeList(typeQuery);
		//商品属性显示在界面
		model.addAttribute("typeList", typeList);
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
		//加载商品属性
		//商品属性对象
		FeatureQuery featureQuery=new FeatureQuery();
		//加载商品属性
		List<Feature> featureList = featureService.getFeatureList(featureQuery);
		//显示在界面
		model.addAttribute("featureList", featureList);
		//加载商品颜色
		//商品颜色对象
		ColorQuery colorQuery=new ColorQuery();
		List<Color> colorList = colorService.getColorList(colorQuery);
		//显示在界面
		model.addAttribute("colorList", colorList);
		
		return "product/add";
	}
	//商品添加
	@RequestMapping(value="/product/add.do")
	public String add(Product product,Img img){
		//涉及 商品表  图片表 SKU表
		product.setImg(img);
		//传商品对象到Service层
		productService.addProduct(product);
		
		return "redirect:/product/list.do";
	}
	//商品上架
	@RequestMapping(value="/product/isShow.do")
	public String isShow(Integer[] ids,Integer page,String name,Integer brandId,Integer isShow,ModelMap model){
		System.out.println(page+":"+name+":"+brandId+":"+isShow);
		//实例化商品对象
		Product product=new Product();
		product.setIsShow(1);
		//上架
		if(null != ids && ids.length>0){
			for(Integer id:ids){
				product.setId(id);
				//修改上架状态。
				productService.updateProductByKey(product);
				Map<String, Object> root=new HashMap<String, Object>();
				//设置值
				//商品加载
				Product p = productService.getProductByKey(id);
				root.put("product", p);
				//skus
				List<Sku> skus = skuService.getStock(id);
				root.put("skus",skus);
				//去重复
				List<Color> colors=new ArrayList<Color>();
				//遍历Sku
				for(Sku sku:skus){
					if(!colors.contains(sku.getColor())){
						colors.add(sku.getColor());
					}
					
				}
				root.put("colors", colors);
				staticPageService.productIndex(root, id);
			}
		}
		
		//TODO 静态化
		
		
		
		//判断
		if(null!=page){
			model.addAttribute("pageNo", page);
		}
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null!=brandId){
			model.addAttribute("brandId", brandId);
		}
		if(null!=isShow){
			model.addAttribute("isShow", isShow);
		}
		return "redirect:/product/list.do";
	}
}
