package cn.edu.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.edu.core.bean.product.Color;
import cn.edu.core.dao.product.ColorDao;
import cn.edu.core.query.product.ColorQuery;
/**
 * ��ɫ
 * @author asus
 *
 */
@Service
@Transactional
public class ColorServiceImpl implements ColorService {

	@Resource
	ColorDao colorDao;

	/**
	 * �������ݿ�
	 * 
	 * @return
	 */
	public Integer addColor(Color color) {
		return colorDao.addColor(color);
	}

	/**
	 * ������������
	 */
	@Transactional(readOnly = true)
	public Color getColorByKey(Integer id) {
		return colorDao.getColorByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorsByKeys(List<Integer> idList) {
		return colorDao.getColorsByKeys(idList);
	}

	/**
	 * ��������ɾ��
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return colorDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return colorDao.deleteByKeys(idList);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public Integer updateColorByKey(Color color) {
		return colorDao.updateColorByKey(color);
	}
	
	@Transactional(readOnly = true)
	public Pagination getColorListWithPage(ColorQuery colorQuery) {
		Pagination p = new Pagination(colorQuery.getPageNo(),colorQuery.getPageSize(),colorDao.getColorListCount(colorQuery));
		p.setList(colorDao.getColorListWithPage(colorQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorList(ColorQuery colorQuery) {
		return colorDao.getColorList(colorQuery);
	}
}
