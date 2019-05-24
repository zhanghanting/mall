package com.springboot.mall.utils;

import java.util.Arrays;

public class StringToIntArray
{
    public static int[] conversion(String[] s1)
    {

        int[] ints = null;
        try
        {
            if(s1 != null)
            {
                String s = Arrays.toString(s1);
                String substring = s.substring(1,s.length() - 1);
                String[] split = substring.split(",");
                ints = new int[split.length];
                for(int i = 0;i < split.length;++i)
                {
                    ints[i] = Integer.parseInt(split[i]);
                }
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
       return ints;
    }
}
