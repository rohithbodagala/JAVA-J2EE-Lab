class Student{
    String Name, USN, Address;
    int age;
    double CGPA;
    Student(String Name, String USN, String Address, int age, double CGPA){
        this.Name = Name;
        this.USN = USN;
        this.Address = Address;
        this.age = age;
        this.CGPA = CGPA;
    }
    public String toString(){
        return "Student{" +
                "\n\tName: " + Name +
                "\n\tUSN: " + USN +
                "\n\tAge: " + age +
                "\n\tCGPA: " + CGPA +
                "\n}\n";
    }
}