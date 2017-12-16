package cn.edu.core.dao.product;

import java.util.List;

import cn.edu.core.bean.product.Img;
import cn.edu.core.query.product.ImgQuery;

public interface ImgDao {

	/**
	 * ���
	 * @param img
	 */
	public Integer addImg(Img img);

	/**
	 * ������������
	 * @param imgQuery
	 */
	public Img getImgByKey(Integer id);

	/**
	 * ����������������
	 * @param imgQuery
	 */
	public List<Img> getImgsByKeys(List<Integer> idList);

	/**
	 * ��������ɾ��
	 * @param imgQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * ������������ɾ��
	 * @param imgQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * ������������
	 * @param imgQuery
	 */
	public Integer updateImgByKey(Img img);

	/**
	 * ��ҳ��ѯ
	 * @param imgQuery
	 */
	public List<Img> getImgListWithPage(ImgQuery imgQuery);

	/**
	 * ���ϲ�ѯ
	 * @param imgQuery
	 */
	public List<Img> getImgList(ImgQuery imgQuery);
	
	/**
	 * ������
	 * @param imgQuery
	 */
	public int getImgListCount(ImgQuery imgQuery);
}
