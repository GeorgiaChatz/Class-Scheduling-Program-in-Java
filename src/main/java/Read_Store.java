import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107

public class Read_Store {

	private static ArrayList<Course> courses;
    private static ArrayList<Teacher> teachers;
	private static ArrayList<Pairs> pairs;
	private String lesson_path;
	private String teacher_path;
	
	
	
	  public Read_Store(String lesson_path,String teacher_path,ArrayList<Course> courses,ArrayList<Teacher> teachers,ArrayList<Pairs> pairs){
		this.lesson_path=lesson_path;
		this.teacher_path=teacher_path;  
		this.courses=courses;
		  this.teachers=teachers;
		  this.pairs=pairs;

	  }
		
		public Read_Store r_sMethod(Read_Store object){

		
		Teacher t_Object; 
		Course  c_Object;
		
		
		courses = new ArrayList<Course>();
        teachers = new ArrayList<Teacher>();
        pairs = new ArrayList<Pairs>();
		
		
		String t_name;//temporary teacher name
		int t_code;//temporary teacher code
		int t_hpd;//temporary teacher hours per day
		int t_hpw;//temporary teacher hours per week
		
		String c_name;//temporary course name
		int c_code;//temporary course code
		int c_class;//temporary course class
		int c_hours;//temporary course hours
		
		File f_teachers = new File(teacher_path);
		File f_lessons = new File(lesson_path);
		int num;//number of tokens
		String []split=null;
		String line1;//used for tokenizing
		String line2;//used for tokenizing
		int c_num;//number of courses per teacher
		int [] t_courses;//courses per teacher
		int t=0;//number of teachers
		int c=0;//number of courses
		
	
		try{
			
			if(f_teachers.exists() && f_lessons.exists() && f_teachers.canRead() && f_lessons.canRead()){
			
				
				BufferedReader reader_teachers = new BufferedReader(new FileReader(f_teachers));
				
				BufferedReader reader_lessons = new BufferedReader(new FileReader(f_lessons));
				//int k=0;
			
				while((line1=reader_lessons.readLine())!=null){
 				
				c++;
				num= getNumberTokens(line1);
				
					for(int i=0;i<num+1;i++){
					
						split=line1.split(",");
						
						
				    }
					
					
					
					
					
					c_code=Integer.parseInt(split[0]);

					c_name=(split[1]);

					c_class=Integer.parseInt(split[2]);

					c_hours=Integer.parseInt(split[3]);

					c_Object=new Course(c_code,c_name,c_class,c_hours);				
				  courses.add(c_Object);				
			}
			
			
			System.out.println("While!");
			
			while((line2=reader_teachers.readLine())!=null){
				t++;
				
				num= getNumberTokens(line2);
				
					for(int i=0;i<num+1;i++){
					
						split=line2.split(",");
						
				    }
					
					System.out.println(split.length);
					t_code=Integer.parseInt(split[0]);
					t_name=(split[1]);
					System.out.println("Teacher_name: "+t_name);
					c_num=Integer.parseInt(split[2]);
					t_courses=new int[c_num];
					for(int i=0; i<c_num;i++){
						t_courses[i]=Integer.parseInt(split[3+i]);
					}
					
					t_hpd=Integer.parseInt(split[c_num+3]);
					t_hpw=Integer.parseInt(split[c_num+4]);
					t_Object=new Teacher(t_code,t_name,t_courses,t_hpd,t_hpw);
					
					teachers.add(t_Object);
                    
                    


                    //INITIALLIZING PAIRS
                   
                    int n_courses=0;
                    int code;
                    Course cour=null;
                    Pairs pair;
                    for(int i=0;i<teachers.size();i++){
                     n_courses=teachers.get(i).getTeacherCourses().length;

                        for(int j=0;j<n_courses;j++){
                            code=teachers.get(i).getTeacherCourses()[j];
                            cour=findCourse(code);
                            pair=new Pairs(teachers.get(i),cour);   
                            pairs.add(pair);
                        }
                     
                    }
                   
				
				
			}
				
				
			}else{
				System.out.println("Error, files can 't be read");
				
			}
			
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		return object;
		

		
	}
	
		
		private static int getNumberTokens(String line){
			int num=0;
			for(char c:line.toCharArray()){
				
				if(c==','){
					num++;
				}
			}
			return num+1;
		}
        
        private static Course findCourse(int course_code){
            for(Course c: courses){
              if(c.getCourseCode()==course_code) return c;
            }
            return null;
        }
        
        public ArrayList<Course> getCourses(){
            return courses;
        }

        public ArrayList<Teacher> getTeachers(){
            return teachers;
        }

        public ArrayList<Pairs> getPairs(){
            return pairs;
        }
	
}
