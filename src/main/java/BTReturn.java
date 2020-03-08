import java.util.ArrayList;
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107

public class BTReturn {

    public Assignment program;
    public boolean success;

    public BTReturn(Assignment program , boolean success){
        this.program = program;
        this.success = success;
    }
  


   public boolean S ( Assignment program){
      if(program.isComplete()){
        success = true;
      }else{
        success = false;
      }
      return success;
   }

}
