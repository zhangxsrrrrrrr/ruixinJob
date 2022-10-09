package net.ruixin.job.demo;

import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Service;

/**
 * @author zhangxun_a
 * @date 2022/10/2 15:49
 * @description: 定时任务demo
 *
 * <p>
 * {@link com.cxytiandi.elasticjob.annotation.ElasticJobConf}
 * 参考 https://github.com/yinjihuan/elastic-job-spring-boot-starter
 *
 * <p>
 * 如果你想控制这个job的注册，那么就请你使用AbXxxxxJob形式
 * @see net.ruixin.job.config.JobBeanConfig
 */
@ElasticJobConf(cron = "0/5 * * * * ?", name = "abJobDemoJob", shardingTotalCount = 1,
        shardingItemParameters = "0=B,1=S,2=G")
public class AbJobDemoJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("123123");
        System.out.println(shardingContext.getShardingItem());
    }
}
