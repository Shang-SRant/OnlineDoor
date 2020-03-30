package com.stq.door.controller;


import com.stq.door.mapper.DoorMapper;
import com.stq.door.pojo.Door;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Shang_SRant
 * @since 2020-03-29
 */
@Controller
@RequestMapping("/door")
public class DoorController {

    @Autowired
    private DoorMapper doorMapper;

    @RequestMapping("/door")
    public String door(Model model) {
        List<Door> doors = doorMapper.selectList(null);
        model.addAttribute("doors", doors);
        return "door";
    }

    @RequestMapping("/1")
    public String changedoor1(String host, String port) throws IOException {
        Socket socket = new Socket(host, Integer.parseInt(port));
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message="1";
        socket.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        socket.close();
        return "door";
    }

    @RequestMapping("/0")
    public String changedoor0(String host, String port) throws IOException {
        Socket socket = new Socket(host, Integer.parseInt(port));
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message="0";
        socket.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        socket.close();
        return "door";
    }

}

