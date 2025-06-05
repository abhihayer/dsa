package com.example.dsa_java.dsa.leetcode;

import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.List;
import java.util.Stack;

import com.example.dsa_java.dsa.leetcode.LCADL_1123_V1.ThNode;

public class LCADL_1123_V1 {
    class ThNode {
        ThNode pn;
        TreeNode tn;
        int depth;

        ThNode(TreeNode tn, ThNode pn, int depth){
            this.pn = pn;
            this.tn = tn;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ThNode rootH = new ThNode(root,null,0);

        List<ThNode> leaves = new ArrayList<>();
        Stack<ThNode> stack = new Stack<>();
        int previousDepth = -1;
        
        stack.push(rootH);
        while(!stack.empty()) { // calculating the depth and attaching the parent & depth to each node
            ThNode currNode = stack.pop();    
            
            if(currNode.tn.left !=null)
                stack.push(new ThNode(currNode.tn.left, currNode, currNode.depth+1));
            
            if(currNode.tn.right !=null)
                stack.push(new ThNode(currNode.tn.right, currNode, currNode.depth+1));
            
            if(currNode.tn.left ==null && currNode.tn.right ==null)
                if(currNode.depth >= previousDepth) leaves.add(currNode);
        }

        leaves.sort((a,b)->b.depth-a.depth); // sorting it in decending order using comparator
        
        // filtering the max depth nodes only, we will find common parent to max depth nodes
        List<ThNode> finalLeaves = new ArrayList<>();
        for(int i=0; i<leaves.size(); i++) { 
            if(leaves.get(i).depth==leaves.get(0).depth)
                finalLeaves.add(leaves.get(i));
            else
                break;
        }

        int maxDepth = finalLeaves.get(0).depth;
        // if only one node has the max depth then that node itself is the lca
        // lca -> Lowest Common Ancestor
        if(finalLeaves.size()==1) return finalLeaves.get(0).tn;

        // in this while loop we are decreasing depth
        while(maxDepth > 0){
            maxDepth--;

            // each node tracking the parent node, hencing going 1 levelup
            for(int i=0; i<finalLeaves.size(); i++){
                finalLeaves.set(i, finalLeaves.get(i).pn);
            }

            // if the parent node of any node isn't same, we will move 1 levelup until it becomes same
            boolean flag = true; 
            for(int i=0; i<finalLeaves.size()-1; i++){
                if(finalLeaves.get(i).tn != finalLeaves.get(i+1).tn) {
                    flag = false;
                    break; 
                }
            }

            // if all parents are same then we are getting out becasue we found lca
            if(flag) break;
        }
        
        TreeNode cpn = null;
        cpn = finalLeaves.get(0).tn;
        
        return cpn==null?root:cpn;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
