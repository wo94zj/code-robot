package ${clazz.pkg};

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

<#if clazz.impPkgs?? && (clazz.impPkgs?size > 0) >
<#list clazz.impPkgs as pkgPath>
import ${pkgPath};
</#list>
</#if>

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ${clazz.name}ControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	/**
	 * 分页查询${clazz.comment!} 测试
	 */
	@Test
	public void getByPageTest() {
		Map<String, Object> urlVariables = new HashMap<>();
		urlVariables.put("pageNum", 1);
		urlVariables.put("pageSize", 10);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> resp = testRestTemplate.exchange("/${humpClazz}/page?pageNum={pageNum}&pageSize={pageSize}", HttpMethod.GET, request, String.class, urlVariables);
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
	}
	
	/**
	 * 新增${clazz.comment!} 测试
	 */
	@Test
	public void post${clazz.name}Test() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> urlVariables = new HashMap<>();
		
		${clazz.name} ${humpClazz} = new ${clazz.name}();
		
		HttpEntity<${clazz.name}> request = new HttpEntity<>(${humpClazz}, headers);
		ResponseEntity<String> resp = testRestTemplate.exchange("/${humpClazz}", HttpMethod.POST, request, String.class, urlVariables);
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
	}
	
	/**
	 * 通过ID查询${clazz.comment!} 测试
	 */
	@Test
	public void get${clazz.name}Test() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		Map<String, Object> urlVariables = new HashMap<>();
		urlVariables.put("id", 1);
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> resp = testRestTemplate.exchange("/${humpClazz}/{id}", HttpMethod.GET, request, String.class, urlVariables);
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
	}
	
	/**
	 * 更新${clazz.comment!} 测试
	 */
	@Test
	public void put${clazz.name}Test() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> urlVariables = new HashMap<>();
		urlVariables.put("id", 1);
		
		${clazz.name} ${humpClazz} = new ${clazz.name}();
		
		HttpEntity<${clazz.name}> request = new HttpEntity<>(${humpClazz}, headers);
		ResponseEntity<String> resp = testRestTemplate.exchange("/${humpClazz}/{id}", HttpMethod.PUT, request, String.class, urlVariables);
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
	}
	
	/**
	 * 删除${clazz.comment!} 测试
	 */
	@Test
	public void del${clazz.name}Test() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		Map<String, Object> urlVariables = new HashMap<>();
		urlVariables.put("id", 1);
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> resp = testRestTemplate.exchange("/${humpClazz}/{id}", HttpMethod.DELETE, request, String.class, urlVariables);
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getBody());
	}
}
