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
 * Ʒ��
 * @author asus
 *
 */
@Controller
@RequestMapping(value="/control")
public class BrandController {
	@Autowired
	private BrandService brandService;
	//Ʒ���б�
	@RequestMapping(value="/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model){
		Brand brand=new Brand();
		StringBuilder params=new StringBuilder();
		//�������������Ʒ�Ϊnull����Ҫ�ж��Ƿ�Ϊ�մ�ʹ��black(ʶ��մ���""    "      ")��emtype(ʶ��մ���"")
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
		//ҳ��                                 ��ҳ��Ϊ�ջ�С��1ʱ��Ϊ1
		brand.setPageNo(Pagination.cpn(pageNo));
		//ÿҳ��
		brand.setPageSize(5);;
		//��ҳ����
		Pagination pagination=brandService.getBrandListWithPage(brand);
		//��ҳչʾ  /brand/lsit.do?name=�٤��&isDisplay=1&pageNo=1
		String url="/control/brand/list.do";
		pagination.pageView(url, params.toString());
		//�洢��model������ʾ��ǰ̨
		model.addAttribute("pagination",pagination);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		return "brand/list";
	}
	//��ת��Ʒ�����ҳ��
	@RequestMapping(value="/brand/toAdd.do")
	public String toAdd(){
		return "brand/add";
	}
	//���Ʒ��
	@RequestMapping(value="/brand/add.do")
	public String add(Brand brand){
		brandService.addBrand(brand);
		return "redirect:list.do";
	}
	//ɾ��һ��Ʒ��
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
	//ɾ�����Ʒ��
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
	//ȥ�޸�ҳ��
	@RequestMapping(value="/brand/toEdit.do")
	public String toEdit(Integer id,ModelMap model){
		Brand brand = brandService.getBrandByKey(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}
	//�޸�ʵ��
	@RequestMapping(value="/brand/edit.do")
	public String edit(Brand brand,ModelMap model){
		brandService.updateBrandBykey(brand);
		return "redirect:list.do";
	}
}
