package cn.edu.core.service.country;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.country.Town;
import cn.edu.core.query.country.TownQuery;

public interface TownService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addTown(Town town);

	/**
	 * ����������ѯ
	 */
	public Town getTownByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Town> getTownsByKeys(List<Integer> idList);

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
	public Integer updateTownByKey(Town town);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param townQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getTownListWithPage(TownQuery townQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param townQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Town> getTownList(TownQuery townQuery);
}
