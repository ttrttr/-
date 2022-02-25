package com.itheima.edu.info.manage.controller;

import com.itheima.edu.info.manage.domain.Student;
import com.itheima.edu.info.manage.domain.Teacher;
import com.itheima.edu.info.manage.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService=new TeacherService();
    private Scanner sc = new Scanner(System.in);
    public void start() {
        teacherLoop:
        while(true){
            System.out.println("--------------老师管理系统------------------");
            System.out.println("1.增加 2.删除 3.修改 4.搜索 5.感谢使用");
            String choice=sc.next();
            switch (choice){
                case "1":
                    //System.out.println("增加");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteTeacher();
                    break;
                case "3":
                    //System.out.println("修改");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("搜索");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢使用");
                    break teacherLoop;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }

    private void findAllTeacher() {
        //StudentService studentService = new StudentService();
        Teacher[] teas = TeacherService.findAllTeacher();
        if(teas==null){
            System.out.println("不存在数据");
            return;
        }
        System.out.println("number\t\tname\tage\tbirthday");
        for (int i = 0; i <teas.length ; i++) {
            Teacher teacher=teas[i];
            if(teacher!=null){
                System.out.println(teacher.getId()+"\t"+teacher.getName()+"\t"+teacher.getAge()+"\t\t"+teacher.getBirthday());
            }
        }
    }

    private void updateTeacher() {
        //StudentService studentService=new StudentService();
        String updateId=inputTeacherId();

        Teacher newTea=inputTeacher(updateId);
        //将学生对象，传递给StudentService（业务员）中的addStudent方法
        //StudentService studentService=new StudentService();
        teacherService.updateTeacher(updateId,newTea);
        //根据返回的Boolean类型结果，在控制台打印成功、失败
        System.out.println("修改成功");
    }

    private void deleteTeacher() {
        //StudentService studentService = new StudentService();
        String delId = inputTeacherId();
        teacherService.deleteTeacher(delId);
        System.out.println("删除成功");
    }

    private void addTeacher() {
        String id;
        while (true){
            System.out.println("请输入老师id");
            id=sc.next();
            boolean result=teacherService.isExit(id);
            if(result){
                System.out.println("id已经存在，重新输入");
            }else{
                break;
            }
        }
        Teacher tea=inputTeacher(id);
        boolean result=teacherService.addTeacher(tea);
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public String inputTeacherId(){
        String id;
        while(true){
            System.out.println("请输入老师id");
            id=sc.next();
            boolean flag=TeacherService.isExit(id);
            if(!flag){
                System.out.println("输入ID不存在，请重新输入");
            }else{
                break;
            }
        }
        return id;
    }

    public Teacher inputTeacher(String id){
        System.out.println("请输入姓名");
        String name=sc.next();
        System.out.println("请输入年龄");
        String age=sc.next();
        System.out.println("请输入生日");
        String birthday=sc.next();
        Teacher newStu=new Teacher();
        newStu.setId(id);
        newStu.setName(name);
        newStu.setAge(age);
        newStu.setBirthday(birthday);
        return newStu;
    }
}
