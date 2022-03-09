package com.剑指offer;

public class L_33 {

    public boolean verifyPostorder(int[] postorder) {
        int begin = 0;
        int end = postorder.length;
        return IsAfter(postorder,begin,end - 1);
    }

    public boolean IsAfter(int[] postorder,int begin,int end){
        if (end <= begin) return true;
        int index = 1;
        while (index < end && postorder[index] < postorder[end - 1]) index++;
        for (int i = index; i < end; i++) {
            if (postorder[end] > postorder[i])
                return false;
        }
        return IsAfter(postorder,begin,index - 1) && IsAfter(postorder,index,end - 1);
    }

}
