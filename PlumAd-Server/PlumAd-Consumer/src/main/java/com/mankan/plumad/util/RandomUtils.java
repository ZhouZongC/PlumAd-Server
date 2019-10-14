package com.mankan.plumad.util;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by GV
 * DATE:2017/8/1
 * TIME:下午8:21
 */
public class RandomUtils {

    /**
     * 自定义位数的随机码
     * @return
     */
    public static String randomNumberCode(int randomCodeLength) {
        String number=RandomStringUtils.random(randomCodeLength, false, true);
        if (number.startsWith("0")){
            return RandomUtils.randomCode(randomCodeLength);
        }
        return number;
    }


    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



    public static String createOrderNumber(int orderId) {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR)).substring(2);
        String month = String.valueOf(date.get(Calendar.MONTH) + 1);
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        String hour = String.valueOf(date.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(date.get(Calendar.MINUTE));
        String second = String.valueOf(date.get(Calendar.SECOND));
        String str = year + month + day + hour + minute + second;
        String code = randomCode();
        String id = str + orderId + code;
        if (id.length() < 16) {
            switch (16 - id.length()) {
                case 1:
                    id = id + randomCode(1);
                    break;
                case 2:
                    id = id + randomCode(2);
                    break;
                case 3:
                    id = id + randomCode(3);
                    break;
                case 4:
                    id = id + randomCode(4);
                    break;
                default:
                    id = id + randomCode(5);
            }
        }
        return id;
    }

    public static String randomCode() {
        return RandomStringUtils.random(4, false, true);
    }

    public static String randomCode(int randomCodeLength) {
        return RandomStringUtils.random(randomCodeLength, false, true);
    }

}
