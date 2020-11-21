//8名演员表演戏剧，一场至少两人表演，其他人在下面观看。至少表演多少场能保证每名演员都能看到其他演员的表演，输出一些可能组合。

        public static int [][] flags = new int[8][8];
	public static ArrayList<Integer> steps = new ArrayList<Integer>();
	public static ArrayList<Integer> actGroup = new ArrayList<Integer>();
	public static ArrayList<Integer> watchGroup = new ArrayList<Integer>();
	
	public static void search(int step) {
		for(int i = 15; i < 255; i++) {
			steps.add(i);
			if(step == 5) {
				check();
			}else {
				search(step+1);
			}
			steps.remove(steps.size()-1);
		}
	}
	
	public static void check() {
		initializeFlags();
		for(Integer itg : steps) {
			int k = 1;
			for(int i = 0; i < 8; i++) {
				if((itg.intValue() & k) == 0) {
					watchGroup.add(i);
				}else {
					actGroup.add(i);
				}
				k = k<<1;
			}
			updateFlags();
		}
		checkResult();
	}
	
	public static void initializeFlags() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i==j) flags[i][j] = 1;
				else flags[i][j] = 0;
			}	
		}
	}
	
	public static void updateFlags() {
		for(Integer w : watchGroup) {
			for(Integer a : actGroup) {
				flags[w][a] = 1;
			}
		}
		watchGroup.clear();
		actGroup.clear();
	}
	
	public static void checkResult() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(flags[i][j] == 0)
					return;
			}
		}
		for(Integer itg : steps) {
			System.out.print(itg + " ");
		}
		System.out.println();
	}
  
  public static void main(String[] args){
      search(1);
  }
  
  
