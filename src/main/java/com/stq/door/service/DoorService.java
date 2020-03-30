package com.stq.door.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stq.door.pojo.Door;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Shang_SRant
 * @since 2020-03-29
 */
public interface DoorService extends IService<Door> {
    public List<Door> doos();
}
