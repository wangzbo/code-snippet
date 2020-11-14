private final int[] dx = {0,0,-1,1};
private final int[] dy = {1,-1,0,0};
    
//is there a valid path when starting to search from position (r,c)
public boolean isThereAPath(int [][] matrix, boolean [][] flags,int r, int c, ArrayList<String> path) {
    if(matrix.length == 0 || matrix[0].length == 0)
        return false;
    //mark at current position
    path.add(r + "," + c);
    flags[r][c] = true;
    //arriving at the terminal
    if(r == matrix.length - 1 && c == matrix[0].length - 1)
        return true;
    for(int i = 0; i < 4; i++) {	
    		if(r+dx[i] >=0 && r+dx[i] < matrix.length && c+dy[i] >= 0 && c+dy[i] < matrix[0].length 
            && !flags[r+dx[i]][c+dy[i]] && matrix[r+dx[i]][c+dy[i]] == 0 
            && isThereAPath(matrix, flags, r+dx[i], c+dy[i], path)) 
    	      return true;
    }
    //no valid path when starting to search from position (r,c)
    path.remove(path.size()-1);
    flags[r][c] = false;
    return false;
}
    
public static void main(String args[]) {

    //  0-0 0 1 0 1
    //    |
    //  1 0 1 0-0-0
    //    |   |   |
    //  0-0 1 0 1 0
    //  |     |   |
    //  0 1 0-0 1 0
    //  |   |     |
    //  0-0-0 1 0 0
    //
    int [][] matrix = {{0,0,0,1,0,1},{1,0,1,0,0,0},{0,0,1,0,1,0},{0,1,0,0,1,0},{0,0,0,1,0,0}};
    boolean [][] flags = new boolean[matrix.length][matrix[0].length];
    ArrayList<String> path = new ArrayList<String>();
    System.out.println(isThereAPath(matrix, flags, 0, 0, path));
    System.out.println(path);
}
