package com.sa.cloud.center.util;


import com.sa.cloud.base.domain.center.Permission;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuTreeUtil {

    private static List<Permission> menuCommon;
    private static List<Object> list = new ArrayList<>();

    public static List<Object> menuList(List<Permission> menu) {
        menuCommon = menu;
        for (Permission x : menu) {
            Map<String, Object> mapArr = new LinkedHashMap<>();
            if (x.getParentId() == 0) {
                mapArr.put("id", x.getId());
                mapArr.put("title", x.getTitle());
                mapArr.put("pid", x.getParentId());
                mapArr.put("children", menuChild(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public static List<?> menuChild(Long id) {
        List<Object> lists = new ArrayList<>();
        for (Permission a : menuCommon) {
            Map<String, Object> childArray = new LinkedHashMap<>();
            if (a.getParentId() == id) {
                childArray.put("id", a.getId());
                childArray.put("title", a.getTitle());
                childArray.put("pid", a.getParentId());
                childArray.put("children", menuChild(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }
}
