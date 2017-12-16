package cn.edu.core.dao.country;

import java.util.List;

import cn.edu.core.bean.country.Town;
import cn.edu.core.query.country.TownQuery;

public interface TownDao {

	/**
	 * ���
	 * @param town
	 */
	public Integer addTown(Town town);

	/**
	 * ������������
	 * @param townQuery
	 */
	public Town getTownByKey(Integer id);

	/**
	 * ����������������
	 * @param townQuery
	 */
	public List<Town> getTownsByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param townQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param townQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param townQuery
	 */
	public Integer updateTownByKey(Town town);

	/**
	 * ��ҳ��ѯ
	 * @param townQuery
	 */
	public List<Town> getTownListWithPage(TownQuery townQuery);

	/**
	 * ���ϲ�ѯ
	 * @param townQuery
	 */
	public List<Town> getTownList(TownQuery townQuery);
	
	/**
	 * ������
	 * @param townQuery
	 */
	public int getTownListCount(TownQuery townQuery);
}