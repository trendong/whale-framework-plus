package com.whale.framework.repository.mapper.krplus;

import com.whale.framework.common.pojo.PageResult;
import com.whale.framework.mybatis.core.mapper.BaseMapperX;
import com.whale.framework.mybatis.core.query.QueryWrapperX;
import com.whale.framework.repository.vo.infra.apierrorlog.InfApiErrorLogExportReqVO;
import com.whale.framework.repository.vo.infra.apierrorlog.InfApiErrorLogPageReqVO;
import com.whale.framework.repository.model.krplus.InfApiErrorLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统异常日志 Mapper 接口
 * </p>
 *
 * @author trendong
 * @since 2021-11-27
 */
@Mapper
public interface InfApiErrorLogMapper extends BaseMapperX<InfApiErrorLog> {

    default PageResult<InfApiErrorLog> selectPage(InfApiErrorLogPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<InfApiErrorLog>()
                .eqIfPresent("user_id", reqVO.getUserId())
                .eqIfPresent("user_type", reqVO.getUserType())
                .eqIfPresent("application_name", reqVO.getApplicationName())
                .likeIfPresent("request_url", reqVO.getRequestUrl())
                .betweenIfPresent("exception_time", reqVO.getBeginExceptionTime(), reqVO.getEndExceptionTime())
                .eqIfPresent("process_status", reqVO.getProcessStatus())
                .orderByDesc("id")
        );
    }

    default List<InfApiErrorLog> selectList(InfApiErrorLogExportReqVO reqVO) {
        return selectList(new QueryWrapperX<InfApiErrorLog>()
                .eqIfPresent("user_id", reqVO.getUserId())
                .eqIfPresent("user_type", reqVO.getUserType())
                .eqIfPresent("application_name", reqVO.getApplicationName())
                .likeIfPresent("request_url", reqVO.getRequestUrl())
                .betweenIfPresent("exception_time", reqVO.getBeginExceptionTime(), reqVO.getEndExceptionTime())
                .eqIfPresent("process_status", reqVO.getProcessStatus())
                .orderByDesc("id")
        );
    }

}
