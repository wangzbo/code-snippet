int LongestAscSubSeq(int inputArr[], int length, vector<int>& path){
    int max_Len = 0; //the longest sub asc seq length
    int max_len_index = 0; //the last index/position of longest sub asc seq
    int pathChain[length]; //Given the longest sub asc seq end with i-th number in inputArr, pathChain[i] holds the previous index/position for the i-th number
    int maxLengths[length]; //DP, maxLengths[i] holds the longest sub asc seq length end with i-th number in inputArr
    maxLengths[0] = 1;
    pathChain[0] = -1;
    for(int i = 1; i < length; i++){
        int j = 0, pre_max_len = 0;
        while(j < i){
            if(inputArr[j] < inputArr[i] && maxLengths[j] > pre_max_len){
                pre_max_len = maxLengths[j];
                pathChain[i] = j;
            }
            j++;
        }
        if(pre_max_len == 0)
            pathChain[i] = -1; //no previous index
        maxLengths[i] = pre_max_len+1;
        if(maxLengths[i] > max_Len){
            max_Len = maxLengths[i];
            max_len_index = i;//index for the last number of the longest sub asc seq
        }
    }
    /*for(int k = 0; k < length; k++)
        cout<<maxLengths[k]<<" ";
    cout<<endl;

    for(int k1 = 0; k1 < length; k1++)
        cout<<pathChain[k1]<<" ";
    cout<<endl;
    */
    //save the longest sub asc seq
    int path_index = max_len_index;
    while(path_index != -1){
        path.insert(path.begin(), inputArr[path_index]);
        path_index = pathChain[path_index];
    }
    return max_Len;
}
