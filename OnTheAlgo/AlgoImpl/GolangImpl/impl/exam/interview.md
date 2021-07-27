3.17

链接：https://www.nowcoder.com/discuss/615992?type=all&order=time&pos=&page=1&channel=-1&source_id=search_all_nctrack
第一题

n 副扑克，张数为 m，大小为 1 ～ m，每幅扑克抽一张，求和恰好为 k 的组合数，结果对 10e9+7 取余数。
思路：动态规划。和为 i，j 副扑克，，dp[i][j] = dp[i-1][j-1]+...+dp[i-m][j-1](此处需要判断 i-m>0 )。初始化，j=1，i<=m,dp[i][j] = 1; i==j,dp[i][j] = 1,后面的情况不可能存在，所以推出循环。

第二题

https://www.nowcoder.com/discuss/615871?type=all&order=time&pos=&page=1&channel=-1&source_id=search_all_nctrack

3.15
作者：izhxxx
链接：https://www.nowcoder.com/discuss/614678?type=all&order=time&pos=&page=1&channel=-1&source_id=search_all_nctrack
来源：牛客网

第一题位运算
给三个数 a b c，求使 a+b=c 的最少翻转次数，翻转是指 a 和 b 每个位 01 翻转

第二题切蜡烛
蜡烛长 n，一分钟烧 1，可以选择 n-1 个位置进行切割并点燃，其中一个烧完可以继续切割，求全部烧完的期望时间

3.12
作者：Sakura-gh
链接：https://www.nowcoder.com/discuss/612738?type=post&order=time&pos=&page=1&channel=-1&source_id=search_post_nctrack
来源：牛客网

第一题就是打电话，你没有目标的电话，但你可以发给其他人，其他人可能有目标的电话，然后建图，bfs 一遍过 （floyed）
第二题就是棋盘上的棋子全部移动到对角线的最小移动次数，cf 上的原题，贴一下链接：https://codeforces.com/contest/1465/problem/C

3.10
模拟题，只能朝着一个方向走，撞墙停止，四个方向
读取输入不太习惯，nextInt 完需要 nextLine 读掉\n，-\_-
签到题

LC 1388. Pizza With 3n Slices

3.8
LC 1539 879

3.6
LC 815 和 1411
