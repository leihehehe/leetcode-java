<p>Given a 2D&nbsp;<code>grid</code> consists of <code>0s</code> (land)&nbsp;and <code>1s</code> (water).&nbsp; An <em>island</em> is a maximal 4-directionally connected group of <code><font face="monospace">0</font>s</code> and a <em>closed island</em>&nbsp;is an island <strong>totally</strong>&nbsp;(all left, top, right, bottom) surrounded by <code>1s.</code></p>

<p>Return the number of <em>closed islands</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png" style="width: 240px; height: 120px;" /></p>

<pre>
<strong>Input:</strong> grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 
Islands in gray are closed because they are completely surrounded by water (group of 1s).</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_4_1610.png" style="width: 160px; height: 80px;" /></p>

<pre>
<strong>Input:</strong> grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,1,1,1,1,1],
&nbsp;              [1,0,0,0,0,0,1],
&nbsp;              [1,0,1,1,1,0,1],
&nbsp;              [1,0,1,0,1,0,1],
&nbsp;              [1,0,1,1,1,0,1],
&nbsp;              [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= grid.length, grid[0].length &lt;= 100</code></li> 
 <li><code>0 &lt;= grid[i][j] &lt;=1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 190, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=number-of-closed-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

如何判断「封闭岛屿」呢？其实很简单，把 [200. 岛屿数量](/problems/number-of-islands) 中那些靠边的岛屿排除掉，剩下的不就是「封闭岛屿」了吗？

有了这个思路，就可以直接写出代码了，注意这题规定 `0` 表示陆地，用 `1` 表示海水。

**详细题解：[一文秒杀所有岛屿题目](https://labuladong.github.io/article/fname.html?fname=岛屿题目)**

**标签：[DFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，二维矩阵**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class dfs.dfs.dfs.dfs.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.Solution {
public:
    // 主函数：计算封闭岛屿的数量
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class dfs.dfs.dfs.dfs.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for j in range(n):
            # 把靠上边的岛屿淹掉
            self.dfs(grid, 0, j)
            # 把靠下边的岛屿淹掉
            self.dfs(grid, m - 1, j)
        for i in range(m):
            # 把靠左边的岛屿淹掉
            self.dfs(grid, i, 0)
            # 把靠右边的岛屿淹掉
            self.dfs(grid, i, n - 1)
        # 遍历 grid，剩下的岛屿都是封闭岛屿
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    res += 1
                    self.dfs(grid, i, j)
        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if grid[i][j] == 1:
            # 已经是海水了
            return
        # 将 (i, j) 变成海水
        grid[i][j] = 1
        # 淹没上下左右的陆地
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class dfs.dfs.dfs.dfs.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.Solution {
     // 主函数：计算封闭岛屿的数量
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 计算封闭岛屿的数量
func closedIsland(grid [][]int) int {
    m, n := len(grid), len(grid[0])
    for j := 0; j < n; j++ {
        // 把靠上边的岛屿淹掉
        dfs(grid, 0, j)
        // 把靠下边的岛屿淹掉
        dfs(grid, m-1, j)
    }
    for i := 0; i < m; i++ {
        // 把靠左边的岛屿淹掉
        dfs(grid, i, 0)
        // 把靠右边的岛屿淹掉
        dfs(grid, i, n-1)
    }
    // 遍历 grid，剩下的岛屿都是封闭岛屿
    res := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 0 {
                res++
                dfs(grid, i, j)
            }
        }
    }
    return res
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
func dfs(grid [][]int, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        return
    }
    if grid[i][j] == 1 {
        // 已经是海水了
        return
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 1
    // 淹没上下左右的陆地
    dfs(grid, i+1, j)
    dfs(grid, i, j+1)
    dfs(grid, i-1, j)
    dfs(grid, i, j-1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var closedIsland = function(grid) {
    var m = grid.length, n = grid[0].length;
    for (var j = 0; j < n; j++) {
        // 把靠上边的岛屿淹掉
        dfs(grid, 0, j);
        // 把靠下边的岛屿淹掉
        dfs(grid, m - 1, j);
    }
    for (var i = 0; i < m; i++) {
        // 把靠左边的岛屿淹掉
        dfs(grid, i, 0);
        // 把靠右边的岛屿淹掉
        dfs(grid, i, n - 1);
    }
    // 遍历 grid，剩下的岛屿都是封闭岛屿
    var res = 0;
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] === 0) {
                res++;
                dfs(grid, i, j);
            }
        }
    }
    return res;
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        return;
    }
    if (grid[i][j] === 1) {
        // 已经是海水了
        return;
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 1;
    // 淹没上下左右的陆地
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

</div></div>
</div></div>

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [130. 被围绕的区域 🟠](/problems/surrounded-regions)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



