package class03;

import java.util.Arrays;
import java.util.Comparator;

import include.globalFunc;
public class ComparatorStudy {
    
     
    public static class Student {          // 自己定义的结构
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
        
     }

    public static class AscendingComp implements Comparator<Integer> {
     
        public int compare(Integer arg0, Integer arg1){
            return arg0 - arg1;
        }
     }

    public static class DecendingComp implements Comparator<Integer> {
     
        public int compare(Integer arg0, Integer arg1){
            return arg1 - arg0;
        }
     }

    public static class IdDecendingComparator implements Comparator<Student> {

        //返回负数的时候，第一个参数排在前面
        //返回正数的时候，第二个参数排在前面
        //返回0的时候，谁在前面无所谓
        public int compare(Student o1, Student o2){
            return o2.id - o1.id;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        public int compare(Student o1, Student o2){
            return o1.id - o2.id;
        }
    }
     public static void printStudents(Student[] students){
        for(int i = 0; i < students.length; i++){
            System.out.printf("name : %s, Id : %d, Age : %d \n", students[i].name, students[i].id, students[i].age);

        }
     }

    
    public static void main(String[] args) {
        Integer[] arr = {54, 2, 5, 5, 12};
        
        Arrays.sort(arr, new DecendingComp());
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        
        System.out.println("=======================");

        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);

        Student[] students = new Student[] {student1, student2, student3};
        System.out.println("第一条打印");

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);
        System.out.println("=======================");

        System.out.println("第二条打印");

        Arrays.sort(students, new IdDecendingComparator());
        printStudents(students);
        System.out.println("=======================");
    }  


}
