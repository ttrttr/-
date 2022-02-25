package com.itheima.edu.info.manage.service;

import com.itheima.edu.info.manage.dao.TeacherDao;
import com.itheima.edu.info.manage.domain.Teacher;

public class TeacherService {
    private static TeacherDao teacherDao = new TeacherDao();

    public static Teacher[] findAllTeacher() {
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        boolean flag=false;
        for (int i = 0; i <allTeacher.length ; i++) {
            Teacher teacher=allTeacher[i];
            if(teacher!=null){
                flag=true;
                break;
            }
        }
        if(flag){
            return allTeacher;
        }else{
            return null;
        }
    }


    public static boolean isExit(String id) {
        boolean exist=false;
        Teacher[] teas= TeacherDao.findAllTeacher();
        //遍历数组,获取每一个学生对象，准备进行判断
        for (int i = 0; i <teas.length ; i++) {
            Teacher teacher = teas[i];
            if(teacher !=null && teacher.getId().equals(id)){
                exist=true;
                break;
            }
        }
        return exist;
    }

    public boolean addTeacher(Teacher tea) {
        return teacherDao.addTeacher(tea);
    }

    public void updateTeacher(String updateId, Teacher newTea) {
        teacherDao.updateTeacher(updateId,newTea);
    }

    public void deleteTeacher(String delId) {
        teacherDao.deleteTeacher(delId);
    }
}
