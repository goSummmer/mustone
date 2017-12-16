package cn.edu.core.service.user;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.user.Employee;
import cn.edu.core.query.user.EmployeeQuery;

public interface EmployeeService {
	/**
	 * ��������
	 * 
	 * @return
	 */
	public Integer addEmployee(Employee employee);

	/**
	 * ����������ѯ
	 */
	public Employee getEmployeeByKey(String id);

	/**
	 * ��������������ѯ
	 */
	public List<Employee> getEmployeesByKeys(List<String> idList);

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id);

	/**
	 * ������������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateEmployeeByKey(Employee employee);

	/**
	 * ����������ѯ��ҳ��ѯ
	 * 
	 * @param employeeQuery
	 *            ��ѯ����
	 * @return
	 */
	public Pagination getEmployeeListWithPage(EmployeeQuery employeeQuery);

	/**
	 * ����������ѯ
	 * 
	 * @param employeeQuery
	 *            ��ѯ����
	 * @return
	 */
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery);
}
