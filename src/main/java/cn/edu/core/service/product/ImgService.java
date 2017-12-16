package cn.edu.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Img;
import cn.edu.core.query.product.ImgQuery;

public interface ImgService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addImg(Img img);

	/**
	 * ����������ѯ
	 */
	public Img getImgByKey(Integer id);

	/**
	 * ��������������ѯ
	 */
	public List<Img> getImgsByKeys(List<Integer> idList);

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
	public Integer updateImgByKey(Img img);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param imgQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getImgListWithPage(ImgQuery imgQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param imgQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Img> getImgList(ImgQuery imgQuery);
}

