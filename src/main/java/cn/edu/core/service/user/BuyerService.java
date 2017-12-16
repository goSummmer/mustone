package cn.edu.core.service.user;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.user.Buyer;
import cn.edu.core.query.user.BuyerQuery;

public interface BuyerService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addBuyer(Buyer buyer);

	/**
	 * ����������ѯ
	 */
	public Buyer getBuyerByKey(String id);

	/**
	 * ��������������ѯ
	 */
	public List<Buyer> getBuyersByKeys(List<String> idList);

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id);

	/**
	 * ������������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateBuyerByKey(Buyer buyer);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param buyerQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param buyerQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery);
}