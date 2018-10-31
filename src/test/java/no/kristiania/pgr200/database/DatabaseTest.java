package no.kristiania.pgr200.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import no.kristiania.pgr200.database.ConferenceTalksDao;
import javax.sql.DataSource;
import org.junit.Test;
import org.postgresql.ds.PGPoolingDataSource;

public class DatabaseTest {

    @Test
    public void shouldInsertConferenceTalks() throws SQLException {
        ConferenceTalksDao dao = new ConferenceTalksDao(createDataSource());
        dao.createTableIfNotExists();
        dao.createTableIfNotExists();
        dao.insertTalk("My Talk Title", "A longer description of the talk");
    }

    private DataSource createDataSource() {
    	PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost/conferencedb_test");
        dataSource.setUser("conference");
        dataSource.setPassword("pZ853D#6*g");
        return dataSource;
    }
    
}
