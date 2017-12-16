package cn.edu.core.dao;

import java.util.List;

import cn.edu.core.bean.product.Brand;
import cn.edu.core.query.product.BrandQuery;
/**
 * 品牌
 * @author asus
 *
 */
public interface BrandDao {
	//分页查询List
	public List<Brand> getBrandListWithPage(Brand brand);
	//查询品牌集合
	public List<Brand> getBrandList(BrandQuery brandQuery);
	//查询总记录数
	public int getBrandCount(Brand brand);
	//添加品牌
	public void addBrand(Brand brand);
	//删除一个品牌
	public void deleteBrandByKey(Integer id);
	//批量删除品牌
	public void deleteBrandByKeys(Integer[] ids);
	//修改信息
	public void updateBrandBykey(Brand brand);
	//查询一个品牌信息
	public Brand getBrandByKey(Integer id);
}
