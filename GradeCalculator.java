import java.util.*;

class Student {
    private String name;
    private List<Integer> marks;

    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double getAverage() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public void displayResult() {
        System.out.println("Student: " + name);
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        Student student = new Student(name);

        System.out.println("Enter marks (type -1 to stop):");
        while (true) {
            int mark = sc.nextInt();
            if (mark == -1) break;
            student.addMark(mark);
        }

        student.displayResult();
        sc.close();
    }
}
