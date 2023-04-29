package app.fitrvapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;

public class Table {

    public String[] objectParamsFromResultSet(ResultSet rs) throws Exception {
        StringBuilder sb = new StringBuilder(rs.getString(1));
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        String s = sb.toString();
        String array[] = s.split(",");
        return array;
    }
}
