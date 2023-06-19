package code.leetcode.onedayone._23.June;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/12 9:54
 */
public class LC1480_TreeAncestor {

    /*
    * 1 找多所有叶子节点，建立出所有的从叶子节点到根节点的路径，记录每个节点属于那条路径
    * 2 非叶子节点会隶属于多条路径，任意选一条即可。
    * */

    private List<List<Integer>> paths;
    private Map<Integer, Integer> whichPath;

    public LC1480_TreeAncestor(int n, int[] parent) {
        boolean[] isParent = new boolean[n];

        for (int p : parent) {
            if (p >= 0) isParent[p] = true;
        }

        paths = new ArrayList<>();
        whichPath  = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!isParent[i]) {
                int pathId = paths.size();
                List<Integer> path = new ArrayList<>();
                for (int j = i; j != -1; j = parent[j]) {
                    path.add(j);
                    // whichPath.put(j, pathId);
                    // put or putIfAbsent都可以只不过是更不更新路径而已
                    whichPath.putIfAbsent(j,pathId);
                }
                paths.add(path);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        List<Integer> path = paths.get(whichPath.get(node));
        int i = path.indexOf(node);

        return i + k < path.size() ? path.get(i + k) : -1;
    }

    public static void main(String[] args) {
        LC1480_TreeAncestor treeAncestor = new LC1480_TreeAncestor(7, new int[]{-1,0,0,1,1,2,2});

        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }


}
