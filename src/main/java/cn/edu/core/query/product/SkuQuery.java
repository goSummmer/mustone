package cn.edu.core.query.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.core.query.BaseQuery;

public class SkuQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SkuQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private Integer productId;
	public Integer getProductId() {
		return productId;
	}
	public SkuQuery setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	private Integer colorId;
	public Integer getColorId() {
		return colorId;
	}
	public SkuQuery setColorId(Integer colorId) {
		this.colorId = colorId;
		return this;
	}
	private String size;
	public String getSize() {
		return size;
	}
	public SkuQuery setSize(String size) {
		this.size = size;
		return this;
	}
	private boolean sizeLike;
	public SkuQuery setSizeLike(boolean isLike) {
		this.sizeLike = isLike;
		return this;
	}
	private Double deliveFee;
	public Double getDeliveFee() {
		return deliveFee;
	}
	public SkuQuery setDeliveFee(Double deliveFee) {
		this.deliveFee = deliveFee;
		return this;
	}
	private Double skuPrice;
	public Double getSkuPrice() {
		return skuPrice;
	}
	public SkuQuery setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
		return this;
	}
	private Integer stockInventory;
	public Integer getStockInventory() {
		return stockInventory;
	}
	public SkuQuery setStockInventory(Integer stockInventory) {
		this.stockInventory = stockInventory;
		return this;
	}
	private Integer skuUpperLimit;
	public Integer getSkuUpperLimit() {
		return skuUpperLimit;
	}
	public SkuQuery setSkuUpperLimit(Integer skuUpperLimit) {
		this.skuUpperLimit = skuUpperLimit;
		return this;
	}
	private String location;
	public String getLocation() {
		return location;
	}
	public SkuQuery setLocation(String location) {
		this.location = location;
		return this;
	}
	private boolean locationLike;
	public SkuQuery setLocationLike(boolean isLike) {
		this.locationLike = isLike;
		return this;
	}
	private String skuImg;
	public String getSkuImg() {
		return skuImg;
	}
	public SkuQuery setSkuImg(String skuImg) {
		this.skuImg = skuImg;
		return this;
	}
	private boolean skuImgLike;
	public SkuQuery setSkuImgLike(boolean isLike) {
		this.skuImgLike = isLike;
		return this;
	}
	private Integer skuSort;
	public Integer getSkuSort() {
		return skuSort;
	}
	public SkuQuery setSkuSort(Integer skuSort) {
		this.skuSort = skuSort;
		return this;
	}
	private String skuName;
	public String getSkuName() {
		return skuName;
	}
	public SkuQuery setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}
	private boolean skuNameLike;
	public SkuQuery setSkuNameLike(boolean isLike) {
		this.skuNameLike = isLike;
		return this;
	}
	private Double marketPrice;
	public Double getMarketPrice() {
		return marketPrice;
	}
	public SkuQuery setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
		return this;
	}
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public SkuQuery setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	private Date updateTime;
	public Date getUpdateTime() {
		return updateTime;
	}
	public SkuQuery setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	private String createUserId;
	public String getCreateUserId() {
		return createUserId;
	}
	public SkuQuery setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
		return this;
	}
	private boolean createUserIdLike;
	public SkuQuery setCreateUserIdLike(boolean isLike) {
		this.createUserIdLike = isLike;
		return this;
	}
	private String updateUserId;
	public String getUpdateUserId() {
		return updateUserId;
	}
	public SkuQuery setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
		return this;
	}
	private boolean updateUserIdLike;
	public SkuQuery setUpdateUserIdLike(boolean isLike) {
		this.updateUserIdLike = isLike;
		return this;
	}
	private Integer lastStatus;
	public Integer getLastStatus() {
		return lastStatus;
	}
	public SkuQuery setLastStatus(Integer lastStatus) {
		this.lastStatus = lastStatus;
		return this;
	}
	private Integer skuType;
	public Integer getSkuType() {
		return skuType;
	}
	public SkuQuery setSkuType(Integer skuType) {
		this.skuType = skuType;
		return this;
	}
	private Integer sales;
	public Integer getSales() {
		return sales;
	}
	public SkuQuery setSales(Integer sales) {
		this.sales = sales;
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
	public SkuQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�product_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyProductId(boolean isAsc) {
		orderFields.add(new OrderField("product_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�color_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyColorId(boolean isAsc) {
		orderFields.add(new OrderField("color_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�size
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySize(boolean isAsc) {
		orderFields.add(new OrderField("size", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�delive_fee
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyDeliveFee(boolean isAsc) {
		orderFields.add(new OrderField("delive_fee", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_price
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySkuPrice(boolean isAsc) {
		orderFields.add(new OrderField("sku_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�stock_inventory
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyStockInventory(boolean isAsc) {
		orderFields.add(new OrderField("stock_inventory", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_upper_limit
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySkuUpperLimit(boolean isAsc) {
		orderFields.add(new OrderField("sku_upper_limit", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�location
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyLocation(boolean isAsc) {
		orderFields.add(new OrderField("location", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_img
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySkuImg(boolean isAsc) {
		orderFields.add(new OrderField("sku_img", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_sort
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySkuSort(boolean isAsc) {
		orderFields.add(new OrderField("sku_sort", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySkuName(boolean isAsc) {
		orderFields.add(new OrderField("sku_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�market_price
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyMarketPrice(boolean isAsc) {
		orderFields.add(new OrderField("market_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�create_time
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyCreateTime(boolean isAsc) {
		orderFields.add(new OrderField("create_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�update_time
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyUpdateTime(boolean isAsc) {
		orderFields.add(new OrderField("update_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�create_user_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyCreateUserId(boolean isAsc) {
		orderFields.add(new OrderField("create_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�update_user_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyUpdateUserId(boolean isAsc) {
		orderFields.add(new OrderField("update_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�last_status
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbyLastStatus(boolean isAsc) {
		orderFields.add(new OrderField("last_status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_type
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySkuType(boolean isAsc) {
		orderFields.add(new OrderField("sku_type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sales
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public SkuQuery orderbySales(boolean isAsc) {
		orderFields.add(new OrderField("sales", isAsc ? "ASC" : "DESC"));
		return this;
	}
}