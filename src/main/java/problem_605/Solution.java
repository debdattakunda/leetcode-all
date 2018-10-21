package main.java.problem_605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n != 0 && flowerbed != null && flowerbed.length == 1 && flowerbed[0] == 0) {
            n--;
            flowerbed[0] = 1;
        }
        if(n != 0 && flowerbed != null && flowerbed.length > 1 && flowerbed[0] == 0 && flowerbed[1] == 0 && n>0) {
            n--;
            flowerbed[0] = 1;
        }
        if(n != 0 && flowerbed != null && flowerbed.length > 1 && flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0 && n>0) {
            n--;
            flowerbed[flowerbed.length-1] = 1;
        }
        for(int i=1; i<flowerbed.length-1; i++) {
            if(n != 0 && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n==0 ? true : false;
    }
}
