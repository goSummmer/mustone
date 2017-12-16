package cn.edu.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.core.bean.product.Product;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.dao.product.SkuDao;
import cn.edu.core.query.product.SkuQuery;
import cn.itcast.common.page.Pagination;

/**
 * ��С���۵�Ԫ�����
 * @author asus
 *
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

	@Resource
	SkuDao skuDao;
	@Resource
	ColorService colorService;
	@Resource
	ProductService productService;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addSku(Sku sku) {
		return skuDao.addSku(sku);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Sku getSkuByKey(Integer id) {
		Sku sku = skuDao.getSkuByKey(id);
		//ͨ����ƷId����Ʒ
		Product product = productService.getProductByKey(sku.getProductId());
		sku.setProduct(product);
		//��ɫ����
		sku.setColor(colorService.getColorByKey(sku.getColorId()));
		return sku;
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkusByKeys(List<Integer> idList) {
		return skuDao.getSkusByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return skuDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return skuDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateSkuByKey(Sku sku) {
		return skuDao.updateSkuByKey(sku);
	}
	
	@Transactional(readOnly = true)
	public Pagination getSkuListWithPage(SkuQuery skuQuery) {
		Pagination p = new Pagination(skuQuery.getPageNo(),skuQuery.getPageSize(),skuDao.getSkuListCount(skuQuery));
		p.setList(skuDao.getSkuListWithPage(skuQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkuList(SkuQuery skuQuery) {
		List<Sku> skus = skuDao.getSkuList(skuQuery);
		//��ɫ�������
		for(Sku sku:skus){
			sku.setColor(colorService.getColorByKey(sku.getColorId()));
		}
		
		return skus;
	}

	public List<Sku> getStock(Integer productId) {
		// TODO Auto-generated method stub
		List<Sku> skus = skuDao.getStock(productId);
		//��ɫ����
		for(Sku sku:skus){
			sku.setColor(colorService.getColorByKey(sku.getColorId()));
		}
		return skus;
	}
}