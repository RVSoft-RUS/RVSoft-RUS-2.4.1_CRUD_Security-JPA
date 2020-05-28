package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class DataConfig {
    @Bean
    LocalContainerEntityManagerFactoryBean getEM() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
//        localContainerEntityManagerFactoryBean.setJpaVendorAdapter();

        return localContainerEntityManagerFactoryBean;
    }
}
