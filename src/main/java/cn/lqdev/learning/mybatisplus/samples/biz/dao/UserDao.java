package cn.lqdev.learning.mybatisplus.samples.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import cn.lqdev.learning.mybatisplus.samples.biz.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oKong
 * @since 2018-07-20
 */
public interface UserDao extends BaseMapper<User> {
	
	/**
	 *  @Param 是参数的别名，在sql中可以动态获取的。
	 * 
	 * @param userCode
	 * @return
	 */
	@Select("SELECT * FROM USER WHERE CODE = #{userCode}")
	List<User> selectUserCustomParamsByAnno(@Param("userCode")String userCode);
	
	List<User> selectUserCustomParamsByXml(@Param("userCode")String userCode);
	
	/**
	 * 
	 * @param rowBounds 分页对象 直接传入page即可
	 * @param wrapper 条件构造器
	 * @return
	 */
	List<User> selectUserWrapper(RowBounds rowBounds, @Param("ew") Wrapper<User> wrapper);

}
