package leetCode;

public class LeetCode_7 {

    public static void main(String[] args){
        int inputNum = 1534236469;
        LeetCode_7 leetCode = new LeetCode_7();
        int reverse = leetCode.reverseTemp(inputNum);
        System.out.println(reverse);
    }

    public int reverseTemp(int x){
        int symbol =1;
        double top = Math.pow(2,31)-1;
        double bottom = Math.pow(2,31) * -1;
        if(x==0){
            return 0;
        }
        System.out.println(top-x);
        if(x>top || x<bottom){
            return 0;
        }
        if(x<0){
            symbol = -1;
            x=Math.abs(x);
        }
        int returnNum = 0;
        int temp;
        while (x !=0){
            temp = x - x/10*10;
            x = x/10;
            returnNum = returnNum *10 + temp;
        }
        return returnNum*symbol;
    }

}
