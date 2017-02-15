package usermanagemnet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDataMapper implements RowMapper<UserBean> {

	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean userBean  = new UserBean ();
		userBean.setUserName(rs.getString("userName"));
		userBean.setPwd(rs.getString("pwd"));
		return userBean;
	}

}
