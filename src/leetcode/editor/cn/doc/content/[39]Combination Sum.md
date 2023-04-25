<p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>

<p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the <span data-keyword="frequency-array">frequency</span> of at least one of the chosen numbers is different.</p>

<p>The test cases are generated such that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,3,6,7], target = 7
<strong>Output:</strong> [[2,2,3],[7]]
<strong>Explanation:</strong>
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,3,5], target = 8
<strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2], target = 1
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= candidates.length &lt;= 30</code></li> 
 <li><code>2 &lt;= candidates[i] &lt;= 40</code></li> 
 <li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li> 
 <li><code>1 &lt;= target &lt;= 40</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2465, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=combination-sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[回溯算法秒杀所有排列/组合/子集问题](https://www.bilibili.com/video/BV1Yt4y1t7dK)

你需要先看前文 [回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)，然后看这道题就很简单了，无非是回溯算法的运用而已。

这道题的关键在于 `candidates` 中的元素可以复用多次，体现在代码中是下面这段：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

对比 [回溯算法团灭子集、排列、组合问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合) 中不能重复使用元素的标准组合问题：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i + 1, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

体会到控制是否重复使用元素的关键了吗？

**详细题解：[回溯算法秒杀所有排列/组合/子集问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

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

class backtracking.round2.backtracking.round2.backtracking.round2.Solution {
public:
    vector<vector<int>> res;

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if (candidates.size() == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    vector<int> track;

    // 回溯算法主函数
    void backtrack(vector<int>& candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.push_back(track);
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.size(); i++) {
            // 选择 candidates[i]
            track.push_back(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.pop_back();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class backtracking.round2.backtracking.round2.backtracking.round2.Solution:
    def __init__(self):
        self.res = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.res
        self.backtrack(candidates, 0, target, 0)
        return self.res

    # 记录回溯的路径
    track = []

    # 回溯算法主函数
    def backtrack(self, candidates, start, target, sum):
        if sum == target:
            # 找到目标和
            self.res.append(self.track[:])
            return

        if sum > target:
            # 超过目标和，直接结束
            return

        # 回溯算法框架
        for i in range(start, len(candidates)):
            # 选择 candidates[i]
            self.track.append(candidates[i])
            sum += candidates[i]
            # 递归遍历下一层回溯树
            self.backtrack(candidates, i, target, sum)
            # 撤销选择 candidates[i]
            sum -= candidates[i]
            self.track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class backtracking.round2.backtracking.round2.backtracking.round2.Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主函数
    void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.add(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func combinationSum(candidates []int, target int) [][]int {
	var res [][]int

	// 定义回溯函数
	var backtrack func(start int, target int, sum int, track []int)

	backtrack = func(start int, target int, sum int, track []int) {
		// 如果当前 sum 等于 target，说明已找到符合要求的组合
		if sum == target {
			// 由于 track 数组为引用类型，因此需要重新生成一个数组对象来保存到结果集
			res = append(res, append([]int{}, track...))
			return
		}

		// 如果当前 sum 已经大于 target，回溯结束
		if sum > target {
			return
		}

		// 从指定位置开始遍历候选数组
		for i := start; i < len(candidates); i++ {
			// 将候选数组当前元素加入路径
			track = append(track, candidates[i])
			sum += candidates[i]
			// 继续遍历下一个元素
			backtrack(i, target, sum, track)
			// 回溯：将当前元素从路径中移除
			sum -= candidates[i]
			track = track[:len(track)-1]
		}
	}

	backtrack(0, target, 0, []int{})

	return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var combinationSum = function(candidates, target) {
    let res = [];
    let track = [];
    
    backtrack(candidates, 0, target, 0, track);
    
    return res;
    
    function backtrack(candidates, start, target, sum, track) {
        if (sum === target) {
            // 找到目标和
            res.push([...track]);
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (let i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.push(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum, track);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.pop();
        }
    }
};
```

</div></div>
</div></div>

**类似题目**：
  - [216. 组合总和 III 🟠](/problems/combination-sum-iii)
  - [40. 组合总和 II 🟠](/problems/combination-sum-ii)
  - [46. 全排列 🟠](/problems/permutations)
  - [47. 全排列 II 🟠](/problems/permutations-ii)
  - [77. 组合 🟠](/problems/combinations)
  - [78. 子集 🟠](/problems/subsets)
  - [90. 子集 II 🟠](/problems/subsets-ii)
  - [剑指 Offer II 079. 所有子集 🟠](/problems/TVdhkn)
  - [剑指 Offer II 080. 含有 k 个元素的组合 🟠](/problems/uUsW3B)
  - [剑指 Offer II 081. 允许重复选择元素的组合 🟠](/problems/Ygoe9J)
  - [剑指 Offer II 082. 含有重复元素集合的组合 🟠](/problems/4sjJUc)
  - [剑指 Offer II 083. 没有重复元素集合的全排列 🟠](/problems/VvJkup)
  - [剑指 Offer II 084. 含有重复元素集合的全排列 🟠](/problems/7p8L0Z)

</details>
</div>



