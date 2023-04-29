package app.fitrvapp;

import app.fitrvapp.dto.MainMuscleGroupDto;
import app.fitrvapp.tables.MainMuscleGroupTable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableConfigurationProperties
public class FitRvAppApplication {

    @Autowired
    private MainMuscleGroupTable mainMuscleGroupTable;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(FitRvAppApplication.class, args);
    }
}
