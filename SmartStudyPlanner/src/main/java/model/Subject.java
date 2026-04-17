package model;

public class Subject {
    private String name;
    private String difficulty;
    private int hours;
    private boolean completed;

    public Subject(String name, String difficulty, int hours) {
        this.name = name;
        this.difficulty = difficulty;
        this.hours = hours;
        this.completed = false;
    }

    public String getName() { return name; }
    public String getDifficulty() { return difficulty; }
    public int getHours() { return hours; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}