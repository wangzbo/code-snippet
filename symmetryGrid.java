//Given 4*4 grid, pick up 4 cells and paint them to black. How many ways to generate an axial symmetry grid?

	public static ArrayList<Integer> comp_list = new ArrayList<Integer>();
	public static int sysmetryCnt = 0;
	
	public static void dfs_compose(int start, int end) {
		for(int i = start; i < end; i++) {
			comp_list.add(i);
			if(comp_list.size() == 4)
		            check_comp_list();
			else
			    dfs_compose(i+1, end+1);
			comp_list.remove(comp_list.size()-1);
		}
	}

	public static void check_comp_list() {
		ArrayList<Integer> x_sysmetry_list = new ArrayList<Integer>();
		ArrayList<Integer> y_sysmetry_list = new ArrayList<Integer>();
		ArrayList<Integer> diag_sysmetry_list = new ArrayList<Integer>();
		ArrayList<Integer> rdiag_sysmetry_list = new ArrayList<Integer>();
		for(Integer num : comp_list) {
			int i = num/4;
			int j = num%4;
			x_sysmetry_list.add((3-i)*4+j);
			y_sysmetry_list.add(i*4+(3-j));
			diag_sysmetry_list.add(4*j+i);
			rdiag_sysmetry_list.add(4*(3-j)+(3-i));		
		}
		if(check_axis_sysmetry(x_sysmetry_list) || check_axis_sysmetry(y_sysmetry_list) 
				|| check_axis_sysmetry(diag_sysmetry_list) || check_axis_sysmetry(rdiag_sysmetry_list))
			sysmetryCnt++;
	}
	
	public static boolean check_axis_sysmetry(ArrayList<Integer> sysmetry_list) {
		for(int i = 0 ; i < sysmetry_list.size(); i++) {
			if(!comp_list.contains(sysmetry_list.get(i))) {
				return false;
			}
		}
		return true;
	}
  
  public static void main(String[] args){
      dfs_compose(0,13);
      System.out.println(sysmetryCnt);
  }
  
  
