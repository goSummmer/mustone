package cn.edu.core.query.product;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌 查询专用对象
 * @author asus
 *
 */
public class BrandQuery {
	private Integer id;
	private String name;
	private String description;
	private String imgUrl;
	private String webSite;
	private Integer sort;
	private Integer isDisplay;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	
	/**********************查询字段指定*********************************/
	public String fields;
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	
	/**********************查询字段Like*********************************/
	private boolean nameLike;
	public boolean getNameLike() {
		return nameLike;
	}
	public void setNameLike(boolean nameLike) {
		this.nameLike = nameLike;
	}
	/**********************order by*********************************/
	//使用类部类存储
	public class FieldOrder{
		private String field;   //id,name,imgUrl
		private String order;	//desc,asc
		public FieldOrder(String field, String order) {
			super();
			this.field = field;
			this.order = order;
		}
		public String getField() {
			return field;
		}
		public void setField(String field) {
			this.field = field;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}	
	}
	//orderby 集合
	private List<FieldOrder> fieldOrders=new ArrayList<FieldOrder>();
	//按照id进行排序
	public void orderbyId(boolean isAsc){
		fieldOrders.add(new FieldOrder("id", isAsc==true?"asc":"desc"));
	}
	//按照name进行排序
	public void orderbyName(boolean isAsc){
		fieldOrders.add(new FieldOrder("name", isAsc==true?"asc":"desc"));
	}
	//页号
	private Integer pageNo=1;
	//开始行
	private Integer startRow;
	//每页数量
	private Integer pageSize=10;
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.startRow=(pageNo-1)*pageSize;
		this.pageSize = pageSize;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		this.startRow=(pageNo-1)*pageSize;
	}
}
