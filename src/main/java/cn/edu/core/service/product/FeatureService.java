package cn.edu.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Feature;
import cn.edu.core.query.product.FeatureQuery;

public interface FeatureService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addFeature(Feature feature);

	/**
	 * ����������ѯ
	 */
	public Feature getFeatureByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Feature> getFeaturesByKeys(List<Integer> idList);

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
	public Integer updateFeatureByKey(Feature feature);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param featureQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getFeatureListWithPage(FeatureQuery featureQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param featureQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Feature> getFeatureList(FeatureQuery featureQuery);
}
