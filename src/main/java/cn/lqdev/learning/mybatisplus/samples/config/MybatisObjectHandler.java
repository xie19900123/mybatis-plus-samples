package cn.lqdev.learning.mybatisplus.samples.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/**
 * 公共字段自动填充
 * 
 * @author oKong
 *
 */

public class MybatisObjectHandler extends MetaObjectHandler{

	@Override
	public void insertFill(MetaObject metaObject) {
		//新增时填充的字段
		setFieldValByName("gmtCreate", new Date(), metaObject);
		setFieldValByName("gmtModified", new Date(), metaObject);
		
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		//更新时 需要填充字段
		setFieldValByName("gmtModified", new Date(), metaObject);
	}

}
