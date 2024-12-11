package pairmatching.domain;

public class Crew {
    private final String name;
    private final String course;

    public Crew(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
