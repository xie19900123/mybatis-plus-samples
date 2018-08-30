package cn.lqdev.learning.mybatisplus.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lqdev.learning.mybatisplus.samples.biz.entity.User;
import cn.lqdev.learning.mybatisplus.samples.biz.service.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 通用CURD示例
 * @author oKong
 *
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest 
@Slf4j
public class GeneralTest {

    @Autowired
    IUserService userService;
    
    @Test
    public void testInsert() {
    	User user = new User();
		user.setCode("001");
		user.setName("okong-insert");
		//默认的插入策略为：FieldStrategy.NOT_NULL，即：判断 null
		//对应在mapper.xml时写法为：<if test="field!=null">
		//这个可以修改的，设置字段的@TableField(strategy=FieldStrategy.NOT_EMPTY)
		//所以这个时候，为null的字段是不会更新的，也可以开启性能插件，查看sql语句就可以知道
		userService.insert(user);
		//新增所有字段，
		userService.insertAllColumn(user);
		log.info("新增结束");
    }
    
    @Test
    public void testUpdate() {
    	
    	User user = new User();
		user.setCode("101");
		user.setName("oKong-insert");
		//这就是ActiveRecord的功能
		user.insert();
		//也可以直接 userService.insert(user);

    	//更新
		User updUser = new User();
		updUser.setId(user.getId());
		updUser.setName("okong-upd");
    	
    	updUser.updateById();
    	log.info("更新结束");
    }
    
    @Test
    public void testDelete() {
    	User user = new User();
		user.setCode("101");
		user.setName("oKong-delete");
		
		user.insert();
		
		//删除
		user.deleteById();
    	log.info("删除结束");

    }
    
    @Test
    public void testSelect() {
    	User user = new User();
		user.setCode("201");
		user.setName("oKong-selecdt");
		
		user.insert();
    	
    	log.info("查询：{}",user.selectById());
    }

}
