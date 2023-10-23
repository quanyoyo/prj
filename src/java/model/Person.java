/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aquan
 */
public class Person {
    private int PersonID;
    private String Fullname;
    private String Gender;
    private String Email;
    private String Password;
    private int Type;
    private boolean IsActive;

    public Person() {
    }
    
    public Person(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }
    
    public Person(int PersonID, String Fullname, String Gender, String Email, String Password, int Type, boolean IsActive) {
        this.PersonID = PersonID;
        this.Fullname = Fullname;
        this.Gender = Gender;
        this.Email = Email;
        this.Password = Password;
        this.Type = Type;
        this.IsActive = IsActive;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    /**
     *
     * @return
     */
    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
    
}
