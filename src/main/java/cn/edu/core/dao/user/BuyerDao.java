package cn.edu.core.dao.user;

import java.util.List;

import cn.edu.core.bean.user.Buyer;
import cn.edu.core.query.user.BuyerQuery;

public interface BuyerDao {

	/**
	 * ���
	 * @param buyer
	 */
	public Integer addBuyer(Buyer buyer);

	/**
	 * ������������
	 * @param buyerQuery
	 */
	public Buyer getBuyerByKey(String id);

	/**
	 * ����������������
	 * @param buyerQuery
	 */
	public List<Buyer> getBuyersByKeys(List<String> idList);

	/**
	 * ��������ɾ��
	 * @param buyerQuery
	 */
	public Integer deleteByKey(String id);

	/**
	 * ������������ɾ��
	 * @param buyerQuery
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * ������������
	 * @param buyerQuery
	 */
	public Integer updateBuyerByKey(Buyer buyer);

	/**
	 * ��ҳ��ѯ
	 * @param buyerQuery
	 */
	public List<Buyer> getBuyerListWithPage(BuyerQuery buyerQuery);

	/**
	 * ���ϲ�ѯ
	 * @param buyerQuery
	 */
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery);
	
	/**
	 * ������
	 * @param buyerQuery
	 */
	public int getBuyerListCount(BuyerQuery buyerQuery);
}