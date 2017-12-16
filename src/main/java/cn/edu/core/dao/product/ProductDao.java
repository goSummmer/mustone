package cn.edu.core.dao.product;

import java.util.List;

import cn.edu.core.bean.product.Product;
import cn.edu.core.query.product.ProductQuery;

public interface ProductDao {

	/**
	 * ���
	 * @param product
	 */
	public Integer addProduct(Product product);

	/**
	 * ������������
	 * @param productQuery
	 */
	public Product getProductByKey(Integer id);

	/**
	 * ����������������
	 * @param productQuery
	 */
	public List<Product> getProductsByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param productQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param productQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param productQuery
	 */
	public Integer updateProductByKey(Product product);

	/**
	 * ��ҳ��ѯ
	 * @param productQuery
	 */
	public List<Product> getProductListWithPage(ProductQuery productQuery);

	/**
	 * ���ϲ�ѯ
	 * @param productQuery
	 */
	public List<Product> getProductList(ProductQuery productQuery);
	
	/**
	 * ������
	 * @param productQuery
	 */
	public int getProductListCount(ProductQuery productQuery);
}