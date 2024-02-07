package com.hexaware.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.hexaware.springbatch.entity.Customer;
import com.hexaware.springbatch.repository.CustomerRepository;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
//	@Autowired
	private CustomerRepository customerRepository;
	
//	@Bean
//	public JobBuilder jobBuilder() {
//		return new JobBuilder(, jobRepository);
//	}
	
//	@Autowired
//	private JobRepository jobRepository;
	
//	@Autowired
	private StepBuilderFactory stepBuilder;


	public SpringBatchConfig(CustomerRepository customerRepository, JobBuilderFactory jobBuilder, StepBuilderFactory stepBuilder) {
		super();
		this.customerRepository = customerRepository;
		this.jobBuilder = jobBuilder;
		this.stepBuilder = stepBuilder;
	}

	
	@Bean
    public FlatFileItemReader<Customer> reader() {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }
	
	
	  private LineMapper<Customer> lineMapper() {
	        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
	 
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");
	 
	        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	        fieldSetMapper.setTargetType(Customer.class);
	 
	        lineMapper.setLineTokenizer(lineTokenizer);
	        lineMapper.setFieldSetMapper(fieldSetMapper);
	        return lineMapper;
	 
	    }
	
	@Bean
	public CustomerProcessor processor() {
		return new CustomerProcessor();
	}
	
	@Bean
    public RepositoryItemWriter<Customer> writer() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepository);
        writer.setMethodName("save");
        return writer;
    }
	
	@Bean
    public Step step1() {
		return new StepBuilder("csv-step",jobRepository).<Customer, Customer>chunk(10, null)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }
	
	@Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
	
	@Bean
    public Job runJob() {
        return new JobBuilder("imports-customers",jobRepository)
                .flow(step1()).end().build();
 
    }
}
