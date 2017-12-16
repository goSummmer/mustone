package cn.edu;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.common.junit.SpringJunitTest;
import cn.edu.core.bean.product.Brand;
import cn.edu.core.query.product.BrandQuery;
import cn.edu.core.service.product.BrandService;

/**
 * ²âÊÔ
 * @author asus
 *
 */

public class TestBrand extends SpringJunitTest {
	
	@Autowired
	private BrandService brandService;
	
	@Test
	public void testAdd()throws Exception {
		// TODO Auto-generated method stu
		BrandQuery brandQuery=new BrandQuery();
//		brandQuery.setFields("id");
//		brandQuery.setNameLike(true);
//		brandQuery.setName("½ð");
//		brandQuery.orderbyId(false);
		brandQuery.setPageSize(2);
		brandQuery.setPageNo(2);
		List<Brand> brandList = brandService.getBrandList(brandQuery);
		System.out.println(brandList.size());
		for (Brand brand:brandList) {
			System.out.println(brand.toString());
		}
	}
	
}
