package com.example.polyglottal_calculator2;

public class TrainerrModel {
    private int id;
    private int targetWeight;
    private int weight;
    private String name;
    private int height;
    private int age;
    private String gender;
    private String activeLevel;

    //constructor
    public TrainerrModel(int id, int targetWeight, int weight, String name, int height, int age, String gender, String activeLevel) {
        this.id = id;
        this.targetWeight = targetWeight;
        this.weight = weight;
        this.name = name;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.activeLevel = activeLevel;
    }

    //toString
    @Override
    public String toString() {
        return "TrainerrModel{" +
                "id=" + id +
                ", targetWeight=" + targetWeight +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", activeLevel='" + activeLevel + '\'' +
                '}';
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(int targetWeight) {
        this.targetWeight = targetWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActiveLevel() {
        return activeLevel;
    }

    public void setActiveLevel(String activeLevel) {
        this.activeLevel = activeLevel;
    }
}
