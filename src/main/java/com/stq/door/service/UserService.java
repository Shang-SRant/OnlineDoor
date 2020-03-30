package com.stq.door.service;

import com.stq.door.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Shang_SRant
 * @since 2020-03-29
 */
public interface UserService extends IService<User> {

    public List<User> login(String uid, String upassword);

}
