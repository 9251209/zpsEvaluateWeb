package cn.net.mine;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * web配置文件
 * 
 * @creator xumj
 * @createdate 2014-11-4 上午10:39:07
 * @note
 */
public class WebXml extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
