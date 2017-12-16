package cn.edu.core.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * ���ﳵ
 * @author asus
 *
 */
public class BuyCart {
	//�������
	List<BuyItem> itemList=new ArrayList<BuyItem>();
	//��������  ���һ��
	private Integer productId;
	//��ӷ���
	public void addItem(BuyItem buyItem){
		//�ж��Ƿ��ظ�
		if(itemList.contains(buyItem)){
			for(BuyItem item:itemList){
				if(item.equals(buyItem)){
					//��ǰ�������������ܺ�
					int resoult=item.getAmount()+buyItem.getAmount();
					//�ж��Ƿ񳬳� �������������ֵ   û�г�����������ֵ
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
	 * С��
	 * ��Ʒ����
	 * @return
	 */
	@JsonIgnore    //json���Ա�ǩ     ���������������������ת����ʽ   �����ַ���ֵ   ����Ӧ�ú���
	public Integer getProductAmount(){
		int result=0;
		for(BuyItem item:itemList){
			result+=item.getAmount();
		}
		return result;
	}
	
	/**
	 * ��Ʒ�ܼ�
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
	 * �˷�
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
	 * Ӧ�����
	 * @return
	 */
	@JsonIgnore
	public Double getTotalPrice(){
		return getProductPrice()+getFee();
	}
	
	/**
	 * ��չ��ﳵ
	 * @return
	 */
	public void clearCart(){
		itemList.clear();
	}
	
	/**
	 * ɾ��һ��
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
