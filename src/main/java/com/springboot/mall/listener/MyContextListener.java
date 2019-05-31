package com.springboot.mall.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
@Component
public class MyContextListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        HashMap<Object,Object> map = new HashMap<>();
        sce.getServletContext().setAttribute("map",map);
    }
}
