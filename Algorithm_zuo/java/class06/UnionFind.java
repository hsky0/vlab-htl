package class06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public static class Mysets{

        // 一个节点对应的集合是什么 node -> List(该节点所属的集合)
        public HashMap<Node, List<Node>> setMap;
        
        public Mysets(List<Node> nodes){
            for(Node cur : nodes){
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for(Node toNode : toSet){
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }


}
