package com.whale.framework.repository.mapper.krplus;

import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.mybatis.core.query.QueryWrapperX;
import com.whale.framework.repository.common.vo.PageResult;
import com.whale.framework.repository.common.vo.system.dict.SysDictTypeExportReqVO;
import com.whale.framework.repository.common.vo.system.dict.SysDictTypePageReqVO;
import com.whale.framework.repository.model.krplus.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
public interface SysDictTypeMapper extends BaseMapperX<SysDictType> {

    default PageResult<SysDictType> selectPage(SysDictTypePageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<SysDictType>()
                .likeIfPresent("name", reqVO.getName())
                .likeIfPresent("`type`", reqVO.getType())
                .eqIfPresent("status", reqVO.getStatus())
                .betweenIfPresent("create_time", reqVO.getBeginCreateTime(), reqVO.getEndCreateTime()));
    }

    default List<SysDictType> selectList(SysDictTypeExportReqVO reqVO) {
        return selectList(new QueryWrapperX<SysDictType>()
                .likeIfPresent("name", reqVO.getName())
                .likeIfPresent("`type`", reqVO.getType())
                .eqIfPresent("status", reqVO.getStatus())
                .betweenIfPresent("create_time", reqVO.getBeginCreateTime(), reqVO.getEndCreateTime()));
    }

    default SysDictType selectByType(String type) {
        return selectOne(new QueryWrapperX<SysDictType>().eq("`type`", type));
    }

    default SysDictType selectByName(String name) {
        return selectOne(new QueryWrapperX<SysDictType>().eq("name", name));
    }

}
