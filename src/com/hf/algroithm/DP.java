package com.hf.algroithm;

/**
 * @author: huangfan
 * @date: 2019/2/26 20:35
 * 动态规划问题：
 *   重点是状态和状态转移方程
 */
public class DP {

    /**
     * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
     * @return
     */
    public int eg1(){

        int [] a={1,3,5};
        int num=11;
        int [] dp=new int[12];
        for (int i=0;i<=num;i++){
            dp[i]=i;
        }
        for (int i=0;i<=num;i++){
            for (int j=1;j<3;j++){
                if(i>a[j]&&(dp[i-a[j]]+1)<dp[i]){
                    dp[i]=dp[i-a[j]]+1;
                }
            }
        }
        return dp[num];
    }

    /**
     * 将一个由N行数字组成的三角形，如图所以，设计一个算法，计算出三角形的由顶至底的一条路径，使该路径经过的数字总和最大
     *                 7
     *               /   \
     *             3      8
     *           /   \  /  \
     *          8     1     0
     *         / \   /  \  / \
     *        2    7     4    4
     *       / \  / \   / \  / \
     *      4   5     2    6    5
     * @return
     */
    public static int eg2(){
        /*f[i][j]表示从(1,1)到(i,j)的最大值
         * 状态转移方程
         *  f[i][j]=max{f[i+1][j],f[i+1][j+1])+map[i][j]
         *  自上而下：最大值在最底层
         *  自下而上：f[1][1]为最大值
         *
         */
        int[][] dp=new int[6][6];
        int[][] a=new int[6][6];
        a[1][1]=7;
        a[1][2]=3;
        a[1][3]=8;
        a[1][4]=2;
        a[1][5]=4;
        a[2][2]=8;
        a[2][3]=1;
        a[2][4]=7;
        a[2][5]=5;
        a[3][3]=0;
        a[3][4]=4;
        a[3][5]=2;
        a[4][4]=4;
        a[4][5]=6;
        a[5][5]=5;
        int n=6;//表示宽度
        int i,j;
        for (i=1;i<n;i++){
            dp[i][n-1]=a[i][n-1];
        }
       /* for (i=1;i<6;i++){
            System.out.println(dp[i][5]);
        }*/
        //自下而上
        for(i = 5;i > 1;i--){
            for(j = 1; j< i;j++){
                System.out.println("dp[j][i]:"+dp[j][i]);
                System.out.println("dp[j+1][i]:"+dp[j+1][i]);
                if (dp[j][i]>dp[j+1][i]){
                    dp[j][i-1]=dp[j][i]+a[j][i-1];
                }else{
                    dp[j][i-1]=dp[j+1][i]+a[j][i-1];
                }
            }
        }
//        sys(dp);
        return dp[1][1];
    }
    private static void sys(int[][] a){
        for(int i = 0; i< 6;i++){
            for(int j = 0; j< 6;j++){
                System.out.println(a[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(eg2());
    }
}
