//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//inputs = ["MapSum", "insert", "sum", "insert", "sum"]
//inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
//
// 
//
// 注意：本题与主站 677 题相同： https://leetcode-cn.com/problems/map-sum-pairs/ 
// Related Topics 设计 字典树 哈希表 字符串 👍 6 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {

    /** Initialize your data structure here. */

    static class TrieNode{
        TrieNode[] children;
        int val;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for(char ch : key.toCharArray()){
            if (node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        boolean notPrefix = false;
        for (char ch : prefix.toCharArray()){
            if (node.children[ch-'a'] == null){
                notPrefix = true;
                break;
            }
            node = node.children[ch-'a'];
        }

        if (notPrefix){
            return 0;
        }
        else{
            int[] total = new int[]{0};
            dfs(node, total);
            return total[0];
        }

    }

    private void dfs(TrieNode root, int[] total){

        for (TrieNode children : root.children){
            if (children != null){
                dfs(children, total);
            }
        }
        total[0] += root.val;

    }


}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
