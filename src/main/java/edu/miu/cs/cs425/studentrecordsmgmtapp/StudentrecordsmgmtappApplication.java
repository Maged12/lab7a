package edu.miu.cs.cs425.studentrecordsmgmtapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

@SpringBootApplication
public class StudentrecordsmgmtappApplication {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");

		Student[] students = {
				new Student("110001", "Dave", dateFormate.parse("11/18/1951")),
				new Student("110002", "Anna", dateFormate.parse("12/07/1990")),
				new Student("110003", "Erica", dateFormate.parse("01/31/1974")),
				new Student("110004", "Carlos", dateFormate.parse("08/22/2009")),
				new Student("110005", "Bob", dateFormate.parse("08/05/1994"))
		};

		printListOfStudents(students);

		List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
		System.out.println("Platinum Alumni Students:");
		for (Student student : platinumAlumni) {
			System.out.println(student);
		}

		printHelloWorld(new Integer[] { 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100 });

		System.out.println("Second biggest number is: " + findSecondBiggest(
				new int[] { 19, 9, 11, 0, 12 }));
	}

	public static void printListOfStudents(Student[] students) {
		Arrays.sort(students, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
		for (Student student : students) {
			System.out.println(student);
		}

	}

	public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
		List<Student> platinumAlumni = new ArrayList<>();
		Date now = new Date();
		for (Student student : students) {
			long years = (now.getTime() - student.getDateOfAdmission().getTime()) / (1000L * 60 * 60 * 24 * 365);
			if (years >= 30) {
				platinumAlumni.add(student);
			}
		}
		platinumAlumni.sort((s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()));
		return platinumAlumni;
	}

	public static void printHelloWorld(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			Integer num = arr[i];
			if (num % 5 == 0 && num % 7 == 0) {
				System.out.println("Hello World");
			} else if (num % 5 == 0) {
				System.out.println("Hello");
			} else if (num % 7 == 0) {
				System.out.println("World");
			}
		}
	}

	public static int findSecondBiggest(int[] numbers) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int number : numbers) {
			if (number > largest) {
				secondLargest = largest;
				largest = number;
			} else if (number > secondLargest && number != largest) {
				secondLargest = number;
			}
		}
		return secondLargest;
	}

}
