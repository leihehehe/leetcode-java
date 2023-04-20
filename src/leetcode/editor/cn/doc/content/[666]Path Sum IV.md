<p>If the depth of a tree is smaller than <code>5</code>, then this tree can be represented by an array of three-digit integers. For each integer in this array:</p>

<ul> 
 <li>The hundreds digit represents the depth <code>d</code> of this node where <code>1 &lt;= d &lt;= 4</code>.</li> 
 <li>The tens digit represents the position <code>p</code> of this node in the level it belongs to where <code>1 &lt;= p &lt;= 8</code>. The position is the same as that in a full binary tree.</li> 
 <li>The units digit represents the value <code>v</code> of this node where <code>0 &lt;= v &lt;= 9</code>.</li> 
</ul>

<p>Given an array of <strong>ascending</strong> three-digit integers <code>nums</code> representing a binary tree with a depth smaller than <code>5</code>, return <em>the sum of all paths from the root towards the leaves</em>.</p>

<p>It is <strong>guaranteed</strong> that the given array represents a valid connected binary tree.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/30/pathsum4-1-tree.jpg" style="width: 212px; height: 183px;" /> 
<pre>
<strong>Input:</strong> nums = [113,215,221]
<strong>Output:</strong> 12
<strong>Explanation:</strong> The tree that the list represents is shown.
The path sum is (3 + 5) + (3 + 1) = 12.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/30/pathsum4-2-tree.jpg" style="width: 132px; height: 183px;" /> 
<pre>
<strong>Input:</strong> nums = [113,221]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The tree that the list represents is shown. 
The path sum is (3 + 1) = 4.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 15</code></li> 
 <li><code>110 &lt;= nums[i] &lt;= 489</code></li> 
 <li><code>nums</code> represents a valid binary tree with depth less than <code>5</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 数组 | 二叉树</details><br>

<div>👍 59, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
本题思路为《[手把手刷二叉树系列教程](https://aep.xet.tech/s/3YGcq3)》的专属内容，用 [手把手带你刷二叉树（纲领篇）](https://labuladong.gitee.io/article/fname.html?fname=二叉树总结) 中的两种思维模式秒杀所有二叉树的题目，并延伸到回溯算法和动态规划系列问题。如果你已经购买课程还无法查看，请点击 [这里](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63956417e4b02685a425cc0d/1) 查看各个插件的解锁方法。如遇到问题，可以在 [bug 反馈页面](https://github.com/labuladong/fucking-algorithm/discussions/704) 反馈。</details>
</div>



