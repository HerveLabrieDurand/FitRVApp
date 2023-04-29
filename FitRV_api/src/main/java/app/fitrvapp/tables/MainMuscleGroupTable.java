package app.fitrvapp.tables;

import app.fitrvapp.dto.MainMuscleGroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class MainMuscleGroupTable {
    @Autowired
    @Qualifier("myJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("myDataSource")
    private DriverManagerDataSource dataSource;

    public List<MainMuscleGroupDto> getAllMainMuscleGroups() throws Exception {
        return jdbcTemplate.query(
                "SELECT * FROM main_muscle_group",
                (rs, rowNum) -> new MainMuscleGroupDto(
                        rs.getLong("main_muscle_group_id"),
                        rs.getString("name"),
                        rs.getString("description")
                )
        );
    }
}
