package cn.edu.core.service.order;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.order.Detail;
import cn.edu.core.query.order.DetailQuery;

public interface DetailService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addDetail(Detail detail);

	/**
	 * ����������ѯ
	 */
	public Detail getDetailByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Detail> getDetailsByKeys(List<Integer> idList);

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
	public Integer updateDetailByKey(Detail detail);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param detailQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getDetailListWithPage(DetailQuery detailQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param detailQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Detail> getDetailList(DetailQuery detailQuery);
}

