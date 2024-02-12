package com.rentmate.rmloginservice.framework.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TimeUtils. 2024/02/10 02:00
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
public class TimeUtils {

    public static String getNowFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

}
