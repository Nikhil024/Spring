package com.thbs.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thbs.Beans.EmailLinkEncryptionBean;
import com.thbs.DataMapper.EmailLinkEncryptionDataMapper;
import com.thbs.data.ExamConstants;
import com.thbs.interfaces.IemailLinkEncryption;

public class EmailLinkEncryptionDao implements IemailLinkEncryption {

	private static final Logger log = LoggerFactory.getLogger(EmailLinkEncryptionDao.class);
	
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	
	
	
	@Override
	public int insertEmailLinkEncryption(EmailLinkEncryptionBean ele) {
		int count = jdbcTemplateObject.update(ExamConstants.INSERT_DATA_TO_EMAIL_LINK_ENCRYPTION,ele.getId(),ele.getEmail(),ele.getName());
		return count;
	}

	@Override
	public List<EmailLinkEncryptionBean> getEmailLinkEncryption(String email) {
		List<EmailLinkEncryptionBean> ele = jdbcTemplateObject.query(ExamConstants.SELECT_A_EMAIL_VERIFICATION_USER_DATA+"'"+email+"'",new EmailLinkEncryptionDataMapper());
		return ele;
	}

}
