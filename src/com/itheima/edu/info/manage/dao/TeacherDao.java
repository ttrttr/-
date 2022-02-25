package com.itheima.edu.info.manage.dao;

import com.itheima.edu.info.manage.domain.Student;
import com.itheima.edu.info.manage.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teas=new Teacher[5];

    public static Teacher[] findAllTeacher() {
        return teas;
    }

    public boolean addTeacher(Teacher tea) {
        int index=-1;
        //2.2遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i <teas.length ; i++) {
            Teacher teacher=teas[i];
            if(teacher==null){
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
            teas[index]=tea;
            return true;
        }
    }

    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i <teas.length ; i++) {
            Teacher tea=teas[i];
            if (tea!=null && tea.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String updateId, Teacher newTea) {
        int index = getIndex(updateId);
        teas[index]=newTea;
    }

    public void deleteTeacher(String delId) {
        int index=getIndex(delId);
        teas[index]=null;
    }
}
