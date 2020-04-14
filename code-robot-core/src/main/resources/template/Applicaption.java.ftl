package ${pkgPath};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("${mapperPkg}")
public class Applicaption {

	public static void main(String[] args) {
		SpringApplication.run(Applicaption.class, args);
	}
}