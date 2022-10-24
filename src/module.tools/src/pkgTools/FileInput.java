package pkgTools;

import pkgData.Jug;
import pkgData.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileInput {
	static List<Jug> Jugs = new ArrayList<>();
	public static List<Person> Persons = new ArrayList<>();
	public FileInput(){
		try {
			BufferedReader dzbanki = new BufferedReader(new FileReader("src/resources/dzbanki.txt"));
			BufferedReader osoby = new BufferedReader(new FileReader("src/resources/osoby.txt"));

			String lineDzbanki, lineOsoby;
			boolean isFirstLine1=true, isFirstLine2=true;


			while ((lineDzbanki = dzbanki.readLine()) != null){
				if (!isFirstLine1){
					int taste=0, volume=0;
					int i;
					for ( i = lineDzbanki.indexOf(';')+2;lineDzbanki.charAt(i)!=';';i++){
						taste*=10;
						taste+=(lineDzbanki.charAt(i)-48);
					}
					for (i+=2;i!=lineDzbanki.length();i++){
						if(lineDzbanki.charAt(i)>=48&&lineDzbanki.charAt(i)<=58){
							volume*=10;
							volume+=(lineDzbanki.charAt(i)-48);
						}
					}
					Jugs.add(new Jug(taste,volume));
					//System.out.println(lineDzbanki);
					//System.out.println(taste);
					//System.out.println(volume);
				}else isFirstLine1=false;
			}

			while ((lineOsoby = osoby.readLine()) != null){
				if (!isFirstLine2){
					int i;
					List<Integer> tempFavFlave=new ArrayList<>();
					int temp=0;
					for ( i = lineOsoby.indexOf(';')+1;(i<lineOsoby.length());i++){
						if (lineOsoby.charAt(i)==',')break;
						temp*=10;
						temp+=(lineOsoby.charAt(i)-48);
					}
					tempFavFlave.add(temp);
					temp=0;
					i++;
					while (i<lineOsoby.length()){
						for (;i<lineOsoby.length();i++){
							if (lineOsoby.charAt(i)==',')break;
							temp*=10;
							temp+=(lineOsoby.charAt(i)-48);
						}
						tempFavFlave.add(temp);
						temp=0;
						i++;
					}
					Persons.add(new Person(tempFavFlave));
					//System.out.println(lineOsoby);
					//System.out.println(tempFavFlave);
				}else isFirstLine2=false;
			}
			dzbanki.close();
			osoby.close();
		}catch (Exception e){
			e.getStackTrace();
		}
	}
	public static Jug getJug(int i){return Jugs.get(i);}
	public static int getJugsListSize(){return Jugs.size();}
	public static void subtractJug(int i, int v){Jugs.get(i).subtractVolume(v);}
	public static int getBestDestination(int i) {
		return Jugs.get(i).getBestDestination();}
	public static void setBestDestination(int i, int bestDestination) {
		Jugs.get(i).setBestDestination(bestDestination);}
}
