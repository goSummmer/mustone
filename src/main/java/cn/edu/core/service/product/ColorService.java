package cn.edu.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Color;
import cn.edu.core.query.product.ColorQuery;

public interface ColorService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addColor(Color color);

	/**
	 * ����������ѯ
	 */
	public Color getColorByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

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
	public Integer updateColorByKey(Color color);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param colorQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getColorListWithPage(ColorQuery colorQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param colorQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
}
