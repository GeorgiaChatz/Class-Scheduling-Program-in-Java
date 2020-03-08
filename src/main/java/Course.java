
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107
public class Course {


	private int course_code;
	private String course_name;
	private int hours_per_week;
	private int taxi;

	public Course(){
		this.course_code = -1;
	}

	public Course(int course_code, String course_name,int taxi,int hours_per_week){

		this.course_code=course_code;
		this.course_name=course_name;
		
		this.hours_per_week=hours_per_week;
		this.taxi = taxi;

	}

	public void setCourseName(String course_name){
		this.course_name=course_name;
	}

	public String getCourseName(){
		return course_name;
	}

	public void setCourseCode(int course_code){
		this.course_code=course_code;
	}

	public int getCourseCode(){
		return course_code;
	}



	public void setCourseHours(int hours){
		hours_per_week=hours;
	}

	public int getCourseHours(){
		return hours_per_week;
	}


	public void setTaxi(int taxi){
		this.taxi = taxi;
	}

	public int getTaxi(){
		return taxi;
	}


}
