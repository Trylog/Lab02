package pkgData;
import java.util.ArrayList;
import java.util.List;

public class Person {

	public List<Integer> favoriteFlavors=new ArrayList<>();
	public List<Integer> drinks=new ArrayList<>();
	private int satisfactionIndex;
	public Person(List<Integer> favoriteFlavors){
		this.favoriteFlavors=favoriteFlavors;
		for (int i =0; i<favoriteFlavors.size();i++){
			drinks.add(0);
		}
	}
	public  void addDrink(int id, int volume){
		drinks.set(id, drinks.get(id)+volume);
	}
	public int getSatisfactionIndex(){
		satisfactionIndex=0;
		for (int i = 0;i< drinks.size();i++) {
			satisfactionIndex+=drinks.size()-i+1;
		}
		/*for (Drink drink:drinks) {
			if(drink.id==favoriteFlavors.get(0)) {satisfactionIndex-=Math.max(400-drink.volume, 0);break;}
		}*/
		return satisfactionIndex;
	}
	public void printResults(){
		for(int i =0;i<favoriteFlavors.size();i++){
			System.out.print(favoriteFlavors.get(i) + ", " + drinks.get(i)+" ; ");
		}
		System.out.println();
	}


}
