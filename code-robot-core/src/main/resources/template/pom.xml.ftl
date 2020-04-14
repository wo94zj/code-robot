<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>${groupId}</groupId>
  <artifactId>${artifactId}</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <properties>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	<maven.compiler.source>1.8</maven.compiler.source>
	<maven.compiler.target>1.8</maven.compiler.target>

	<maven.cpmpiler.encoding>UTF-8</maven.cpmpiler.encoding>
	<maven.test.skip>true</maven.test.skip>

	<junit.version>4.12</junit.version>
	<slf4j.slf4j-api.version>1.7.25</slf4j.slf4j-api.version>
  	<alibaba.fastjson>1.2.58</alibaba.fastjson>
  </properties>
  
  <dependencyManagement>
    <dependencies>
        <!-- Override Spring Data release train provided by Spring Boot -->
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-releasetrain</artifactId>
            <version>Fowler-SR2</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>2.2.2.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
  </dependencyManagement>

	<dependencies>
		<!-- Core starter, including auto-configuration support, logging and YAML -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<!-- Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- Starter for using JDBC with the HikariCP connection pool -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<!-- spring aop -->
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
		<!-- Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<!-- exclude JUnit 4 support -->
		        <exclusion>
		            <groupId>org.junit.vintage</groupId>
		            <artifactId>junit-vintage-engine</artifactId>
		        </exclusion>
		    </exclusions>
		</dependency>
		<!-- ClassNotFoundException: net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection -->
		<dependency>
		  <groupId>net.bytebuddy</groupId>
		  <artifactId>byte-buddy</artifactId>
		  <!-- <version>1.3.16</version> -->
		  <version>1.10.6</version>
		  <scope>runtime</scope>
		</dependency>
		<dependency>
		  <groupId>org.objenesis</groupId>
		  <artifactId>objenesis</artifactId>
		  <version>2.1</version>
		  <scope>runtime</scope>
		</dependency>
		<!-- Starter for logging using Logback. Default logging starter -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</dependency>
		
		<!--MySQL JDBC驱动 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<!-- 自动加载mybatis配置 -->
		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter</artifactId>
		    <version>2.1.1</version>
		</dependency>
		<!-- MyBatis 插件依赖 -->
		<dependency>
		    <groupId>tk.mybatis</groupId>
		    <artifactId>mapper-spring-boot-starter</artifactId>
		    <version>2.1.5</version>
		</dependency>
		<!-- 注册分页拦截器 -->
		<dependency>
		    <groupId>com.github.pagehelper</groupId>
		    <artifactId>pagehelper-spring-boot-starter</artifactId>
		    <version>1.2.13</version>
		</dependency>
		
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<scope>provided</scope>
		</dependency>
		
		<!--阿里 FastJson依赖 -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>${r'${alibaba.fastjson}'}</version>
		</dependency>
	</dependencies>
    
  <!-- Package as an executable jar -->
  <build>
      <plugins>
          <plugin>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-maven-plugin</artifactId>
              <configuration>
				<mainClass>${mainClass}</mainClass>
				<includeSystemScope>true</includeSystemScope>
			  </configuration>
			  <executions>
				<execution>
					<goals>
						<goal>repackage</goal>
					</goals>
				</execution>
			  </executions>
          </plugin>
      </plugins>
  </build>
</project>