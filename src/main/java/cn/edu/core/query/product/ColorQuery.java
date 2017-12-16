package cn.edu.core.query.product;

import java.util.ArrayList;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class ColorQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ColorQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public ColorQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public ColorQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private Integer parentId;
	public Integer getParentId() {
		return parentId;
	}
	public ColorQuery setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}
	private String imgUrl;
	public String getImgUrl() {
		return imgUrl;
	}
	public ColorQuery setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}
	private boolean imgUrlLike;
	public ColorQuery setImgUrlLike(boolean isLike) {
		this.imgUrlLike = isLike;
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
	public ColorQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ColorQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�parent_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ColorQuery orderbyParentId(boolean isAsc) {
		orderFields.add(new OrderField("parent_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�img_url
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ColorQuery orderbyImgUrl(boolean isAsc) {
		orderFields.add(new OrderField("img_url", isAsc ? "ASC" : "DESC"));
		return this;
	}

}