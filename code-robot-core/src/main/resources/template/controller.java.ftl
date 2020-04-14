package ${clazz.pkg};

<#if clazz.impPkgs?? && (clazz.impPkgs?size > 0) >
<#list clazz.impPkgs as pkgPath>
import ${pkgPath};
</#list>
</#if>

import com.github.pagehelper.PageInfo;

import ${respPkg}.BaseDto;
import ${respPkg}.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ${clazz.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 */
@RestController
@RequestMapping(value = "${humpClazz}")
public class ${clazz.name}Controller {

	@Autowired
	private ${clazz.name}Service ${humpClazz}Service;
	
	/**
	 * 分页查询 ${clazz.comment!}
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public BaseDto<PageInfo<${clazz.name}>> getByPage(@RequestParam(required = false, defaultValue = "1")int pageNum, @RequestParam(required = false, defaultValue = "20")int pageSize) {
		return ResultUtil.success(${humpClazz}Service.selectByPage(pageNum, pageSize));
	}
	
	/**
	 * 添加 ${clazz.comment!}
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public BaseDto<Integer> post${clazz.name}(@RequestBody ${clazz.name} ${humpClazz}) {
		return ResultUtil.success(${humpClazz}Service.insert${clazz.name}(${humpClazz}));
	}
	
	/**
	 * 通过ID查询 ${clazz.comment!}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BaseDto<${clazz.name}> get${clazz.name}(@PathVariable("id")Long id) {
		return ResultUtil.success(${humpClazz}Service.select${clazz.name}ById(id));
	}
	
	/**
	 * 通过ID更新 ${clazz.comment!}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public BaseDto<Integer> put${clazz.name}(@PathVariable("id")Long id, ${clazz.name} ${humpClazz}) {
		return ResultUtil.success(${humpClazz}Service.update${clazz.name}(${humpClazz}));
	}
	
	/**
	 * 通过ID删除 ${clazz.comment!}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public BaseDto<Integer> del${clazz.name}(@PathVariable("id")Long id) {
		return ResultUtil.success(${humpClazz}Service.delete${clazz.name}(id));
	}
}