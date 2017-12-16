package cn.edu.core.bean.product;

import java.io.Serializable;

import cn.edu.core.web.Constans;

/**
 * ͼƬ
 * @author asus
 *
 */
public class Img implements Serializable {
	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer productId;
	private String url;
	private Integer isDef;
	
	//��ȡȫUrl
	public String getAllUrl(){
		return Constans.IMAGE_URL+url;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsDef() {
		return isDef;
	}
	public void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}
	public String toString() {
		return "Img [id=" + id + ",productId=" + productId + ",url=" + url + ",isDef=" + isDef + "]";
	}
}
