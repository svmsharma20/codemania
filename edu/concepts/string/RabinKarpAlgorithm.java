package edu.concepts.string;

import java.util.ArrayList;

public class RabinKarpAlgorithm {

    private static final long prime = 31;
    private static final long MODULO = 1000000007L;

    ArrayList<Long> haystackHashPrefix = new ArrayList<>();
    ArrayList<Long> primePowers = new ArrayList<>();

    public static void main(String[] args) {
        String haystack = "cabbage cabinet is like a cab";
        String needle = "cab";

        System.out.println(new RabinKarpAlgorithm().getNeedlesInHaystack(haystack, needle));
    }

    private ArrayList<Integer> getNeedlesInHaystack(String haystack, String needle){
        ArrayList<Integer> matches = new ArrayList<>();

        initHash(haystack);

        long needleHash = getHash(needle);

        for (int left = 0, right=needle.length()-1; right < haystack.length(); left++, right++) {
            if( ((needleHash*primePowers.get(left)) % MODULO) == (substringHash(left, right)%MODULO)){
                matches.add(left);
            }
        }

        return matches;
    }

    private long substringHash(int left, int right){
        if(left==0){
            return haystackHashPrefix.get(right);
        }
        return (haystackHashPrefix.get(right) - haystackHashPrefix.get(left-1));
    }

    private void initHash(String s){
        long hash = 0;
        long power = 1;

        for (int i = 0; i < s.length(); i++) {
            hash += ((s.charAt(i)-'a'+1) * power) % MODULO;
            haystackHashPrefix.add(hash);
            primePowers.add(power);
            power = (power * prime) % MODULO;
        }
    }

    private long getHash(String s){
        long hash = 0;
        long power = 1;

        for (int i = 0; i < s.length(); i++) {
            hash += ((s.charAt(i)-'a'+1)*power) % MODULO;
            power = (power*prime) % MODULO;
        }

        return hash;
    }
}
