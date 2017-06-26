package com.example.administrator.taiya.entity;

import java.util.regex.Pattern;

public class ParseData
{

    private static boolean is0or1(String paramString)
    {
        return Pattern.compile("^[0-1]*$").matcher(paramString).matches();
    }

    public static boolean isDeviceId(String paramString)
    {
        String str = paramString.toUpperCase();
        while ((!is0or1(str.substring(0, 1))) || (!isHex(str.substring(1, str.length())))) {
            return true;
        }
        return false;
    }

    private static boolean isHex(String paramString)
    {
        return Pattern.compile("^[A-Fa-f0-9]+$").matcher(paramString).matches();
    }

}