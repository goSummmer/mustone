package cn.edu.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.core.bean.order.Order;
import cn.edu.core.query.order.OrderQuery;
import cn.edu.core.service.order.OrderService;

/**
 * �����б� �����鿴
 * 
 * @author asus
 *
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * ����״̬ �����鿴
	 * 
	 * @param isPaiy
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/order/list.do")
	public String list(Integer isPaiy, Integer state, ModelMap model) {
		OrderQuery orderQuery = new OrderQuery();
		// ֧��״̬
		if (null != isPaiy) {
			orderQuery.setIsPaiy(isPaiy);
		}
		// ����״̬
		if (null != state) {
			orderQuery.setState(state);
		}
		List<Order> orderList = orderService.getOrderList(orderQuery);
		model.addAttribute("orderList", orderList);
		return "order/list";
	}
}
