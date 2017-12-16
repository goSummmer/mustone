package cn.edu.core.dao.product;

import java.util.List;

import cn.edu.core.bean.product.Type;
import cn.edu.core.query.product.TypeQuery;

public interface TypeDao {

	/**
	 * ���
	 * @param type
	 */
	public Integer addType(Type type);

	/**
	 * ������������
	 * @param typeQuery
	 */
	public Type getTypeByKey(Integer id);

	/**
	 * ����������������
	 * @param typeQuery
	 */
	public List<Type> getTypesByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param typeQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param typeQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param typeQuery
	 */
	public Integer updateTypeByKey(Type type);

	/**
	 * ��ҳ��ѯ
	 * @param typeQuery
	 */
	public List<Type> getTypeListWithPage(TypeQuery typeQuery);

	/**
	 * ���ϲ�ѯ
	 * @param typeQuery
	 */
	public List<Type> getTypeList(TypeQuery typeQuery);
	
	/**
	 * ������
	 * @param typeQuery
	 */
	public int getTypeListCount(TypeQuery typeQuery);
}
