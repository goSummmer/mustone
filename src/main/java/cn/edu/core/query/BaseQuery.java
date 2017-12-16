package cn.edu.core.query;

import java.io.Serializable;

/**
 * ���������ö���
 * @author asus
 *
 */
public class BaseQuery implements Serializable{

	private static final long serialVersionUID = 1L;
	//���峣�� ÿҳ��
	public final static int DEFAULT_SIZE = 10;
	//ÿҳ��
	protected int pageSize = DEFAULT_SIZE;
	//��ʼ��
	protected int startRow;//��ʼ��
	//ҳ��
	protected int pageNo = 1;
	//Sql��ѯ�ֶ�
	protected String fields;
	

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo-1)*this.pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public BaseQuery setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo-1)*this.pageSize;
		return this;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	
}