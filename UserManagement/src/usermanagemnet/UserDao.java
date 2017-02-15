package usermanagemnet;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao implements IuserData {

	private String SQL_INSERT_DATA = "INSERT INTO DATA(NAME,PWD)VALUES(?,?)";
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void createUser(String username, String Password) {
		int count = jdbcTemplateObject.update(SQL_INSERT_DATA ,username,Password);
		if(count==1) {
			System.out.println("record has been inserted!!");
			return;
	}
	}
}
