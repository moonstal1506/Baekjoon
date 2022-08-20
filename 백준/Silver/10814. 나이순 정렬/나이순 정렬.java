import java.util.*;


public class Main {

    static int[] arr;
    static boolean[] check;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Person(age, name));
        }
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p);
        }
    }
}

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
