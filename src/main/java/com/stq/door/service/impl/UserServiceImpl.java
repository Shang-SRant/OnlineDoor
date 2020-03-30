package com.stq.door.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stq.door.pojo.User;
import com.stq.door.mapper.UserMapper;
import com.stq.door.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Shang_SRant
 * @since 2020-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> login(String uid, String upassword) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid)
               .eq("upassword",upassword);
        return userMapper.selectList(wrapper);
    }
}
