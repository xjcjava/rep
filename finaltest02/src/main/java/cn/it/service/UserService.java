package cn.it.service;

import cn.it.domain.Condition;
import cn.it.domain.PageBean;
import cn.it.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();
    PageBean<User> findUserByCondition(Condition condition,Integer pageNum);
    User login(User user);
    void addUser(User user);
    void delUser(Integer uid);
    void updateUser(User user);
    User findUserById(Integer uid);

}
