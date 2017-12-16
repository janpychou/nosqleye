package cn.org.openwork.nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ServletComponentScan
@EnableScheduling
@ImportResource(locations = { "classpath:druid-bean.xml" })
@EnableCaching
public class NosqlEyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NosqlEyeApplication.class, args);
	}
}
