package cn.edu.core.service.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.core.bean.product.Img;
import cn.edu.core.bean.product.Product;
import cn.edu.core.bean.product.Sku;
import cn.edu.core.dao.product.ProductDao;
import cn.edu.core.query.product.ImgQuery;
import cn.edu.core.query.product.ProductQuery;
import cn.itcast.common.page.Pagination;
/**
 * 商品事务层
 * @author asus
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductDao productDao;
	@Resource
	ImgService imgService;
	@Resource
	SkuService skuService;
	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProduct(Product product) {
		//商品保存 返回ID
		Integer id=productDao.addProduct(product);
		//1、商品       图片       sku
		//商品编号
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String no = df.format(new Date());
		product.setNo(no);
		//添加时间
		product.setCreateTime(new Date());
		//图片
		product.getImg().setProductId(product.getId());
		product.getImg().setIsDef(1);
		imgService.addImg(product.getImg());
		//保存SKU
		//s、m、xl、xxl
		//实例化sku
		Sku sku=new Sku();
		sku.setProductId(product.getId());
		for(String color:product.getColor().split(",")){
			//颜色id
			sku.setColorId(Integer.parseInt(color));
			//运费
			sku.setDeliveFee(10.00);
			//售价
			sku.setSkuPrice(0.00);
			//市场价
			sku.setMarketPrice(0.00);
			//库存
			sku.setStockInventory(0);
			//购买限制
			sku.setSkuUpperLimit(0);
			//添加时间
			sku.setCreateTime(new Date());
			//是否最新
			sku.setLastStatus(1);
			//0 ：商品   1：赠品
			sku.setSkuType(0);
			for(String size:product.getSize().split(",")){
				//尺码
				sku.setSize(size);
				//保存sku
				skuService.addSku(sku);
			}
		}
		
		return id;
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Product getProductByKey(Integer id) {
		Product product = productDao.getProductByKey(id);
		ImgQuery imgQuery=new ImgQuery();
		imgQuery.setProductId(product.getId());
		imgQuery.setIsDef(1);
		List<Img> imgList = imgService.getImgList(imgQuery);
		product.setImg(imgList.get(0));
		return product;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductsByKeys(List<Integer> idList) {
		return productDao.getProductsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductByKey(Product product) {
		return productDao.updateProductByKey(product);
	}
	
	@Transactional(readOnly = true)
	public Pagination getProductListWithPage(ProductQuery productQuery) {
		Pagination p = new Pagination(productQuery.getPageNo(),productQuery.getPageSize(),productDao.getProductListCount(productQuery));
		List<Product> products = productDao.getProductListWithPage(productQuery);
		//遍历商品
		for(Product product:products){
			ImgQuery imgQuery=new ImgQuery();
			imgQuery.setProductId(product.getId());
			imgQuery.setIsDef(1);
			List<Img> imgList = imgService.getImgList(imgQuery);
			product.setImg(imgList.get(0));
		}
		p.setList(products);
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductList(ProductQuery productQuery) {
		return productDao.getProductList(productQuery);
	}
}
