package cn.edu.core.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 购物车
 * @author asus
 *
 */
public class BuyCart {
	//购物项集合
	List<BuyItem> itemList=new ArrayList<BuyItem>();
	//继续购物  最后一款
	private Integer productId;
	//添加方法
	public void addItem(BuyItem buyItem){
		//判断是否重复
		if(itemList.contains(buyItem)){
			for(BuyItem item:itemList){
				if(item.equals(buyItem)){
					//以前和现在新增的总和
					int resoult=item.getAmount()+buyItem.getAmount();
					//判断是否超出 如果超出则给最大值   没有超出则正常赋值
					if(item.getSku().getSkuUpperLimit()>=resoult){
						item.setAmount(resoult);
					}else {
						item.setAmount(item.getSku().getSkuUpperLimit());
					}
					break;
				}
			}
		}else{
			itemList.add(buyItem);
		}
	}
	
	/**
	 * 小计
	 * 商品数量
	 * @return
	 */
	@JsonIgnore    //json忽略标签     这是由于这个方法不符合转换格式   由于又返回值   所以应该忽略
	public Integer getProductAmount(){
		int result=0;
		for(BuyItem item:itemList){
			result+=item.getAmount();
		}
		return result;
	}
	
	/**
	 * 商品总价
	 * @return
	 */
	@JsonIgnore
	public Double getProductPrice(){
		Double price=0.00;
		for(BuyItem item:itemList){
			price+=item.getSku().getSkuPrice()*item.getAmount();
		}
		return price;
	}
	
	/**
	 * 运费
	 * @return
	 */
	@JsonIgnore
	public Double getFee(){
		Double fee=0.00;
		if(getProductPrice()<=39){
			fee=10.00;
		}
		return fee;
	}
	
	/**
	 * 应付金额
	 * @return
	 */
	@JsonIgnore
	public Double getTotalPrice(){
		return getProductPrice()+getFee();
	}
	
	/**
	 * 清空购物车
	 * @return
	 */
	public void clearCart(){
		itemList.clear();
	}
	
	/**
	 * 删除一个
	 * @param item
	 */
	public void deleteItem(BuyItem item){
		itemList.remove(item);
	}
	
	public List<BuyItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<BuyItem> itemList) {
		this.itemList = itemList;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	
}
