package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "web")
public class HibernateConfig {
   private Environment environment;

   @Autowired
   public void setEnvironment(Environment environment) {
      this.environment = environment;
   }

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("db.driver")));
      dataSource.setUrl(environment.getProperty("db.url"));
      dataSource.setUsername(environment.getProperty("db.username"));
      dataSource.setPassword(environment.getProperty("db.password"));
      return dataSource;
   }

//   @Bean
//   public LocalSessionFactoryBean getSessionFactory() {
//      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//      factoryBean.setDataSource(getDataSource());
//
//      Properties props=new Properties();
//      props.put("hibernate.show_sql", environment.getProperty("hiber.show_sql"));
//      props.put("hibernate.hbm2ddl.auto", environment.getProperty("hiber.hbm2ddl.auto"));
//
//      factoryBean.setHibernateProperties(props);
//      factoryBean.setAnnotatedClasses(User.class, Role.class);
//      return factoryBean;
//   }

   @Bean
   public PlatformTransactionManager transactionManager() {
      return new JpaTransactionManager(entityManagerFactory());
   }

   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
      return new HibernateJpaVendorAdapter();
   }

   @Bean()
   public EntityManagerFactory entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean factoryBean =
              new LocalContainerEntityManagerFactoryBean();
      factoryBean.setPackagesToScan("/web/model");
      factoryBean.setDataSource(dataSource());
      factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());



      return factoryBean.getNativeEntityManagerFactory();
   }


}
