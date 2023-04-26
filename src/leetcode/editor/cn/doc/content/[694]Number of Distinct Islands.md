<p>You are given an <code>m x n</code> binary matrix <code>grid</code>. An island is a group of <code>1</code>'s (representing land) connected <strong>4-directionally</strong> (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.</p>

<p>An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.</p>

<p>Return <em>the number of <b>distinct</b> islands</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/01/distinctisland1-1-grid.jpg" style="width: 413px; height: 334px;" /> 
<pre>
<strong>Input:</strong> grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/01/distinctisland1-2-grid.jpg" style="width: 413px; height: 334px;" /> 
<pre>
<strong>Input:</strong> grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 50</code></li> 
 <li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 哈希表 | 哈希函数</details><br>

<div>👍 157, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=number-of-distinct-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

如果想把岛屿转化成字符串，说白了就是序列化，序列化说白了就是遍历嘛，前文 [二叉树的序列化和反序列化](https://labuladong.github.io/article/fname.html?fname=二叉树的序列化) 讲了二叉树和字符串互转，这里也是类似的，对于形状相同的岛屿，如果从同一起点出发，`dfs` 函数遍历的顺序肯定是一样的。

所以，遍历顺序从某种意义上说就可以用来描述岛屿的形状，比如下图这两个岛屿：

![](https://labuladong.github.io/pictures/岛屿/6.png)

假设它们的遍历顺序是：

> 下，右，上，撤销上，撤销右，撤销下

如果我用分别用 `1, 2, 3, 4` 代表上下左右，用 `-1, -2, -3, -4` 代表上下左右的撤销，那么可以这样表示它们的遍历顺序：

> 2, 4, 1, -1, -4, -2

**这就相当于是岛屿序列化的结果，只要每次使用 `dfs` 遍历岛屿的时候生成这串数字进行比较，就可以计算到底有多少个不同的岛屿了**。

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

class dfs.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.backtracking.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.binaryTree.bfs.Solution {
public:
    int numDistinctIslands(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        // 记录所有岛屿的序列化结果
        unordered_set<string> islands;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    string s;
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid, i, j, s, 's'); // 用字符代替数字，方便后续拼接
                    islands.insert(s);/**<extend up -200>![](https://labuladong.github.io/pictures/岛屿/6.png) */
                }
            }
        }
        // 不相同的岛屿数量
        return islands.size();
    }

private:
    void dfs(vector<vector<int>>& grid, int i, int j, string& s, char dir) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n 
            || grid[i][j] == 0) {
            return;
        }
        // 前序遍历位置：进入 (i, j)
        grid[i][j] = 0;
        s += dir;
        dfs(grid, i - 1, j, s, 'u'); // 上
        dfs(grid, i + 1, j, s, 'd'); // 下
        dfs(grid, i, j - 1, s, 'l'); // 左
        dfs(grid, i, j + 1, s, 'r'); // 右
        
        // 后序遍历位置：离开 (i, j)
        s += 'b';
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class dfs.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.backtracking.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.binaryTree.bfs.Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        islands = set() # 记录所有岛屿的序列化结果
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1: # 如果岛屿是1
                    # 淹掉这个岛屿，同时存储岛屿的序列化结果
                    sb = [] # 没有StringBuilder，用数组代替
                    # 初始的方向可以随便写，不影响正确性
                    self.dfs(grid, i, j, sb, 666)
                    islands.add("".join(sb))
                    #![](https://labuladong.github.io/pictures/岛屿/6.png)

        return len(islands) # 返回不同的岛屿数量

    def dfs(self, grid: List[List[int]], i: int, j: int, sb: List[str], dir: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
            return
        # 前序遍历位置：进入 (i, j)
        grid[i][j] = 0
        sb.append(str(dir)).append(',')

        self.dfs(grid, i - 1, j, sb, 1)  # 上
        self.dfs(grid, i + 1, j, sb, 2)  # 下
        self.dfs(grid, i, j - 1, sb, 3)  # 左
        self.dfs(grid, i, j + 1, sb, 4)  # 右

        # 后序遍历位置：离开 (i, j)
        sb.append(str(-dir)).append(',')
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class dfs.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.binaryTree.backtracking.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.backtracking.round2.binaryTree.bfs.Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录所有岛屿的序列化结果
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid, i, j, sb, 666);
                    islands.add(sb.toString());/**<extend up -200>![](https://labuladong.github.io/pictures/岛屿/6.png) */
                }
            }
        }
        // 不相同的岛屿数量
        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n 
            || grid[i][j] == 0) {
            return;
        }
        // 前序遍历位置：进入 (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');
        
        dfs(grid, i - 1, j, sb, 1); // 上
        dfs(grid, i + 1, j, sb, 2); // 下
        dfs(grid, i, j - 1, sb, 3); // 左
        dfs(grid, i, j + 1, sb, 4); // 右
        
        // 后序遍历位置：离开 (i, j)
        sb.append(-dir).append(',');
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// LeetCode问题“不同岛屿的数量”的解决方案： https://leetcode.com/problems/number-of-distinct-islands/
// 作者：Obadiah Crowe
// 时间：2021年7月29日
import (
	"fmt"
	"strconv"
	"strings"
)

func numDistinctIslands(grid [][]int) int {
	// 计算行数和列数
	m, n := len(grid), len(grid[0])

	// 存储所有不同岛屿的序列化结果
	islands := make(map[string]bool)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				// 淹没此岛屿，同时存储其序列化结果
				var sb strings.Builder
				// 初始方向可以是任意的，不会影响正解
				dfs(grid, i, j, &sb, 666)
				islands[sb.String()] = true
				/**<向上扩展-200>
				![](https://labuladong.github.io/pictures/岛屿/6.png)
				*/
			}
		}
	}

	// 岛屿数量即为不同岛屿序列化结果的数量
	return len(islands)
}

func dfs(grid [][]int, i, j int, sb *strings.Builder, dir int) {
	// 计算行数和列数
	m, n := len(grid), len(grid[0])

	// 如果(i, j)不在网格范围内, 或者是海洋, 直接返回
	if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 {
		return
	}

	// pre-order: 进入点(i, j)
	grid[i][j] = 0 // 淹没该岛屿
	sb.WriteString(strconv.Itoa(dir) + ",") //记录方向

	dfs(grid, i-1, j, sb, 1) // 上
	dfs(grid, i+1, j, sb, 2) // 下
	dfs(grid, i, j-1, sb, 3) // 左
	dfs(grid, i, j+1, sb, 4) // 右

	// post-order: 离开点(i, j)
	sb.WriteString(strconv.Itoa(-dir) + ",") // 记录方向
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var numDistinctIslands = function(grid) {
    var m = grid.length, n = grid[0].length;
    // Record the serialization results of all islands
    var islands = new Set();
    for(var i=0; i<m; i++) {
        for(var j=0; j<n; j++) {
            if(grid[i][j] == 1) {
                // Drown the island and store the serialization result of the island
                var sb = new StringBuilder();
                // The initial direction can be written randomly, which does not affect the correctness
                dfs(grid, i, j, sb, 666);
                islands.add(sb.toString());/**<extend up -200>![](https://labuladong.github.io/pictures/岛屿/6.png) */
            }
        }
    } 
    // The number of different islands
    return islands.size();

    function dfs(grid, i, j, sb, dir) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0) {
            return;
        } 
        // Pre-order traversal position: enter (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i-1, j, sb, 1); // up
        dfs(grid, i+1, j, sb, 2); // down
        dfs(grid, i, j-1, sb, 3); // left
        dfs(grid, i, j+1, sb, 4); // right

        // Post-order traversal position: leave (i, j)
        sb.append(-dir).append(',');
    }
};
```

</div></div>
</div></div>

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



