package com.itheima.edu.info.manage.controller;

import com.itheima.edu.info.manage.domain.Student;
import com.itheima.edu.info.manage.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService=new StudentService();
    private Scanner sc = new Scanner(System.in);
    public void start() {
        //Scanner sc = new Scanner(System.in);
        studentLoop:
        while(true){
            System.out.println("--------------学生管理系统------------------");
            System.out.println("1.增加 2.删除 3.修改 4.搜索 5.感谢使用");
            String choice=sc.next();
            switch (choice){
                case "1":
                    //System.out.println("增加");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteStudent();
                    break;
                case "3":
                    //System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("搜索");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢使用");
                    break studentLoop;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }

    public void updateStudent() {
        //StudentService studentService=new StudentService();
        String updateId=inputStudentId();

        Student newStu=inputStudent(updateId);
        //将学生对象，传递给StudentService（业务员）中的addStudent方法
        //StudentService studentService=new StudentService();
        studentService.updateStudent(updateId,newStu);
        //根据返回的Boolean类型结果，在控制台打印成功、失败
        System.out.println("修改成功");
    }

    public void deleteStudent() {
        //StudentService studentService = new StudentService();
        String delId = inputStudentId();
        studentService.deleteStudent(delId);
        System.out.println("删除成功");
    }

    public void findAllStudent() {
        //StudentService studentService = new StudentService();
        Student[] stus = studentService.findAllStudent();
        if(stus==null){
            System.out.println("不存在数据");
            return;
        }
        System.out.println("number\t\tname\tage\tbirthday");
        for (int i = 0; i <stus.length ; i++) {
            Student student=stus[i];
            if(student!=null){
                System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getAge()+"\t\t"+student.getBirthday());
            }
        }
    }

    public void addStudent() {
        //键盘接收学生信息
        //StudentService studentService=new StudentService();
        String id;
        //Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入学生id");
            id=sc.next();
            boolean flag=studentService.isExit(id);
            if(flag){
                System.out.println("输入ID存在，请重新输入");
            }else{
                break;
            }
        }
        Student stu=inputStudent(id);
        //将学生对象，传递给StudentService（业务员）中的addStudent方法
        //StudentService studentService=new StudentService();
        boolean result=studentService.addStudent(stu);
        //根据返回的Boolean类型结果，在控制台打印成功、失败
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public String inputStudentId(){
        String id;
        while(true){
            System.out.println("请输入学生id");
            id=sc.next();
            boolean flag=studentService.isExit(id);
            if(!flag){
                System.out.println("输入ID不存在，请重新输入");
            }else{
                break;
            }
        }
        return id;
    }

    public Student inputStudent(String id){
        System.out.println("请输入姓名");
        String name=sc.next();
        System.out.println("请输入年龄");
        String age=sc.next();
        System.out.println("请输入生日");
        String birthday=sc.next();
        Student newStu=new Student();
        newStu.setId(id);
        newStu.setName(name);
        newStu.setAge(age);
        newStu.setBirthday(birthday);
        return newStu;
    }
}
