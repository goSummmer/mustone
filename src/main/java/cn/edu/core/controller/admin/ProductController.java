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
 * ��̨��Ʒ����
 * ��Ʒ�б�
 * ��Ʒ���
 * ��Ʒ����
 * @author asus
 *
 */
@Controller
public class ProductController {
	@Autowired
	private BrandService brandService;       //Ʒ��
	@Autowired
	private ProductService productService;   //��Ʒ
	@Autowired
	private TypeService typeService;    	 //����
	@Autowired
	private FeatureService featureService;   //����
	@Autowired
	private ColorService colorService; 		 //��ɫ
	@Autowired
	private StaticPageService staticPageService; //��̬��
	@Autowired
	private SkuService skuService;
	
	//��Ʒ����
	@RequestMapping(value="/product/list.do")
	public String list(Integer pageNo,String name,Integer brandId,Integer isShow,ModelMap model){
		BrandQuery brandQuery=new BrandQuery();
		brandQuery.setFields("id,name");
		//����Ʒ��
		List<Brand> brandList=brandService.getBrandList(brandQuery);
		model.addAttribute("brandList",brandList);
		
		//��ҳ����
		StringBuilder params=new StringBuilder();
		
		//��Ʒ��ѯ����
		ProductQuery productQuery=new ProductQuery();
		//�ж������Ƿ�Ϊ��
		if(StringUtils.isNotBlank(name)){
			productQuery.setName(name);
			//Ҫ��ģ����ѯ
			productQuery.setNameLike(true);
			params.append("&name="+name);
			
			//��������
			model.addAttribute("name", name);
		}
		//�ж�Ʒ��ID
		if(null!=brandId){
			productQuery.setBrandId(brandId);
			params.append("&").append("brandId=").append(brandId);
			model.addAttribute("brandId",brandId);
		}
		//�ж��ϲ��ϼ�
		if(null!=isShow){
			productQuery.setIsShow(isShow);
			params.append("&").append("isShow=").append(isShow);
			model.addAttribute("isShow",isShow);
		}else{
			//Ĭ����ʾ�¼�
			productQuery.setIsShow(0);
			params.append("&").append("isShow=").append(0);
			model.addAttribute("isShow",0);
		}
		//����ҳ��
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//����ÿҳ��
		productQuery.setPageSize(5);
		//����ID���ŷ�
		productQuery.orderbyId(false);
		//���ش��з�ҳ��Ʒ
		Pagination productListWithPage = productService.getProductListWithPage(productQuery);
		//ҳ����ʾ
		String url="/product/list.do";
		productListWithPage.pageView(url, params.toString());
		//ҳ����ʾ
		model.addAttribute("productListWithPage", productListWithPage);
		return "product/list";
	}
	
	//��Ʒ���
	@RequestMapping("/product/toAdd.do")
	public String toAdd(ModelMap model){
		//������Ʒ����
		TypeQuery typeQuery=new TypeQuery();
		//��ѯ�ֶ�
		typeQuery.setFields("id,name");
		typeQuery.setIsDisplay(1);
		List<Type> typeList=typeService.getTypeList(typeQuery);
		//��Ʒ������ʾ�ڽ���
		model.addAttribute("typeList", typeList);
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
		//������Ʒ����
		//��Ʒ���Զ���
		FeatureQuery featureQuery=new FeatureQuery();
		//������Ʒ����
		List<Feature> featureList = featureService.getFeatureList(featureQuery);
		//��ʾ�ڽ���
		model.addAttribute("featureList", featureList);
		//������Ʒ��ɫ
		//��Ʒ��ɫ����
		ColorQuery colorQuery=new ColorQuery();
		List<Color> colorList = colorService.getColorList(colorQuery);
		//��ʾ�ڽ���
		model.addAttribute("colorList", colorList);
		
		return "product/add";
	}
	//��Ʒ���
	@RequestMapping(value="/product/add.do")
	public String add(Product product,Img img){
		//�漰 ��Ʒ��  ͼƬ�� SKU��
		product.setImg(img);
		//����Ʒ����Service��
		productService.addProduct(product);
		
		return "redirect:/product/list.do";
	}
	//��Ʒ�ϼ�
	@RequestMapping(value="/product/isShow.do")
	public String isShow(Integer[] ids,Integer page,String name,Integer brandId,Integer isShow,ModelMap model){
		System.out.println(page+":"+name+":"+brandId+":"+isShow);
		//ʵ������Ʒ����
		Product product=new Product();
		product.setIsShow(1);
		//�ϼ�
		if(null != ids && ids.length>0){
			for(Integer id:ids){
				product.setId(id);
				//�޸��ϼ�״̬��
				productService.updateProductByKey(product);
				Map<String, Object> root=new HashMap<String, Object>();
				//����ֵ
				//��Ʒ����
				Product p = productService.getProductByKey(id);
				root.put("product", p);
				//skus
				List<Sku> skus = skuService.getStock(id);
				root.put("skus",skus);
				//ȥ�ظ�
				List<Color> colors=new ArrayList<Color>();
				//����Sku
				for(Sku sku:skus){
					if(!colors.contains(sku.getColor())){
						colors.add(sku.getColor());
					}
					
				}
				root.put("colors", colors);
				staticPageService.productIndex(root, id);
			}
		}
		
		//TODO ��̬��
		
		
		
		//�ж�
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
