package cn.edu.core.service.order;

import java.util.List;

import cn.edu.core.bean.BuyCart;
import cn.edu.core.bean.order.Order;
import cn.edu.core.query.order.OrderQuery;
import cn.itcast.common.page.Pagination;

public interface OrderService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addOrder(Order order,BuyCart buyCart);

	/**
	 * ����������ѯ
	 */
	public Order getOrderByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Order> getOrdersByKeys(List<Integer> idList);

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
	public Integer updateOrderByKey(Order order);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param orderQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getOrderListWithPage(OrderQuery orderQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param orderQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Order> getOrderList(OrderQuery orderQuery);
}

