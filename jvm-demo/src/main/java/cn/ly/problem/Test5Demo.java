package cn.ly.problem;

/**
 * 给一个座位数组，有人用1表示，无人用0表示，坐位两端不能有人
 * 现在算，第N个人进来的时候，能否坐下，能则返回true，不能则返回false
 * 例如：[1,0,0,0,1] n=1 ，true
 *  n=2,false
 *  不用考虑坐位，n是否有效
 */
public class Test5Demo {
    public static void main(String[] args) {
        // flowerbed = [1,0,0,0,1], n = 1 true
        // flowerbed = [1,0,0,0,1], n = 2 false
        // [1,0,1,0,1,0,1]
        // [0,0,0,0,1] 2
        //        //0
        int[] flowerbed = new int[]{0,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*int m = flowerbed.length;

        int count = 0;
        for (int i=0;i<m;i++) {

            if (flowerbed[i] == 0 && (i == m - 1 || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {

                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;

*/
        int count = 0;
        for(int i=0,size=flowerbed.length;i<size;i++){
            if(flowerbed[i] ==0 && (i==0 || flowerbed[i-1] ==0) && (i==size-1 || flowerbed[i+1]==0)){
                flowerbed[i] = 1;
                count++;
            }

        }

        return count >= n;
    }


}
