package net.ruixin.job;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.cxytiandi.elasticjob.annotation.EnableElasticJob;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableElasticJob
public class ModelJobApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(ModelJobApplication.class).web(WebApplicationType.NONE).run(args);
    }

}
