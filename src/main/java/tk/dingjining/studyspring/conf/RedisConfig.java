package tk.dingjining.studyspring.conf;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setKeySerializer(RedisSerializer.string());
		template.setValueSerializer(RedisSerializer.java());
		template.setHashKeySerializer(RedisSerializer.string());
		template.setHashValueSerializer(RedisSerializer.string());

		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}
