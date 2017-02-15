package com.thbs.interfaces;

import java.util.List;

import com.thbs.Beans.EmailLinkEncryptionBean;

public interface IemailLinkEncryption {
	
	public int insertEmailLinkEncryption(EmailLinkEncryptionBean ele);
	public List<EmailLinkEncryptionBean> getEmailLinkEncryption(String email);
	

}
