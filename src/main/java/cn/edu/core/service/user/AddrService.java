package cn.edu.core.service.user;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.user.Addr;
import cn.edu.core.query.user.AddrQuery;

public interface AddrService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr);

	/**
	 * ����������ѯ
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

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
	public Integer updateAddrByKey(Addr addr);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param addrQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param addrQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
}
