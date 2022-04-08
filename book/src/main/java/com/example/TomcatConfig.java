package com.example;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//@Configuration
public class TomcatConfig {

	@Bean  
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {

			@Override
			protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
				tomcat.enableNaming(); 
				return super.getTomcatWebServer(tomcat);
			}

			@Override
			protected void postProcessContext(Context context) {
				ContextResource resource = new ContextResource();
				resource.setType(DataSource.class.getName());
				resource.setName("jdbc/DB1");
				resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
				resource.setProperty("driverClassName", "org.mariadb.jdbc.Driver");
				resource.setProperty("url", "jdbc:mariadb://localhost:3306/database1");
				resource.setProperty("username", "test");
				resource.setProperty("password", "test");
				context.getNamingResources().addResource(resource);

			}
		};
//		tomcat.addAdditionalTomcatConnectors(redirectConnector());
		return tomcat;
	}

	/*

	@Bean(destroyMethod="")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:comp/env/jdbc/DB1");
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource)bean.getObject();
	}

	*/

}