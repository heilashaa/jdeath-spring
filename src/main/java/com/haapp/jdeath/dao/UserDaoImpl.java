package com.haapp.jdeath.dao;

import com.haapp.jdeath.entity.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao{

    private final SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) getSession().createQuery("from User").list();
    }

    @Override
    public User getUserWithMaxAccount() {
        return (User) getSession().createQuery("select User from User u left join Account a on u.id=a.id group by u.id order by a.account desc").list().get(0);
    }

    @Override
    public Long getSumOfAllAccounts() {
        return (Long) getSession().createQuery("select sum (account) from Account").list().get(0);
    }
}
