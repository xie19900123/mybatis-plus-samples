package cn.lqdev.learning.mybatisplus.samples.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.lqdev.learning.mybatisplus.samples.biz.dao.UserDao;
import cn.lqdev.learning.mybatisplus.samples.biz.entity.User;
import cn.lqdev.learning.mybatisplus.samples.biz.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oKong
 * @since 2018-07-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
