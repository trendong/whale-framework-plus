package com.whale.framework.repository.mapper.krplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.repository.model.krplus.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
public interface SysRoleMenuMapper extends BaseMapperX<SysRoleMenu> {

    default List<SysRoleMenu> selectListByRoleId(Long roleId) {
        return selectList(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId));
    }

    default void insertList(Long roleId, Collection<Long> menuIds) {
        List<SysRoleMenu> list = menuIds.stream().map(menuId -> {
            SysRoleMenu entity = new SysRoleMenu();
            entity.setRoleId(roleId);
            entity.setMenuId(menuId);
            return entity;
        }).collect(Collectors.toList());
        // TODO mybatis plus 增加批量插入的功能
        list.forEach(this::insert);
    }


    default void deleteListByRoleIdAndMenuIds(Long roleId, Collection<Long> menuIds) {
        delete(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId)
                .in("menu_id", menuIds));
    }

    default void deleteListByMenuId(Long menuId) {
        delete(new QueryWrapper<SysRoleMenu>().eq("menu_id", menuId));
    }

    default void deleteListByRoleId(Long roleId) {
        delete(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId));
    }


}
