/* Notes:       Data when fetched from database comes in a hashcode form.
                to make it readable we need toString method in Object class which converts hash and prints the data in our specified way

 */
package com.hibernate.entity;

public class Student {
    private int sno;
    private String name;
    private double marks;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    //implicitly called
    public String toString(){
        return sno+" "+name+" "+marks;
    }
}
