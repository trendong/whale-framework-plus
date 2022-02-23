package com.whale.framework.repository.mapper.krplus;

import com.whale.framework.common.pojo.PageResult;
import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.mybatis.core.query.QueryWrapperX;
import com.whale.framework.repository.vo.infra.apiaccesslog.InfApiAccessLogExportReqVO;
import com.whale.framework.repository.vo.infra.apiaccesslog.InfApiAccessLogPageReqVO;
import com.whale.framework.repository.model.krplus.InfApiAccessLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * API 访问日志表 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
@Mapper
public interface InfApiAccessLogMapper extends BaseMapperX<InfApiAccessLog> {

    default PageResult<InfApiAccessLog> selectPage(InfApiAccessLogPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<InfApiAccessLog>()
                .eqIfPresent("user_id", reqVO.getUserId())
                .eqIfPresent("user_type", reqVO.getUserType())
                .eqIfPresent("application_name", reqVO.getApplicationName())
                .likeIfPresent("request_url", reqVO.getRequestUrl())
                .betweenIfPresent("begin_time", reqVO.getBeginBeginTime(), reqVO.getEndBeginTime())
                .geIfPresent("duration", reqVO.getDuration())
                .eqIfPresent("result_code", reqVO.getResultCode())
                .orderByDesc("id")
        );
    }

    default List<InfApiAccessLog> selectList(InfApiAccessLogExportReqVO reqVO) {
        return selectList(new QueryWrapperX<InfApiAccessLog>()
                .eqIfPresent("user_id", reqVO.getUserId())
                .eqIfPresent("user_type", reqVO.getUserType())
                .eqIfPresent("application_name", reqVO.getApplicationName())
                .likeIfPresent("request_url", reqVO.getRequestUrl())
                .betweenIfPresent("begin_time", reqVO.getBeginBeginTime(), reqVO.getEndBeginTime())
                .geIfPresent("duration", reqVO.getDuration())
                .eqIfPresent("result_code", reqVO.getResultCode())
                .orderByDesc("id")
        );
    }

}
