package org.lhyf.mybatis.proxy;

import org.lhyf.mybatis.bean.User;

import java.util.List;

/**
 * @author YF
 * @date 2021/08/08 10:14
 * @Description
 */
public interface UserMapper {
    User getUserById(Integer id);

    List<User> getUserList();
}
