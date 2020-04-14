<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<!-- 日志输出格式 -->
	<property name="LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} ${r'${PID}'} %level %X{ip} [%thread] %logger - %msg%n" />
	
	<!-- 日志路径及名称配置 -->
    <property name="LOG_FILE" value="${r'${LOG_FILE:-${LOG_PATH:-logs}/'}${name}}"/>
	
	<!-- 控制台日志 -->
	<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
		<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
			<pattern>${r'${LOG_PATTERN}'}</pattern>
			<charset>UTF-8</charset>
		</encoder>
	</appender>
	
	<!-- 文件日志配置 -->
	<appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${r'${LOG_FILE}'}.log</file>
		<!-- Support multiple-JVM writing to the same log file -->
		<prudent>true</prudent>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- daily rollover -->
			<fileNamePattern>${r'${LOG_FILE}'}-%d{yyyy-MM-dd}.log</fileNamePattern>
			<!-- keep 7 days' worth of history capped at 7GB total size -->
			<maxHistory>7</maxHistory>
			<totalSizeCap>7GB</totalSizeCap>
		</rollingPolicy>
		<encoder>
			<pattern>${r'${LOG_PATTERN}'}</pattern>
			<charset>UTF-8</charset>
		</encoder>
	</appender>
	
	<!-- 错误日志配置 -->
	<appender name="FILE_ERROR" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${r'${LOG_FILE}'}.error.log</file>
		<prudent>true</prudent>
		<filter class="ch.qos.logback.classic.filter.ThresholdFilter">
			<level>ERROR</level>
		</filter>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<!-- daily rollover -->
			<fileNamePattern>${r'${LOG_FILE}'}.error-%d{yyyy-MM-dd}.log</fileNamePattern>
			<!-- keep 7 days' worth of history capped at 7GB total size -->
			<maxHistory>7</maxHistory>
			<totalSizeCap>7GB</totalSizeCap>
		</rollingPolicy>
		<encoder>
			<pattern>${r'${LOG_PATTERN}'}</pattern>
			<charset>UTF-8</charset>
		</encoder>
	</appender>

	<!-- the level of the root level is set to DEBUG by default.  -->
	<root level="${r'${log.root.level}'}">
		<appender-ref ref="STDOUT" />
		<appender-ref ref="FILE" />
		<appender-ref ref="FILE_ERROR" />
	</root>
	
</configuration>