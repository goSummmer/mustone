package cn.edu.core.service.order;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.order.Detail;
import cn.edu.core.dao.order.DetailDao;
import cn.edu.core.query.order.DetailQuery;
/**
 * ��������(��������)
 * @author asus
 *
 */
@Service
@Transactional
public class DetailServiceImpl implements DetailService {

	@Resource
	DetailDao detailDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addDetail(Detail detail) {
		return detailDao.addDetail(detail);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Detail getDetailByKey(Integer id) {
		return detailDao.getDetailByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Detail> getDetailsByKeys(List<Integer> idList) {
		return detailDao.getDetailsByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return detailDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return detailDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateDetailByKey(Detail detail) {
		return detailDao.updateDetailByKey(detail);
	}
	
	@Transactional(readOnly = true)
	public Pagination getDetailListWithPage(DetailQuery detailQuery) {
		Pagination p = new Pagination(detailQuery.getPageNo(),detailQuery.getPageSize(),detailDao.getDetailListCount(detailQuery));
		p.setList(detailDao.getDetailListWithPage(detailQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Detail> getDetailList(DetailQuery detailQuery) {
		return detailDao.getDetailList(detailQuery);
	}
}

