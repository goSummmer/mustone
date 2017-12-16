package cn.edu.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.service.product.BrandService;
import cn.itcast.common.page.Pagination;

/**
 * 品牌
 * @author asus
 *
 */
@Controller
@RequestMapping(value="/control")
public class BrandController {
	@Autowired
	private BrandService brandService;
	//品牌列表
	@RequestMapping(value="/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model){
		Brand brand=new Brand();
		StringBuilder params=new StringBuilder();
		//传进来的是名称否为null，还要判断是否为空串使用black(识别空串：""    "      ")和emtype(识别空串："")
		if(StringUtils.isNotBlank(name)){
			brand.setName(name);
			params.append("name=").append(name);
		}
		if(isDisplay!=null){
			brand.setIsDisplay(isDisplay);
			params.append("&").append("isDisplay=").append(isDisplay);
		}else{
			brand.setIsDisplay(1);
			params.append("&").append("isDisplay=").append(1);
		}
		//页号                                 当页号为空或小于1时置为1
		brand.setPageNo(Pagination.cpn(pageNo));
		//每页数
		brand.setPageSize(5);;
		//分页对象
		Pagination pagination=brandService.getBrandListWithPage(brand);
		//分页展示  /brand/lsit.do?name=瑜伽树&isDisplay=1&pageNo=1
		String url="/control/brand/list.do";
		pagination.pageView(url, params.toString());
		//存储在model里面显示在前台
		model.addAttribute("pagination",pagination);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		return "brand/list";
	}
	//跳转到品牌添加页面
	@RequestMapping(value="/brand/toAdd.do")
	public String toAdd(){
		return "brand/add";
	}
	//添加品牌
	@RequestMapping(value="/brand/add.do")
	public String add(Brand brand){
		brandService.addBrand(brand);
		return "redirect:list.do";
	}
	//删除一个品牌
	@RequestMapping(value="/brand/delete.do")
	public String delete(Integer id,String name,Integer isDisplay,ModelMap model){
		brandService.deleteBrandByKey(id);
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null!=isDisplay){
			model.addAttribute("isDisplay",isDisplay);
		}
		return "redirect:list.do";
	}
	//删除多个品牌
	@RequestMapping(value="/brand/deletes.do")
	public String deleteS(Integer[] ids,String name,Integer isDisplay,ModelMap model){
		brandService.deleteBrandByKeys(ids);
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null!=isDisplay){
			model.addAttribute("isDisplay",isDisplay);
		}
		return "redirect:list.do";
	}
	//去修改页面
	@RequestMapping(value="/brand/toEdit.do")
	public String toEdit(Integer id,ModelMap model){
		Brand brand = brandService.getBrandByKey(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}
	//修改实现
	@RequestMapping(value="/brand/edit.do")
	public String edit(Brand brand,ModelMap model){
		brandService.updateBrandBykey(brand);
		return "redirect:list.do";
	}
}
