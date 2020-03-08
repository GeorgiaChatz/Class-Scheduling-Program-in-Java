
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107
public class Teacher  {

	private int teacher_code;
	private String teacher_name;
    private int[] teacher_courses;
	private int hours_per_day;
	private int hours_per_week;

	public Teacher(){
		this.teacher_code = -1;
	}


	public Teacher(int teacher_code,String teacher_name,int[] teacher_courses,int hours_per_day,int hours_per_week){
		this.teacher_code=teacher_code;
		this.teacher_name=teacher_name;
        this.teacher_courses=teacher_courses;
		this.hours_per_day=hours_per_day;
		this.hours_per_week=hours_per_week;

	}

	public int getTeacherCode(){
		return teacher_code;
	}

	public void setTeacherCode(int teacher_code){
		this.teacher_code=teacher_code;
	}

	public String getTeacherName(){
		return teacher_name;
	}

	public void setTeacherName(String teacher_name){
		this.teacher_name=teacher_name;
	}

    public void setTeacherCourses(int [] teacher_courses){
		this.teacher_courses=teacher_courses;
	}

	public int[] getTeacherCourses(){
		return teacher_courses;
	}


	public int getHoursPerDay(){
		return hours_per_day;
	}

	public void setHoursPerDay(int hours_per_day){
		this.hours_per_day=hours_per_day;
	}

	public int getHoursPerWeek(){
		return hours_per_week;
	}

	public void setHoursPerWeek(int hours_per_week){
		this.hours_per_week=hours_per_week;
	}

}
