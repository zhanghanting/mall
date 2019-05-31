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
    public void setNonNullParameter(PreparedStatement preparedStatement,int index,int[] ints,JdbcType jdbcType) throws SQLException
    {
        //将JavaBean字段类型转换为对应数据库中的类型
        //index是你需要转换的数据所在数据库表的列数
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < ints.length;++i)
        {
            stringBuilder.append(ints[i]);
            if(i != ints.length-1)
                stringBuilder.append(",");
        }
        String s = stringBuilder.toString();
        preparedStatement.setString(index,s);

    }
    //数据库中column字段类型转换为相应的JavaBean类型
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
