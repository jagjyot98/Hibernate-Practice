/* Notes:           Changes in the table structure cannot necessarily be implemented to an existing table.
                    We might need to create a whole new table to implement the desired changes to the table structure
                    When we changed generated value strategy to IDENTITY from AUTO , we needed to either delete the old table and create new or, we can generate a new table with other name.
                    New table will be created with new structure requirements.
* */
package com.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table (name="employeeInfo2")
public class Employee {
    @Id
//    @GeneratedValue (strategy = GenerationType.AUTO)    //for random id value generator

    //for implementing our own method for id generation
//    @GeneratedValue (strategy = GenerationType.AUTO, generator = "empid_generator") //generation type auto creates a table for next id value
//    @SequenceGenerator(name = "empid_generator",initialValue = 1,allocationSize = 1)    //for creating a sequence in id generation

    //for simply creating a sequence in id generation, NO sequence table will be created
    @GeneratedValue (strategy = GenerationType.IDENTITY)    //kind of auto_increment starts like 1,2,3....
    private int eno;

    @Column (name="empName")
    private String ename;

/*    @OneToMany
//    @JoinColumn(name = "address_address_id")
    private Address address;    */

    private int esalary;

//    public Address getAddress() {
//        return address;
//    }

//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEsalary() {
        return esalary;
    }

    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }

    //implicitly called
    public String toString(){
        return eno+" "+ename+" "+esalary;
    }
}
