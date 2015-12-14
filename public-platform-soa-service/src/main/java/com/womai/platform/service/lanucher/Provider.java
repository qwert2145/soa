package com.womai.platform.service.lanucher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述：服务提供者.
 */
public class Provider {

    private static volatile boolean running = true;
    private static ApplicationContext ctx;

    private Provider() {
    }

    public static void main(String[] args){
        try{
            ctx = new ClassPathXmlApplicationContext(
                    new String[]{
                            "applicationContext-dao.xml",
                            "applicationContext-provider.xml"
                    }
            );
           /* logger.info("platform-soa server started.");*/
        }catch (Exception e){
            running  = false;
           /* logger.error(e.getMessage());*/
        }

        synchronized (Provider.class) {
            while (running) {
                try {
                    Provider.class.wait();
                } catch (Exception e) {
                   /* logger.error(e.getMessage());*/
                }
            }
        }
    }
}
