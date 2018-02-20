package hello;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public MyBatisCursorItemReader<Status> reader(SqlSessionFactory sqlSessionFactory) {
        MyBatisCursorItemReader<Status> reader = new MyBatisCursorItemReader<>();
        reader.setSqlSessionFactory(sqlSessionFactory);
        reader.setQueryId(StatusMapper.class.getName() + ".selectAll");

        return reader;
    }

    @Bean
    public StatusItemProcessor processor() {
        return new StatusItemProcessor();
    }

    @Bean
    public MyBatisBatchItemWriter<Status> writer(SqlSessionFactory sqlSessionFactory) {
        MyBatisBatchItemWriter<Status> writer = new MyBatisBatchItemWriter<>();
        writer.setSqlSessionFactory(sqlSessionFactory);
        writer.setStatementId(StatusMapper.class.getName() + ".insert");
        return writer;
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, SqlSessionFactory sqlSessionFactory) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1(sqlSessionFactory))
                .end()
                .build();
    }

    @Bean
    public Step step1(SqlSessionFactory sqlSessionFactory) {
        return stepBuilderFactory.get("step1")
                .<Status, Status>chunk(5)
                .reader(reader(sqlSessionFactory))
                .processor(processor())
                .writer(writer(sqlSessionFactory))
                .build();
    }
    // end::jobstep[]
}