package cn.edu.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.user.Buyer;
import cn.edu.core.dao.user.BuyerDao;
import cn.edu.core.query.user.BuyerQuery;
/**
 * ������
 * @author asus
 *
 */
@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

	@Resource
	BuyerDao buyerDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addBuyer(Buyer buyer) {
		return buyerDao.addBuyer(buyer);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Buyer getBuyerByKey(String id) {
		return buyerDao.getBuyerByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Buyer> getBuyersByKeys(List<String> idList) {
		return buyerDao.getBuyersByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return buyerDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return buyerDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateBuyerByKey(Buyer buyer) {
		return buyerDao.updateBuyerByKey(buyer);
	}
	
	@Transactional(readOnly = true)
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery) {
		Pagination p = new Pagination(buyerQuery.getPageNo(),buyerQuery.getPageSize(),buyerDao.getBuyerListCount(buyerQuery));
		p.setList(buyerDao.getBuyerListWithPage(buyerQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery) {
		return buyerDao.getBuyerList(buyerQuery);
	}
}
