package com.lenzi.fra.demo.batchBoot.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lenzi.fra.demo.batchBoot.tasklet.Tasklet2;

@Configuration
@EnableBatchProcessing
@Import(DatasourceConfiguration.class)
public class BatchConfiguration extends BatchConfigurationBase {
	
    @Bean
    // posso usare la naming convenction per iniettare gli step
    public Job job(Step step1, Step step2) {
        return getJobs().get("jobSemplice")
                .incrementer(new RunIdIncrementer())
                .start(step1).next(step2)
                .build();
    }

    @Bean
    // posso usare un @Qualifier per iniettare un'interfaccia 
    public Step step1(@Qualifier("tasklet1") Tasklet tasklet) {
        return getStepBuilderFactory().get("step1").tasklet(tasklet)
                .build();
    }

    @Bean
    // posso usare la classe tradizionale...
    public Step step2(Tasklet2 tasklet) {
        return getStepBuilderFactory().get("step2").tasklet(tasklet)
                .build();
    }
    

    

}