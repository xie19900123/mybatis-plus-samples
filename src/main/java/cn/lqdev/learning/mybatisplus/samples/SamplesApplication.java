package cn.lqdev.learning.mybatisplus.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * mybatis-plus 示例工程
 * 
 * @author oKong
 *
 */

@SpringBootApplication
@Slf4j
public class SamplesApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SamplesApplication.class, args);
		log.info("mybatis-plus-samples 工程启动!");
	}

}
