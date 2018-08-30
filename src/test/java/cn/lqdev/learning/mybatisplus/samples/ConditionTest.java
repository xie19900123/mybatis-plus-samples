package cn.lqdev.learning.mybatisplus.samples;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import cn.lqdev.learning.mybatisplus.samples.biz.dao.UserDao;
import cn.lqdev.learning.mybatisplus.samples.biz.entity.User;
import cn.lqdev.learning.mybatisplus.samples.biz.service.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 条件构造器示例
 * @author oKong
 *
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest 
@Slf4j
public class ConditionTest {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void testOne() {
		User user =  new User();
		user.setCode("701");
		user.setName("okong-condition");
	    user.insert();
	    
		EntityWrapper<User> qryWrapper = new EntityWrapper<>();
		
		qryWrapper.eq(User.CODE, user.getCode());
		qryWrapper.eq(User.NAME, user.getName());
		
		//也可以直接 
//		qryWrapper.setEntity(user);
		
		//打印sql语句
		System.out.println(qryWrapper.getSqlSegment());
		
		//设置select 字段 即：select code,name from 
		qryWrapper.setSqlSelect(User.CODE,User.NAME);
		System.out.println(qryWrapper.getSqlSelect());
		
		//查询
	    User qryUser = userService.selectOne(qryWrapper);
	    System.out.println(qryUser);
	    log.info("拼接一结束");
	}
	
	@Test
	public void testTwo() {
		User user =  new User();
		user.setCode("702");
		user.setName("okong-condition");
	    user.insert();
	    
		EntityWrapper<User> qryWrapper = new EntityWrapper<>();
		qryWrapper.where("code = {0}", user.getCode())
		.and("name = {0}",user.getName())
		.andNew("status = 0");
		System.out.println(qryWrapper.getSqlSegment());
		//等等很复杂的。
		//复杂的建议直接写在xml里面了，要是非动态的话 比较xml一眼看得懂呀
		//查询
	    User qryUser = userService.selectOne(qryWrapper);
	    System.out.println(qryUser);
	    log.info("拼接二结束");
	}

	@Test
	public void testCustomSql() {
		User user = new User();
		user.setCode("703");
		user.setName("okong-condition");
	    user.insert();
	    
		EntityWrapper<User> qryWrapper = new EntityWrapper<>();
		qryWrapper.eq(User.CODE, user.getCode());
		
		Page<User> pageUser = new Page<>();
	    pageUser.setCurrent(1);
	    pageUser.setSize(10);
	    
	    List<User> userlist = userDao.selectUserWrapper(pageUser, qryWrapper);
	    System.out.println(userlist.get(0));
	    log.info("自定义sql结束");
	}

}
