package cn.hfjava.news.common;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//数据库操作辅助类
public class BaseDao {

    private static Properties props = null;
    private static final String CONFIG_FILE_NAME = "jdbc.properties";
    private static  String jdbcUrl = null;
    private static  String userName = null;
    private static  String password = null;

    /*static {
        props = new Properties();
        InputStream is = BaseDao.class.getClassLoader()
                .getResourceAsStream(CONFIG_FILE_NAME);
        try {
            props.load(is);

            String driverClass =
                    props.getProperty("jdbc.driver_class");
            jdbcUrl = props.getProperty("jdbc.database_url");
            userName = props.getProperty("jdbc.user_name");
            password = props.getProperty("jdbc.password");
            //加载并注册驱动程序
            Class.forName(driverClass);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private Connection getConnection(){
        Connection conn = null;
        try {
            //conn = DriverManager.getConnection(jdbcUrl,userName,password);
            //获取Context实例
            Context ctx = new InitialContext();
            //通过ctx的lookup()方法从Tomcat容器中获取DataSource实例
            DataSource dataSource = (DataSource)ctx.
                    lookup("java:comp/env/jdbc/jsp");
            //通过数据源对象从连接池中获得可用的连接对象
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public int executeUpdate(String sql,Object ... params){
        int affectedRows = 0;
        Connection conn = this.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if(params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1,params[i]);
                }
            }
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(conn,pstmt,null);
        }
        return affectedRows;
    }

    public <E> List<E> executeQuery(Class<E> clazz,String sql,Object ... params){
        List<E> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            conn  = getConnection();
            pstmt = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1,params[i]);
                }
            }
            rst = pstmt.executeQuery();
            ResultSetMetaData rsmd = rst.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rst.next()){
                //通过反射机制动态创建未知类实例对象
                E entity = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i+1);
                    Object columnValue = rst.getObject(columnName);

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(entity,columnValue);
                }

                list.add(entity);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            release(conn,pstmt,rst);
        }
        return list;
    }


    /**
     * 提供统一的插入/删除/更新方法[需要考虑事务]
     *
     * @param sql
     * @param parameters
     */
    public void executeUpdate(String[] sql, String[][] parameters) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn  = getConnection();
            //禁用自动提交事务
            conn.setAutoCommit(false);

            for (int i = 0; i < sql.length; i++) {
                if (parameters[i] != null) {
                    pstmt = conn.prepareStatement(sql[i]);
                    for (int j = 0; j < parameters[i].length; i++) {
                        pstmt.setString(j + 1, parameters[i][j]);
                    }
                    pstmt.executeUpdate();
                }
            }
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();//回滚操作
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());

        } finally {
            release(conn,pstmt,null);
        }
    }

    private void release(Connection conn, PreparedStatement pstmt, ResultSet rst) {
        try{
            if(null != rst ) {
                rst.close();
                rst = null;
            }
            if(null != pstmt){
                pstmt.close();
                pstmt = null;
            }
            if(null != conn){
                conn.close();
                conn = null;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
