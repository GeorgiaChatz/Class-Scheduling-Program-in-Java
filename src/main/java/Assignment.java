
import java.util.ArrayList;
import java.io.*;
import java.util.*;
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107

public class Assignment {

	ArrayList<Course> lessons;
	ArrayList<Teacher> teachers;
    ArrayList<Pairs> available_pairs;
    int number_of_days;
    int number_of_hours;
    ArrayList <ArrayList <Slot>> _A, _B,_C;

    void print() {

    	System.out.println("A Taxi");

    	for (int i=0; i<_A.get(0).size() ;i++){
    		for (int j=0; j<_A.size(); j++){
				if (i==0){
					System.out.println((i+1)+"st Hour of Day:"+(j+1));
				}
				if (i==1){
					System.out.println((i+1)+"nd Hour of Day:"+(j+1));
				}
				if (i==2){
					System.out.println((i+1)+"rd Hour of Day:"+(j+1));
				}
				if (i>2 && i<6){
					System.out.println((i+1)+"th Hour of Day:"+(j+1));
				}
    			Course less = _A.get(j).get(i).getPair().getCourse();
    			Teacher teach = _A.get(j).get(i).getPair().getTeacher();

				System.out.println(less.getCourseName()+ " By: "+teach.getTeacherName()+ " || ");

			}
			System.out.print("\n");
    	}

	System.out.print("\n");
    System.out.println("B Taxi");

	for (int i=0; i<_B.get(0).size() ;i++){
		for (int j=0; j<_B.size(); j++){
			if (i==0){
				System.out.println((i+1)+"st Hour of Day:"+(j+1));
			}
			if (i==1){
				System.out.println((i+1)+"nd Hour of Day:"+(j+1));
			}
			if (i==2){
				System.out.println((i+1)+"rd Hour of Day:"+(j+1));
			}
			if (i>2 && i<6){
				System.out.println((i+1)+"th Hour of Day:"+(j+1));
			}
			Course less = _B.get(j).get(i).getPair().getCourse();
			Teacher teach = _B.get(j).get(i).getPair().getTeacher();

			System.out.println("Course: "+less.getCourseName()+ " Teacher: "+teach.getTeacherName()+ " || ");
		}
		System.out.print("\n");
	}

	System.out.print("\n");
	System.out.println("C Taxi");

		for (int i=0; i<_C.get(0).size() ;i++){
			for (int j=0; j<_C.size(); j++){
				if (i==0){
					System.out.println((i+1)+"st Hour of Day:"+(j+1));
				}
				if (i==1){
					System.out.println((i+1)+"nd Hour of Day:"+(j+1));
				}
				if (i==2){
					System.out.println((i+1)+"rd Hour of Day:"+(j+1));
				}
				if (i>2 && i<6){
					System.out.println((i+1)+"th Hour of Day:"+(j+1));
				}
					Course less = _C.get(j).get(i).getPair().getCourse();
					Teacher teach = _C.get(j).get(i).getPair().getTeacher();

					System.out.println("Course: "+less.getCourseName()+ " Teacher: "+teach.getTeacherName()+ " || ");
			}
			System.out.print("\n");
		}

}
     void arxikopoiisi_Arrays(){
    	    _A = new ArrayList<ArrayList <Slot>>();
    	    _B = new ArrayList<ArrayList <Slot>>();
    	    _C = new ArrayList<ArrayList <Slot>>();

    	    for (int i=0; i<number_of_days; i++){
						_A.add(new ArrayList<Slot>());
						_B.add(new ArrayList<Slot>());
						_C.add(new ArrayList<Slot>());
						for(int j=0;j<number_of_hours;j++){
							_A.get(i).add(new Slot());
							_B.get(i).add(new Slot());
							_C.get(i).add(new Slot());
						}
    	    }
			this.Creation_Metopou_anazitisis(_A,_B,_C);
     }

	 void Creation_Metopou_anazitisis(ArrayList <ArrayList <Slot>> _A,ArrayList <ArrayList <Slot>> _B,ArrayList <ArrayList <Slot>> _C){

			for  (int i=0; i<_A.size(); i++){
				for (int j=0; j<_A.get(i).size(); j++){
					_A.get(i).get(j).metopo_anazitisis = new ArrayList<Pairs>();
					_B.get(i).get(j).metopo_anazitisis = new ArrayList<Pairs>();
					_C.get(i).get(j).metopo_anazitisis = new ArrayList<Pairs>();
				}
			}
			for (int i=0; i<available_pairs.size(); i++){
				int lesson_id = available_pairs.get(i).getCourse().getCourseCode();
       			boolean match = false;
        		for (int less=0; less<lessons.size(); less++){
       			   if (lessons.get(less).getCourseCode()==lesson_id){
         		   match = true;
					break;
          			}
       			}
				if(match == false)
					continue;

				if (available_pairs.get(i).getCourse().getTaxi()==0){
					for (int j=0; j<_A.size(); j++){
						for (int k=0; k<_A.get(j).size(); k++){
							_A.get(j).get(k).metopo_anazitisis.add(available_pairs.get(i));
						}
					}

				}else if (available_pairs.get(i).getCourse().getTaxi()==1){
					for (int j=0; j<_B.size(); j++){
						for (int k=0; k<_B.get(j).size(); k++){
							_B.get(j).get(k).metopo_anazitisis.add(available_pairs.get(i));
						}
					}

				}else if (available_pairs.get(i).getCourse().getTaxi()==2){
					for (int j=0; j<_C.size(); j++){
						for (int k=0; k<_C.get(j).size(); k++){
							_C.get(j).get(k).metopo_anazitisis.add(available_pairs.get(i));
						}
					}
				}  //END IF
			} //END FOR
	 } //END Creation_Metopou_anazitisis

	 void arxikopoiisi_Arrays (ArrayList<Course> lessons , ArrayList <Teacher> teachers , ArrayList <Pairs> pairs, int days, int hours){
			this.lessons = lessons;
			this.teachers = teachers;
			this.available_pairs = pairs;
			this.number_of_days = days;
			this.number_of_hours = hours;
			arxikopoiisi_Arrays();

	 } //END void Arxikopoiisi_Arrays

	 final int selectUnassignedVariable(){
		//1st for
		for (int k=0; k<_A.size();k++){
			for(int l=0; l<_A.get(k).size(); l++){
				if ((_A.get(k).get(l).getPair().getCourse().getCourseCode() == -1) || (_A.get(k).get(l).getPair().getTeacher().getTeacherCode() == -1) ){
					return k*_A.get(0).size() + l;
				} //END if

			}

		}
		//2nd for
		for (int k=0; k<_B.size();k++){
			for(int l=0; l<_B.get(k).size(); l++){
				if ((_B.get(k).get(l).getPair().getCourse().getCourseCode() == -1) || (_B.get(k).get(l).getPair().getTeacher().getTeacherCode() == -1) ){
					return  k*_B.get(0).size() + l + _A.size() * _A.get(0).size();
				} //END if

			}

		}
		//3rd for
		for (int k=0; k<_C.size();k++){
			for(int l=0; l<_C.get(k).size(); l++){
				if ((_C.get(k).get(l).getPair().getCourse().getCourseCode() == -1) || (_C.get(k).get(l).getPair().getTeacher().getTeacherCode() == -1) ){
					return k*_C.get(0).size() + l + _B.size()* _B.get(0).size() + _A.size() * _A.get(0).size();
				} //END if

			}

		}
		return -1;
	 } //END selectUnassigned

	 final ArrayList<Pairs> getPossibleValues(int index){
		//1st if
		if (index< _A.size() * _A.get(0).size()){
			int k = index /  _A.get(0).size();
			int l = index -  _A.get(0).size() * k; //upoloipo
			return _A.get(k).get(l).getValuesOfMetopoAnazitisis();
		}//end if
		index -= _A.size() * _A.get(0).size();

		//2nd if
		if (index< _B.size() * _B.get(0).size()){
			int k = index /  _B.get(0).size();
			int l = index -  _B.get(0).size() * k; //upoloipo
			return _B.get(k).get(l).getValuesOfMetopoAnazitisis();
		}//end if
		index -= _B.size() * _B.get(0).size();

		//3rd if
		if (index< _C.size() * _C.get(0).size()){
			int k = index /  _C.get(0).size();
			int l = index -  _C.get(0).size() * k; //upoloipo
			return _C.get(k).get(l).getValuesOfMetopoAnazitisis();
		}//end if

		return new ArrayList<Pairs>();
	 }// END getPossibleValues

	 final int checkConstraints(){
		return checkTeachers() + checkLessons() + checkFeasibility();
	 } //END checkConstraints

	 final int checkTeachers() {
		int constraints_violated = 0;

		for (int t=0; t<teachers.size(); t++){
			Teacher current_teach = teachers.get(t);
			int week_hours = 0;
//for A
			for(int i=0; i<_A.size();i++){
				int hours=0;
				for (int j=0; j<_A.get(i).size(); j++){
					if (_A.get(i).get(j).getPair().getTeacher().getTeacherCode() == current_teach.getTeacherCode()){
						week_hours++;
						hours++;
					}//end if
				}//endfor1
				if (hours > current_teach.getHoursPerDay()){
					constraints_violated ++;
				}//end if2
			}//endfor2
//for B
			for(int i=0; i<_B.size();i++){
				int hours=0;
				for (int j=0; j<_B.get(i).size(); j++){
					if (_B.get(i).get(j).getPair().getTeacher().getTeacherCode() == current_teach.getTeacherCode()){
						week_hours ++;
						hours++;
					}//end if
				}//endfor1
				if (hours > current_teach.getHoursPerDay()){
					constraints_violated ++;
				}//end if2
			}//endfor2
//for C
			for(int i=0; i<_C.size();i++){
				int hours=0;
				for (int j=0; j<_C.get(i).size(); j++){
					try{
						if (_C.get(i).get(j).getPair().getTeacher().getTeacherCode() == current_teach.getTeacherCode()){
							week_hours++;
							hours++;
						}
					}catch (NullPointerException e){}

				}//endfor1
				if (hours > current_teach.getHoursPerDay()){
					constraints_violated ++;
				}//end if2
			}//endfor2
		}//endfor
		return constraints_violated;
	 }

	 final int checkLessons(){
		int constraints_violated = 0;
		for (int c=0; c<lessons.size(); c++){
			Course current_cour = lessons.get(c);
			int hours = 0;
			//for A
			for (int i=0; i<_A.size();i++){
				for (int j=0; j<_A.get(i).size(); j++){
					if (_A.get(i).get(j).getPair().getCourse().getCourseCode() == current_cour.getCourseCode()){
						hours++;
					}//end if
				}//end inner A for
			}//end A for
			//for B
			for (int i=0; i<_B.size();i++){
				for (int j=0; j<_B.get(i).size(); j++){
					if (_B.get(i).get(j).getPair().getCourse().getCourseCode() == current_cour.getCourseCode()){
						hours++;
					}//end if
				}//end inner B for
			}//end B for
			//for C
			for (int i=0; i<_C.size();i++){
				for (int j=0; j<_C.get(i).size(); j++){
					try{
							if (_C.get(i).get(j).getPair().getCourse().getCourseCode() == current_cour.getCourseCode()){
								hours++;
							}//end if
						}catch(NullPointerException e){

						}
				}//end inner C for
			}//end C for
			if (hours> current_cour.getCourseHours()){
				constraints_violated++;
			}
		}//end for
		return constraints_violated;
	 }//END checkLessons

	 final int checkFeasibility(){
		 int constraints_violated = 0;
			for (int i=0; i<_A.size();i++){
				for (int j=0; j<_A.get(i).size(); j++){
				// A & B
					try{
							if ( (_A.get(i).get(j).getPair().getCourse().getCourseCode() >=0 ) && (_B.get(i).get(j).getPair().getCourse().getCourseCode() >=0) && (_A.get(i).get(j).getPair().getCourse().getCourseCode()  == _B.get(i).get(j).getPair().getCourse().getCourseCode()) ){
								constraints_violated++;
							}//end if
							if ( (_A.get(i).get(j).getPair().getTeacher().getTeacherCode() >=0 ) && (_B.get(i).get(j).getPair().getTeacher().getTeacherCode() >=0) && (_A.get(i).get(j).getPair().getTeacher().getTeacherCode()  == _B.get(i).get(j).getPair().getTeacher().getTeacherCode()) ){
								constraints_violated++;
							}//end if

						// A & C
							if ( (_A.get(i).get(j).getPair().getCourse().getCourseCode() >=0 ) && (_C.get(i).get(j).getPair().getCourse().getCourseCode() >=0) && (_A.get(i).get(j).getPair().getCourse().getCourseCode()  == _C.get(i).get(j).getPair().getCourse().getCourseCode()) ){
								constraints_violated++;
							}//end if
							if ( (_A.get(i).get(j).getPair().getTeacher().getTeacherCode() >=0 ) && (_C.get(i).get(j).getPair().getTeacher().getTeacherCode() >=0) && (_A.get(i).get(j).getPair().getTeacher().getTeacherCode()  == _C.get(i).get(j).getPair().getTeacher().getTeacherCode()) ){
								constraints_violated++;
							}//end if
						// B & C
							if ( (_B.get(i).get(j).getPair().getCourse().getCourseCode() >=0 ) && (_C.get(i).get(j).getPair().getCourse().getCourseCode() >=0) && (_B.get(i).get(j).getPair().getCourse().getCourseCode()  == _C.get(i).get(j).getPair().getCourse().getCourseCode()) ){
								constraints_violated++;
							}//end if
							if ( (_B.get(i).get(j).getPair().getTeacher().getTeacherCode() >=0 ) && (_C.get(i).get(j).getPair().getTeacher().getTeacherCode() >=0) && (_B.get(i).get(j).getPair().getTeacher().getTeacherCode()  == _C.get(i).get(j).getPair().getTeacher().getTeacherCode()) ){
								constraints_violated++;
							}//end if
						}catch (NullPointerException e){
						}
				}//end inner for
			}//end for
		return constraints_violated;
	 }//END  checkFeasibility

	 final boolean isComplete(){
		for (int k=0; k<_A.size();k++){
			for(int l=0; l<_A.get(k).size(); l++){
				if ((_A.get(k).get(l).getPair().getCourse().getCourseCode()  == -1 ) || (_A.get(k).get(l).getPair().getTeacher().getTeacherCode() == -1 ) ){
					return false;
				}//end if
			}//end inner for
		}//end forA

		for (int k=0; k<_B.size();k++){
			for(int l=0; l<_B.get(k).size(); l++){
				if ((_B.get(k).get(l).getPair().getCourse().getCourseCode()  == -1 ) || (_B.get(k).get(l).getPair().getTeacher().getTeacherCode() == -1 ) ){
					return false;
				}//end if
			}//end inner for
		}//end forB
		for (int k=0; k<_C.size();k++){
			for(int l=0; l<_C.get(k).size(); l++){
				try{
					if ((_C.get(k).get(l).getPair().getCourse().getCourseCode()  == -1 ) || (_C.get(k).get(l).getPair().getTeacher().getTeacherCode() == -1 ) ){
						return false;
					}//end if
				}catch (NullPointerException e){}
			}//end inner for
		}//end forC
		return true;
	 }//END isComplete

	 void addPair(int index,Pairs pair){

			if (index<_A.size() * _A.get(0).size()){
				int k = index / _A.get(0).size();
				int l = index - _A.get(0).size() * k;
				_A.get(k).get(l).setPairs(pair);
				return;
			}//end if
			index -=_A.size()*_A.get(0).size();
			//B
			if (index<_B.size() * _B.get(0).size()){
				int k = index / _B.get(0).size();
				int l = index - _B.get(0).size() * k;
				_B.get(k).get(l).setPairs(pair);
				return;
			}//end if
			index -=_B.size()*_B.get(0).size();
			//C
			if (index<_C.size() * _C.get(0).size()){
				int k = index / _C.get(0).size();
				int l = index - _C.get(0).size() * k;
				_C.get(k).get(l).setPairs(pair);
			}//end if
	 }//END addPair

	void removeVar(int index){

			//A
				if (index<_A.size() * _A.get(0).size()){
					int k = index / _A.get(0).size();
					int l = index - _A.get(0).size() * k; //upoloipo
					_A.get(k).get(l).setPairs(null);
					return;
				}//end if
				index -=_A.size()*_A.get(0).size();
			//B
				if (index<_B.size() * _B.get(0).size()){
					int k = index / _B.get(0).size();
					int l = index - _B.get(0).size() * k;
					_B.get(k).get(l).setPairs(null);
					return;
				}//end if
				index -=_B.size()*_B.get(0).size();
			//C
				if (index<_C.size() * _C.get(0).size()){
					int k = index / _C.get(0).size();
					int l = index - _C.get(0).size() * k;
					_C.get(k).get(l).setPairs(null);
				}//end if   */
	}//END removeVar
}
