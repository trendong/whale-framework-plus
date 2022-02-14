package com.whale.framework.repository.mapper.krplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.repository.model.krplus.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
public interface SysUserRoleMapper extends BaseMapperX<SysUserRole> {

    default List<SysUserRole> selectListByUserId(Long userId) {
        return selectList(new QueryWrapper<SysUserRole>().eq("user_id", userId));
    }

    default void insertList(Long userId, Collection<Long> roleIds) {
        List<SysUserRole> list = roleIds.stream().map(roleId -> {
            SysUserRole entity = new SysUserRole();
            entity.setUserId(userId);
            entity.setRoleId(roleId);
            return entity;
        }).collect(Collectors.toList());
        // TODO 芋艿，mybatis plus 增加批量插入的功能
        list.forEach(this::insert);
    }

    default void deleteListByUserIdAndRoleIdIds(Long userId, Collection<Long> roleIds) {
        delete(new QueryWrapper<SysUserRole>().eq("user_id", userId)
                .in("role_id", roleIds));
    }

    default void deleteListByUserId(Long userId) {
        delete(new QueryWrapper<SysUserRole>().eq("user_id", userId));
    }

    default void deleteListByRoleId(Long roleId) {
        delete(new QueryWrapper<SysUserRole>().eq("role_id", roleId));
    }

}
