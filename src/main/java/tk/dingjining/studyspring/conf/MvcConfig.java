package tk.dingjining.studyspring.conf;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class MvcConfig extends WebMvcConfigurationSupport {
//	@Override
//	protected void configureMessageConverters(List<HttpMessageConverter<?>> converts) {
//		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//		FastJsonConfig config = new FastJsonConfig();
//		config.setSerializerFeatures(
//				// 保留map空的字段
//				SerializerFeature.WriteMapNullValue,
//				// 将String类型的null转成""
//				SerializerFeature.WriteNullStringAsEmpty,
//				// 将Number类型的null转成0
//				SerializerFeature.WriteNullNumberAsZero,
//				// 将List类型的null转成[]
//				SerializerFeature.WriteNullListAsEmpty,
//				// 将Boolean类型的null转成false
//				SerializerFeature.WriteNullBooleanAsFalse,
//				// 避免循环引用
//				SerializerFeature.DisableCircularReferenceDetect);
//		converter.setFastJsonConfig(config);
//		converter.setDefaultCharset(Charset.forName("UTF-8"));
//		List<MediaType> mediaTypeList = new ArrayList<>();
//		// 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces= "application/json"
//		mediaTypeList.add(MediaType.APPLICATION_JSON);
//		converter.setSupportedMediaTypes(mediaTypeList);
//
//		converts.add(converter);
//		super.configureMessageConverters(converts);
//	}
}
