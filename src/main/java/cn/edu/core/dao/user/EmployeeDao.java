package cn.edu.core.dao.user;

import java.util.List;

import cn.edu.core.bean.user.Employee;
import cn.edu.core.query.user.EmployeeQuery;

public interface EmployeeDao {

	/**
	 * ���
	 * @param employee
	 */
	public Integer addEmployee(Employee employee);

	/**
	 * ������������
	 * @param employeeQuery
	 */
	public Employee getEmployeeByKey(String id);

	/**
	 * ����������������
	 * @param employeeQuery
	 */
	public List<Employee> getEmployeesByKeys(List<String> idList);

	/**
	 * ��������ɾ��
	 * @param employeeQuery
	 */
	public Integer deleteByKey(String id);

	/**
	 * ������������ɾ��
	 * @param employeeQuery
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * ������������
	 * @param employeeQuery
	 */
	public Integer updateEmployeeByKey(Employee employee);

	/**
	 * ��ҳ��ѯ
	 * @param employeeQuery
	 */
	public List<Employee> getEmployeeListWithPage(EmployeeQuery employeeQuery);

	/**
	 * ���ϲ�ѯ
	 * @param employeeQuery
	 */
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery);
	
	/**
	 * ������
	 * @param employeeQuery
	 */
	public int getEmployeeListCount(EmployeeQuery employeeQuery);
}
