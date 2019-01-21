package cn.hfjava.news.dao;



import cn.hfjava.news.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();


    int addUser(User user);


    int deleteAll(String[] ids);


    User getUserById(int userId);

    int updateUser(User user);

    int deleteUserById(int userId);

    User findUserById(int userId);



}
