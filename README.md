Initial conditions :
=====
* Maven 3.3.3
* JDK 1.8


Test procedure :
=====
**From project root & initial state (fresh from github)**

 
1. mvn clean install (required as there are inter-modules dependencies)
2. mvn -f ./TestApiWar/pom.xml spring-boot:run


**Expected :**

Should boot properly. No error and http://localhost:8090/health down because the postgresql database is configured with crappy values... but the server is up and running.


Action :
-----


1. Modify test.jce.technical.configuration.CacheConfiguration -> comment the bean cacheManager block    
2. mvn clean install (required as there are inter-modules dependencies)
3. mvn -f ./TestApiWar/pom.xml spring-boot:run

        @Bean
        public ConcurrentMapCacheManager cacheManager() {
            return new ConcurrentMapCacheManager("test");
        }


**Expected :**

Fail on startup, ending with

    Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: test.jce.persistence.authentication.dao.mapper.AuthenticationMapper test.jce.persistence.authentication.dao.impl.AuthenticationDaoImpl.mapper; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [test.jce.persistence.authentication.dao.mapper.AuthenticationMapper] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:571)
   	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
    	

And with a lot of looping 

    Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.sql.DataSource]: Factory method 'dataSource' threw exception; nested exception is java.lang.NullPointerException; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceAutoConfiguration$NonEmbeddedConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.sql.DataSource]: Factory method 'dataSource' threw exception; nested exception is java.lang.NullPointerException; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'sqlSessionFactory' defined in class path resource [test/jce/persistence/configuration/DatabaseConfig.class]: Unsatisfied dependency expressed through constructor argument with index 0 of type [javax.sql.DataSource]: : Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceAutoConfiguration$NonEmbeddedConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.sql.DataSource]: Factory method 'dataSource' threw exception; nested exception is java.lang.NullPointerException; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceAutoConfiguration$NonEmbeddedConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.sql.DataSource]: Factory method 'dataSource' threw exception; nested exception is java.lang.NullPointerException
    
Action :
-----

1. Modify test.jce.TestApiApplication -> comment the @EnableCaching annotation     
2. mvn clean install (required as there are inter-modules dependencies)
3. mvn -f ./TestApiWar/pom.xml spring-boot:run

**Expected :**

Should boot properly. No error and http://localhost:8080/health down because the postgresql database is configured with crappy values... but the server is up and running.