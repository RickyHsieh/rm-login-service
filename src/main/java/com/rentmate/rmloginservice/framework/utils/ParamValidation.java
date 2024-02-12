package com.rentmate.rmloginservice.framework.utils;

/**
 * Validation. 2024/02/10 01:44
 * Description:
 * Author: Ricky
 *
 * @version 1.0.0
 */
public class ParamValidation {

    public static boolean checkAllParamValid(String... parameters) {
        for (String param : parameters) {
            if (param == null || param.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
