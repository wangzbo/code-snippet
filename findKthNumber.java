    public int doPartition(int [] array, int start, int end) {
    	if(start < 0 || end > array.length || start >= end) return 0;
    	int low = start, high = end - 1;
    	int num = array[start];
    	while(low < high) {
    		while(low < high && array[high] <= num)
    			high--;
    		array[low] = array[high];
    		while(low < high && array[low] >= num)
    			low++;	
    		array[high] = array[low];
    	}
    	array[low] = num;
    	return low;
    }
    
    public int findKthNumber(int [] array, int start, int end, int k) {
    	if(k <= 0 || k > array.length) return 0;
    	int partition = doPartition(array, start, end);
    	if(partition == k-1)
    		return array[partition];
    	else if(partition > k-1)
    		return findKthNumber(array, start, partition, k);
    	else
    		return findKthNumber(array, partition+1, end, k);
    }
    
