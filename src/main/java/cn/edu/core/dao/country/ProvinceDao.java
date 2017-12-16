package cn.edu.core.dao.country;

import java.util.List;

import cn.edu.core.bean.country.Province;
import cn.edu.core.query.country.ProvinceQuery;

public interface ProvinceDao {

	/**
	 * ���
	 * @param province
	 */
	public Integer addProvince(Province province);

	/**
	 * ������������
	 * @param provinceQuery
	 */
	public Province getProvinceByKey(Integer id);

	/**
	 * ����������������
	 * @param provinceQuery
	 */
	public List<Province> getProvincesByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param provinceQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param provinceQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param provinceQuery
	 */
	public Integer updateProvinceByKey(Province province);

	/**
	 * ��ҳ��ѯ
	 * @param provinceQuery
	 */
	public List<Province> getProvinceListWithPage(ProvinceQuery provinceQuery);

	/**
	 * ���ϲ�ѯ
	 * @param provinceQuery
	 */
	public List<Province> getProvinceList(ProvinceQuery provinceQuery);
	
	/**
	 * ������
	 * @param provinceQuery
	 */
	public int getProvinceListCount(ProvinceQuery provinceQuery);
}
