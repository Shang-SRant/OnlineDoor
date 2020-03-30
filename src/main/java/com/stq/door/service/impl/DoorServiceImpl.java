package com.stq.door.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stq.door.pojo.Door;
import com.stq.door.mapper.DoorMapper;
import com.stq.door.pojo.User;
import com.stq.door.service.DoorService;
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
public class DoorServiceImpl extends ServiceImpl<DoorMapper, Door> implements DoorService {

    @Autowired
    public DoorMapper doorMapper;

    @Override
    public List<Door> doos() {
        return doorMapper.selectList(null);
    }
}
