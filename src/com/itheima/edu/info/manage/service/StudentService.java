package com.itheima.edu.info.manage.service;

import com.itheima.edu.info.manage.controller.StudentController;
import com.itheima.edu.info.manage.dao.StudentDao;
import com.itheima.edu.info.manage.domain.Student;

public class StudentService {
    private  StudentDao studentDao = new StudentDao();

    public boolean addStudent(Student stu) {
        //创建studentdao
        //将学生对象，传递给studentDao库管中的addStudent方法
        //将返回的Boolean类型结果，返还给studentController
        //StudentDao studentDao = new StudentDao();
        return studentDao.addStudent(stu);
    }

    public boolean isExit(String id) {
        boolean exist=false;
        //StudentDao studentDao = new StudentDao();
        Student[] stus=studentDao.findAllStudent();
        //遍历数组,获取每一个学生对象，准备进行判断
        for (int i = 0; i <stus.length ; i++) {
            Student student = stus[i];
            if(student !=null && student.getId().equals(id)){
                exist=true;
                break;
            }
        }
        return exist;
    }

    public Student[] findAllStudent(){
        //StudentDao studentDao = new StudentDao();
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag=false;
        for (int i = 0; i <allStudent.length ; i++) {
            Student student=allStudent[i];
            if(student!=null){
                flag=true;
                break;
            }
        }
        if(flag){
            return allStudent;
        }else{
            return null;
        }
    }

    public void deleteStudent(String delId) {
        //StudentDao studentDao = new StudentDao();
        studentDao.deleteStudent(delId);
    }

    public void updateStudent(String updateId, Student newStu) {
        //StudentDao studentDao = new StudentDao();
        studentDao.updateStudent(updateId,newStu);
    }
}
