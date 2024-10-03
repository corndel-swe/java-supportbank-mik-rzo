package com.corndel.supportbank.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrencyUtils {

    public static String formatTimestamp(Long timestamp) {
        Date date = new Date(timestamp * 1000);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }
}
