package cn.edu.core.query.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class ProductQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ProductQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String no;
	public String getNo() {
		return no;
	}
	public ProductQuery setNo(String no) {
		this.no = no;
		return this;
	}
	private boolean noLike;
	public ProductQuery setNoLike(boolean isLike) {
		this.noLike = isLike;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public ProductQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public ProductQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private Double weight;
	public Double getWeight() {
		return weight;
	}
	public ProductQuery setWeight(Double weight) {
		this.weight = weight;
		return this;
	}
	private Integer isNew;
	public Integer getIsNew() {
		return isNew;
	}
	public ProductQuery setIsNew(Integer isNew) {
		this.isNew = isNew;
		return this;
	}
	private Integer isHot;
	public Integer getIsHot() {
		return isHot;
	}
	public ProductQuery setIsHot(Integer isHot) {
		this.isHot = isHot;
		return this;
	}
	private Integer isCommend;
	public Integer getIsCommend() {
		return isCommend;
	}
	public ProductQuery setIsCommend(Integer isCommend) {
		this.isCommend = isCommend;
		return this;
	}
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public ProductQuery setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	private String createUserId;
	public String getCreateUserId() {
		return createUserId;
	}
	public ProductQuery setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
		return this;
	}
	private boolean createUserIdLike;
	public ProductQuery setCreateUserIdLike(boolean isLike) {
		this.createUserIdLike = isLike;
		return this;
	}
	private Date checkTime;
	public Date getCheckTime() {
		return checkTime;
	}
	public ProductQuery setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
		return this;
	}
	private String checkUserId;
	public String getCheckUserId() {
		return checkUserId;
	}
	public ProductQuery setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
		return this;
	}
	private boolean checkUserIdLike;
	public ProductQuery setCheckUserIdLike(boolean isLike) {
		this.checkUserIdLike = isLike;
		return this;
	}
	private Integer isShow;
	public Integer getIsShow() {
		return isShow;
	}
	public ProductQuery setIsShow(Integer isShow) {
		this.isShow = isShow;
		return this;
	}
	private Integer isDel;
	public Integer getIsDel() {
		return isDel;
	}
	public ProductQuery setIsDel(Integer isDel) {
		this.isDel = isDel;
		return this;
	}
	private Integer typeId;
	public Integer getTypeId() {
		return typeId;
	}
	public ProductQuery setTypeId(Integer typeId) {
		this.typeId = typeId;
		return this;
	}
	private Integer brandId;
	public Integer getBrandId() {
		return brandId;
	}
	public ProductQuery setBrandId(Integer brandId) {
		this.brandId = brandId;
		return this;
	}
	private String keywords;
	public String getKeywords() {
		return keywords;
	}
	public ProductQuery setKeywords(String keywords) {
		this.keywords = keywords;
		return this;
	}
	private boolean keywordsLike;
	public ProductQuery setKeywordsLike(boolean isLike) {
		this.keywordsLike = isLike;
		return this;
	}
	private Integer sales;
	public Integer getSales() {
		return sales;
	}
	public ProductQuery setSales(Integer sales) {
		this.sales = sales;
		return this;
	}
	private String description;
	public String getDescription() {
		return description;
	}
	public ProductQuery setDescription(String description) {
		this.description = description;
		return this;
	}
	private boolean descriptionLike;
	public ProductQuery setDescriptionLike(boolean isLike) {
		this.descriptionLike = isLike;
		return this;
	}
	private String packageList;
	public String getPackageList() {
		return packageList;
	}
	public ProductQuery setPackageList(String packageList) {
		this.packageList = packageList;
		return this;
	}
	private boolean packageListLike;
	public ProductQuery setPackageListLike(boolean isLike) {
		this.packageListLike = isLike;
		return this;
	}
	private String feature;
	public String getFeature() {
		return feature;
	}
	public ProductQuery setFeature(String feature) {
		this.feature = feature;
		return this;
	}
	private boolean featureLike;
	public ProductQuery setFeatureLike(boolean isLike) {
		this.featureLike = isLike;
		return this;
	}
	private String color;
	public String getColor() {
		return color;
	}
	public ProductQuery setColor(String color) {
		this.color = color;
		return this;
	}
	private boolean colorLike;
	public ProductQuery setColorLike(boolean isLike) {
		this.colorLike = isLike;
		return this;
	}
	private String size;
	public String getSize() {
		return size;
	}
	public ProductQuery setSize(String size) {
		this.size = size;
		return this;
	}
	private boolean sizeLike;
	public ProductQuery setSizeLike(boolean isLike) {
		this.sizeLike = isLike;
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
	public ProductQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�no
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyNo(boolean isAsc) {
		orderFields.add(new OrderField("no", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�weight
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyWeight(boolean isAsc) {
		orderFields.add(new OrderField("weight", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_new
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyIsNew(boolean isAsc) {
		orderFields.add(new OrderField("is_new", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_hot
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyIsHot(boolean isAsc) {
		orderFields.add(new OrderField("is_hot", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_commend
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyIsCommend(boolean isAsc) {
		orderFields.add(new OrderField("is_commend", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�create_time
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyCreateTime(boolean isAsc) {
		orderFields.add(new OrderField("create_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�create_user_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyCreateUserId(boolean isAsc) {
		orderFields.add(new OrderField("create_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�check_time
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyCheckTime(boolean isAsc) {
		orderFields.add(new OrderField("check_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�check_user_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyCheckUserId(boolean isAsc) {
		orderFields.add(new OrderField("check_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_show
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyIsShow(boolean isAsc) {
		orderFields.add(new OrderField("is_show", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_del
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�type_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyTypeId(boolean isAsc) {
		orderFields.add(new OrderField("type_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�brand_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyBrandId(boolean isAsc) {
		orderFields.add(new OrderField("brand_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�keywords
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyKeywords(boolean isAsc) {
		orderFields.add(new OrderField("keywords", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sales
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbySales(boolean isAsc) {
		orderFields.add(new OrderField("sales", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�description
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyDescription(boolean isAsc) {
		orderFields.add(new OrderField("description", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�package_list
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyPackageList(boolean isAsc) {
		orderFields.add(new OrderField("package_list", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�feature
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyFeature(boolean isAsc) {
		orderFields.add(new OrderField("feature", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�color
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbyColor(boolean isAsc) {
		orderFields.add(new OrderField("color", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�size
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public ProductQuery orderbySize(boolean isAsc) {
		orderFields.add(new OrderField("size", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
