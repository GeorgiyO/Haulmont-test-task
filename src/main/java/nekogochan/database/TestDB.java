package nekogochan.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("ALL")
public class TestDB {

    @Autowired
    private JdbcTemplate jdbc;

    public void add(int id) {
        jdbc.update(
            "insert into test (id) values (?)",
            id
        );
    }

    public String getAll() {
        StringBuilder result = new StringBuilder();
        jdbc.query(
            "select * from test",
            (resultSet, i) -> resultSet.getInt("id")
        ).forEach(result::append);
        return result.toString();
    }

}
