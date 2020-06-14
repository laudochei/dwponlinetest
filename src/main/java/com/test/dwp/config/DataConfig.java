package com.test.dwp.config;

/*
import java.util.Properties;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DataConfig {
      
        
        //mysql db on local machine 
    
        @Bean
        public DataSource getDataSource() {
            DriverManagerDataSource db = new DriverManagerDataSource();
            db.setDriverClassName("com.mysql.jdbc.Driver");
            db.setUrl("jdbc:mysql://localhost:3306/charm");
            db.setUsername("root");
            db.setPassword("welcome");
            return db;
        }
      
    
    
    
        
        //postgres db on local machine 
        /*
        @Bean
        public DataSource getDataSource() {
            DriverManagerDataSource db = new DriverManagerDataSource();
            db.setDriverClassName("org.postgresql.Driver");
            //db.setUrl("jdbc:postgresql://localhost:5432/jsondb");
            db.setUrl("jdbc:postgresql://localhost:5432/assetc");
            //db.setUrl("jdbc:postgresql://localhost:5432/products");
            db.setUsername("postgres");
            db.setPassword("welcome");
            return db;  
        }
       */
    
        
        
        

       /*
       //mysql db on heroku 
       @Bean
        public DataSource getDataSource() {
            DriverManagerDataSource db = new DriverManagerDataSource();
            db.setDriverClassName("com.mysql.jdbc.Driver");
            db.setUrl("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_7ac45a05bab0085");
            db.setUsername("b4778f9d520c68");
            db.setPassword("132d6c92");
            return db;
        }
        */
        
        
         /*
        @Bean
        public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
	}
  
        
        @Bean
        public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
            LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
            sfb.setDataSource(dataSource);
            sfb.setPackagesToScan(new String[] { "com.accord.charm.model"});
            Properties props = new Properties();
            props.setProperty("dialet", "org.hibernate.dialect.MySQL5InnoDBDialect");
            sfb.setHibernateProperties(props);
            return sfb;
        }
}


*/