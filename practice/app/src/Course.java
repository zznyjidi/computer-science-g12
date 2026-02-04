public class Course {
    public String courseCode;
    public String teacher;

    public Course(String courseCode, String teacher) {
        this.courseCode = courseCode;
        this.teacher = teacher;
    }

    public String toString() {
        return courseCode + ": " + teacher;
    }
}
