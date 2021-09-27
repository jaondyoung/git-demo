package cn.ly.problem;

public class Test6Demo {
    public static void main(String[] args) {
    /*给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。


示例 ：
输入：[7,1,5,3,6,4]
输出：5

1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/
//        int[] arr = new  int[]{7,1,5,3,6,4};
        int[] arr = new  int[]{7,6,4,3,1};
        System.out.println(maxVal(arr));

    }

    public static int maxVal(int[] prices){
        //相差最大，并且索引小到大
        int max = 0 ;
        int min = 0;
        for (int i = 0; i < prices.length-1; i++) {
           min = prices[i];
            for (int j = i+1; j <prices.length ; j++) {
                if(prices[j] - min > max){
                    max = prices[j] - min;
                }

            }
        }
        return max;
    }
}
