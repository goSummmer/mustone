package cn.edu.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.dao.BrandDao;
import cn.edu.core.query.product.BrandQuery;
import cn.itcast.common.page.Pagination;
/**
 * Ʒ������
 * @author asus
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Resource
	private BrandDao brandDao;
	
	@Transactional(readOnly=true)
	public Pagination getBrandListWithPage(Brand brand) {
		//��ҳ������������(1.ҳ������2.ÿҳ������3.�ܼ�¼��)
		Pagination pagination=new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//Brand����
		pagination.setList(brandDao.getBrandListWithPage(brand));
		return pagination;
	}
	//���Ʒ��
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}
	//ɾ��һ��Ʒ��
	public void deleteBrandByKey(Integer id) {
		brandDao.deleteBrandByKey(id);
	}
	//����ɾ��
	public void deleteBrandByKeys(Integer[] ids) {
		brandDao.deleteBrandByKeys(ids);
	}
	//�޸�Ʒ����Ϣ
	public void updateBrandBykey(Brand brand) {
		brandDao.addBrand(brand);
	}
	//����id��ѯһ��Ʒ����Ϣ
	public Brand getBrandByKey(Integer id) {
		return brandDao.getBrandByKey(id);
	}
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		// TODO Auto-generated method stub
		return brandDao.getBrandList(brandQuery);
	}

}
