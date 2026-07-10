package org.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2468 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());

        long small = 0;
        String smallBin = Long.toBinaryString(a);
        int smallIdx = -1;
        for (int j = smallBin.length()-2; j >= 0; j--) {
            if (smallBin.charAt(j) == '1' && smallBin.charAt(j+1) == '0') {
                smallIdx = j;
                break;
            }
        }
        if (smallIdx != -1) {
            String prev = smallBin.substring(0, smallIdx) + "01";
            String after = smallBin.substring(smallIdx+2);

            int ones = 0;
            for (int j = 0; j < after.length(); j++) if (after.charAt(j) == '1') ones++;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ones; j++) sb.append('1');
            for (int j = 0; j < after.length() - ones; j++) sb.append('0');

            small = Long.parseLong(prev + sb.toString(), 2);
        } else small = 0;

        long big = 0;
        String bigBin = "0" + Long.toBinaryString(a);
        int bigIdx = -1;
        for (int j = bigBin.length()-2; j >= 0; j--) {
            if (bigBin.charAt(j) == '0' && bigBin.charAt(j+1) == '1') {
                bigIdx = j;
                break;
            }
        }
        if (bigIdx != -1) {
            String prev = bigBin.substring(0, bigIdx) + "10";
            String after = bigBin.substring(bigIdx+2);

            int ones = 0;
            for (int j = 0; j < after.length(); j++) if (after.charAt(j) == '1') ones++;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < after.length() - ones; j++) sb.append('0');
            for (int j = 0; j < ones; j++) sb.append('1');

            big = Long.parseLong(prev + sb.toString(), 2);
        } else big = 0;

        System.out.println(small + " " + big);
    }
}
