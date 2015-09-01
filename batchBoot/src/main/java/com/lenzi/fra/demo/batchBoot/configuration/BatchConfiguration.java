package com.lenzi.fra.demo.batchBoot.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lenzi.fra.demo.batchBoot.tasklet.Tasklet2;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


	@Autowired
	JobBuilderFactory jobs;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
    @Bean
    // posso usare la naming convenction per iniettare gli step
    public Job job(Step step1, Step step2) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .start(step1).next(step2)
                .build();
    }

    @Bean
    // posso usare un @Qualifier per iniettare un'interfaccia 
    public Step step1(@Qualifier("tasklet1") Tasklet tasklet) {
        return stepBuilderFactory.get("step1").tasklet(tasklet)
                .build();
    }

    @Bean
    // posso usare la classe tradizionale...
    public Step step2(Tasklet2 tasklet) {
        return stepBuilderFactory.get("step2").tasklet(tasklet)
                .build();
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}