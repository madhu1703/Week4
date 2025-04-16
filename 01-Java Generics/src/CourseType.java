import java.util.*;
abstract class CourseType {
    private String title;
    private int credits;
    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }
    public String getTitle() {
        return title;
    }
    public int getCredits() {
        return credits;
    }
    public abstract String getEvaluationType();
    @Override
    public String toString() {
        return title + " (" + getEvaluationType() + ", " + credits + " credits)";
    }
}
class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }
    public String getEvaluationType() {
        return "Exam-Based";
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }
    public String getEvaluationType() {
        return "Research-Based";
    }
}
class Course<T extends CourseType> {
    private T courseType;
    public Course(T courseType) {
        this.courseType = courseType;
    }
    public T getCourseType() {
        return courseType;
    }
    @Override
    public String toString() {
        return courseType.toString();
    }
}
class Department {
    private String name;
    private List<Course<? extends CourseType>> courses;
    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }
    public void displayCourses() {
        System.out.println("Courses in " + name + " Department:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println("- " + course);
        }
    }
}
class UniversityCourseManagement {
    public static void main(String[] args) {
        Department csDept = new Department("Computer Science");
        Department bioDept = new Department("Biotechnology");
        csDept.addCourse(new Course<>(new ExamCourse("Data Structures", 4)));
        csDept.addCourse(new Course<>(new AssignmentCourse("Web Development", 3)));
        bioDept.addCourse(new Course<>(new ResearchCourse("Genetic Engineering", 5)));
        bioDept.addCourse(new Course<>(new ExamCourse("Biochemistry", 4)));
        csDept.displayCourses();
        System.out.println();
        bioDept.displayCourses();
    }
}
