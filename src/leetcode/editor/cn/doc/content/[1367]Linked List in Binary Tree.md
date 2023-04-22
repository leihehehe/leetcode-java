<p>Given a binary tree <code>root</code> and a&nbsp;linked list with&nbsp;<code>head</code>&nbsp;as the first node.&nbsp;</p>

<p>Return True if all the elements in the linked list starting from the <code>head</code> correspond to some <em>downward path</em> connected in the binary tree&nbsp;otherwise return False.</p>

<p>In this context downward path means a path that starts at some node and goes downwards.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/02/12/sample_1_1720.png" style="width: 220px; height: 280px;" /></strong></p>

<pre>
<strong>Input:</strong> head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
<strong>Output:</strong> true
<strong>Explanation:</strong> Nodes in blue form a subpath in the binary Tree.  
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/02/12/sample_2_1720.png" style="width: 220px; height: 280px;" /></strong></p>

<pre>
<strong>Input:</strong> head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no path in the binary tree that contains all the elements of the linked list from <span><code>head</code></span>.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree will be in the range <code>[1, 2500]</code>.</li> 
 <li>The number of nodes in the list will be in the range <code>[1, 100]</code>.</li> 
 <li><code>1 &lt;= Node.val&nbsp;&lt;= 100</code>&nbsp;for each node in the linked list and binary tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 链表 | 二叉树</details><br>

<div>👍 171, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
本题思路为《[手把手刷二叉树系列教程](https://aep.xet.tech/s/3YGcq3)》的专属内容，用 [手把手带你刷二叉树（纲领篇）](https://labuladong.gitee.io/article/fname.html?fname=二叉树总结) 中的两种思维模式秒杀所有二叉树的题目，并延伸到回溯算法和动态规划系列问题。如果你已经购买课程还无法查看，请点击 [这里](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63956417e4b02685a425cc0d/1) 查看各个插件的解锁方法。如遇到问题，可以在 [bug 反馈页面](https://github.com/labuladong/fucking-algorithm/discussions/704) 反馈。</details>
</div>



