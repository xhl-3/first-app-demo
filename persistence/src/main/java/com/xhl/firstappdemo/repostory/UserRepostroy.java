package com.xhl.firstappdemo.repostory;

import com.xhl.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xhl on 2018/8/26.
 * {@link User} {@link Repository}
 * 用户仓储
 */
@Repository
public class UserRepostroy {

    /**
     * 采用内存型存储方式map
     */
    private  final ConcurrentMap<Integer,User> repository=new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator= new AtomicInteger();

    /**
     * 保存用户
     * @param user
     * @return
     */
    public boolean save(User user){
//        boolean success=false;
        Integer id=idGenerator.incrementAndGet();
//        repository.put(id,user);
        user.setId(id);
        return repository.put(id,user)==null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
