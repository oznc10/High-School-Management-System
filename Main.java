import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teacher teacherAli = new Teacher("Ali","Kara",36,32000,"DOCTOR");
        teacherAli.getTeacherBranches().add("Matematik");
        teacherAli.getTeacherBranches().add("Turkish");

        Teacher teacherCan = new Teacher("Can","Dana",29,30000,"INTERN");
        teacherCan.getTeacherBranches().add("Physics");


        Teacher teacherAyse = new Teacher("Ayse","Kiraz",33,43000,"PROFESSOR");
        teacherAyse.getTeacherBranches().add("PE");
        teacherAyse.getTeacherBranches().add("Geography");
        teacherAyse.getTeacherBranches().add("History");


        Student studentCenk = new Student("Cenk","Tosun",38,4,teacherAli);
        studentCenk.setGpa(2.70);
        studentCenk.setAdvisorTeacher(teacherAli);


        Student studentHaydar = new Student("Haydar","Kaya",21,3,teacherCan);
        studentHaydar.setGpa(3.20);
        studentHaydar.setAdvisorTeacher(teacherCan);


        Student studentSemih = new Student("Semih","Senturk",18,1,teacherAyse);
        studentSemih.setGpa(2.99);
        studentSemih.setAdvisorTeacher(teacherAyse);

        Student studentErkan = new Student("Erkan","Yalcin",19,2,teacherAyse);
        studentErkan.setGpa(2.76);
        studentErkan.setAdvisorTeacher(teacherAyse);


        teacherAli.addStudent(studentCenk);
        teacherAli.addStudent(studentHaydar);
        teacherAli.removeStudent(studentCenk);


        teacherCan.addStudent(studentSemih);


        teacherAyse.addStudent(studentCenk);
        teacherAyse.addStudent(studentHaydar);

        Principal principalAziz = new Principal("Aziz","Yildirim",69,"Professor",70000);
        principalAziz.addStudent(studentCenk);
        principalAziz.addStudent(studentHaydar);
        principalAziz.addStudent(studentSemih);
        principalAziz.addStudent(studentErkan);
        principalAziz.addTeacher(teacherAli);
        principalAziz.addTeacher(teacherAyse);
        principalAziz.addTeacher(teacherCan);
        while(true){
            System.out.println("Welcome to Student Management System.Please choose your operation.(1 - 12)");
            System.out.println("1 - List Teachers");
            System.out.println("2 - List Students");
            System.out.println("3 - Add New Student");
            System.out.println("4 - Remove Student");
            System.out.println("5 - Add New Teacher");
            System.out.println("6 - Remove Teacher");
            System.out.println("7 - Show Teacher Branches");
            System.out.println("8 - Update Student GPA");
            System.out.println("9 - View Student Passing Status");
            System.out.println("10 - Update All Student's Grade");
            System.out.println("11 - Update All Teacher's Salary");
            System.out.println("12 - Exit");
            int choose = input.nextInt();
            if(choose < 1 || choose > 12){
                return;
            }
            switch(choose){
                case 1 :
                    principalAziz.showTeacherList();
                    break;
                case 2:
                    principalAziz.showStudentList();
                    break;
                case 3:
                    System.out.println("Please Enter Student Informations in Order: (Name,Surname,Age,Grade,Advisor Teacher)");
                    System.out.println("Enter Student Name:");
                    String name = input.next();
                    System.out.println("Enter Student Surname:");
                    String surname = input.next();
                    System.out.println("Enter Student Age:");
                    int age = input.nextInt();
                    System.out.println("Enter Student Grade:");
                    int grade = input.nextInt();
                    if(grade < 9 || grade > 12){
                        System.out.println("ERROR.False grade information.");
                        return;
                    }
                    System.out.println("Choose Advisor Teacher:");
                    for(int i = 0; i < principalAziz.getTeacherList().size() ; i++){
                        System.out.println((i+1) + "- " + principalAziz.getTeacherList().get(i).getTeacherName() + " " + principalAziz.getTeacherList().get(i).getTeacherSurname());
                    }
                    int advisor = input.nextInt();
                    if(advisor < 1 || advisor > principalAziz.teacherList.size() + 1){
                        System.out.println("ERROR.Invalid Advisor Selection.");
                        return;
                    }
                    Teacher advisorTeacher;
                    advisorTeacher = principalAziz.getTeacherList().get(advisor - 1);
                    Student student = new Student(name,surname,age,grade,advisorTeacher);
                    principalAziz.addStudent(student);
                    System.out.println("New Student " + student.getStudentName()+ " " + student.getStudentSurname() + " Added Successfully to List.");
                    break;
                case 4:
                    System.out.println("Please Select The Student That You Want To Remove.");
                    for(int s = 0 ; s < principalAziz.getStudentList().size() ; s++){
                        System.out.println((s+1) + "- " + principalAziz.getStudentList().get(s).getStudentName() + " " + principalAziz.getStudentList().get(s).getStudentSurname());
                    }
                    int removeStudent = input.nextInt();
                    if(removeStudent < 1 || removeStudent > principalAziz.getStudentList().size()){
                        System.out.println("ERROR.Invalid Selection.");
                        return;
                    }
                    System.out.println("Student " + principalAziz.getStudentList().get(removeStudent - 1).getStudentName() + " " + principalAziz.getStudentList().get(removeStudent - 1).getStudentSurname() + " removed successfully from list.");
                    principalAziz.removeStudent(principalAziz.getStudentList().get(removeStudent - 1));
                    break;
                case 5:
                    System.out.println("Please Enter Teacher Informations In Order: (Name,Surname,Age,Salary,Academic Level)");
                    System.out.println("Enter Teacher Name:");
                    String namee = input.next();
                    System.out.println("Enter Teacher Surname:");
                    String surnamee = input.next();
                    System.out.println("Enter Teacher Age:");
                    int agee = input.nextInt();
                    System.out.println("Enter Teacher Salary:");
                    int salary = input.nextInt();
                    System.out.println("Enter Teacher Academic Level:");
                    String academicLevel = input.next();
                    Teacher teacher = new Teacher(namee,surnamee,agee,salary,academicLevel);
                    principalAziz.addTeacher(teacher);
                    System.out.println("New Teacher " + teacher.getTeacherName() + " " + teacher.getTeacherSurname() + " Added Successfully To List.");
                    break;
                case 6:
                    System.out.println("Please Select The Teacher That You Want To Remove.");
                    for(int t = 0; t < principalAziz.getTeacherList().size() ; t++){
                        System.out.println((t+1) + "- " + principalAziz.getTeacherList().get(t).getTeacherName() + " " + principalAziz.getTeacherList().get(t).getTeacherSurname());
                    }
                    int removeTeacher = input.nextInt();
                    if(removeTeacher < 1 || removeTeacher > principalAziz.getTeacherList().size()){
                        System.out.println("ERROR.Invalid Selection.");
                        return;
                    }
                    System.out.println("Teacher " + principalAziz.getTeacherList().get(removeTeacher - 1).getTeacherName() + " " + principalAziz.getTeacherList().get(removeTeacher - 1).getTeacherSurname() + " removed successfully from list.");
                    principalAziz.removeTeacher(principalAziz.getTeacherList().get(removeTeacher - 1));
                    break;
                case 7:
                    System.out.println("Please Select Which Teacher's Branches will be displayed.");
                    for(int b = 0 ; b < principalAziz.getTeacherList().size() ; b++){
                        System.out.println((b+1) + "- " + principalAziz.getTeacherList().get(b).getTeacherName() + " " + principalAziz.getTeacherList().get(b).getTeacherSurname());
                    }
                    int branch = input.nextInt();
                    if(branch < 1 || branch > principalAziz.getTeacherList().size()){
                        System.out.println("ERROR.Invalid Selection.");
                        return;
                    }
                    System.out.println(principalAziz.getTeacherList().get(branch - 1).getFormattedBranches());
                    break;
                case 8 :
                    System.out.println("Please Select Which Student's GPA Will Be Updated.");
                    for(int j = 0 ; j < principalAziz.getStudentList().size() ; j++){
                        System.out.println((j+1) + "- " + principalAziz.getStudentList().get(j).getStudentName() + " " +  principalAziz.getStudentList().get(j).getStudentSurname());
                    }
                    int update = input.nextInt();
                    if(update < 1 || update > principalAziz.getStudentList().size()){
                        System.out.println("ERROR.Invalid Selection.");
                        return;
                    }
                    double oldGPA = principalAziz.getStudentList().get(update - 1).getGpa();
                    System.out.println("Please Enter the New Value of GPA");
                    double newGPA = input.nextDouble();
                    if(newGPA < 0 || newGPA > 4){
                        System.out.println("ERROR.Invalid Value.");
                        return;
                    }
                    principalAziz.updateStudentGPA(update - 1,newGPA);
                    System.out.println("Student " + principalAziz.getStudentList().get(update - 1).getStudentName() + " " +  principalAziz.getStudentList().get(update - 1).getStudentSurname() + "'s GPA Updated From " +
                            oldGPA + " to " + newGPA);
                    break;
                case 9:
                    System.out.println("Please Select Which Student's Passing Status will be Viewed.");
                    for(int j = 0 ; j < principalAziz.getStudentList().size() ; j++){
                        System.out.println((j+1) + "- " + principalAziz.getStudentList().get(j).getStudentName() + " " +  principalAziz.getStudentList().get(j).getStudentSurname());
                    }
                    int view = input.nextInt();
                    if(view < 1 || view > principalAziz.getStudentList().size()){
                        System.out.println("ERROR.Invalid Value.");
                        return;
                    }
                    principalAziz.getStudentList().get(view - 1).passedCheck();
                    break;
                case 10:
                    System.out.println("Getting Ready For Updating Grade Operation.(Graduated Student's Grade will Update as 0)");
                    for(int k = 0 ; k < principalAziz.getStudentList().size() ; k++){
                        principalAziz.getStudentList().get(k).updateGrade();
                    }
                    System.out.println("Update Operation Completed Successfully.");
                    break;
                case 11:
                    System.out.println("Getting Ready for Updating Salary Operation.");
                    for(int m = 0; m < principalAziz.getTeacherList().size() ; m++){
                        principalAziz.updateTeacherSalary(principalAziz.getTeacherList().get(m).getTeacherSalary(), principalAziz.getTeacherList().get(m).getTeacherAcademicLevel());
                    }
                    System.out.println("Update Operation Completed Successfully.");
                    break;
                case 12:
                    System.out.println("Exiting the Program...");
                    return;
            }
        }
    }
}
class Student{
    private String studentName;
    private String studentSurname;
    private int studentAge;
    private int studentGrade;
    private Teacher advisorTeacher;
    private double gpa;
    public Student(String studentName,String studentSurname,int studentAge,int studentGrade,Teacher advisorTeacher){
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentAge = studentAge;
        this.studentGrade = studentGrade;
        this.advisorTeacher = advisorTeacher;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setStudentSurname(String studentSurname){
        this.studentSurname = studentSurname;
    }
    public void setStudentAge(int studentAge){
        this.studentAge = studentAge;
    }
    public void setStudentGrade(int studentGrade){
        this.studentGrade = studentGrade;
    }
    public void setAdvisorTeacher(Teacher advisorTeacher){
        this.advisorTeacher = advisorTeacher;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getStudentSurname(){
        return studentSurname;
    }
    public int getStudentAge(){
        return studentAge;
    }
    public int getStudentGrade(){
        return studentGrade;
    }
    public Teacher getAdvisorTeacher(){
        return advisorTeacher;
    }
    public double getGpa(){
        return gpa;
    }
    public void updateGrade(){
        if(getStudentGrade() == 1 || getStudentGrade() == 2){
            if(getGpa() >= 3.00){
                setStudentGrade(getStudentGrade() + 1);
            }
        }
        if(getStudentGrade() == 3){
            if(getGpa() >= 2.50){
                setStudentGrade(getStudentGrade() + 1);
            }
        }
        if(studentGrade == 4){
            if(getGpa() >= 2.30){
                setStudentGrade(0);
            }
        }
    }
   public void passedCheck(){
        if(studentGrade == 1 || studentGrade == 2){
            if(getGpa() >= 3.00){
                System.out.println(getStudentName() + " " + getStudentSurname() + " is passed class from " + getStudentGrade() + " to " + (getStudentGrade() + 1) + "!");
            }
            else{
                System.out.println(getStudentName() + " " + getStudentSurname() + " couldn't passed class from " + getStudentGrade() + " to " + (getStudentGrade() +1));
            }
        }
        if(studentGrade == 3){
            if(getGpa() >= 2.50){
                System.out.println(getStudentName() + " " + getStudentSurname() + " is passed class from 3 to 4!");
            }
            else{
                System.out.println(getStudentName() + " " + getStudentSurname() + " couldn't passed class from 3 to 4.");
            }
        }
        if(studentGrade == 4){
            if(getGpa() >= 2.30){
                System.out.println(getStudentName() + " " + getStudentSurname() + " is graduated from school!");
            }
            else{
                System.out.println(getStudentName() + " " + getStudentSurname() + " couldn't graduate from school.");
            }
        }
   }
   @Override
    public String toString(){
        return "Student name :" + getStudentName() + ",Student surname: " + getStudentSurname() + ",Student age: " + getStudentAge() + "," +
                "Student grade: " + getStudentGrade() + ",Student GPA: " + getGpa() + ",Advisor teacher name : " + advisorTeacher.getTeacherName();

   }
}
  class Teacher{
      private String teacherName;
      private String teacherSurname;
      private int teacherAge;
      private String teacherAcademicLevel;
      private double teacherSalary;
      private ArrayList<String> branches = new ArrayList<>();
      private ArrayList<Student> teachersStudents = new ArrayList<>();

      public Teacher(String teacherName,String teacherSurname,int teacherAge,int teacherSalary,String teacherAcademicLevel){
          this.teacherName = teacherName;
          this.teacherSurname = teacherSurname;
          this.teacherAge = teacherAge;
          this.teacherSalary = teacherSalary;
          this.teacherAcademicLevel = teacherAcademicLevel;
      }

      public String getTeacherName(){
          return this.teacherName;
      }
      public void setTeacherName(String teacherName){
          this.teacherName = teacherName;
      }
      public String getTeacherSurname(){
          return this.teacherSurname;
      }
      public void setTeacherSurname(String teacherSurname){
          this.teacherSurname = teacherSurname;
      }
      public int getTeacherAge(){
          return this.teacherAge;
      }
      public void setTeacherAge(int teacherAge){
          this.teacherAge = teacherAge;
      }
      public String getTeacherAcademicLevel(){
          return this.teacherAcademicLevel;
      }
      public void setTeacherAcademicLevel(String teacherAcademicLevel){
          this.teacherAcademicLevel = teacherAcademicLevel;
      }
      public double getTeacherSalary(){
          return this.teacherSalary;
      }
      public void setTeacherSalary(double teacherSalary){
          this.teacherSalary = teacherSalary;
      }
      public ArrayList<String> getTeacherBranches(){
          return this.branches;
      }
      public void setBranches(ArrayList<String> branches){
          this.branches = branches;
      }
      public ArrayList<Student> getTeachersStudents(){
          return this.teachersStudents;
      }
      public void setTeachersStudents(ArrayList<Student> teachersStudents){
          this.teachersStudents = teachersStudents;
      }
      public String getFormattedBranches(){
          String result = "";
          if(branches != null){
              for(int i = 0 ; i < branches.size() ; i++){
                  if(i < branches.size() - 1){
                      result += branches.get(i) + ",";
                  }
                  if(i == branches.size() - 1){
                      result += branches.get(i);
                  }
              }
          }
          return result;
      }
      public void addStudent(Student student){
          teachersStudents.add(student);
      }
      public void removeStudent(Student student){
          teachersStudents.remove(student);
      }
      public void printStudentList(){
          if(teachersStudents != null){
              System.out.println("Teacher " + getTeacherName() + "'s student name list:");
              for(int i = 0 ; i < teachersStudents.size() ; i++){
                  System.out.println(teachersStudents.get(i).getStudentName() + " " + teachersStudents.get(i).getStudentSurname());
              }
          }
      }
      @Override
      public String toString(){
          return "Teacher name: " + getTeacherName() + ",Teacher surname: " + getTeacherSurname() + ",Teacher academic level: " + getTeacherAcademicLevel() +
                  ",Teacher age: " + getTeacherAge() + ",Teacher salary: " + getTeacherSalary() + " TL,Teacher branches:(" + getFormattedBranches() + ")";
      }
}
class Principal{
    private String principalName;
    private String principalSurname;
    private int principalAge;
    private String principalAcademicLevel;
    private int principalSalary;
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Teacher> teacherList = new ArrayList<>();

    public Principal(String principalName,String principalSurname,int principalAge,String principalAcademicLevel,int principalSalary){
        this.principalName = principalName;
        this.principalSurname = principalSurname;
        this.principalAge = principalAge;
        this.principalAcademicLevel = principalAcademicLevel;
        this.principalSalary = principalSalary;
    }
    public String getPrincipalName() {
        return principalName;
    }
    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }
    public String getPrincipalSurname() {
        return principalSurname;
    }
    public void setPrincipalSurname(String principalSurname) {
        this.principalSurname = principalSurname;
    }
    public int getPrincipalAge() {
        return principalAge;
    }
    public void setPrincipalAge(int principalAge) {
        this.principalAge = principalAge;
    }
    public String getPrincipalAcademicLevel() {
        return principalAcademicLevel;
    }
    public void setPrincipalAcademicLevel(String principalAcademicLevel) {
        this.principalAcademicLevel = principalAcademicLevel;
    }
    public int getPrincipalSalary() {
        return principalSalary;
    }
    public void setPrincipalSalary(int principalSalary) {
        this.principalSalary = principalSalary;
    }
    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }
    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }
    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }
    public void removeTeacher(Teacher teacher){
        teacherList.remove(teacher);
    }
    public void addStudent(Student student){
        studentList.add(student);
    }
    public void removeStudent(Student student){
        studentList.remove(student);
    }
    public void showTeacherList() {
        if (teacherList == null) {
            System.out.println("ERROR.Empty Teacher List.");
            return;
        }
        System.out.println("Current Teacher List:");
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println((i + 1) + "- " + teacherList.get(i).getTeacherName() + " " + teacherList.get(i).getTeacherSurname());
        }
    }
        public void showStudentList(){
            if(studentList == null){
                System.out.println("ERROR.Empty Student List.");
                return;
            }
            System.out.println("Current Student List:");
            for(int i = 0 ; i < studentList.size() ; i++){
                System.out.println((i+1) + "- " + studentList.get(i).getStudentName() + " " + studentList.get(i).getStudentSurname());
            }
        }
    public String getFormattedTeacherList(){
        String result = "";
        if(teacherList != null){
            for(int i = 0; i < teacherList.size(); i++){
                if(i < teacherList.size() - 1){
                    result += teacherList.get(i) + ",";
                }
                if(i == teacherList.size() - 1){
                    result += teacherList.get(i);
                }
            }
        }
        return result;
    }
    public void updateStudentGPA(int index,double gpa){
        studentList.get(index).setGpa(gpa);
    }
    public void updateTeacherSalary(double salary,String academicLevel){
        if(!academicLevel.equals("PROFESSOR") && !academicLevel.equals("DOCTOR") && !academicLevel.equals("INTERN")){
            System.out.println("ERROR.Invalid Academic Level.");
            return;
        }
        if(academicLevel.equals("PROFESSOR")){
            salary += salary * (30 / 100);
        }
        if(academicLevel.equals("DOCTOR")){
            salary += salary * (20 / 100);
        }
        if(academicLevel.equals("INTERN")){
            salary += salary * (10 / 100);
        }

    }
    @Override
    public String toString(){
        return "Principal name: " + getPrincipalName() + ",Principal surname: " + getPrincipalSurname() + ",Principal age: " + getPrincipalAge() +
                ",Principal academic level: " + getPrincipalAcademicLevel() + ",Principal salary: " + getPrincipalSalary() + ",Principal's teacher list:(" +
                getFormattedTeacherList() + ")";
    }
}

