
package org.com.model;

public class User {
    private String name;
    private int age;
    private String gender;
    private String activityLevel;


    public User(String name, int age, String gender, String activityLevel) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
    }


    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getActivityLevel() { return activityLevel; }


    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }


    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", gender='" + gender + "', activityLevel='" + activityLevel + "'}";
    }
}