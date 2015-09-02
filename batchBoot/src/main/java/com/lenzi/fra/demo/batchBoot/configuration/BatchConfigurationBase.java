package com.lenzi.fra.demo.batchBoot.configuration;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BatchConfigurationBase {


	@Autowired
	private JobBuilderFactory jobs;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	public JobBuilderFactory getJobs() {
		return jobs;
	}
	
	public StepBuilderFactory getStepBuilderFactory() {
		return stepBuilderFactory;
	}
}
