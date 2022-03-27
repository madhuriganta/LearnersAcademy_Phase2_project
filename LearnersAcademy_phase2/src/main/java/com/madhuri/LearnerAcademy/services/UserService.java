package com.madhuri.LearnerAcademy.services;

import com.madhuri.LearnerAcademy.bean.UserBean;
import com.madhuri.LearnerAcademy.dao.UserDao;

public class UserService {
	UserDao usrDao=new UserDao();
	public String login(UserBean beanFromUser) {
		String type=null;
		UserBean beanFromDB=usrDao.getUserByUserName(beanFromUser.getUsrname());
		if(beanFromDB != null)
		{
			if(beanFromUser.getUsrname().equals(beanFromDB.getUsrname()) && beanFromUser.getPassword().equals(beanFromDB.getPassword()))
			{
				type=beanFromDB.getType();
			}
			
		}
		return type;
	}
	public void logout() {
		
	}
	

}
