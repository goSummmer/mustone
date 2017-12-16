package cn.edu.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Product;
import cn.edu.core.query.product.ProductQuery;
/**
 * 
 * @author asus
 *
 */

public interface ProductService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addProduct(Product product);

	/**
	 * ����������ѯ
	 */
	public Product getProductByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Product> getProductsByKeys(List<Integer> idList);

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
	public Integer updateProductByKey(Product product);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param productQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getProductListWithPage(ProductQuery productQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param productQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Product> getProductList(ProductQuery productQuery);
}

