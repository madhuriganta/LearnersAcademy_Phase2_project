package com.madhuri.LearnerAcademy.services;

import java.util.List;

import com.madhuri.LearnerAcademy.bean.ClassReport;
import com.madhuri.LearnerAcademy.bean.ClassesBean;
import com.madhuri.LearnerAcademy.bean.StudentBean;
import com.madhuri.LearnerAcademy.bean.SubjectBean;
import com.madhuri.LearnerAcademy.bean.TeachersBean;
import com.madhuri.LearnerAcademy.dao.ClassReportDao;
import com.madhuri.LearnerAcademy.dao.ClassesDao;
import com.madhuri.LearnerAcademy.dao.StudentDao;
import com.madhuri.LearnerAcademy.dao.SubjectsDao;
import com.madhuri.LearnerAcademy.dao.TeachersDao;

public class AdminService {
	
	StudentDao stdDao=new StudentDao();
	public boolean saveStudent(StudentBean bean) {
		return stdDao.insertStudent(bean);
		
	}
	
	public int deleteStudent(String sId) {
		return stdDao.deleteStudentById(sId);
	}
	public StudentBean findStudentById(String sId) {
		return stdDao.getStudentById(sId);
		
	}
	public List<StudentBean> findAllStudents() {
		return stdDao.getAllStudents();
		
	}
	public boolean updateStudent(StudentBean bean) {
		return stdDao.updateStudentById(bean);
	
	}
	
	
	TeachersDao tcrDao=new TeachersDao();
	public boolean saveTeacher(TeachersBean bean) {
		return tcrDao.insertTeacher(bean);
		
	}
	
	public int deleteTeacher(String regno) {
		return tcrDao.deleteTeacherById(regno);
	}
	public TeachersBean findTeacherById(String regno) {
		return tcrDao.getTeacherById(regno);
		
	}
	public boolean updateTeacher(TeachersBean bean) {
		return tcrDao.updateTeacherById(bean);
	
	}
	public List<TeachersBean> findAllTeachers() {
		return tcrDao.getAllTeachers();
		
	}
	
	SubjectsDao subDao=new SubjectsDao();
	public boolean saveSubject(SubjectBean bean) {
		return subDao.insertSubject(bean);
		
	}
	
	public int deleteSubject(String subId) {
		return subDao.deleteSubjectById(subId);
	}
	public SubjectBean findSubjectById(String subId) {
		return subDao.getSubjectById(subId);
		
	}
	public boolean updateSubject(SubjectBean bean) {
		return subDao.updateSubjectById(bean);
	
	}
	public List<SubjectBean> findAllSubjects() {
		return subDao.getAllsubjects();
		
	}
	ClassesDao clsDao=new ClassesDao();
	
	public boolean saveClasses(ClassesBean bean) {
		return clsDao.insertClass(bean);
		
	}
	public boolean updateClass(ClassesBean bean) {
		return clsDao.updateClassById(bean);
	
	}
	public int deleteClasses(String cId) {
		return clsDao.deleteClassById(cId);
	}
	ClassReportDao clsRtDao=new ClassReportDao();
	public List<ClassReport> getClassReport() {
		return clsRtDao.getClassReport();
		
	}
	
	
	
   

}
