import java.util.*;
abstract class JobRole {
    private String candidateName;
    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public abstract String getRequiredSkills();
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }
    @Override
    public String getRequiredSkills() {
        return "Java, Data Structures, Algorithms, OOP";
    }
}
class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }
    @Override
    public String getRequiredSkills() {
        return "Python, Machine Learning, Statistics, SQL";
    }
}
class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }
    @Override
    public String getRequiredSkills() {
        return "Communication, Roadmapping, Business Strategy";
    }
}
class Resume<T extends JobRole> {
    private T jobRole;
    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }
    public T getJobRole() {
        return jobRole;
    }
    public void displayResume() {
        System.out.println("Candidate: " + jobRole.getCandidateName());
        System.out.println("Skills   : " + jobRole.getRequiredSkills());
    }
}
class ResumeScreeningSystem {
    public static <T extends JobRole> Resume<T> processResume(T role) {
        return new Resume<>(role);
    }
    public static void screenAllResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            System.out.println("Screening: " + role.getCandidateName());
            System.out.println("Skills Required: " + role.getRequiredSkills());
            System.out.println("------------------------------------------------");
        }
    }
}
public class ResumeScreening {
    public static void main(String[] args) {
        List<JobRole> candidateList = new ArrayList<>();
        candidateList.add(new SoftwareEngineer("Alice"));
        candidateList.add(new DataScientist("Bob"));
        candidateList.add(new ProductManager("Carol"));
        System.out.println("AI Screening Started...\n");
        ResumeScreeningSystem.screenAllResumes(candidateList);
        System.out.println("\nIndividual Resume View:\n");
        Resume<SoftwareEngineer> seResume = ResumeScreeningSystem.processResume(new SoftwareEngineer("David"));
        seResume.displayResume();
    }
}

