class Student {
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Специальность: " + major);
    }
}

class StudentComparison {
    public static void main(String[] args) {

        Student[] students = {
                new Student("Иван", 20, "Программирование"),
                new Student("Анна", 22, "Математика"),
                new Student("Сергей", 19, "Физика"),
                new Student("Елена", 24, "Химия")
        };

        Student oldestStudent = findOldestStudent(students);

        if (oldestStudent != null) {
            System.out.println("Самый старший студент:");
            oldestStudent.displayInfo();
        }
    }

    public static Student findOldestStudent(Student[] students) {
        Student oldest = students[0];
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }

        return oldest;
    }
}