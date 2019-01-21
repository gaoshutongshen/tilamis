package cn.hfjava.news.service.impl;

import cn.hfjava.news.dao.UserDao;
import cn.hfjava.news.dao.impl.UserDaoImpl;
import cn.hfjava.news.pojo.User;
import cn.hfjava.news.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAllUser() {
        return userDao.getUserList();
    }


    @Override
    public int deleteAll(String[] ids) {
        return userDao.deleteAll(ids);
    }

    @Override
    public User getUserDetail(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User findUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUserById(user.getUserId());
    }

    @Override
    public boolean addNewUser(User user) {
        int result = userDao.addUser(user);
        return result > 0;
    }
}
