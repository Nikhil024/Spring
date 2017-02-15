package com.student.bhavya;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beans.Questions;
import com.beans.Subjects;
import com.beans.User;
import com.beans.ueQuestions;
import com.dao.InterfacesImpl.QuestionsDao;
import com.dao.InterfacesImpl.SubjectsDao;
import com.dao.InterfacesImpl.UserDao;
import com.dao.InterfacesImpl.ueQuestionsDao;
import com.encryption.MD5;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	UserDao UserDaoObj =  (UserDao)context.getBean("userDao");
	QuestionsDao QuestionsDaoObj =  (QuestionsDao)context.getBean("questionsDao");
	SubjectsDao SubjectsDaoObj =  (SubjectsDao)context.getBean("subjectsDao");
	ueQuestionsDao ueQuestionsDaoObj =  (ueQuestionsDao)context.getBean("uequestionsDao");


	/* Start: Questions table SELECT,INSERT,UPDATE AND DELETE Operations*/
	@RequestMapping(value = "/questions",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<Questions> questions(){
		List<Questions> questions = QuestionsDaoObj.getAllQuestions();
		log.info("Questions data "+questions);
		return questions;
	}

	@RequestMapping(value = "/questionsinsert",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String questionsinsert(@RequestParam("question") String question,@RequestParam("option1") String option1,@RequestParam("option2") String option2,@RequestParam("option3") String option3,@RequestParam("option4") String option4,@RequestParam("answer") String answer,@RequestParam("subject") String subject){
		Questions q = new Questions();
		q.setQuestion(question);
		q.setOption1(option1);
		q.setOption2(option2);
		q.setOption3(option3);
		q.setOption4(option4);
		q.setAnswer(answer);
		q.setSubject(subject);

		int count = QuestionsDaoObj.insertQuestions(q);
		log.info("Questions inserted "+count);
		if(count >= 1){
			return "\"Inserted\": " +"\"1\"";
		}
		return "\"Inserted\": " +"\"0\"";
	}


	@RequestMapping(value = "/questionsupdate",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String questionsupdate(@RequestParam("id") int id,@RequestParam("question") String question,@RequestParam("option1") String option1,@RequestParam("option2") String option2,@RequestParam("option3") String option3,@RequestParam("option4") String option4,@RequestParam("answer") String answer,@RequestParam("subject") String subject){
		Questions q = new Questions();
		q.setId(id);
		q.setQuestion(question);
		q.setOption1(option1);
		q.setOption2(option2);
		q.setOption3(option3);
		q.setOption4(option4);
		q.setAnswer(answer);
		q.setSubject(subject);
		int count = QuestionsDaoObj.updateQuestions(q);
		log.info("Questions Updated "+count);
		if(count >= 1){
			return "\"Updated\": " +"\"1\"";
		}
		return "\"Updated\": " +"\"0\"";
	}

	@RequestMapping(value = "/questionsdelete",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String questionsdelete(@RequestParam("id") int id){
		Questions q = new Questions();
		q.setId(id);
		int count = QuestionsDaoObj.deleteQuestions(q);
		log.info("Questions Deleted "+count);
		if(count >= 1){
			return "\"Deleted\": " +"\"1\"";
		}
		return "\"Deleted\": " +"\"0\"";
	}
	/* End: Questions table SELECT,INSERT,UPDATE AND DELETE Operations*/




	/* Start: Subjects table SELECT,INSERT,UPDATE AND DELETE Operations*/
	@RequestMapping(value = "/subjects",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<Subjects> subjects(){
		List<Subjects> subjects = SubjectsDaoObj.getAllSubjects();
		log.info("Subjects data "+subjects);
		return subjects;
	}

	@RequestMapping(value = "/subjectsinsert",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String insertSubjects(@RequestParam("subjectname") String subjectname){
		Subjects s = new Subjects();
		s.setSubjectname(subjectname);
		int count = SubjectsDaoObj.insertSubjects(s);
		log.info("Subjects Inserted "+count);
		if(count >= 1){
			return "\"Inserted\": " +"\"1\"";
		}
		return "\"Inserted\": " +"\"0\"";
	}


	@RequestMapping(value = "/subjectsdelete",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String deleteSubjects(@RequestParam("id") int id){
		Subjects s = new Subjects();
		s.setId(id);
		int count = SubjectsDaoObj.deleteSubjects(s);
		log.info("Subjects Deleted "+count);
		if(count >= 1){
			return "\"Deleted\": " +"\"1\"";
		}
		return "\"Deleted\": " +"\"0\"";
	}



	@RequestMapping(value = "/subjectsupdate",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String updateSubjects(@RequestParam("id") int id,@RequestParam("subjectname") String subjectname){
		Subjects s = new Subjects();
		s.setId(id);
		s.setSubjectname(subjectname);
		int count = SubjectsDaoObj.updateSubjects(s);
		log.info("Subjects Updated "+count);
		if(count >= 1){
			return "\"Updated\": " +"\"1\"";
		}
		return "\"Updated\": " +"\"0\"";
	}
	/* End: Subjects table SELECT,INSERT,UPDATE AND DELETE Operations*/



	/* Start: User table SELECT,INSERT,UPDATE AND DELETE Operations*/
	@RequestMapping(value = "/users",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<User> users(){
		List<User> users = UserDaoObj.getAllUsers();
		log.info("User data "+users);
		return users;
	}

	@RequestMapping(value = "/usersinsert",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String insertUsers(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("birthday") String birthday,@RequestParam("profession") String profession){
		User u = new User();
		u.setUsername(username);
		u.setPassword(MD5.encryption(password));
		u.setEmail(email);
		u.setBirthdate(birthday);
		u.setProfession(profession);
		int count = UserDaoObj.insertUsers(u);
		log.info("Users inserted "+count);
		if(count >= 1){
			return "\"Inserted\": " +"\"1\"";
		}
		return "\"Inserted\": " +"\"0\"";
	}

	@RequestMapping(value = "/usersdelete",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String deleteUsers(@RequestParam("id") int id){
		User u = new User();
		u.setId(id);
		int count = UserDaoObj.deleteUsers(u);
		log.info("Users deleted "+count);
		if(count >= 1){
			return "\"Deleted\": " +"\"1\"";
		}
		return "\"Deleted\": " +"\"0\"";
	}

	@RequestMapping(value = "/usersupdate",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String updateUsers(@RequestParam("id") int id,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("birthday") String birthday,@RequestParam("profession") String profession){
		User u = new User();
		u.setId(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setBirthdate(birthday);
		u.setProfession(profession);

		int count = UserDaoObj.updateUsers(u);
		log.info("Users updated "+count);
		if(count >= 1){
			return "\"Updated\": " +"\"1\"";
		}
		return "\"Updated\": " +"\"0\"";
	}
	/* End: User table SELECT,INSERT,UPDATE AND DELETE Operations*/




	/* Start: USERS_EXAM_QUESTIONS table SELECT,INSERT,UPDATE AND DELETE Operations*/
	@RequestMapping(value = "/uequestions",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<ueQuestions> ueQuestions(){
		List<ueQuestions> ueques = ueQuestionsDaoObj.getAllUsersueQuestions();
		log.info("ueQuestions data "+ueques);
		return ueques;
	}

	@RequestMapping(value = "/uequestionsinsert",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String insertueQuestions(){
		ueQuestions ueq = new ueQuestions();
		int count = ueQuestionsDaoObj.insertueQuestions(ueq);
		log.info("USERS_EXAM_QUESTIONS inserted "+count);
		if(count >= 1){
			return "\"Inserted\": " +"\"1\"";
		}
		return "\"Inserted\": " +"\"0\"";
	}

	@RequestMapping(value = "/uequestionsdelete",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String deleteueQuestions(){
		ueQuestions ueq = new ueQuestions();
		int count = ueQuestionsDaoObj.deleteueQuestions(ueq);
		log.info("USERS_EXAM_QUESTIONS updated "+count);
		if(count >= 1){
			return "\"Deleted\": " +"\"1\"";
		}
		return "\"Deleted\": " +"\"0\"";
	}



	@RequestMapping(value = "/uequestionsupdate",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String updateueQuestions(){
		ueQuestions ueq = new ueQuestions();
		int count = ueQuestionsDaoObj.updateueQuestions(ueq);
		log.info("USERS_EXAM_QUESTIONS updated "+count);
		if(count >= 1){
			return "\"Updated\": " +"\"1\"";
		}
		return "\"Updated\": " +"\"0\"";
	}
	/* End: USERS_EXAM_QUESTIONS table SELECT,INSERT,UPDATE AND DELETE Operations*/
}
