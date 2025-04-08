package com.example.dsa_java.dsa.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeMap;

public class SolvingQWB_2140_V3 {

    public long mostPoints(int[][] questions) {
        // Storing the index of each question
        TreeMap<Integer, List<Integer>> nextPossibleNodes = new TreeMap<>();
        List<List<Integer>> solvedQuestionList = new ArrayList<>(); 

        // Traversing over each node
        for(int i=0; i<questions.length; i++) {

            List<Integer> possibleIndicesAtI = new ArrayList<>();
            int skips = questions[i][1]+1;

            for(int j=i+skips; j<questions.length; j++) {
                possibleIndicesAtI.add(j);
            }
            nextPossibleNodes.put(i, possibleIndicesAtI);
        }

        NavigableSet<Integer> nvSet = nextPossibleNodes.navigableKeySet();
        System.out.println("\n\npossible next nodes: ");
        System.out.println(nextPossibleNodes);

        System.out.println("\n\nall possible paths: ");

        for(int i:nvSet) { // Iterate on keys

            if(pathExists(i, solvedQuestionList)) continue;

            int j = i;
            int prevJ = i;
            int[] ij = new int[questions.length];
            List<Integer> tempList = new ArrayList<>();

            while(ij[j] <= nextPossibleNodes.get(j).size()) { 
                // j moves on keys, ij[] moves in list value stored against key
                // prevJ keeps track of previous j before empty.
                    
                if(nextPossibleNodes.get(j).isEmpty() || ij[j] == nextPossibleNodes.get(j).size()){
                    
                    if(nextPossibleNodes.get(j).isEmpty()){
                        tempList.add(j);
                        solvedQuestionList.add(tempList);
                        System.out.println(j+"-->{}");
                    }
                    else{
                        System.out.println(j+"-|");
                        ij[j]=0;
                    }

                    ij[prevJ]++;
                    j=i;
                }
                else{
                    tempList.add(j);
                    System.out.print(j+"->");
                    prevJ = j;
                    j = nextPossibleNodes.get(j).get(ij[j]);
                }

                if(i==j){
                    tempList = new ArrayList<>();
                }

                if(ij[i]==nextPossibleNodes.get(i).size()) {
                    System.out.println(i+"->{}");
                    System.out.println("Here please\n");

                    tempList.add(i);
                    solvedQuestionList.add(tempList);
                    break;
                }
            }
        }

        int maxPoints = -1;
        for(List<Integer> li:solvedQuestionList){

            int tempPoints = 0;
            for(int j: li) {
                tempPoints += questions[j][0];
            }
            maxPoints = tempPoints > maxPoints?tempPoints:maxPoints;
        }

        System.out.println("\n\nall possible solved questons:");
        System.out.println(solvedQuestionList);

        System.out.println("\n\nMAX points: ");
        System.out.println(maxPoints);
        return maxPoints;
    }

    public boolean pathExists(int node, List<List<Integer>> allSOleved) {
        for(List<Integer> li: allSOleved) {
            if(li.contains(node)) return true;
        }

        return false;
    }
}
/**
 * 0 -> 1,2
 * 1 -> 2,3,4
 * 2 -> 4,5
 * 3 -> 4
 * 4 -> {} 
 * 5 -> {}
 * 
 * Paths                   for i
 *                         cj[] 0 1 2 3 4 5
 * 0->1->2->4->{}               0 0 0 0 0 0
 * 0->1->2->5->{}               0 0 1 0 0 0
 * 0->2->4->{}                  1 0 0 0 0 0
 * 0->2->5->{}                  1 0 1 0 0 0
 * 
 * 
 * 
 * 
 * 
 */