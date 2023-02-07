import java.util.Scanner;

public class Main {

	static int lightNumber;
	static int[] lights;
	static int studentNumber;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		lightNumber = sc.nextInt();
		lights = new int[lightNumber];
		for (int i = 0; i < lightNumber; i++) {
			lights[i] = sc.nextInt();
		}
		studentNumber = sc.nextInt();
		for (int i = 0; i < studentNumber; i++) {
			int gender = sc.nextInt();
			if (gender == 1) {
				changeBoy(sc.nextInt());
			} else {
				changeGirl(sc.nextInt());
			}
		}

		for (int i = 0; i < lightNumber; i++) {
			System.out.print(lights[i] + " ");
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}

	private static void changeBoy(int number) {
		for (int i = 0; i < lightNumber; i++) {
			if ((i + 1) % number == 0) {
				changeState(i);
			}
		}
	}

	private static void changeGirl(int number) {
		int mid = number - 1;
		changeState(mid);

		int before = mid - 1;
		int after = mid + 1;
		while (0 <= before && after < lightNumber && lights[before] == lights[after]) {
			changeState(before);
			changeState(after);
			before--;
			after++;
		}
	}

	private static void changeState(int idx) {
		if (lights[idx] == 0) {
			lights[idx] = 1;
		} else {
			lights[idx] = 0;
		}
	}
}