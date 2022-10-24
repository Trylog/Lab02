//Michał Bernacki-Janson 264021
//projekt działa w InteliJ ale nie wiem dlaczego nie można go uruchomić poprawnie z lini poleceń
package pkgMain;
import pkgTools.FileInput;
import pkgTools.Optimization;

public class Main {
	public static void main(String[] args){
		//System.out.println("Hello World!");
		FileInput input = new FileInput();
		Optimization opt=new Optimization();
		for (int i=0;i<3;i++){
			System.out.print(i+": ");
			FileInput.Persons.get(i).printResults();
		}

	}
}
