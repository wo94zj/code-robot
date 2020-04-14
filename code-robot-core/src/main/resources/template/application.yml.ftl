server:
  port: 9001
  connection-timeout: 6000
  http2:
    enabled: true
  error:
    path: /error
    whitelabel:
      enabled: true
  servlet:
    context-path: /${name}
    session:
      timeout: 1800 #30分钟
  tomcat:
    basedir: tmp/${name}
    uri-encoding: UTF-8
    min-spare-threads: 7 # Minimum amount of worker threads.
    max-http-post-size: 100MB # Maximum size of the HTTP post content.
    max-connections: 10000 # Maximum number of connections that the server accepts and processes at any given time.
    max-threads: 200 # Maximum amount of worker threads.
    max-swallow-size: 100MB # Maximum amount of request body to swallow.

spring:
  mvc:
    throw-exception-if-no-handler-found: true #404抛异常，交给程序处理
    static-path-pattern: /statics/** #静态文件配置
  application:
    name: chat
  http:
    encoding:
      enabled: true
      charset: UTF-8
  servlet:
    multipart: 
      enabled: true # Whether to enable support of multipart uploads.
      file-size-threshold: 0B # Threshold after which files are written to disk.
      location:  # Intermediate location of uploaded files.
      max-file-size: 100MB # Max file size.
      max-request-size: 100MB # Max request size.
      resolve-lazily: false # Whether to resolve the multipart request lazily at the time of file or parameter access.
  redis:
    database: 0 #索引（默认为0）
    host: 127.0.0.1 #地址
    port: 6379 #端口号
    #password:  #连接密码（默认空）
    timeout: 6000
    pool:
      max-idle: 8 #连接池中的最大空闲连接
      min-idle: 0 #连接池中的最小空闲连接
      max-active: 8 #连接池最大连接数（使用负值表示没有限制）
      max-wait: -1 #连接池最大阻塞等待时间（使用负值表示没有限制）
  datasource:
    url: ${jdbcUrl}
    username: ${jdbcUsername}
    password: ${jdbcPassword}
    driver-class-name: ${jdbcDriverName}
    sql-script-encoding: UTF-8

mybatis:
  configuration:
    map-underscore-to-camel-case: true
    auto-mapping-behavior: PARTIAL
    default-statement-timeout: 30
    default-fetch-size: 100
    local-cache-scope: STATEMENT
    jdbc-type-for-null: NULL

logging:
  config: classpath:logback.xml
  level:
    root: INFO
    org.springframework.web: INFO
    tk.mybatis.pagehelper.mapper: TRACE