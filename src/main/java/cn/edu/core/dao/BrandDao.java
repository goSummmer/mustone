package cn.edu.core.dao;

import java.util.List;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.query.product.BrandQuery;
/**
 * Ʒ��
 * @author asus
 *
 */
public interface BrandDao {
	//��ҳ��ѯList
	public List<Brand> getBrandListWithPage(Brand brand);
	//��ѯƷ�Ƽ���
	public List<Brand> getBrandList(BrandQuery brandQuery);
	//��ѯ�ܼ�¼��
	public int getBrandCount(Brand brand);
	//���Ʒ��
	public void addBrand(Brand brand);
	//ɾ��һ��Ʒ��
	public void deleteBrandByKey(Integer id);
	//����ɾ��Ʒ��
	public void deleteBrandByKeys(Integer[] ids);
	//�޸���Ϣ
	public void updateBrandBykey(Brand brand);
	//��ѯһ��Ʒ����Ϣ
	public Brand getBrandByKey(Integer id);
}
