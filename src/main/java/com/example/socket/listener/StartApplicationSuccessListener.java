package com.example.socket.listener;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Title: StartApplicationSuccessListener.java
 * @Description:
 * 		interface ApplicationListener<ApplicationReadyEvent>:在StartApplication.run(args)执行完成之后，
 * 		执行onApplicationEvent(ApplicationReadyEvent event)
 * @author: huangchuang
 * @version: v1.0
 * @create at: 2017年7月5日 上午10:38:14
 * @reviewer:
 * @review at:
 */
@Component
public class StartApplicationSuccessListener implements ApplicationListener<ApplicationReadyEvent>
{

    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(StartApplicationSuccessListener.class);

    private final static String SLASH = "/";
    private final static String COLON = ":";
    @Value("${current.project.path}")
    private String path;
    @Value("${server.port}")
    private String port;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event)
    {
        Logger.info("**********************************************************************************");
        Logger.info("*******************   PATH: " + path + COLON + port + contextPath + SLASH + "   ******************");
        Logger.info("**********************************************************************************");
    }
}