//Find the longest number string, the last one is returned if more than one.
//ex. input "1234567890abc9.+12345.678.9ed", return "+12345.678"

bool isNumber(char ch){
    return (ch >= '0') && (ch <= '9');
}
bool isSign(char ch){
    return (ch == '+') || (ch == '-');
}
//Assume inputStr is a NULL terminated string
const char* findLongestNumStr(const char* inputStr, int length){
    if(length == 0)
        return "";
    int longest = 0;
    int start_index = 0, end_index = 0;
    //DP, longestNum[i] holds the max number string ended with character inputStr[i]
    int* longestNum = new int[length]{0};
    //initialize the first value of longestNum
    if(isNumber(inputStr[0])){
        longestNum[0] = 1;
        longest = 1;
        start_index = 0;
        end_index = 0;
    }else if(isSign(inputStr[0])&&isNumber(inputStr[1])){
        longestNum[0] = 1;
        longest = 1;
        start_index = 0;
        end_index = 0;
    }else
        longestNum[0] = 0;

    int i = 1;
    while(inputStr[i] != '\0'){
        if(isSign(inputStr[i])&&isNumber(inputStr[i+1])){
            longestNum[i] = 1;
        }else if(isNumber(inputStr[i])){
            longestNum[i] = longestNum[i-1]+1;
        }else if(inputStr[i] == '.'){
            if(isNumber(inputStr[i-1])&&isNumber(inputStr[i+1])){
                int j = 1;
                for(; j <= longestNum[i-1]; j++){
                    if(inputStr[i-j] == '.')
                        break;
                }
                longestNum[i] = j;
            }else{
                longestNum[i] = 0;
            }
        }else{
            longestNum[i] = 0;
        }
        if(longestNum[i] >= longest){
            longest = longestNum[i];
            end_index = i;
            start_index = i+1-longest;
        }
        i++;
    }
    delete [] longestNum;
    if(longest > 0){
        char* res = new char[longest+1];
        for(int k = start_index; k <= end_index; k++){
            res[k-start_index] = inputStr[k];
        }
        res[longest] = '\0';
        return res;
    }
    return "";
}
