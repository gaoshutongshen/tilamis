package cn.hfjava.news.dao.impl;

import cn.hfjava.news.common.BaseDao;
import cn.hfjava.news.dao.UserDao;
import cn.hfjava.news.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> getUserList() {
        String sql = "select userId,userName," +
                "insert(`password`,1,LENGTH(`password`),repeat('*',length(`password`))) AS `password`," +
                "email,createDate,modifyDate,isDeleted" +
                " from users where isDeleted=0";
        List<User> userList = super.executeQuery(User.class,sql,null);
        return userList;
    }

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO users (userName,`password`,email)VALUES(?,?,?)";
        int result = super.executeUpdate(sql,
                user.getUserName(),
                user.getPassword(),
                user.getEmail());

        return result;
    }

    @Override
    public int deleteAll(String[] ids) { // [12,88,223,28,1,3]
        int count = 0;
        String sql = "delete from users where userId=? and isDeleted=0";
        if(ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                count += super.executeUpdate(sql,ids[i]);
            }
        }
        return count;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        String sql = "select userId,userName," +
                "insert(`password`,1,LENGTH(`password`),repeat('*',length(`password`))) AS `password`," +
                "email,createDate,modifyDate,isDeleted" +
                " from users where isDeleted=0 and userId=?";
        List<User> userList = super.executeQuery(User.class,sql,userId);
        if(userList != null && userList.size() == 1){
            user = userList.get(0);
            return user;
        }
        return null;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update `users` SET userName=?,`password`=?,email=?,modifyDate=? " +
                "WHERE isDeleted=0 AND userId=?";
        List<Object> paramList = new ArrayList<>();
        paramList.add(user.getUserName());
        paramList.add(user.getPassword());
        paramList.add(user.getEmail());
        paramList.add(user.getModifyDate());
        paramList.add(user.getUserId());
        int result = super.executeUpdate(sql,paramList.toArray());
        return result;
    }

    @Override
    public int deleteUserById(int userId) {
        String sql = "delete from users where userId=?";
        int result = super.executeUpdate(sql,userId);
        return result;
    }

    @Override
    public User findUserById(int userId) {
        User user = null;
        String sql = "select userId,userName, password,email,createDate,modifyDate,isDeleted from users where isDeleted=0 and userId=?";
        List<User> userList = super.executeQuery(User.class,sql,userId);
        if(userList != null && userList.size() == 1){
            user = userList.get(0);
            return user;
        }
        return null;
    }
}
