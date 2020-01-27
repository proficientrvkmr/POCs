package com.java.practice.serialization;

import java.io.*;

public class SerializationOfRequiredFields {
    public static void main(String[] args) {

        Student studentObj = new Student();

        studentObj.setDoNotStoreEmpId("123456799");
        studentObj.setSalary(10000);
        studentObj.setName("Aman Jain");
        studentObj.setOnProject(true);

        //Before Externalization
        System.out.println(studentObj);
        saveIntoDB(studentObj);
        System.out.println("Serialization Done.");
    }

    private static void saveIntoDB(Student student) {
        try {
            FileOutputStream fos = new FileOutputStream("DB2.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DeserializeStudent {
    public static void main(String[] args) {
        //After Externalization
        Student empFromDB = getEmpFromDB();
        System.out.println(empFromDB);
        System.out.println("Deserialization Done.");
    }

    private static Student getEmpFromDB() {
        try {
            FileInputStream fis = new FileInputStream("DB2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();
            ois.close();
            return student;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Student implements Serializable {

    private String doNotStoreEmpId;
    private Integer salary;
    private String name;
    private boolean onProject;

    //This is required
    public Student() {

    }

    public String getDoNotStoreEmpId() {
        return doNotStoreEmpId;
    }

    public void setDoNotStoreEmpId(String doNotStoreEmpId) {
        this.doNotStoreEmpId = doNotStoreEmpId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnProject() {
        return onProject;
    }

    public void setOnProject(boolean onProject) {
        this.onProject = onProject;
    }

    private void readObject(ObjectInput in) throws IOException {
        salary = in.readInt();
        name = in.readUTF();
        onProject = in.readBoolean();
    }

    private void writeObject(ObjectOutput out) throws IOException {
        out.write(salary);
        out.writeUTF(name);
        out.writeBoolean(onProject);
    }

    @Override
    public String toString() {
        return "Student [doNotStoreEmpId=" + doNotStoreEmpId + ", salary="
                + salary + ", name=" + name + ", onProject="
                + onProject + "]";
    }
}