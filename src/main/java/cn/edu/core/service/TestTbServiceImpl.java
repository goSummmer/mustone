package cn.edu.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.core.bean.TestTb;
import cn.edu.core.dao.TestTbDao;

/**
 *  µœ÷¿‡
 * @author asus
 *
 */
@Service
public class TestTbServiceImpl implements TestTbService {

	@Resource
	private TestTbDao testTbDao;
	
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
	}
	
}
