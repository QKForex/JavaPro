package com.qkforex.dev.concurrency.chapter01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordQuery {

    interface rowHander<T> {
        T handle(ResultSet rs);
    }

    private Connection connection;
    //private PreparedStatement ps;
    //private ResultSet rs;

    RecordQuery(Connection conn)
    {
        this.connection=conn;
    }

    public <T> T query(rowHander<T> handle,String sql,Object ... params)throws SQLException
    {
        try
        {
            PreparedStatement ps=this.connection.prepareStatement(sql);
            int index=1;
            for (Object object:params)
            {
                ps.setObject(index++,object);
            }
            ResultSet rs=ps.executeQuery();
            return handle.handle(rs);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            this.connection.close();
        }
        return null;
    }

}


