package com.java.practice.serialization;

import java.io.*;

public class ExternalizationOfRequiredFields {

    public static void main(String[] args) {
        Employee saveEmp = new Employee();

        saveEmp.setDoNotStoreEmpId("123456799");
        saveEmp.setSalary(10000);
        saveEmp.setName("Aman Jain");
        saveEmp.setOnProject(true);

        //Before Externalization
        System.out.println(saveEmp);
        saveIntoDB(saveEmp);
        System.out.println("Serialization Done.");
    }

    private static void saveIntoDB(Employee settings) {
        try {
            FileOutputStream fos = new FileOutputStream("DB.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(settings);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DeserializeData {
    public static void main(String[] args) {
        //After Externalization
        Employee empFromDB = getEmpFromDB();
        System.out.println(empFromDB);
        System.out.println("Deserialization Done.");
    }

    private static Employee getEmpFromDB() {
        try {
            FileInputStream fis = new FileInputStream("DB.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee employee = (Employee) ois.readObject();
            ois.close();
            return employee;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


class Employee implements Externalizable {

    private String doNotStoreEmpId;
    private Integer salary;
    private String name;
    private boolean onProject;

    //This is required
    public Employee() {

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

    public void readExternal(ObjectInput in) throws IOException {
        salary = in.readInt();
        name = in.readUTF();
        onProject = in.readBoolean();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(salary);
        out.writeUTF(name);
        out.writeBoolean(onProject);
    }

    @Override
    public String toString() {
        return "Employee [doNotStoreEmpId=" + doNotStoreEmpId + ", salary="
                + salary + ", name=" + name + ", onProject="
                + onProject + "]";
    }
}