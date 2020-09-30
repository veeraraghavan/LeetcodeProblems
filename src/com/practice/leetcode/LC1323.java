class Solution {
    public int maximum69Number (int number) {
        int temp=number;  
        int pos=-1;    
        int multiplyer=1; 
        while(temp!=0)
        {
        if(temp%10==6) pos=multiplyer; 
        temp=temp/10;    
        multiplyer=multiplyer*10; 
        }
        if(pos!=-1) number=number+3*pos;
        return number;
    }
}
