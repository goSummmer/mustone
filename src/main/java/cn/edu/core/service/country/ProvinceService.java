package cn.edu .core.service.country;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.country.Province;
import cn.edu.core.query.country.ProvinceQuery;

public interface ProvinceService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addProvince(Province province);

	/**
	 * ����������ѯ
	 */
	public Province getProvinceByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Province> getProvincesByKeys(List<Integer> idList);

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
	public Integer updateProvinceByKey(Province province);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param provinceQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param provinceQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Province> getProvinceList(ProvinceQuery provinceQuery);
}
