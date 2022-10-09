package net.ruixin.job.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author zhangxun_a
 * @date 2022/10/9 22:39
 * @description: 通过bean的控制然后取消job的注册
 * 如果你想使用这个方法请在yaml文件中设置remove.bean=y;
 *
 * 如果你想使用这个，请将你的job名称设置为AbXxxxxJob形式
 */
@Component
@ConditionalOnProperty(prefix = "remove",name = "bean",havingValue = "y")
public class JobBeanConfig implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        for (String beanDefinitionName : beanDefinitionRegistry.getBeanDefinitionNames()) {
            if (beanDefinitionName.startsWith("ab") && beanDefinitionName.endsWith("Job"))
                beanDefinitionRegistry.removeBeanDefinition(beanDefinitionName);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
