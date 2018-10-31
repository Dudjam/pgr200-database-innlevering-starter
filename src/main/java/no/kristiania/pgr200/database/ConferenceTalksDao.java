package no.kristiania.pgr200.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class ConferenceTalksDao {

    private DataSource dataSource;

    public ConferenceTalksDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTableIfNotExists() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            conn.createStatement().executeUpdate("create table if not exists CONFERENCE_TALK (TITLE varchar primary key, DESCRIPTION text)");
        }
    }

    public void insertTalk(String title, String description) throws SQLException {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "insert into CONFERENCE_TALK (TITLE, DESCRIPTION) values (?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.setString(2, description);

                statement.executeUpdate();
            }
        }
    }
    
    public void listTalks() throws SQLException {
    	try(Connection conn = dataSource.getConnection()) {
    		String sql = "SELECT * FROM CONFERENCE_TALK";
    		try (PreparedStatement statement = conn.prepareStatement(sql)) {
    			ResultSet rs = statement.executeQuery();
    			
    			while (rs.next()) {
            		System.out.print(rs.getString(1));
            		System.out.print(": ");
            		System.out.println(rs.getString(2));
            	}
    		}
    	}
    }
    
    //WILLIAM
    public void cleanup() throws SQLException {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "delete from CONFERENCE_TALK";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
            	statement.executeQuery();
            }
        }
    }
}
