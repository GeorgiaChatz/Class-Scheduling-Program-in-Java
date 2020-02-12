import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Scanner;
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107

public class MainClass {

	public static void main(String[]args) {

		

		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		ArrayList<Pairs> pairs = new ArrayList<Pairs>();


        Scanner input = new Scanner(System.in);
		String lesson_path="";
		String teacher_path="";





		System.out.println("Enter path of teachers file");
		teacher_path=input.next();
		System.out.println("Enter path of lessons file");
		lesson_path=input.next();

		//INITIALIZE COURSES:
		Read_Store read= new Read_Store(lesson_path,teacher_path,courses,teachers,pairs);
		read=read.r_sMethod(read);

		pairs=read.getPairs();
		teachers=read.getTeachers();
		courses=read.getCourses();

			int days =5;
			int hours = 6;
	   		 Assignment initial = new Assignment();
			initial.arxikopoiisi_Arrays(courses , teachers , pairs , days , hours);

			BacktrackingSearch Dfs= new BacktrackingSearch();

			BTReturn success = Dfs.Search(initial);
			if (success.success){
				try{
				success.program.print();
				}catch(NullPointerException e){}
			}else{
					System.out.println("not valid program");
			}//endif
	}
}
