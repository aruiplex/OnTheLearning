#include <iostream>
#include <vector>

using namespace std;

// 答案的最小和
int ansMin = INT_MAX;

void dfs(vector<vector<int>> nums, int row, int col, int x, int y, int sum);

// 求最小和
int minAbs(vector<vector<int>> nums, int row, int col)
{
    for (int i = 0; i < row; i++)
    {
        dfs(nums, row, col, i, 0, 0);
    }
    return ansMin;
}

void dfs(vector<vector<int>> nums, int row, int col, int x, int y, int sum)
{
    if (y == col - 1)
    {
        if (ansMin > sum)
        {
            ansMin = sum;
        }
        return;
    }
    for (int i = 0; i < row; i++)
    {
        int newx = i;
        int newy = y + 1;
        if (newy < col)
        {
            dfs(nums, row, col, newx, newy, sum + abs(nums[newx][newy] - nums[x][y]));
        }
    }
}

int main()
{
    int row, col;
    while (cin >> row >> col)
    {
        vector<vector<int>> nums(row, vector<int>(col, 0));
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                int item;
                cin >> item;
                nums[i][j] = item;
            }
        }
        cout << minAbs(nums, row, col) << endl;
    }
}