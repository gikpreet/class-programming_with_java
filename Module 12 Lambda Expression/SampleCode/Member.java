public abstract class Member {
    protected String name;
    protected String department;

    public Member(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }

    //public abstract int compareTo(Member member);
}

class Student extends Member implements Comparable<Student> {
    private int studentNo;

    public Student(int studentNo, String name, String department) {
        super(name, department);
        this.studentNo = studentNo;
    }

    public int getStudentNo() {
        return this.studentNo;
    }

    @Override
    public String toString() {
        return this.studentNo + ", " + this.name + ", " + this.department;
    }

    @Override
    public int compareTo(Student member) {
        Student student = (Student)member;
        if (this.studentNo > student.getStudentNo()) {
            return 1;
        }
        else if (this.studentNo < student.getStudentNo()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class Professor extends Member implements Comparable<Professor> {
    private String employeeNo;
    private int age;

    public Professor(String name, String department, String employeeNo, int age) {
        super(name, department);
        this.employeeNo = employeeNo;
        this.age = age;
    }

    public String getEmployeeNo() {
        return this.employeeNo;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.employeeNo + ", " + this.name + ", " + this.department + ", " + this.age;
    }

    @Override
    public int compareTo(Professor member) {
        Professor professor = (Professor)member;
        if (this.employeeNo.compareTo(professor.getEmployeeNo()) >= 1) {
            return 1;
        }
        else if (this.employeeNo.compareTo(professor.getEmployeeNo()) < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}