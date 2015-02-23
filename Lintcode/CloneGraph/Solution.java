import java.util.*;

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        //nodes works as a queue to BFS;
        //hashmap works as 1.keep the relationship between new and old; 2.flag
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
        new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        //put the 1st one into queue;
        map.put(node, new UndirectedGraphNode(node.label));
        nodes.add(node);
        int i = 0;
        while (i < nodes.size()){
            UndirectedGraphNode temp = nodes.get(i);
            for (int j = 0; j < temp.neighbors.size(); j++) {
                if (!map.containsKey(temp.neighbors.get(j))) {
                    nodes.add(temp.neighbors.get(j));
                    map.put(temp.neighbors.get(j),
                    new UndirectedGraphNode(temp.neighbors.get(j).label));
                }
            }
            i++;
        }
        
        //clone neighbors
        for ( i = 0; i < nodes.size(); i++) {
            for(int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                map.get(nodes.get(i)).neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        
        return map.get(node);
        
    }
}
