
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107
public class Pairs  {

	
	private Teacher teacher;
	private Course course;

	public Pairs(){
		teacher = new Teacher();
		course = new Course();
	}
	
	
	public Pairs(Teacher teacher,Course course){
		this.teacher=teacher;
		this.course=course;
	}
	
	public Teacher getTeacher(){
		return teacher;
	}
	
	public void setTeacher(Teacher teacher){
		this.teacher=teacher;
	}
	
	public Course getCourse(){
		return course;
	}
	
	public void setCourse(Course course){
		this.course=course;
	}
	
    public void pairToString(Pairs pair){
    	System.out.println("Course: " +pair.getCourse().getCourseName()+ " Teacher : "+pair.getTeacher().getTeacherName());
    }
	
}