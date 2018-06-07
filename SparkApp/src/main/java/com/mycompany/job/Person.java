
package com.mycompany.job;

import java.io.Serializable;

public   class Person implements Serializable {
  private  Integer PassengerId;
  private  Integer Survived;

 //|-- Name: string (nullable = true)
  private  String Sex ;
  private  Integer Age;
 //|-- SibSp: integer (nullable = true)
// |-- Parch: integer (nullable = true)
// |-- Ticket: string (nullable = true)
 //|-- Fare: double (nullable = true)
 
 //|-- Embarked: string (nullable = true)

    public Person(Integer PassengerId, Integer Survived,  String Sex, Integer Age) {
        this.PassengerId = PassengerId;
        this.Survived = Survived;
       
        this.Sex = Sex;
        this.Age = Age;
    
    }

    public Person() {
    }

    public Integer getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(Integer PassengerId) {
        this.PassengerId = PassengerId;
    }

    public Integer getSurvived() {
        return Survived;
    }

    public void setSurvived(Integer Survived) {
        this.Survived = Survived;
    }

    

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }

  
   
    
}
