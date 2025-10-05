package org.example;
public class Animal {
    private String name;
    private String type;
    private String sound;
    private String briefHistory;


    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.sound=sound;
        this.briefHistory=briefHistory;
    }

    public String getBriefHistory() {
        return briefHistory;
    }

    public void setBriefHistory(String briefHistory) {
        this.briefHistory = briefHistory;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
