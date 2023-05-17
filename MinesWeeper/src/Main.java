import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Minesweeper mine = new Minesweeper();
		mine.start();
		mine.print();

		boolean a = true;

		while (a) {
			System.out.print("Enter the line number to open: ");
			int line = scan.nextInt();
			System.out.print("Enter the column number to open: ");
			int column = scan.nextInt();

			if (mine.check(line, column)) {
				System.out.println("Game Over. You Lose...");
				a = false;
			} else {
				mine.print();
			}

		}
	}
}