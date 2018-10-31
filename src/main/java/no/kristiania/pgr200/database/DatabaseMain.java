package no.kristiania.pgr200.database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import org.postgresql.ds.PGPoolingDataSource;

public class DatabaseMain {
	
	private DataSource dataSource;
	private ConferenceTalksDao dao;
	//private LocalFileReader lfr;
	private static String dbUrl;
	
	public DatabaseMain() throws SQLException, IOException{
		//this.lfr = new LocalFileReader();
		//DatabaseMain.dbUrl = lfr.readProperties();
		DatabaseMain.dbUrl = "jdbc:postgresql://localhost/conferencedb_test";
		this.dataSource = createDataSource();
        this.dao = new ConferenceTalksDao(dataSource);
        this.dao.createTableIfNotExists();
	}
	
	public static void main(String[] args) throws SQLException, IOException{
		new DatabaseMain().run(args);
	}
	
	public static DataSource createDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUser("conference");
        dataSource.setPassword("pZ853D#6*g");
        return dataSource;
    }
	
	private void run(String[] args) throws SQLException {
        if (args.length == 0) {
            System.out.println("No argument(s) found. Please run with a valid argument. (insert,cleanup,list)");
            System.exit(1);
        }


        String command = args[0];

        if (command.equals("insert")) {
            insertTalk();
        } else if (command.equals("cleanup")) {
        	cleanup();
        } else if (command.equals("list")) {
        	listTalks();
        } else {
            System.err.println("Unknown command!");
        }
    }
	
	private void insertTalk() throws SQLException {
        dao.insertTalk("NEW TALK, ID: " + UUID.randomUUID(), "PLACEHOLDER DESCRIPTION");
    }
	
	private void listTalks() throws SQLException {
		dao.listTalks();
	}
	
	//Removes rows from conference_talks
	private void cleanup() throws SQLException {
    	dao.cleanup();
    }
}