package cn.edu.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Type;
import cn.edu.core.dao.product.TypeDao;
import cn.edu.core.query.product.TypeQuery;
/**
 * ��Ʒ����
 * @author asus
 *
 */ 
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	TypeDao typeDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addType(Type type) {
		return typeDao.addType(type);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Type getTypeByKey(Integer id) {
		return typeDao.getTypeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypesByKeys(List<Integer> idList) {
		return typeDao.getTypesByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return typeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return typeDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type) {
		return typeDao.updateTypeByKey(type);
	}
	
	@Transactional(readOnly = true)
	public Pagination getTypeListWithPage(TypeQuery typeQuery) {
		Pagination p = new Pagination(typeQuery.getPageNo(),typeQuery.getPageSize(),typeDao.getTypeListCount(typeQuery));
		p.setList(typeDao.getTypeListWithPage(typeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypeList(TypeQuery typeQuery) {
		return typeDao.getTypeList(typeQuery);
	}
}
