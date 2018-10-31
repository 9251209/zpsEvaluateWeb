package cn.net.mine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Init
 * 
 * @creator xumj 
 * @createdate 2014-11-4 上午10:31:56
 * @note
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
