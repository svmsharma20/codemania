package edu.interviewBit.string;

import java.util.ArrayList;

public class ValidIpAddresses {

    public static void main(String[] args) {
        String[] testcases = {"19245843"};

        for (int i=0; i<testcases.length; i++) {
            String[] validIps = calculateAllValidIps(testcases[i]);
            System.out.println("=====================");
            System.out.println("Testcase:"+i);
            System.out.println();
            for (String ip : validIps) {
                System.out.println(ip);
            }
            System.out.println("=====================\n");
        }

    }

    private static String[] calculateAllValidIps(String ip) {
        ip = ip.trim();

        ArrayList<String> validIpList = new ArrayList<>();

        for (int i = 1; i <=3 && i<ip.length() ; i++) {
            String seg1 = ip.substring(0,i);
            if(!isValidIpSegment(seg1)){
                continue;
            }

            for(int j=i+1; j<j+3 && j<ip.length(); j++){

                String seg2 = ip.substring(i, j);
                if(!isValidIpSegment(seg2)){
                    continue;
                }

                for (int k = j+1; k<k+3 && k<ip.length(); k++) {
                    String seg3 = ip.substring(j,k);
                    String seg4 = ip.substring(k);

                    if(isValidIpSegment(seg3) && isValidIpSegment(seg4)){
                        String validIp = String.format("%s.%s.%s.%s", seg1, seg2, seg3, seg4);
                        validIpList.add(validIp);
                    }
                }
            }
        }

        String[] validIpsArr = new String[validIpList.size()];
        validIpList.toArray(validIpsArr);

        return validIpsArr;
    }

    private static boolean isValidIpSegment(String ipSegment){

        if(ipSegment==null || ipSegment.length()==0 || (ipSegment.startsWith("0") && ipSegment.length()>1)){
            return false;
        }

        int segmentValue = Integer.parseInt(ipSegment);

        return (segmentValue>=0 && segmentValue<= 255);
    }

}
