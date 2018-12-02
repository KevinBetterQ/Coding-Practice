//评测题目: import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String ipMatch(String ip, String[] ipRangeList) {
	  	String[] subIP = ip.split("\\.");
        String binIP = toBinary(Integer.parseInt(subIP[0]),8)
                       + toBinary(Integer.parseInt(subIP[1]),8)
          			   + toBinary(Integer.parseInt(subIP[2]),8)
                       + toBinary(Integer.parseInt(subIP[3]),8);
        for(String str : ipRangeList) {
          String[] sub = str.split("\\.");
          String[] nnet = sub[3].split("/");
          String[] nnetR = nnet[1].split(" ");
          int net = Integer.parseInt(nnetR[0]);
          String bin = toBinary(Integer.parseInt(sub[0]),8)
                       + toBinary(Integer.parseInt(sub[1]),8)
          			   + toBinary(Integer.parseInt(sub[2]),8)
                       + toBinary(Integer.parseInt(nnet[0]),8);
          for(int i = 0; i < net; i++) {
            if(bin.charAt(i) != binIP.charAt(i)) break;
            if(i == net - 1) return str;
          }
         }
        return null;
    }
    
    static String toBinary(int num, int digits) {
    	String str00 = Integer.toBinaryString(1 << digits).substring(1);
        String s = Integer.toBinaryString(num);
        return s.length() < digits ? str00.substring(s.length()) + s : s;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
        
        String _ip;
        try {
            _ip = in.nextLine();
        } catch (Exception e) {
            _ip = null;
        }
        
        List<String> _ipRangeList = new ArrayList<>();
        
        while (in.hasNextLine()) {
            try {
                _ipRangeList.add(in.nextLine());
            } catch (Exception e) {
        
            }
        }
        
        res = ipMatch(_ip, _ipRangeList.toArray(new String[_ipRangeList.size()]));
        System.out.println(res);
    }
}