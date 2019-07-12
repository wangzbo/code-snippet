//There are 10 glasses of water and 2 of them are posionous. How many mouses at least needed to test out the poisonous water for only 
//one experiment.
//Solution: Assume the ten glasses of water are from 1 to 10. Layout the 1-9 glasses of water as a 3*3 matrix:
//   
//   1    2    3
//   4    5    6
//   7    8    9
//
//Use 3 mouses to drink the water in each row, another 3 to drink the water in each column, the last one mouse to drink the diagonal 
//1,5,9. Finally, according to which mouses are dead, we can know which 2 glasses of water are poisonous.
//Given the dead mouse numbers, output the poisonous water numbers

private HashMap<Integer, ArrayList<Integer>> mousePoisonMap = new HashMap<Integer, ArrayList<Integer>>();

public void buildMousePoisonMap() {
	int[][] poisonArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	ArrayList<ArrayList<Integer>> poisonMouseList = new ArrayList<ArrayList<Integer>>();
	for (int i = 0; i < poisonArray.length * poisonArray[0].length; i++) {
		poisonMouseList.add(new ArrayList<Integer>());
	}
	for (int i = 0; i < poisonArray.length; i++) {
		for (int j = 0; j < poisonArray[0].length; j++) {
			poisonMouseList.get(poisonArray[i][j] - 1).add(i + 1);
			poisonMouseList.get(poisonArray[i][j] - 1).add(j + poisonArray.length + 1);
		}
	}
	for (int i = 0; i < poisonArray.length; i++) {
		poisonMouseList.get(poisonArray[i][i] - 1).add(poisonArray.length + poisonArray[0].length + 1);
	}

	for (int i = 0; i < poisonMouseList.size(); i++) {
		int sum = 0;
		for (Integer itg : poisonMouseList.get(i)) {
			sum += (1 << (itg.intValue() - 1));
		}
		ArrayList<Integer> poisonCombine = new ArrayList<Integer>();
		poisonCombine.add(i + 1);
		poisonCombine.add(poisonArray.length * poisonArray[0].length + 1);
		mousePoisonMap.put(sum, poisonCombine);
	}
	for (int i = 0; i < poisonMouseList.size() - 1; i++) {
		for (int j = i + 1; j < poisonMouseList.size(); j++) {
			HashSet<Integer> mouseSet = new HashSet<Integer>();
			mouseSet.addAll(poisonMouseList.get(i));
			mouseSet.addAll(poisonMouseList.get(j));
			int sum = 0;
			for (Integer itg : mouseSet) {
				sum += (1 << (itg.intValue() - 1));
			}
			ArrayList<Integer> poisonCombine = new ArrayList<Integer>();
			poisonCombine.add(i + 1);
			poisonCombine.add(j + 1);
			mousePoisonMap.put(sum, poisonCombine);
		}
	}
}
	
public ArrayList<Integer> getPoisonNum(ArrayList<Integer> deadMouse){
	int sum = 0;
	for(Integer itg : deadMouse) {
		sum += (1 << (itg.intValue() - 1));
	}
	return mousePoisonMap.get(sum);
}
