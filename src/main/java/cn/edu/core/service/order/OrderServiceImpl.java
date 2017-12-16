package cn.edu.core.service.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.BuyCart;
import cn.edu.core.bean.BuyItem;
import cn.edu.core.bean.order.Detail;
import cn.edu.core.bean.order.Order;
import cn.edu.core.dao.order.OrderDao;
import cn.edu.core.query.order.OrderQuery;
/**
 * ������
 * @author asus
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDao orderDao;
	@Resource
	DetailService detailService;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addOrder(Order order,BuyCart buyCart) {
		//���ɶ�����
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String oid = df.format(new Date());
		//������
		order.setOid(oid);
		//�˷�
		order.setDeliverFee(buyCart.getFee());
		//Ӧ�����
		order.setPayableFee(buyCart.getTotalPrice());
		//�������
		order.setTotalPrice(buyCart.getProductPrice());
		//֧��״̬
		if(order.getPaymentWay()==0){
			order.setIsPaiy(0);
		}else {
			order.setIsPaiy(1);
		}
		//����״̬   �ύ����
		order.setState(0);
		//����ʱ��
		order.setCreateDate(new Date());
		//���涩��
		Integer addOrder = orderDao.addOrder(order);
		//�������
		List<BuyItem> itemList = buyCart.getItemList();
		for(BuyItem item:itemList){
			//���涩������
			Detail detail=new Detail();
			//����һ������Id
			detail.setOrderId(order.getId());
			//��Ʒ����
			detail.setProductName(item.getSku().getProduct().getName());
			//��Ʒ���
			detail.setProductNo(item.getSku().getProduct().getNo());
			//��ɫ����
			detail.setColor(item.getSku().getColor().getName());
			//����
			detail.setSize(item.getSku().getSize());
			//��Ʒ���ۼ�
			detail.setSkuPrice(item.getSku().getSkuPrice());
			//��������
			detail.setAmount(item.getAmount());
			
			//����
			detailService.addDetail(detail);
		}
		return addOrder;
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Order getOrderByKey(Integer id) {
		return orderDao.getOrderByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Order> getOrdersByKeys(List<Integer> idList) {
		return orderDao.getOrdersByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return orderDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return orderDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateOrderByKey(Order order) {
		return orderDao.updateOrderByKey(order);
	}
	
	@Transactional(readOnly = true)
	public Pagination getOrderListWithPage(OrderQuery orderQuery) {
		Pagination p = new Pagination(orderQuery.getPageNo(),orderQuery.getPageSize(),orderDao.getOrderListCount(orderQuery));
		p.setList(orderDao.getOrderListWithPage(orderQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Order> getOrderList(OrderQuery orderQuery) {
		return orderDao.getOrderList(orderQuery);
	}
}

