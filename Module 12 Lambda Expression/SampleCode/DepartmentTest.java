import java.util.Comparator;

public class DepartmentTest {
    public static void main(String[] args) {
        Department<Student> department = new Department<Student>();
        department.add(new Student(3, "Celine", "CE"));
        department.add(new Student(1, "James", "CS"));
        department.add(new Student(4, "Kim", "CE"));

        for(Student s: department) {
            System.out.println(s);
        }

        department.sort();
        System.out.println();

        for(Student s: department) {
            System.out.println(s);
        }

        // Anonumous Class
        Comparator<Student> com = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        department.sort(com);  
        System.out.println();

        for(Student s: department) {
            System.out.println(s);
        }

        // Lambda Expression
        department.sort((s1, s2) -> s1.getDepartment().compareTo(s2.getDepartment()));
        System.out.println();

        for(Student s: department) {
            System.out.println(s);
        }
    }
}
