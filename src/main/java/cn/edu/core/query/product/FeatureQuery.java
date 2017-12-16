package cn.edu.core.query.product;

import java.util.ArrayList;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class FeatureQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public FeatureQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public FeatureQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public FeatureQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private String value;
	public String getValue() {
		return value;
	}
	public FeatureQuery setValue(String value) {
		this.value = value;
		return this;
	}
	private boolean valueLike;
	public FeatureQuery setValueLike(boolean isLike) {
		this.valueLike = isLike;
		return this;
	}
	private Integer sort;
	public Integer getSort() {
		return sort;
	}
	public FeatureQuery setSort(Integer sort) {
		this.sort = sort;
		return this;
	}
	private Integer isDel;
	public Integer getIsDel() {
		return isDel;
	}
	public FeatureQuery setIsDel(Integer isDel) {
		this.isDel = isDel;
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
	public FeatureQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public FeatureQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�value
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public FeatureQuery orderbyValue(boolean isAsc) {
		orderFields.add(new OrderField("value", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sort
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public FeatureQuery orderbySort(boolean isAsc) {
		orderFields.add(new OrderField("sort", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_del
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public FeatureQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}

}

