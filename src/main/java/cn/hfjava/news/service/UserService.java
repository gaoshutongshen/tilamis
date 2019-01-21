package cn.hfjava.news.service;

import cn.hfjava.news.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    boolean addNewUser(User user);

    int deleteAll(String[] ids);

    User getUserDetail(int userId);
    User findUserById(int userId);

    int modifyUser(User user);
    int deleteUser(User user);
}
