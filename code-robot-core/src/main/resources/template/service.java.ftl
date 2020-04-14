package ${clazz.pkg};

<#if clazz.impPkgs?? && (clazz.impPkgs?size > 0) >
<#list clazz.impPkgs as pkgPath>
import ${pkgPath};
</#list>
</#if>

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${clazz.comment!} 服务类
 * </p>
 *
 * @author ${author}
 */
@Service
public class ${clazz.name}Service {

	@Autowired
	private ${clazz.name}Mapper ${humpClazz}Mapper;
	
	/**
	 * 分页查询 ${clazz.comment!}
	 */
	public PageInfo<${clazz.name}> selectByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<${clazz.name}> list = ${humpClazz}Mapper.selectAll();
		PageInfo<${clazz.name}> page = new PageInfo<>(list);
		return page;
	}
	
	/**
	 * 通过ID查询 ${clazz.comment!}
	 */
	public ${clazz.name} select${clazz.name}ById(long id) {
		return ${humpClazz}Mapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 插入 ${clazz.comment!}
	 */
	public int insert${clazz.name}(${clazz.name} record) {
		return ${humpClazz}Mapper.insertUseGeneratedKeys(record);
	}
	
	/**
	 * 更具主键删除 ${clazz.comment!}
	 */
	public int delete${clazz.name}(long id) {
		return ${humpClazz}Mapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据主键更新 ${clazz.comment!}
	 */
	public int update${clazz.name}(${clazz.name} record) {
		return ${humpClazz}Mapper.updateByPrimaryKey(record);
	}
}
