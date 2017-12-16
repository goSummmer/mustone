package cn.edu.core.dao.product;

import java.util.List;

import cn.edu.core.bean.product.Color;
import cn.edu.core.query.product.ColorQuery;


public interface ColorDao {

	/**
	 * ���
	 * @param color
	 */
	public Integer addColor(Color color);

	/**
	 * ������������
	 * @param colorQuery
	 */
	public Color getColorByKey(Integer id);

	/**
	 * ����������������
	 * @param colorQuery
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param colorQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param colorQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param colorQuery
	 */
	public Integer updateColorByKey(Color color);

	/**
	 * ��ҳ��ѯ
	 * @param colorQuery
	 */
	public List<Color> getColorListWithPage(ColorQuery colorQuery);

	/**
	 * ���ϲ�ѯ
	 * @param colorQuery
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
	
	/**
	 * ������
	 * @param colorQuery
	 */
	public int getColorListCount(ColorQuery colorQuery);
}
