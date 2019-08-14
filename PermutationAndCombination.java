    public void permutation(int []arr,int start,int end) {
        if (start==end) {
            System.out.println(Arrays.toString(arr));
        }
        else {
            for(int i=start;i<end;i++) {
                swap(arr, start, i);
                permutation(arr, start+1, end);
                swap(arr, start, i);
            }
        }
    }
    public void swap(int []arr,int start,int end) {
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }

    
    private ArrayList<Integer> composition = new ArrayList<Integer>();
    public void combination(int []arr,int start,int end, int n) {
    	if(n == 0) 
    		System.out.println(composition);
    	else {
    		for(int i = start; i <= end - n; i++) {
    			composition.add(arr[i]);
    			combination(arr,i+1,end,n-1);
    			composition.remove(composition.size()-1);
    		}
    	}
    }

    public void combination(int [] arr) {
        for(int i = 0; i <= arr.length; i++) {
        	combination(arr,0,arr.length,i);
        }
    }
    
