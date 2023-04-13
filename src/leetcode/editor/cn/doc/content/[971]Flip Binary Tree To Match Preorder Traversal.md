<p>You are given the <code>root</code> of a binary tree with <code>n</code> nodes, where each node is uniquely assigned a value from <code>1</code> to <code>n</code>. You are also given a sequence of <code>n</code> values <code>voyage</code>, which is the <strong>desired</strong> <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order" target="_blank"><strong>pre-order traversal</strong></a> of the binary tree.</p>

<p>Any node in the binary tree can be <strong>flipped</strong> by swapping its left and right subtrees. For example, flipping node 1 will have the following effect:</p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/15/fliptree.jpg" style="width: 400px; height: 187px;" /> 
<p>Flip the <strong>smallest</strong> number of nodes so that the <strong>pre-order traversal</strong> of the tree <strong>matches</strong> <code>voyage</code>.</p>

<p>Return <em>a list of the values of all <strong>flipped</strong> nodes. You may return the answer in <strong>any order</strong>. If it is <strong>impossible</strong> to flip the nodes in the tree to make the pre-order traversal match </em><code>voyage</code><em>, return the list </em><code>[-1]</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-01.png" style="width: 150px; height: 205px;" /> 
<pre>
<strong>Input:</strong> root = [1,2], voyage = [2,1]
<strong>Output:</strong> [-1]
<strong>Explanation:</strong> It is impossible to flip the nodes such that the pre-order traversal matches voyage.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-02.png" style="width: 150px; height: 142px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3], voyage = [1,3,2]
<strong>Output:</strong> [1]
<strong>Explanation:</strong> Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-02.png" style="width: 150px; height: 142px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3], voyage = [1,2,3]
<strong>Output:</strong> []
<strong>Explanation:</strong> The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is <code>n</code>.</li> 
 <li><code>n == voyage.length</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= Node.val, voyage[i] &lt;= n</code></li> 
 <li>All the values in the tree are <strong>unique</strong>.</li> 
 <li>All the values in <code>voyage</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 109, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
本题思路为《[手把手刷二叉树系列教程](https://aep.xet.tech/s/3YGcq3)》的专属内容，用 [手把手带你刷二叉树（纲领篇）](https://labuladong.gitee.io/article/fname.html?fname=二叉树总结) 中的两种思维模式秒杀所有二叉树的题目，并延伸到回溯算法和动态规划系列问题。如果你已经购买课程还无法查看，请点击 [这里](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63956417e4b02685a425cc0d/1) 查看各个插件的解锁方法。如遇到问题，可以在 [bug 反馈页面](https://github.com/labuladong/fucking-algorithm/discussions/704) 反馈。</details>
</div>



