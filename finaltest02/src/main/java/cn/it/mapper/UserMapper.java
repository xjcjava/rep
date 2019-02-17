package cn.it.mapper;

import cn.it.domain.Condition;
import cn.it.domain.PageBean;
import cn.it.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> findAll();
    Integer findTotalCount(Condition condition);
    List<User> findByCondition(Map<String,Object> map);
    User login(User user);
    void addUser(User user);
    void delUser(Integer uid);
    void updateUser(User user);
    User findUserById(Integer uid);



}
