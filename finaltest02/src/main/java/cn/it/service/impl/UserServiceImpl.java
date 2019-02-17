package cn.it.service.impl;

import cn.it.domain.Condition;
import cn.it.domain.PageBean;
import cn.it.domain.User;
import cn.it.mapper.UserMapper;
import cn.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public PageBean<User> findUserByCondition(Condition condition, Integer pageNum) {
//        PageBean<User> pb=new PageBean<User>();
//        Integer totalCount = userMapper.findTotalCount(condition);
//
//        Integer rows = 5;
//        Integer totalPage = totalCount % rows == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
//
//        Integer start = (pageNum - 1) * rows;
//
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("condition",condition);
//        map.put("pageStart",start);
//        map.put("pageSize",rows);
//        List<User> list = userMapper.findByCondition(map);
//
//        //pb.setTotalPage(totalPage);
//        pb.setPages(totalPage);
//        pb.setPageNum(pageNum);
//        pb.setPageSize(rows);
//        pb.setCounts(totalCount);
//        pb.setList(list);
//
//        return pb;

        PageBean<User> pageBean = new PageBean<>();
        Integer counts = userMapper.findTotalCount(condition);
//        System.out.println(counts); --->null!
        Integer pageSize = 5;
        Integer pages = counts % pageSize == 0 ? (counts / pageSize) : (counts / pageSize) + 1;
        Integer pageStart = (pageNum - 1) * pageSize;
        Map<String, Object> map = new HashMap<>();
        map.put("condition", condition);
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        List<User> list = userMapper.findByCondition(map);
        pageBean.setPages(pages);
        pageBean.setPageStart(pageStart);
        pageBean.setPageSize(pageSize);
        pageBean.setCounts(counts);
        pageBean.setList(list);
        pageBean.setPageNum(pageNum);
        return pageBean;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(Integer uid) {
        userMapper.delUser(uid);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }


}
