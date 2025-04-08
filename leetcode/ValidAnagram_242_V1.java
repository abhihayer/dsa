package com.example.dsa_java.dsa.leetcode;

class ValidAnagram_242_V1 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;

        for(int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0)+1);

            ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch,0)+1);
        }

        Set<Character> skeys = smap.keySet();
        Set<Character> tkeys = tmap.keySet();

        if(skeys.size()!=tkeys.size()) return false;

        for(Character ch: skeys) {
            if(tkeys.contains(ch)) {
                if(!tmap.get(ch).equals(smap.get(ch))) return false;
            }
            else {
                return false;
            }
        }

        return true;

    }
}