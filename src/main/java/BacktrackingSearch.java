import java.util.ArrayList;

//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107

public class BacktrackingSearch{


	public final BTReturn Search (Assignment assignment) {


		if (assignment.isComplete()){
			System.out.println("Program complete!");
			return new BTReturn(assignment, true);
		}//end if
		int var = assignment.selectUnassignedVariable();
		ArrayList <Pairs> values = new ArrayList <Pairs>();
		if (var>=0){
			values = assignment.getPossibleValues(var);
		}//end if

	for (int i=0; i<values.size(); i++){
		assignment.addPair(var, values.get(i));
		if (assignment.checkConstraints()==0){
		  BTReturn success = Search(assignment);
			if (success.success){
				return success;
			}
		}//end if
		assignment.removeVar(var);	
	}// end for
		return new BTReturn(assignment, false);
	}//end search
}//END  BacktrackingSearch