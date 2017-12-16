package cn.edu.core.dao.country;

import java.util.List;

import cn.edu.core.bean.country.City;
import cn.edu.core.query.country.CityQuery;

public interface CityDao {

	/**
	 * ���
	 * @param city
	 */
	public Integer addCity(City city);

	/**
	 * ������������
	 * @param cityQuery
	 */
	public City getCityByKey(Integer id);

	/**
	 * ����������������
	 * @param cityQuery
	 */
	public List<City> getCitysByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param cityQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param cityQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param cityQuery
	 */
	public Integer updateCityByKey(City city);

	/**
	 * ��ҳ��ѯ
	 * @param cityQuery
	 */
	public List<City> getCityListWithPage(CityQuery cityQuery);

	/**
	 * ���ϲ�ѯ
	 * @param cityQuery
	 */
	public List<City> getCityList(CityQuery cityQuery);
	
	/**
	 * ������
	 * @param cityQuery
	 */
	public int getCityListCount(CityQuery cityQuery);
}
