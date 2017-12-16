package cn.edu.core.query.country;

import java.util.ArrayList;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class CityQuery extends BaseQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public CityQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public CityQuery setCode(String code) {
		this.code = code;
		return this;
	}
	private boolean codeLike;
	public CityQuery setCodeLike(boolean isLike) {
		this.codeLike = isLike;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public CityQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public CityQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private String province;
	public String getProvince() {
		return province;
	}
	public CityQuery setProvince(String province) {
		this.province = province;
		return this;
	}
	private boolean provinceLike;
	public CityQuery setProvinceLike(boolean isLike) {
		this.provinceLike = isLike;
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
	public CityQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�code
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public CityQuery orderbyCode(boolean isAsc) {
		orderFields.add(new OrderField("code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public CityQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�province
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public CityQuery orderbyProvince(boolean isAsc) {
		orderFields.add(new OrderField("province", isAsc ? "ASC" : "DESC"));
		return this;
	}

}
