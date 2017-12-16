package cn.edu.common.junit;
/**
 * 测试公共类
 */
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)   ///这时spring结合junit
@ContextConfiguration(locations="classpath:application-context.xml")
public class SpringJunitTest {

}
