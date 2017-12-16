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
 * ������
 * �޸Ŀ��
 * @author asus
 *
 */
@Controller
public class SkuController {
	
	@Autowired
	private SkuService skuService;
	
	/**
	 * ��ת��������ҳ��
	 * @param productId
	 * @param pno
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sku/list.do")
	public String list(Integer productId,String pno,ModelMap model){
		//���Ե�������ҳ��
		model.addAttribute("pno",pno);
		//��С���۵�Ԫ
		SkuQuery skuQuery=new SkuQuery();
		skuQuery.setProductId(productId);
		List<Sku> skus=skuService.getSkuList(skuQuery);
		//���۵�Ԫ����
		model.addAttribute("skus", skus);
		
		return "sku/list";
	}
	
	/**
	 * �����޸�
	 * @param sku
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sku/add.do")
	public void add(Sku sku,ModelMap model,HttpServletResponse response){
		//�����޸���Ϣ
		skuService.updateSkuByKey(sku);
		//������ʾ��Ϣ
		JSONObject jo=new JSONObject();
		jo.put("message", "����ɹ���");
		
		ResponseUtils.renderJson(response,jo.toString());
	}

}
