package snippet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		int choice;

		do {

			System.out.println("\n===== Student Management System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Display Students");
			System.out.println("3. Search Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Update Student");
			System.out.println("6. Exit");
			System.out.print("Choose: ");

			choice = input.nextInt();

			switch (choice) {

			// ===================== ADD STUDENT =====================
			case 1:

				System.out.print("Enter ID: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("Enter Name: ");
				String name = input.nextLine();
				System.out.print("Enter Age: ");
				int age = input.nextInt();
				students.add(new Student(id, name, age));
				System.out.println("Student added successfully!");
				break;

			// ===================== DISPLAY STUDENTS =====================
			case 2:

				if (students.isEmpty()) {
					System.out.println("No students found.");
				} else {
					System.out.println("\n===== Students List =====");
					for (Student st : students) {
						System.out.println("ID: " + st.id + " | Name: " + st.name + " | Age: " + st.age);
					}
				}

				break;

			// ===================== SEARCH STUDENT =====================
			case 3:

				System.out.print("Enter Student ID: ");
				int searchId = input.nextInt();

				boolean found = false;

				for (Student st : students) {

					if (st.id == searchId) {

						System.out.println("\nStudent Found:");
						System.out.println("ID: " + st.id);
						System.out.println("Name: " + st.name);
						System.out.println("Age: " + st.age);

						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("Student not found!");
				}

				break;

			// ===================== DELETE STUDENT =====================
			case 4:

				System.out.print("Enter Student ID to delete: ");
				int deleteId = input.nextInt();
				boolean deleted = false;
				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).id == deleteId) {
						students.remove(i);
						System.out.println("Student deleted successfully!");
						deleted = true;
						break;
					}
				}
				if (!deleted) {
					System.out.println("Student not found!");
				}
				break;
			// ===================== UPDATE STUDENT =====================
			case 5:

				System.out.print("Enter Student ID to update: ");
				int updateId = input.nextInt();
				input.nextLine();
				boolean updated = false;
				for (Student st : students) {
					if (st.id == updateId) {
						System.out.print("Enter New Name: ");
						st.name = input.nextLine();
						System.out.print("Enter New Age: ");
						st.age = input.nextInt();
						System.out.println("Student updated successfully!");
						updated = true;
						break;
					}
				}
				if (!updated) {
					System.out.println("Student not found!");
				}
				break;
			// ===================== EXIT =====================
			case 6:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 6);

		input.close();
	}
}
