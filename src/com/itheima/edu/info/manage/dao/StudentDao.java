package com.itheima.edu.info.manage.dao;

import com.itheima.edu.info.manage.domain.Student;

public class StudentDao {
    private static Student[] stus=new Student[5];
    public boolean addStudent(Student stu) {
        //添加学生数组
        //2.1定义变量index为-1，假设数组已经全部存满，没有null元素
        int index=-1;
        //2.2遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i <stus.length ; i++) {
            Student student=stus[i];
            if(student==null){
                index=i;
            }else{
                break;
            }
        }
        //2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
        //3.返回是否添加成功的Boolean类型状态
        if(index==-1){
            return false;
        }else{
            stus[index]=stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudent(String delId) {
        int index=getIndex(delId);
        stus[index]=null;
    }

    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i <stus.length ; i++) {
            Student stu=stus[i];
            if (stu!=null&&stu.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student newStu) {
        int index = getIndex(updateId);
        stus[index]=newStu;
    }
}
