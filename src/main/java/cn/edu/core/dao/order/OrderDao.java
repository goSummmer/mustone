package cn.edu.core.dao.order;

import java.util.List;

import cn.edu.core.bean.order.Order;
import cn.edu.core.query.order.OrderQuery;

public interface OrderDao {

	/**
	 * ���
	 * @param order
	 */
	public Integer addOrder(Order order);

	/**
	 * ������������
	 * @param orderQuery
	 */
	public Order getOrderByKey(Integer id);

	/**
	 * ����������������
	 * @param orderQuery
	 */
	public List<Order> getOrdersByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param orderQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param orderQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param orderQuery
	 */
	public Integer updateOrderByKey(Order order);

	/**
	 * ��ҳ��ѯ
	 * @param orderQuery
	 */
	public List<Order> getOrderListWithPage(OrderQuery orderQuery);

	/**
	 * ���ϲ�ѯ
	 * @param orderQuery
	 */
	public List<Order> getOrderList(OrderQuery orderQuery);
	
	/**
	 * ������
	 * @param orderQuery
	 */
	public int getOrderListCount(OrderQuery orderQuery);
}
