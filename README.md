## code-robot

#### 简介

项目主要是生成web项目的工具。以库表作为基础，通过模版，生成对应得ORM（tk.mybatis）、RESTful API、测试代码和API文档。

### 项目说明

#### code-robot-core

生成代码的核心逻辑。分为数据库表信息读取部分、生成类文件信息汇总部分和生成文件模版部分。

##### 数据库表信息读取部分

包路径：com.robot.core.db

默认MySql。

> 其他数据库需要实现IDbQuery和ITypeConvert，程序会根据datasource配置自动识别对应的数据库类型

##### 生成类文件信息汇总部分

包路径：com.robot.core.pkg

提供模版所需要的数据信息。

##### 生成文件模版部分

默认通过FreeMarker模版生成文件。

> 其他模版需要实现ITemplateFactory，并在TemplateUtil.initTempBySuffix(“suffix”)添加对应模版引擎文件后缀

#### code-robot-outer

生成一套mvn项目的工具包，依赖`code-robot-core`。

### 使用说明

#### 注意事项

1. 创建表时一定要指定表和字段的`comment`，不然可能无法生成api文档。

#### 步骤

##### 准备

1. 编译code-robot
2. 配置application.yml，并和code-robot-outer.jar放到同一目录
3. 准备模版（code-robot-core/resources/template下有），在jar文件同目录建template文件夹，并把模版放进去

##### 执行

`java -jar code-robot-outer.jar `

#### 配置部分

##### application.yml

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/db_name?useUnicode=true&characterEncoding=utf-8&connectTimeout=60000&socketTimeout=60000&serverTimezone=GMT%2B8
    username: youname
    password: youpwd
    driver-class-name: com.mysql.cj.jdbc.Driver
    sql-script-encoding: UTF-8

#keeper:
#  author: robot

#db:
#  include-tables: #选定库中的表
#      - "tb_name"

package:
  pkg-path: com.robot.test #生成项目的基础包路径
  name-strategy:
    scheme: UNDERLINE_TO_CAMEL #命名转换策略。UNDERLINE_TO_CAMEL：下划线转驼峰；UNCHANGE：不做修改
    class-remove-prefix: #表名转类名时去掉前缀
      - "mc_"
    #field-remove-prefix: #字段转化时需要去掉前缀

template: 
  path: template #模版路径
  #suffix: .ftl

project:
  groupId: com.test
  artifactId: robot-test
  name: rt #项目名称
  rootPath: F:\dev\work #项目所在工作空间，生成项目位置

logging:
  config: classpath:logback.xml
  level:
    root: INFO
```

## 参考

* `https://github.com/GitHub-Laziji/code-generator`