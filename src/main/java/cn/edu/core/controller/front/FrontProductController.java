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
 * ǰ̨��Ʒ�б����
 * ��Ʒ����ҳ
 * @author asus
 *
 */
@Controller
public class FrontProductController {
	
	@Autowired
	private BrandService brandService;       //Ʒ��
	@Autowired
	private ProductService productService;   //��Ʒ
	@Autowired
	private TypeService typeService;    	 //����
	@Autowired
	private FeatureService featureService;   //����
	@Autowired
	private SkuService skuService;           //
	
	//��Ʒ�����б�ҳ��
	@RequestMapping(value="/product/display/list.shtml")
	public String list(Integer pageNo,Integer brandId,Integer typeId,String typeName,String brandName,ModelMap model){
		
		//������Ʒ����
		//��Ʒ���Զ���
		FeatureQuery featureQuery=new FeatureQuery();
		//������Ʒ����
		List<Feature> featureList = featureService.getFeatureList(featureQuery);
		//��ʾ�ڽ���
		model.addAttribute("featureList", featureList);
		
		//��ҳ����
		StringBuilder params=new StringBuilder();
		ProductQuery productQuery=new ProductQuery();
		//����ҳ��
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//����ÿҳ��
		productQuery.setPageSize(Product.FRONT��PAGE_SIZE);
		//���ð���Ʒ��ID���е�������
		productQuery.orderbyBrandId(false);
		
		//���� TODO
		//������ѡ����
		boolean flag=false;
		//����Map����
		Map<String,String> query=new HashMap<String, String>();
		//Ʒ��ID
		if(null != brandId){
			productQuery.setBrandId(brandId);
			model.addAttribute("brandName", brandName);
			flag=true;
			query.put("Ʒ��", brandName);
			params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
		}else{
			//������ƷƷ��
			//Ʒ����������
			BrandQuery brandQuery=new BrandQuery();
			//���ò�ѯ�ֶ�
			brandQuery.setFields("id,name");
			//���ÿɼ�
			brandQuery.setIsDisplay(1);
			//����Ʒ��
			List<Brand> brandList = brandService.getBrandList(brandQuery);
			//Ʒ����ʾ�ڽ���
			model.addAttribute("brandList", brandList);
		}
		//����ID
		if(null != typeId){
			productQuery.setTypeId(typeId);
			query.put("����", typeName);
			//��ʾ��ҳ��
			model.addAttribute("typeId", typeId);
			model.addAttribute("typeName", typeName);
			params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);
			flag=true;
		}else{
			//������Ʒ����
			TypeQuery typeQuery=new TypeQuery();
			//��ѯ�ֶ�
			typeQuery.setFields("id,name");
			typeQuery.setIsDisplay(1);
			List<Type> typeList=typeService.getTypeList(typeQuery);
			//��Ʒ������ʾ�ڽ���
			model.addAttribute("typeList", typeList);
		}
		model.addAttribute("flag", flag);
		
		//����
		model.addAttribute("query", query);
		//���ش��з�ҳ����Ʒ
		Pagination productListWithPage = productService.getProductListWithPage(productQuery);
		//ҳ����ʾ
		String url="/product/display/list.shtml";
		productListWithPage.pageView(url, params.toString());
		//ҳ����ʾ
		model.addAttribute("productListWithPage", productListWithPage);
		
		return "product/product";
	}
	
	
	@RequestMapping(value="/product/detail.shtml")
	public String detail(Integer id,ModelMap model){
		//��Ʒ����
		Product product = productService.getProductByKey(id);
		model.addAttribute("product", product);
		//skus
		List<Sku> skus = skuService.getStock(id);
		model.addAttribute("skus",skus);
		//ȥ�ظ�
		List<Color> colors=new ArrayList<Color>();
		//����Sku
		for(Sku sku:skus){
			if(!colors.contains(sku.getColor())){
				colors.add(sku.getColor());
			}
			
		}
		model.addAttribute("colors", colors);
		return "product/productDetail";
	}
}
