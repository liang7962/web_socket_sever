package com.example.socket.controller;

import com.example.socket.service.MyWebSocket;
import com.example.socket.util.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author: jinliang
 * @create: 2018/11/13 14:26
 * @desc:   消息推送
 * @param
 **/
@Controller
public class TransWebSocketController {

    @Autowired
    MyWebSocket myWebSocket;


    @RequestMapping(value = "websocket_send",method = RequestMethod.GET)
    @ResponseBody
    public String websocketSend(){
        try {
            myWebSocket.sendInfo("消息");
        } catch (IOException e) {
            LoggerUtils.info(getClass(),"发送失败,:"+ e);
            return "fail";
        }
        return "success";
    }

}
