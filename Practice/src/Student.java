public class Student {
    public String name;
    public Course course;
    public double grade;

    public Student(String name, Course course, double grade) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public Student(String name, Course course) {
        this(name, course, 0);
    }
}