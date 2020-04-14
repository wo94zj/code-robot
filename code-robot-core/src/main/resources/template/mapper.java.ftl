package ${clazz.pkg};

<#if clazz.impPkgs?? && (clazz.impPkgs?size > 0) >
<#list clazz.impPkgs as pkgPath>
import ${pkgPath};
</#list>
</#if>

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>
 * ${clazz.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 */
<#if clazz.annotationList?? && (clazz.annotationList?size > 0) >
<#list clazz.annotationList as al>
${al}
</#list>
</#if>
public interface ${clazz.name}Mapper extends Mapper<${clazz.name}>, MySqlMapper<${clazz.name}> {

}