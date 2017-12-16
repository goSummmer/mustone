package cn.edu.core.dao.user;

import java.util.List;

import cn.edu.core.bean.user.Addr;
import cn.edu.core.query.user.AddrQuery;

public interface AddrDao {

	/**
	 * ���
	 * @param addr
	 */
	public Integer addAddr(Addr addr);

	/**
	 * ������������
	 * @param addrQuery
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * ����������������
	 * @param addrQuery
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param addrQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param addrQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param addrQuery
	 */
	public Integer updateAddrByKey(Addr addr);

	/**
	 * ��ҳ��ѯ
	 * @param addrQuery
	 */
	public List<Addr> getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * ���ϲ�ѯ
	 * @param addrQuery
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
	
	/**
	 * ������
	 * @param addrQuery
	 */
	public int getAddrListCount(AddrQuery addrQuery);
}
