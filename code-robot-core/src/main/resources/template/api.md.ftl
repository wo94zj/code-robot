## 聊天室接口文档

#### 版本信息

| 版本 | 日期     | 备注 |
| ---- | -------- | ---- |
| v1.0 |  | 初版 |

#### 简介


#### 接口基础信息

##### 请求说明

| 请求信息     | 说明                                 |
| ------------ | ------------------------------------ |
| 基础URL      | `http://{ip}:{port}/${name}/`           |
| 测试地址     | ``    |
| 正式地址     | `` |
| 请求协议     | http                                 |
| 规范         | RESTful                              |
| 响应数据格式 | json                                 |

> 注：请求URL路径中拼接的参数，不用再在请求体中添加。

##### 响应基础信息

| 属性 | 类型   | 必填 | 默认值 | 备注         |
| ---- | ------ | ---- | ------ | ------------ |
| code | int    | Y    | 2000   | 响应标识     |
| msg  | String | Y    | OK     | 响应结果描述 |
| data | object | Y    | ""     | 响应具体内容 |

示例：

```json
{
    "code": 2000,
    "msg": "OK",
    "data": ""
}
```

##### 响应状态码枚举

| code码 | 结果             |
| ------ | ---------------- |
| 2000   | 成功             |
| 2001   | 操作失败         |
| 4000   | 请求参数错误     |
| 4040   | URL错误          |
| 4050   | 请求方法错误     |
| 4150   | 请求数据格式错误 |
| 5000   | 服务端异常       |
| 5001   | 合作方响应异常   |

### 接口列表

<#if modelMap??>
<#list modelMap?keys as key>
<#if (modelMap[key].comment)?length gt 0>

#### ${modelMap[key].comment} 添加接口

##### 请求说明

| 请求信息     | 说明                              |
| ------------ | --------------------------------- |
| URL          | `/${modelMap[key].humpName}`             |
| 请求方式     | POST                              |
| Content-Type | application/json;charset=UTF-8 |

##### 请求参数

| 参数 | 类型   | 必填 | 备注   |
| ---- | ------ | ---- | ------ |
<#list modelMap[key].fields as field>
<#if field.name != "id" && field.name != "updateTime" && field.name != "createTime">
| ${field.name} | ${field.type} | Y    | ${field.comment} |
</#if>
</#list>

##### 响应信息

| 属性           | 类型    | 上层参数       | 备注        |
| -------------- | ------- | -------------- | ----------- |
| data      | Integer  |  | 1：成功 |

示例：

```json
```

#### ${modelMap[key].comment} 删除接口

##### 请求说明

| 请求信息     | 说明                              |
| ------------ | --------------------------------- |
| URL          | `/${modelMap[key].humpName}/{id}`             |
| 请求方式     | DELETE                              |
| Content-Type | application/x-www-form-urlencoded |

##### 请求参数

| 参数 | 类型   | 必填 | 备注   |
| ---- | ------ | ---- | ------ |
| id | Long | Y    | ID |


##### 响应信息

| 属性           | 类型    | 上层参数       | 备注        |
| -------------- | ------- | -------------- | ----------- |
| data      | Integer  |  | 1：成功 |

示例：

```json
```

#### ${modelMap[key].comment} 修改接口

##### 请求说明

| 请求信息     | 说明                              |
| ------------ | --------------------------------- |
| URL          | `/${modelMap[key].humpName}/{id}`             |
| 请求方式     | PUT                              |
| Content-Type | application/json;charset=UTF-8 |

##### 请求参数

| 参数 | 类型   | 必填 | 备注   |
| ---- | ------ | ---- | ------ |
<#list modelMap[key].fields as field>
<#if field.name != "updateTime" && field.name != "createTime">
| ${field.name} | ${field.type} | Y    | ${field.comment} |
</#if>
</#list>


##### 响应信息

| 属性           | 类型    | 上层参数       | 备注        |
| -------------- | ------- | -------------- | ----------- |
| data      | Integer  |  | 1：成功 |

示例：

```json
```

#### ${modelMap[key].comment} 查询接口

##### 请求说明

| 请求信息     | 说明                              |
| ------------ | --------------------------------- |
| URL          | `/${modelMap[key].humpName}/{id}`             |
| 请求方式     | GET                              |
| Content-Type | application/x-www-form-urlencoded |

##### 请求参数

| 参数 | 类型   | 必填 | 备注   |
| ---- | ------ | ---- | ------ |
| id | Long | Y    | ID |


##### 响应信息

| 属性           | 类型    | 上层参数       | 备注        |
| -------------- | ------- | -------------- | ----------- |
<#list modelMap[key].fields as field>
| ${field.name} | ${field.type} |	| ${field.comment} |
</#list>

示例：

```json
```

#### ${modelMap[key].comment} 分页查询接口

##### 请求说明

| 请求信息     | 说明                              |
| ------------ | --------------------------------- |
| URL          | `/${modelMap[key].humpName}/page`             |
| 请求方式     | GET                              |
| Content-Type | application/x-www-form-urlencoded |

##### 请求参数

| 参数 | 类型   | 必填 | 备注   |
| ---- | ------ | ---- | ------ |
| id | Long | Y    | ID |
| pageNum | Integer | N    | 页号 |
| pageSize | Integer | N    | 页大小 |

##### 响应信息

| 属性           | 类型    | 上层参数       | 备注        |
| -------------- | ------- | -------------- | ----------- |
|hasNextPage	|boolean	|	|是否还有下一页	|
|pageNum	|Integer	|	|页号	|
|total	|Integer	|	|总行数	|
|isLastPage	|boolean	|	|是否是最后一页	|
<#list modelMap[key].fields as field>
| ${field.name} | ${field.type} |list	| ${field.comment} |
</#list>

示例：

```json
```

</#if>
</#list>
</#if>