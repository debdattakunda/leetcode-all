package main.java.problem_786;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        this.backtrack(A, 0, 0, minHeap, new HashSet<>());
        while(K-1 > 0) {
            minHeap.poll();
            K--;
        }
        Tuple ans = minHeap.poll();
        return new int[]{(int)ans.x, (int)ans.y};
    }

    private void backtrack(int[] A, int index, double prev, PriorityQueue<Tuple> minHeap, Set<String> seen) {

        if(index==A.length) return;
        for(int i=index; i<A.length; i++) {
            if(prev!=0 && !seen.contains(prev +"/"+A[i])) {
                System.out.println(prev +"/"+A[i]);
                seen.add(prev +"/"+A[i]);
                minHeap.offer(new Tuple(prev, (double)A[i]));
            }
            backtrack(A, i+1, A[i], minHeap, seen);
        }
    }

    class Tuple implements Comparable<Tuple> {
        double x, y;
        public Tuple(double x, double y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Tuple that) {
            double div1 = (double) (this.x / this.y);
            double div2 = (double) (that.x / that.y);
            return div1>div2 ? 1 : -1;
        }
    }
}
