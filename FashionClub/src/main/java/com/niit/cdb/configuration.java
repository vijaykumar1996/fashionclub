package com.niit.cdb;
import java.util.*;
import javax.sql.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.orm.hibernate5.*;
import org.springframework.transaction.annotation.*;
import com.niit.bean.*;

@Configuration
@EnableTransactionManagement
@ComponentScan(" com.niit")
public class configuration {

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	dataSource.setUsername("vijay");
	dataSource.setPassword("vijay");
	System.out.println("----DataSource object is created---");
	return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProp.put("hibernate.show_sql","true");
		hibernateProp.put("hibernate.format_sql","true");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
        factory.addProperties(hibernateProp);
        factory.addAnnotatedClass(Category.class);
        factory.addAnnotatedClass(Supplier.class);
        factory.addAnnotatedClass(Product.class);
        factory.addAnnotatedClass(UserInfo.class);
        System.out.println("---SessionFactory object created----");
        
        return factory.buildSessionFactory();
        		
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
	System.out.println("----Transaction Object created----");
	return new HibernateTransactionManager(sessionFactory);
	}

}
