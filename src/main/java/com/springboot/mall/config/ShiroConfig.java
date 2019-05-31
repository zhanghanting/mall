package com.springboot.mall.config;

import com.springboot.mall.shiro.CustomRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.HashMap;
import java.util.Properties;

public class ShiroConfig
{
    /*在securityManager中注册realm,
    sessionManager,cacheManager*/
    @Bean
    public SecurityManager securityManager(CustomRealm customRealm,
                                           DefaultWebSessionManager sessionManager,
                                           EhCacheManager ehCacheManager)
    {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRealm);
        defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setCacheManager(ehCacheManager);
        return defaultWebSecurityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/auth/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthor");
        HashMap<String,String> filterMap = new HashMap<>();
        filterMap.put("/unAuthorized","anon");
        filterMap.put("/admin/auth/login","anon");
        filterMap.put("/refuse","anon");
        filterMap.put("/logout","logout");
        filterMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
    {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/refuse");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager)
    {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    /*session Manager*/
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager()
    {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(60000);
        sessionManager.setDeleteInvalidSessions(true);
        return  sessionManager;

    }
    /*cacheManager*/
    @Bean
    public EhCacheManager ehCacheManager()
    {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-cache.xml");
        return ehCacheManager;
    }
}
