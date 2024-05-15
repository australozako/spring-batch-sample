package fr.dkf.batch.springbatchsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBatchSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchSampleApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:org/springframework/batch/core/schema-drop-hsqldb.sql")
				.addScript("classpath:org/springframework/batch/core/schema-hsqldb.sql")
				.addScript("classpath:schema.sql")
				.build();
	}
}
