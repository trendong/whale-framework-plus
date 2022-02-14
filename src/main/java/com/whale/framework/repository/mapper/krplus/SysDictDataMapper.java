package com.whale.framework.repository.mapper.krplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.mybatis.core.query.QueryWrapperX;
import com.whale.framework.repository.common.vo.PageResult;
import com.whale.framework.repository.common.vo.system.dict.SysDictDataExportReqVO;
import com.whale.framework.repository.common.vo.system.dict.SysDictDataPageReqVO;
import com.whale.framework.repository.model.krplus.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
public interface SysDictDataMapper extends BaseMapperX<SysDictData> {

    default SysDictData selectByDictTypeAndValue(String dictType, String value) {
        return selectOne(new QueryWrapper<SysDictData>().eq("dict_type", dictType)
                .eq("value", value));
    }

    default Long selectCountByDictType(String dictType) {
        return selectCount("dict_type", dictType);
    }

    default PageResult<SysDictData> selectPage(SysDictDataPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<SysDictData>()
                .likeIfPresent("label", reqVO.getLabel())
                .likeIfPresent("dict_type", reqVO.getDictType())
                .eqIfPresent("status", reqVO.getStatus())
                .orderByAsc("dict_type", "sort"));
    }

    default List<SysDictData> selectList(SysDictDataExportReqVO reqVO) {
        return selectList(new QueryWrapperX<SysDictData>().likeIfPresent("label", reqVO.getLabel())
                .likeIfPresent("dict_type", reqVO.getDictType())
                .eqIfPresent("status", reqVO.getStatus()));
    }

    default boolean selectExistsByUpdateTimeAfter(Date maxUpdateTime) {
        return selectOne(new QueryWrapper<SysDictData>().select("id")
                .gt("update_time", maxUpdateTime).last("LIMIT 1")) != null;
    }

}
