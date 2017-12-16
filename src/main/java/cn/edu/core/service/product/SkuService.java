package cn.edu.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.query.product.SkuQuery;

public interface SkuService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addSku(Sku sku);

	/**
	 * ����������ѯ
	 */
	public Sku getSkuByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Sku> getSkusByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateSkuByKey(Sku sku);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param skuQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getSkuListWithPage(SkuQuery skuQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param skuQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Sku> getSkuList(SkuQuery skuQuery);
	
	/**
	 * ������0
	 * @param productId
	 * @return
	 */
	public List<Sku> getStock(Integer productId);
	
}