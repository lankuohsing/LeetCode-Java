package array.integer_to_roman;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static String intToRoman(int num) {

    	
        int n1=(int)(num/1000);//千位数字
        int n2=(int)((num-n1*1000)/100);
        int n3=(int)((num-n1*1000-n2*100)/10);
        int n4=(int)(num-n1*1000-n2*100-n3*10);

        String s4="";
        if (n4==4) {
			s4="IV";
		}
        else {
			if (n4==9) {
				s4="IX";
			}
			else {
				int numI=n4%5;
				int numV=n4/5;
				for (int i = 0; i < numV; i++) {
					s4=s4+"V";
					
				}
				for (int i = 0; i < numI; i++) {
					s4=s4+"I";
				}

			}
		}
        String s3="";
        if (n3==1) {
			s3="X";
			
		}
        else {
			if (n3==4) {
				s3="XL";
			}
			else {
				if (n3==9) {
					s3="XC";
				}
				else {
					int numX=n3%5;
					int numL=n3/5;
					for (int i = 0; i < numL; i++) {
						s3=s3+"L";
						
					}
					for (int i = 0; i < numX; i++) {
						s3=s3+"X";
					}
				}
			}
		}
        
        String s2="";
        if (n2==1) {
			s2="C";
			
		}
        else {
			if (n2==4) {
				s2="CD";
			}
			else {
				if (n2==9) {
					s2="CM";
				}
				else {
					int numC=n2%5;
					int numD=n2/5;
					for (int i = 0; i < numD; i++) {
						s2=s2+"D";
						
					}
					for (int i = 0; i < numC; i++) {
						s2=s2+"C";
					}
				}
			}
		}
        
        String s1="";
        for (int i = 0; i < n1; i++) {
			s1=s1+"M";
		}
        
        return s1+s2+s3+s4;
    }
}
public class IntegerToRoman {
	public static void main(String[] args) {
		int num=1994;
		String result=Solution1.intToRoman(num);

		System.out.println(result);
	}
	
}
