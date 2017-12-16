package cn.edu.core.query.country;

import java.util.ArrayList;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class ProvinceQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ProvinceQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public ProvinceQuery setCode(String code) {
		this.code = code;
		return this;
	}
	private boolean codeLike;
	public ProvinceQuery setCodeLike(boolean isLike) {
		this.codeLike = isLike;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public ProvinceQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public ProvinceQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
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
	public ProvinceQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�code
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProvinceQuery orderbyCode(boolean isAsc) {
		orderFields.add(new OrderField("code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProvinceQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}

}

