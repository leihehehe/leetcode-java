package priorityQueue;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static class Student implements Comparable<Student>{
        int age;
        public Student(int age){
            this.age=age;
        }

        @Override
        public int compareTo(Student s) {
            if(this.age>s.age) return 1;
            else if (this.age < s.age) {
                return -1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> queue = new PriorityQueue<>();
        queue.offer(new Student(30));
        queue.offer(new Student(40));
        queue.offer(new Student(50));
        queue.offer(new Student(60));
        System.out.println(queue.poll().age);
        System.out.println(queue.poll().age);
        System.out.println(queue.poll().age);
        System.out.println(queue.poll().age);
    }
}
