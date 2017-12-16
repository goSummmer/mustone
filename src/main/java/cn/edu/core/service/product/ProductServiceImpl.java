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
 * ��Ʒ�����
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
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addProduct(Product product) {
		//��Ʒ���� ����ID
		Integer id=productDao.addProduct(product);
		//1����Ʒ       ͼƬ       sku
		//��Ʒ���
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String no = df.format(new Date());
		product.setNo(no);
		//���ʱ��
		product.setCreateTime(new Date());
		//ͼƬ
		product.getImg().setProductId(product.getId());
		product.getImg().setIsDef(1);
		imgService.addImg(product.getImg());
		//����SKU
		//s��m��xl��xxl
		//ʵ����sku
		Sku sku=new Sku();
		sku.setProductId(product.getId());
		for(String color:product.getColor().split(",")){
			//��ɫid
			sku.setColorId(Integer.parseInt(color));
			//�˷�
			sku.setDeliveFee(10.00);
			//�ۼ�
			sku.setSkuPrice(0.00);
			//�г���
			sku.setMarketPrice(0.00);
			//���
			sku.setStockInventory(0);
			//��������
			sku.setSkuUpperLimit(0);
			//���ʱ��
			sku.setCreateTime(new Date());
			//�Ƿ�����
			sku.setLastStatus(1);
			//0 ����Ʒ   1����Ʒ
			sku.setSkuType(0);
			for(String size:product.getSize().split(",")){
				//����
				sku.setSize(size);
				//����sku
				skuService.addSku(sku);
			}
		}
		
		return id;
	}

	/**
	 * ������������
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
	 * ��������ɾ��
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
	 * ������������
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
		//������Ʒ
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
