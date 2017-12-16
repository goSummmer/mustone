package cn.edu.core.service.product;


import java.util.List;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.query.product.BrandQuery;
import cn.itcast.common.page.Pagination;

/**
 * Ʒ��
 * @author asus
 *
 */
public interface BrandService {
	//��ȡƷ������
	public Pagination getBrandListWithPage(Brand brand);
	//��ѯƷ�Ƽ���
	public List<Brand> getBrandList(BrandQuery brandQuery);
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
