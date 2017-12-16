package cn.edu.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.user.Addr;
import cn.edu.core.dao.user.AddrDao;
import cn.edu.core.query.user.AddrQuery;
/**
 *  ��ַ
 * @author asus
 *
 */
@Service
@Transactional
public class AddrServiceImpl implements AddrService {

	@Resource
	AddrDao addrDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr) {
		return addrDao.addAddr(addr);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Addr getAddrByKey(Integer id) {
		return addrDao.getAddrByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrsByKeys(List<Integer> idList) {
		return addrDao.getAddrsByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return addrDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return addrDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateAddrByKey(Addr addr) {
		return addrDao.updateAddrByKey(addr);
	}
	
	@Transactional(readOnly = true)
	public Pagination getAddrListWithPage(AddrQuery addrQuery) {
		Pagination p = new Pagination(addrQuery.getPageNo(),addrQuery.getPageSize(),addrDao.getAddrListCount(addrQuery));
		p.setList(addrDao.getAddrListWithPage(addrQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrList(AddrQuery addrQuery) {
		return addrDao.getAddrList(addrQuery);
	}
}