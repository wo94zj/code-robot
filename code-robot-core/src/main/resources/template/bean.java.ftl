package ${clazz.pkg};

<#if clazz.impPkgs?? && (clazz.impPkgs?size > 0) >
<#list clazz.impPkgs as pkgPath>
import ${pkgPath};
</#list>
</#if>

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * ${clazz.comment!}
 * </p>
 *
 * @author ${author}
 */
@Data
<#if clazz.annotationList?? && (clazz.annotationList?size > 0) >
<#list clazz.annotationList as al>
${al}
</#list>
</#if>
public class ${clazz.name} implements Serializable {

	private static final long serialVersionUID = 1L;
	
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#if fields?? && (fields?size > 0) >
<#list fields as field>
    /**
     * ${field.comment!}
     */
    <#if field.annotationList?? && (field.annotationList?size > 0) >
	<#list field.annotationList as al>
	${al}
	</#list>
	</#if>
	private ${field.type} ${field.name};
</#list>
</#if>
<#------------  END 字段循环遍历  ---------->
}
