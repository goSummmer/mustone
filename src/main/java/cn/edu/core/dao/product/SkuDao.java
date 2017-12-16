package cn.edu.core.dao.product;

import java.util.List;

import cn.edu.core.bean.product.Sku;
import cn.edu.core.query.product.SkuQuery;

public interface SkuDao {

	/**
	 * ���
	 * @param sku
	 */
	public Integer addSku(Sku sku);

	/**
	 * ������������
	 * @param skuQuery
	 */
	public Sku getSkuByKey(Integer id);

	/**
	 * ����������������
	 * @param skuQuery
	 */
	public List<Sku> getSkusByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param skuQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param skuQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param skuQuery
	 */
	public Integer updateSkuByKey(Sku sku);

	/**
	 * ��ҳ��ѯ
	 * @param skuQuery
	 */
	public List<Sku> getSkuListWithPage(SkuQuery skuQuery);

	/**
	 * ���ϲ�ѯ
	 * @param skuQuery
	 */
	public List<Sku> getSkuList(SkuQuery skuQuery);
	
	/**
	 * ������
	 * @param skuQuery
	 */
	public int getSkuListCount(SkuQuery skuQuery);
	
	/**
	 * ������0
	 * @param productId
	 * @return
	 */
	public List<Sku> getStock(Integer productId);

}