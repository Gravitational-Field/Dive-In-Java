package com.imcode.model;

/**
 * 班级信息
 */
public class Clazz {
    private int id;
    private String classNumber;
    private String className;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", classNumber='" + classNumber + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
