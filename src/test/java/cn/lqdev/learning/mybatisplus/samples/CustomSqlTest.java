package cn.lqdev.learning.mybatisplus.samples;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lqdev.learning.mybatisplus.samples.biz.dao.UserDao;
import cn.lqdev.learning.mybatisplus.samples.biz.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义sql示例
 * @author oKong
 *
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest 
@Slf4j
public class CustomSqlTest {
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void testCustomAnno() {
        User user = new User();
        user.setCode("901");
        user.setName("okong-sql");
        user.insert();
		List<User> userlist = userDao.selectUserCustomParamsByAnno(user.getCode());
		//由于新增的 肯定不为null 故不判断了。
		System.out.println(userlist.get(0).toString());
		log.info("注解形式结束------");
	}
	
	@Test
	public void testCustomXml() {
		User user = new User();
		user.setCode("902");
		user.setName("okong-sql");
		user.insert();
		List<User> userlist = userDao.selectUserCustomParamsByXml(user.getCode());
		//由于新增的 肯定不为null 故不判断了。
		System.out.println(userlist.get(0).toString());
		log.info("xml形式结束------");
	}

}
