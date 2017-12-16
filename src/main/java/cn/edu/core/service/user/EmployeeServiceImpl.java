package cn.edu.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.user.Employee;
import cn.edu.core.dao.user.EmployeeDao;
import cn.edu.core.query.user.EmployeeQuery;
/**
 * Ա��
 * @author asus
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	EmployeeDao employeeDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Employee getEmployeeByKey(String id) {
		return employeeDao.getEmployeeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByKeys(List<String> idList) {
		return employeeDao.getEmployeesByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return employeeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return employeeDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateEmployeeByKey(Employee employee) {
		return employeeDao.updateEmployeeByKey(employee);
	}
	
	@Transactional(readOnly = true)
	public Pagination getEmployeeListWithPage(EmployeeQuery employeeQuery) {
		Pagination p = new Pagination(employeeQuery.getPageNo(),employeeQuery.getPageSize(),employeeDao.getEmployeeListCount(employeeQuery));
		p.setList(employeeDao.getEmployeeListWithPage(employeeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery) {
		return employeeDao.getEmployeeList(employeeQuery);
	}
}
