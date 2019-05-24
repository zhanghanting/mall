package com.springboot.mall.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringToIntArray extends BaseTypeHandler<int []>
{
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement,int i,int[] ints,JdbcType jdbcType) throws SQLException
    {

    }

    @Override
    public int[] getNullableResult(ResultSet resultSet,String s) throws SQLException
    {
        String identityString = resultSet.getString(s);
        String[] identityArray = identityString.split(",");
        int[] ints = new int[identityArray.length];
        for(int i = 0;i <identityArray.length;++i)
        {
            ints[i] = Integer.parseInt(identityArray[i]);
        }
        return ints;
    }

    @Override
    public int[] getNullableResult(ResultSet resultSet,int i) throws SQLException
    {
        return new int[0];
    }

    @Override
    public int[] getNullableResult(CallableStatement callableStatement,int i) throws SQLException
    {
        return new int[0];
    }
}
