package cn.edu.core.query.product;

import java.util.ArrayList;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class ImgQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ImgQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private Integer productId;
	public Integer getProductId() {
		return productId;
	}
	public ImgQuery setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	private String url;
	public String getUrl() {
		return url;
	}
	public ImgQuery setUrl(String url) {
		this.url = url;
		return this;
	}
	private boolean urlLike;
	public ImgQuery setUrlLike(boolean isLike) {
		this.urlLike = isLike;
		return this;
	}
	private Integer isDef;
	public Integer getIsDef() {
		return isDef;
	}
	public ImgQuery setIsDef(Integer isDef) {
		this.isDef = isDef;
		return this;
	}
	/**
	 * ==============================������ѯʱ��Order����˳������==========================
	 * ========
	 **/
	 	public class OrderField {
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;

		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	}
		/**
	 * ==============================������ѯʱ��Order����˳������==========================
	 * ========
	 **/
	/** �����б��ֶ� **/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * �����������ԣ�id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ImgQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�product_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ImgQuery orderbyProductId(boolean isAsc) {
		orderFields.add(new OrderField("product_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�url
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ImgQuery orderbyUrl(boolean isAsc) {
		orderFields.add(new OrderField("url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_def
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ImgQuery orderbyIsDef(boolean isAsc) {
		orderFields.add(new OrderField("is_def", isAsc ? "ASC" : "DESC"));
		return this;
	}
}

