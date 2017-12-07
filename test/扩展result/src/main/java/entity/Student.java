package entity;

import java.util.Date;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/1
 */
public class Student {
    private Integer studId;
    private String name;
    private String email;
    private Date dob;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString(){
        return "name is "+this.getName()+",email is "+this.getEmail()+".";
    }
}
