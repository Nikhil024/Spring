package com.thbs.data;

public final class ExamConstants {

	public final static String BACKGROUND_IMAGE = PropertiesfileReading.getProperty("BackgroundImage");
	public final static String HOME_PAGE_BACKGROUND_IMAGE = PropertiesfileReading.getProperty("HomePageBackgroundImage");
	public final static String COMPANY_NAME = PropertiesfileReading.getProperty("CompanyName");
	public final static String PROJECT_NAME = PropertiesfileReading.getProperty("ProjectName");
	public final static String PROJECT_DESCRIPTION = PropertiesfileReading.getProperty("ProjectDescription");
	public final static String SIDEBAR1 = PropertiesfileReading.getProperty("Sidebar1");
	public final static String SIDEBAR1_CONTENT = PropertiesfileReading.getProperty("Sidebar1Content");
	public final static String SIDEBAR2 = PropertiesfileReading.getProperty("Sidebar2");
	public final static String SIDEBAR2_CONTENT = PropertiesfileReading.getProperty("Sidebar2Content");
	public final static String SIDEBAR3 = PropertiesfileReading.getProperty("Sidebar3");
	public final static String SIDEBAR3_CONTENT = PropertiesfileReading.getProperty("Sidebar3Content");
	public final static String PASSWORD_MATCH_FAIL = PropertiesfileReading.getProperty("PasswordMatchFail");
	public final static String USERTYPE = PropertiesfileReading.getProperty("UserType");
	public final static String USER_ALREADY_EXISTS = PropertiesfileReading.getProperty("UserAlreadyExists");
	public final static String EMAIL_USERNAME = PropertiesfileReading.getProperty("EmailUserName");
	public final static String EMAIL_PASSWORD = PropertiesfileReading.getProperty("EmailPassword");
	public final static String EMAIL_VERIFICATION_SUBJECT = PropertiesfileReading.getProperty("MailVerificationSubject");
	public final static String INSERT_USERS_DATA = PropertiesfileReading.getProperty("InsertUsersQuery");
	public final static String SELECT_A_USER_DATA =  PropertiesfileReading.getProperty("SelectAUserQuery");
	public final static String INSERT_DATA_TO_EMAIL_LINK_ENCRYPTION = PropertiesfileReading.getProperty("InsertDataToEmailLinkEncryption");
	public final static String ONLINE_EXAMINATION_PORTAL_WEBSITE = PropertiesfileReading.getProperty("OnlineExaminationPortalWebsite");
	public final static String SELECT_A_EMAIL_VERIFICATION_USER_DATA = PropertiesfileReading.getProperty("selectAEmailVerificationUserData");
	public final static String NO_DATA_FOR_EMAIL_VERIFICATION = PropertiesfileReading.getProperty("noDataForEmailVerification");
	public final static String SELECT_USER_DATA_BY_ID = PropertiesfileReading.getProperty("selectAUserDataById");
	public final static String UPDATE_USER_EMAIL_VERIFIED = PropertiesfileReading.getProperty("UpdateUserEmailVerified");
	public final static String UPDATE_USER_SUBSCRIBED = PropertiesfileReading.getProperty("UpdateUserSubscribed");
	public final static String UPDATE_USER_ADMIN_ACCEPTED = PropertiesfileReading.getProperty("UpdateUserAdminVerified");
	public final static String NO_USER_EXIST = PropertiesfileReading.getProperty("NoUserExist");
	public final static String EMAIL_SMTP_HOST = PropertiesfileReading.getProperty("EmailSmtpHost");
	public final static String EMAIL_SMTP_PORT = PropertiesfileReading.getProperty("EmailSmtpPort");
	public final static String EMAIL_SOCKET_FACTORY_CLASS = PropertiesfileReading.getProperty("EmailSocketFactoryClass");
	public final static String EMAIL_SMTP_AUTH = PropertiesfileReading.getProperty("EmailSmtpAuth");
	public final static String PAGE_DISPLAY_VALUE = PropertiesfileReading.getProperty("PageDisplayValue"); 
	public final static String LOGIN_PASSWORD_FAIL = PropertiesfileReading.getProperty("LoginPasswordFail"); 
	public final static String REDIRECT_VALUE = PropertiesfileReading.getProperty("RedirectValue");
	public final static String LOGIN_AS_ADMIN = PropertiesfileReading.getProperty("LoginAsAdmin"); 
	public final static String STUDENT_LOGIN_SUCCESSFULL = PropertiesfileReading.getProperty("StudentLoginSuccessFull"); 
	public final static String INITIAL_VERIFICATION_VALUE = PropertiesfileReading.getProperty("InitialVerificationValue"); 
	public final static String AFTER_VERIFICATION_VALUE = PropertiesfileReading.getProperty("AfterVerificationValue");
	public final static String LOGIN_AS_STUDENT = PropertiesfileReading.getProperty("LoginAsStudent"); 
	public final static String MODEL_ATTRIBUTE = "data";
	public final static String WINDOWS_PIE_CHART_STORE_LOCATION = PropertiesfileReading.getProperty("WindowsPieChartStoreLocation");
	public final static String LINUX_PIE_CHART_STORE_LOCATION = PropertiesfileReading.getProperty("LinuxPieChartStoreLocation");
	public final static String WINDOWS_PROFILE_IMAGE_STORE_LCOATION = PropertiesfileReading.getProperty("WindowsProfileImageStoreLocation");
	public final static String LINUX_PROFILE_IMAGE_STORE_LCOATION = PropertiesfileReading.getProperty("LinuxProfileImageStoreLocation");
	
	public final static String NO_LOGIN_MESSAGE = PropertiesfileReading.getProperty("NoLoginMessage");
	public final static String CATILANA_HOME_LOCATION = System.getProperty("catalina.home");
	public final static String WINDOWS_PIE_CHART_STORED_LOCATION = CATILANA_HOME_LOCATION + WINDOWS_PIE_CHART_STORE_LOCATION;
	public final static String WINDOWS_PROFILE_IMAGE_STORED_LCOATION = CATILANA_HOME_LOCATION + WINDOWS_PROFILE_IMAGE_STORE_LCOATION;
	public final static String LINUX_PROFILE_IMAGE_STORED_LCOATION = CATILANA_HOME_LOCATION + LINUX_PROFILE_IMAGE_STORE_LCOATION;
	public final static String JPEG_IMAGE_EXTENSION = PropertiesfileReading.getProperty("JPEGImageExtension");
	public final static String FIRST_TIME_PROFILE_AND_NO_PROFILE_PICTURE = PropertiesfileReading.getProperty("FirstTimeProfileAndNoProfilePicture");
	public final static String INSERT_IMAGE_QUERY = PropertiesfileReading.getProperty("InsertImage");
	public static String UPDATE_IMAGE_QUERY = PropertiesfileReading.getProperty("UpdateImage");
	public final static String SELECT_IMAGE_QUERY = PropertiesfileReading.getProperty("GetAllImages");
	public final static String INSERT_USER_DETAILS = PropertiesfileReading.getProperty("InsertUserDetails");
	public final static String SELECT_USER_DETAILS = PropertiesfileReading.getProperty("SelectUserDetails");
	public final static String LOCK_SCREEN_IMAGE_NAME = PropertiesfileReading.getProperty("LockScreenImageName");
	public final static String SCREEN_LOCKED_MESSAGE = PropertiesfileReading.getProperty("ScreenLockedMessage");
	public final static String SELECT_ALL_SUBJECTS = PropertiesfileReading.getProperty("SelectAllSubjects");
	public final static String INSERT_SUBJECTS = PropertiesfileReading.getProperty("InsertSubjects");
	
	public static String UPDATE_USER_DETAILS = PropertiesfileReading.getProperty("UpdateUserDetails");
	public static String NO_DATA = PropertiesfileReading.getProperty("NoData");
	public static String EMAIL_VERIFICATION_ALREADY_DONE = PropertiesfileReading.getProperty("EmailVerificationAlreadyDone");
	public static String EMAIL_VERIFICATION_SUCCESS = PropertiesfileReading.getProperty("EmailVerificationSuccess");
	






}
