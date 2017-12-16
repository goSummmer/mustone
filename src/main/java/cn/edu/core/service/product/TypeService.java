package cn.edu.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Type;
import cn.edu.core.query.product.TypeQuery;

public interface TypeService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addType(Type type);

	/**
	 * ����������ѯ
	 */
	public Type getTypeByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Type> getTypesByKeys(List<Integer> idList);

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
	public Integer updateTypeByKey(Type type);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param typeQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getTypeListWithPage(TypeQuery typeQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param typeQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Type> getTypeList(TypeQuery typeQuery);
}
