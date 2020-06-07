package com.example.mvctest.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/6 0006 下午 23:30
 * @Version 1.0
 */

@Transactional
@Repository
public interface UserRepository  extends PagingAndSortingRepository<User,Long> {

    User findByName(String name);

}
