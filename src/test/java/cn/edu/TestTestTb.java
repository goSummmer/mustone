package cn.edu;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.common.junit.SpringJunitTest;
import cn.edu.core.bean.TestTb;
import cn.edu.core.service.TestTbService;

/**
 * ≤‚ ‘
 * @author asus
 *
 */

public class TestTestTb extends SpringJunitTest {
	
	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void testAdd()throws Exception {
		// TODO Auto-generated method stu
		TestTb testTb=new TestTb();
		testTb.setId(3);
		testTb.setName("’≈»˝");
		testTb.setBirthday(new Date());
		testTbService.addTestTb(testTb);
	}
	
}
