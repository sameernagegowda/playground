package com.bhs.sb.bs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Entry Class
 * @author CSK1KOR
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.bhs.sb.bs", "com.bhs.sb.bs.api", "com.bhs.sb.bs.controller","com.bhs.p20.dc.model", "com.bhs.sb.bs.config" })
public class Application implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(Application.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}
