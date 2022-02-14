package com.whale.framework.repository.mapper.krplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.mybatis.core.query.QueryWrapperX;
import com.whale.framework.repository.common.vo.system.menu.SysMenuListReqVO;
import com.whale.framework.repository.model.krplus.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
public interface SysMenuMapper extends BaseMapperX<SysMenu> {

    default Long selectCountByParentId(Long parentId) {
        return selectCount(new QueryWrapper<SysMenu>().eq("parent_id", parentId));
    }

    default List<SysMenu> selectList(SysMenuListReqVO reqVO) {
        return selectList(new QueryWrapperX<SysMenu>().likeIfPresent("name", reqVO.getName())
                .eqIfPresent("status", reqVO.getStatus()));
    }

    default SysMenu selectByParentIdAndName(Long parentId, String name) {
        return selectOne(new QueryWrapper<SysMenu>().eq("parent_id", parentId)
                .eq("name", name));
    }


}
