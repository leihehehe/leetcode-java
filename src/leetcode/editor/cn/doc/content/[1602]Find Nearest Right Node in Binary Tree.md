<p>Given the <code>root</code> of a binary tree and a node <code>u</code> in the tree, return <em>the <strong>nearest</strong> node on the <strong>same level</strong> that is to the <strong>right</strong> of</em> <code>u</code><em>, or return</em> <code>null</code> <em>if </em><code>u</code> <em>is the rightmost node in its level</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/24/p3.png" style="width: 241px; height: 161px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,null,4,5,6], u = 4
<strong>Output:</strong> 5
<strong>Explanation:</strong> The nearest node on the same level to the right of node 4 is node 5.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/23/p2.png" style="width: 101px; height: 161px;" /> 
<pre>
<strong>Input:</strong> root = [3,null,4,2], u = 2
<strong>Output:</strong> null
<strong>Explanation:</strong> There are no nodes to the right of 2.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li>All values in the tree are <strong>distinct</strong>.</li> 
 <li><code>u</code> is a node in the binary tree rooted at <code>root</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 二叉树</details><br>

<div>👍 11, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
本题思路为《[手把手刷二叉树系列教程](https://aep.xet.tech/s/3YGcq3)》的专属内容，用 [手把手带你刷二叉树（纲领篇）](https://labuladong.gitee.io/article/fname.html?fname=二叉树总结) 中的两种思维模式秒杀所有二叉树的题目，并延伸到回溯算法和动态规划系列问题。如果你已经购买课程还无法查看，请点击 [这里](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63956417e4b02685a425cc0d/1) 查看各个插件的解锁方法。如遇到问题，可以在 [bug 反馈页面](https://github.com/labuladong/fucking-algorithm/discussions/704) 反馈。</details>
</div>





