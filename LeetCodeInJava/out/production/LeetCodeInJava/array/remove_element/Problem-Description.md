给定一个数组 _nums _和一个值 _val_，你需要**[原地](https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95)**移除所有数值等于 _val _的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在**[原地](https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95)修改输入数组**并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

**示例 1:**

<pre style="box-sizing: border-box; font-family: SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace; font-size: 13px; margin-top: 0px; margin-bottom: 1em; overflow: auto; background: rgb(247, 249, 250); padding: 10px 15px; color: rgb(38, 50, 56); line-height: 1.6; border-radius: 3px; white-space: pre-wrap; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; text-decoration-style: initial; text-decoration-color: initial;">给定 _nums_ = **[3,2,2,3]**, _val_ = **3**,

函数应该返回新的长度 **2**, 并且 _nums_ 中的前两个元素均为 **2**。

你不需要考虑数组中超出新长度后面的元素。
</pre>

**示例 2:**

<pre style="box-sizing: border-box; font-family: SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace; font-size: 13px; margin-top: 0px; margin-bottom: 1em; overflow: auto; background: rgb(247, 249, 250); padding: 10px 15px; color: rgb(38, 50, 56); line-height: 1.6; border-radius: 3px; white-space: pre-wrap; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; text-decoration-style: initial; text-decoration-color: initial;">给定 _nums_ = **[0,1,2,2,3,0,4,2]**, _val_ = **2**,

函数应该返回新的长度 **`5`**, 并且 _nums_ 中的前五个元素为 **`0`**, **`1`**, **`3`**, **`0`**, **4**。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。</pre>