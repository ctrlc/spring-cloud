package com.sa.cloud.base;

import com.sa.cloud.base.domain.center.TreeDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * list　和　tree　互转
 *
 * @author sa
 * @date 2020-04-13
 */
public class TreeListConvertUtil {

    /**
     * Tree转list
     *
     * @param trees
     */
    public static List<TreeDTO> tree2list(List<TreeDTO> trees) {
        List<TreeDTO> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(trees)) {
            return list;
        }
        for (TreeDTO tree : trees) {
            list.add(tree);
            if (null == tree.getChildren()) {
                continue;
            }
            for (TreeDTO sub : tree.getChildren()) {
                tree2list(sub, list, tree.getId());
            }
        }
        return list;
    }

    /**
     * Tree转list
     * <p>
     * 适用只有一个跟节点的情况
     * </p>
     *
     * @param root
     * @param list
     * @param parentId
     */
    public static void tree2list(TreeDTO root, List<TreeDTO> list, Long parentId) {
        if (root == null) {
            return;
        }
        TreeDTO d = new TreeDTO(root.getId(), parentId, root.getTitle());
        list.add(d);
        if (null == root.getChildren()) {
            return;
        }
        for (TreeDTO sub : root.getChildren()) {
            tree2list(sub, list, d.getId());
        }
    }

    /**
     * list转Tree
     *
     * @param srclist
     * @return
     */
    public static List<TreeDTO> list2tree(List<TreeDTO> srclist) {
        List<TreeDTO> trees = new ArrayList<>();
        for (TreeDTO t1 : srclist) {
            boolean isRoot = true;
            for (TreeDTO t2 : srclist) {
                if (t1.getParentId() != null && t1.getParentId().equals(t2.getId())) {
                    isRoot = false;
                    if (t2.getChildren() == null) {
                        t2.setChildren(new ArrayList<>());
                    }
                    t2.getChildren().add(t1);
                    break;
                }
            }
            if (isRoot) {
                trees.add(t1);
            }
        }
        return trees;
    }


    public static void main(String[] args) {
/*        List<TreeDTO> list = new ArrayList<TreeDTO>();
//        list.add(new TreeDTO("1",null,"中国"));
        list.add(new TreeDTO("2", "1", "广东"));
        list.add(new TreeDTO("3", "2", "广州"));
        list.add(new TreeDTO("4", "2", "深圳"));
        list.add(new TreeDTO("5", "3", "越秀"));
        list.add(new TreeDTO("6", "3", "天河"));
        list.add(new TreeDTO("7", "4", "福田"));
        list.add(new TreeDTO("8", "4", "南山"));
        list.add(new TreeDTO("9", "4", "罗湖"));
        list.add(new TreeDTO("10", "1", "河南"));
        list.add(new TreeDTO("11", "10", "郑州"));
        list.add(new TreeDTO("12", "11", "二七"));
        List<TreeDTO> trees = list2tree(list);
        System.out.println(trees.size());
//        tree2list(trees.get(0),list2,null);
        List<TreeDTO> list2 = tree2list(trees);
        System.out.println(list2.size());*/
    }

}
