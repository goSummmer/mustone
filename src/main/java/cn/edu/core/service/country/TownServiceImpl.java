package cn.edu.core.service.country;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.country.Town;
import cn.edu.core.dao.country.TownDao;
import cn.edu.core.query.country.TownQuery;
/**
 * ��/��
 * @author asus
 *
 */
@Service
@Transactional
public class TownServiceImpl implements TownService {

	@Resource
	TownDao townDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addTown(Town town) {
		return townDao.addTown(town);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Town getTownByKey(Integer id) {
		return townDao.getTownByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Town> getTownsByKeys(List<Integer> idList) {
		return townDao.getTownsByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return townDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return townDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateTownByKey(Town town) {
		return townDao.updateTownByKey(town);
	}
	
	@Transactional(readOnly = true)
	public Pagination getTownListWithPage(TownQuery townQuery) {
		Pagination p = new Pagination(townQuery.getPageNo(),townQuery.getPageSize(),townDao.getTownListCount(townQuery));
		p.setList(townDao.getTownListWithPage(townQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Town> getTownList(TownQuery townQuery) {
		return townDao.getTownList(townQuery);
	}
}
