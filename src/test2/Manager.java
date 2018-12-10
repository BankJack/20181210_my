package test2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    ArrayList<Student> list=new ArrayList<>();
    /*{
        Student stu1=new Student("001","张立",18,'男');
        Student stu2=new Student("002","张二",18,'男');
        Student stu3=new Student("003","张看",18,'男');
        Student stu4=new Student("004","张老",18,'男');
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
    }*/

    public boolean add(Student stu){
        list.add(stu);
        if (cc()) return true;

        return false;
    }

    private boolean cc() {
        try {
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("E:/student"));
            out.writeObject(list);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean remove(String stuNo){
        for (Student s : list) {
            if(s.getStuNo().equals(stuNo)){
                list.remove(s);
                this.cc();
                return true;
            }
        }
        return false;
    }

    private Student seekStu(String stuNo){
        for (Student s : list) {
            if(s.getStuNo().equals(stuNo)){
                return s;
            }
        }
        return null;
    }

    public Student revamp(String stuNo,String name,int age,char sex){
        Student stu=this.seekStu(stuNo);
        if(stu==null)
            return null;

        stu.setAge(age);
        stu.setName(name);
        stu.setSex(sex);

        this.cc();
        return stu;
    }

    public List<Student> seekAll(){
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/student"));
            Object obj=in.readObject();
            if(obj instanceof ArrayList){

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
