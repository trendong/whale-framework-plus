package com.whale.framework.common.util.date;

import java.util.Date;

/**
 * 时间工具类
 *
 * @author trendong
 */

public class DateUtils {

    public static final String FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";

    public static long diff(Date endTime, Date startTime) {
        return endTime.getTime() - startTime.getTime();
    }

}
