package com.example.polyglottal_calculator2;

public class TraineeModelToDisplay {

    private String name;
    private int targetWeight;
    private int weight;
    private int height;
    private int age;
    private String activeLevel;

    public TraineeModelToDisplay(String name, int targetWeight, int weight, int height, int age, String activeLevel) {
        this.name = name;
        this.targetWeight = targetWeight;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activeLevel = activeLevel;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", targetWeight=" + targetWeight +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", activeLevel='" + activeLevel + '\'';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getActiveLevel() {
        return activeLevel;
    }

    public void setActiveLevel(String activeLevel) {
        this.activeLevel = activeLevel;
    }
}
