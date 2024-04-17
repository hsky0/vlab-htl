package class07;

public class Code01_TrieTree {

    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;     // 可以使用hash表

        public TrieNode(){
            pass = 0;
            end  = 0;
            // next[0] == null 没有走向‘a’的路
            // next[1] != null 有走向‘a’的路
            // ...
            // next[25] != null 有走向‘z’的路
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;      // 声明一个根节点

        public Trie() {             // 定义整棵前缀树，开始的时候，前缀树只有一个根节点
            root = new TrieNode();  
        }

        public void insert(String word){        // 方法，将字符串在前缀树上构建出来
            if(word == null){
                return;
            }
            char[] str = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for(int i = 0; i < str.length; i++){
                index = str[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word){
            if(search(word) != 0){          // 确定树中确实加入过word，才删除
                char[] str = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                node.pass--;
                for(int i = 0; i < str.length; i++){
                    index = str[i] - 'a';
                    // if(node.nexts[index] == null){           // 错误
                    //     return;
                    // }
                    if(--node.nexts[index].pass == 0){          // 找到该字符结尾的地方
                        // C++ 要遍历到底去析构
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }


        // word这个单词之前加入过几次
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] str = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < str.length; i++){
                index = str[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所有加入过的字符中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] str = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < str.length; i++){
                index = str[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

    }

        

    

    public static void main(String[] args) {
        String[] strarr = {"kdfujgnbv", "dkfjv", "htl", "htlkgfj", "htl", "hyq", "fkg"};
        Trie trie = new Trie();
        System.out.println(trie.search("htl"));
        for(int i = 0; i < strarr.length; i++){
            trie.insert(strarr[i]);
        } 
        System.out.println(trie.search("htl"));
        System.out.println(trie.prefixNumber("htl"));
        trie.delete("htl");
        System.out.println(trie.search("htl"));
        System.out.println(trie.prefixNumber("htl"));
    }
}