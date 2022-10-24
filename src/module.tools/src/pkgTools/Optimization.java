package pkgTools;

import pkgData.Person;

import java.util.ArrayList;
import java.util.List;

public class Optimization {

	public Optimization() {
		List<Integer> tempTab = new ArrayList<>();
		int maxFlaveTabDepth=0;
		for (Person p: FileInput.Persons) {
			if(maxFlaveTabDepth<p.favoriteFlavors.size())maxFlaveTabDepth=p.favoriteFlavors.size();
		}


		for (int p = 0; p < FileInput.Persons.size(); p++) {
			for (int i = 0; i < FileInput.getJugsListSize(); i++) {
				if (FileInput.Persons.get(p).favoriteFlavors.get(0) == FileInput.getJug(i).getTasteId() && FileInput.getJug(i).getVolume() >= 400) {
					FileInput.Persons.get(p).addDrink(0, 400);
					FileInput.subtractJug(i, 400);
					FileInput.setBestDestination(i,p);
					break;
				}
			}
			if (FileInput.Persons.get(p).drinks.get(0) == 0) tempTab.add(p);
		}
		for (int r = 0; r < tempTab.size(); r++) {
			for (int i = 0; i < FileInput.getJugsListSize(); i++) {
				if (FileInput.Persons.get(tempTab.get(r)).favoriteFlavors.get(0) == FileInput.getJug(i).getTasteId() && FileInput.getJug(i).getVolume() > 0) {
					FileInput.Persons.get(tempTab.get(r)).addDrink(0, FileInput.getJug(i).getVolume());
					FileInput.subtractJug(i, FileInput.getJug(i).getVolume());
					FileInput.setBestDestination(i,tempTab.get(r));
					tempTab.remove(tempTab.get(r));
					break;
				}
			}
		}
		if(!tempTab.isEmpty()){
			for (int j=1;j<maxFlaveTabDepth;j++){
				for (int r = 0; r < tempTab.size(); r++) {
					for (int i = 0; i < FileInput.getJugsListSize(); i++) {
						if (FileInput.Persons.get(tempTab.get(r)).favoriteFlavors.get(j) == FileInput.getJug(i).getTasteId() && FileInput.getJug(i).getVolume() > 0) {
							FileInput.Persons.get(tempTab.get(r)).addDrink(j, 1);
							FileInput.subtractJug(i, 1);
							FileInput.setBestDestination(i,tempTab.get(r));
							tempTab.remove(tempTab.get(r));
							break;
						}
					}
				}
				if(tempTab.isEmpty())break;
			}
		}
		if(!tempTab.isEmpty()){
			for (int j=0;j<maxFlaveTabDepth;j++){
				for (int r = 0; r < tempTab.size(); r++) {
					for (int i = 0; i < FileInput.getJugsListSize(); i++) {
						if(FileInput.Persons.get(tempTab.get(r)).favoriteFlavors.get(j) == FileInput.getJug(i).getTasteId()&&FileInput.getBestDestination(i)!=-1) {
							FileInput.Persons.get(FileInput.getBestDestination(i)).addDrink(FileInput.Persons.get(FileInput.getBestDestination(i)).favoriteFlavors.indexOf(FileInput.getJug(i).getTasteId()),-1);
							FileInput.Persons.get(tempTab.get(r)).addDrink(j,1);
							tempTab.remove(tempTab.get(r));
							break;
						}
					}
				}
				if(tempTab.isEmpty())break;
			}
		}
		for (int i =0;i<FileInput.getJugsListSize();i++){
			if(FileInput.getJug(i).getVolume()!=0)FileInput.Persons.get(FileInput.getBestDestination(i)).addDrink(FileInput.Persons.get(FileInput.getBestDestination(i)).favoriteFlavors.indexOf(FileInput.getJug(i).getTasteId()) ,FileInput.getJug(i).getVolume());
		}

	}
}
