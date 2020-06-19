package tk.dingjining.studyspring.conf;

import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druid() {
		return new DruidDataSource();
	}

	/**
	 * 配置监控
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<?> statViewServlet() {
		ServletRegistrationBean<?> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
		HashMap<String, String> map = new HashMap<>(2);
		map.put("loginUsername", "xinzhi");
		map.put("loginPassword", "123456");
		bean.setInitParameters(map);
		return bean;
	}
	@Bean
	public FilterRegistrationBean<?> webStatFilter() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new WebStatFilter());
		HashMap<String, String> map = new HashMap<>(8);
		map.put("exclusions", "*.js");
		map.put("exclusions", "*.css");
		map.put("exclusions", "*.jpg");
		map.put("exclusions", "*.html");
		bean.setInitParameters(map);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}
