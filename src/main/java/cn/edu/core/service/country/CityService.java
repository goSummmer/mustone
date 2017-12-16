package cn.edu.core.service.country;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.country.City;
import cn.edu.core.query.country.CityQuery;

public interface CityService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addCity(City city);

	/**
	 * ����������ѯ
	 */
	public City getCityByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<City> getCitysByKeys(List<Integer> idList);

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
	public Integer updateCityByKey(City city);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param cityQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getCityListWithPage(CityQuery cityQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param cityQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<City> getCityList(CityQuery cityQuery);
}
