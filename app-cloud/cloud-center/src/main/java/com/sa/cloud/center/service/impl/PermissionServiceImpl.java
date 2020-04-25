package com.sa.cloud.center.service.impl;

import com.sa.cloud.base.domain.center.MetaDTO;
import com.sa.cloud.base.domain.center.Permission;
import com.sa.cloud.base.domain.center.TreeDTO;
import com.sa.cloud.base.mapper.center.PermissionMapper;
import com.sa.cloud.center.service.PermissionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public List<Permission> findPermissionByRoleId(Long roleId) {
        return permissionMapper.findPermissionByRoleId(roleId);
    }

    @Override
    public Permission findPermissionById(int id) {
        return null;
    }

    @Override
    public int insertPermission(Permission permission) {
        return 0;
    }

    @Override
    public int updatePermission(Permission permission) {
        return 0;
    }

    @Override
    public int deletePermission(Permission permission) {
        return 0;
    }


    /**
     * 将权限列表数据转换成tree
     *
     * @param permissions
     */
    public List<Object> getPermissionTree(List<Permission> permissions) {
        List<Object> list = new ArrayList<>();
        for (Permission p : permissions) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (p.getParentId() == 0) {
                map.put("id", p.getId());
                map.put("title", p.getTitle());
                map.put("parentId", p.getParentId());
                map.put("path", p.getPath());
                map.put("component", p.getPath());

                Map<String, Object> metaMap = new LinkedHashMap<>();
                metaMap.put("title", p.getTitle());
                metaMap.put("icon", p.getIcon());
                metaMap.put("noCache", true);
                map.put("meta", metaMap);

                map.put("children", childPermission(p.getId(), permissions));
                list.add(map);
            }
        }
        return list;
    }


    private List<Object> childPermission(Long id, List<Permission> permissions) {
        List<Object> list = new ArrayList<>();
        for (Permission p : permissions) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (p.getParentId() == id) {
                map.put("id", p.getId());
                map.put("title", p.getTitle());
                map.put("parentId", p.getParentId());
                map.put("path", p.getPath());
                map.put("component", p.getPath());

                Map<String, Object> metaMap = new LinkedHashMap<>();
                metaMap.put("title", p.getTitle());
                metaMap.put("icon", p.getIcon());
                metaMap.put("noCache", true);
                map.put("meta", metaMap);

                List<Object> subChild = childPermission(p.getId(), permissions);
                if(CollectionUtils.isNotEmpty(subChild)) {
                    map.put("children", subChild);
                }
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将权限列表数据转换成tree
     *
     * @param permissions
     */
    /*public List<TreeDTO> getPermissionTree(List<Permission> permissions) {
        List<TreeDTO> list = new ArrayList<>();
        for (Permission p : permissions) {
            TreeDTO tree = new TreeDTO();
            if (p.getParentId() == 0) {
                tree.setId(p.getId());
                tree.setTitle(p.getTitle());
                tree.setParentId(p.getParentId());
                tree.setPath(p.getPath());
                tree.setComponent(p.getPath());

                MetaDTO meta = new MetaDTO();
                meta.setTitle(p.getTitle());
                meta.setIcon(p.getIcon());
                meta.setNoCache(true);

                tree.setMeta(meta);
                tree.setChildren(childPermission(p.getId(), permissions));

                list.add(tree);
            }
        }
        return list;
    }


    private List<TreeDTO> childPermission(Long id, List<Permission> permissions) {
        List<TreeDTO> list = new ArrayList<>();
        for (Permission p : permissions) {
            Map<String, Object> map = new LinkedHashMap<>();
            TreeDTO tree = new TreeDTO();
            if (p.getParentId() == id) {
                tree.setId(p.getId());
                tree.setTitle(p.getTitle());
                tree.setParentId(p.getParentId());
                tree.setPath(p.getPath());
                tree.setComponent(p.getPath());

                MetaDTO meta = new MetaDTO();
                meta.setTitle(p.getTitle());
                meta.setIcon(p.getIcon());
                meta.setNoCache(true);

                tree.setMeta(meta);

                List<TreeDTO> subChild = childPermission(p.getId(), permissions);
                if(CollectionUtils.isNotEmpty(subChild)) {
                    map.put("children", subChild);
                }
                list.add(tree);
            }
        }
        return list;
    }*/


}
