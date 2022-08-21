import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SerialNumber> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new SerialNumber(sc.next()));
        }
        Collections.sort(list);
        for (SerialNumber num : list) {
            System.out.println(num.name);
        }
    }
}

class SerialNumber implements Comparable<SerialNumber> {
    int length;
    int sum;
    String name;

    public SerialNumber(String name) {
        this.name = name;
        this.length = name.length();
        calSum();
    }

    private void calSum() {
        for (Character c : name.toCharArray()) {
            if ('1' <= c && c <= '9') sum += c - '0';
        }
    }

    @Override
    public int compareTo(SerialNumber o) {
        if (length != o.length) return length - o.length;
        else if (sum != o.sum) return sum - o.sum;
        return name.compareTo(o.name);
    }
}