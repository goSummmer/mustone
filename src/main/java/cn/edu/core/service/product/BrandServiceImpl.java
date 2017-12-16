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
 * 品牌事务
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
		//分页：有三个参数(1.页号数，2.每页数量，3.总计录数)
		Pagination pagination=new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//Brand集合
		pagination.setList(brandDao.getBrandListWithPage(brand));
		return pagination;
	}
	//添加品牌
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}
	//删除一个品牌
	public void deleteBrandByKey(Integer id) {
		brandDao.deleteBrandByKey(id);
	}
	//批量删除
	public void deleteBrandByKeys(Integer[] ids) {
		brandDao.deleteBrandByKeys(ids);
	}
	//修改品牌信息
	public void updateBrandBykey(Brand brand) {
		brandDao.addBrand(brand);
	}
	//根据id查询一个品牌信息
	public Brand getBrandByKey(Integer id) {
		return brandDao.getBrandByKey(id);
	}
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		// TODO Auto-generated method stub
		return brandDao.getBrandList(brandQuery);
	}

}
