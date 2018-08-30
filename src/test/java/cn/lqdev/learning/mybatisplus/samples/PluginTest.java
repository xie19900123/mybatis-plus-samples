package cn.lqdev.learning.mybatisplus.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import cn.lqdev.learning.mybatisplus.samples.biz.entity.User;
import cn.lqdev.learning.mybatisplus.samples.biz.service.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 插件测试类
 * @author xiedeshou
 *
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest 
@Slf4j
public class PluginTest {
	
	@Autowired
	IUserService userService;
	
	@Test
	public void testPagination() {
		Page<User> page = new Page<>();
		//每页数
		page.setSize(10);
		//当前页码
		page.setCurrent(1);
		
		//无条件时
		Page<User> pageList = userService.selectPage(page);
		System.out.println(pageList.getRecords().get(0));
		
		//新增数据 避免查询不到数据
		User user = new User();
		user.setCode("801");
		user.setName("okong-Pagination");
		user.insert();
		//加入条件构造器
		EntityWrapper<User> qryWapper = new EntityWrapper<>();
		//这里也能直接设置 entity 这是条件就是entity的非空字段值了
//	    qryWapper.setEntity(user);
		//这里建议直接用 常量 
	//	qryWapper.eq(User.CODE, user.getCode());
		pageList = userService.selectPage(page, qryWapper);
		System.out.println(pageList.getRecords().get(0));
		log.info("分页结束");
	}

}
