package cn.edu.core.service.country;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.country.Province;
import cn.edu.core.dao.country.ProvinceDao;
import cn.edu.core.query.country.ProvinceQuery;

/**
 * ʡ
 * @author asus
 *
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
	ProvinceDao provinceDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addProvince(Province province) {
		return provinceDao.addProvince(province);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Province getProvinceByKey(Integer id) {
		return provinceDao.getProvinceByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvincesByKeys(List<Integer> idList) {
		return provinceDao.getProvincesByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return provinceDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return provinceDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateProvinceByKey(Province province) {
		return provinceDao.updateProvinceByKey(province);
	}
	
	@Transactional(readOnly = true)
	public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery) {
		Pagination p = new Pagination(provinceQuery.getPageNo(),provinceQuery.getPageSize(),provinceDao.getProvinceListCount(provinceQuery));
		p.setList(provinceDao.getProvinceListWithPage(provinceQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvinceList(ProvinceQuery provinceQuery) {
		return provinceDao.getProvinceList(provinceQuery);
	}
}
