package cn.edu.core.dao.order;

import java.util.List;

import cn.edu.core.bean.order.Detail;
import cn.edu.core.query.order.DetailQuery;

public interface DetailDao {

	/**
	 * ���
	 * @param detail
	 */
	public Integer addDetail(Detail detail);

	/**
	 * ������������
	 * @param detailQuery
	 */
	public Detail getDetailByKey(Integer id);

	/**
	 * ����������������
	 * @param detailQuery
	 */
	public List<Detail> getDetailsByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param detailQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param detailQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param detailQuery
	 */
	public Integer updateDetailByKey(Detail detail);

	/**
	 * ��ҳ��ѯ
	 * @param detailQuery
	 */
	public List<Detail> getDetailListWithPage(DetailQuery detailQuery);

	/**
	 * ���ϲ�ѯ
	 * @param detailQuery
	 */
	public List<Detail> getDetailList(DetailQuery detailQuery);
	
	/**
	 * ������
	 * @param detailQuery
	 */
	public int getDetailListCount(DetailQuery detailQuery);
}
