package app.fitrvapp.tables;

import app.fitrvapp.dto.MainMuscleGroupDto;
import app.fitrvapp.tables.MainMuscleGroupTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class MainMuscleGroupTableTest {

    @Autowired
    private MainMuscleGroupTable mainMuscleGroupTable;

    @Test
    public void testGetAllMainMuscleGroups() throws Exception {
        /* Setup test variable */
        List<MainMuscleGroupDto> mainMuscleGroups = mainMuscleGroupTable.getAllMainMuscleGroups();

        /* Setup test assertions */
        assertNotNull(mainMuscleGroups);
        assertTrue(mainMuscleGroups.size() == 7);
    }
}