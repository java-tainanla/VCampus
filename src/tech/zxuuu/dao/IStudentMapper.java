package tech.zxuuu.dao;

import java.util.List;
import java.util.Map;

import javax.sound.sampled.LineListener;

import tech.zxuuu.entity.Student;

public interface IStudentMapper {

	public Boolean verifyStudent(Student student);
	
	public String getNameByCardNumber(String cardNumber);
	
	public String getPasswordByUsername(String cardNumber);
	
	public Boolean insertStudent(Student student);
	
	public int deleteStudent(String cardnumber);
	
	public Integer searchStudentByCardNumber(String cardnumber);
	
	public Integer searchStudentByStudentNumber(String studentnumber);
	
	public int switchStudent(Student student);
	
	public List<Student> tableDisplay(Map map);
}
