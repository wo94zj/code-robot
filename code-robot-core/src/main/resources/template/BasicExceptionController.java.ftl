package ${pkgPath};

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${respPkg}.BaseDto;
import ${respPkg}.ResultCode;
import ${respPkg}.ResultUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/error")
public class BasicExceptionController implements ErrorController {
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping
	public ResponseEntity<BaseDto<Serializable>> handleError(HttpServletRequest request, HttpServletResponse response) {
		Object error = request.getAttribute("javax.servlet.error.exception");
		log.error("request ERROR :{}", error);
		
		return new ResponseEntity<BaseDto<Serializable>>(ResultUtil.result(ResultCode.SYSTEM_ERROR), HttpStatus.OK);
	}
	
}
