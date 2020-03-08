
import java.util.ArrayList;
//Georgia Chatzilygeroudi 3150223
//Spiridoula Vlataki 3150012
//Kostantinos Messanakis 3150107

public class Slot  {

	public ArrayList<Pairs> metopo_anazitisis;
	private Pairs pair;


	public Slot(){
		this.pair = new Pairs();
		this.metopo_anazitisis = new ArrayList<Pairs>();
	}

	public Slot(Pairs pair,ArrayList<Pairs> metopo_anazitisis){
		this.pair=pair;
		this.metopo_anazitisis=metopo_anazitisis;
	}

	public Pairs getPair(){
		return pair;
	}

	public ArrayList<Pairs> getValuesOfMetopoAnazitisis(){
		return metopo_anazitisis;
	}

	public void setPairs(Pairs pair){
		this.pair = pair;
	}

}
