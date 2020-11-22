package tk.dingjining.studyspring.conf;

import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	// 配置自定义Realm
	@Bean
	public UserRealm userRealm() {
		return new UserRealm();
	}

	// 配置url过滤器
	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

		chainDefinition.addPathDefinition("/captcha", "anon");
		chainDefinition.addPathDefinition("/logout", "anon");
		chainDefinition.addPathDefinition("/layuiadmin/**", "anon");
		chainDefinition.addPathDefinition("/druid/**", "anon");
		chainDefinition.addPathDefinition("/api/**", "anon");
		// all other paths require a logged in user
		chainDefinition.addPathDefinition("/login", "anon");
		chainDefinition.addPathDefinition("/**", "authc");
		return chainDefinition;
	}

	// 配置security并设置userReaml，避免xxxx required a bean named 'authorizer' that could
	// not be found.的报错
	@Bean
	public SessionsSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm());
		return securityManager;
	}
}
