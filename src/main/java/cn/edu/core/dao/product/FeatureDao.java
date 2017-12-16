package cn.edu.core.dao.product;

import java.util.List;

import cn.edu.core.bean.product.Feature;
import cn.edu.core.query.product.FeatureQuery;

public interface FeatureDao {

	/**
	 * ���
	 * @param feature
	 */
	public Integer addFeature(Feature feature);

	/**
	 * ������������
	 * @param featureQuery
	 */
	public Feature getFeatureByKey(Integer id);

	/**
	 * ����������������
	 * @param featureQuery
	 */
	public List<Feature> getFeaturesByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param featureQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param featureQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param featureQuery
	 */
	public Integer updateFeatureByKey(Feature feature);

	/**
	 * ��ҳ��ѯ
	 * @param featureQuery
	 */
	public List<Feature> getFeatureListWithPage(FeatureQuery featureQuery);

	/**
	 * ���ϲ�ѯ
	 * @param featureQuery
	 */
	public List<Feature> getFeatureList(FeatureQuery featureQuery);
	
	/**
	 * ������
	 * @param featureQuery
	 */
	public int getFeatureListCount(FeatureQuery featureQuery);
}
