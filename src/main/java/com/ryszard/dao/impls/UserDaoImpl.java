package com.ryszard.dao.impls;

import com.ryszard.dao.UserDao;
import com.ryszard.domain.vo.User;
import com.ryszard.exception.DaoException;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public User findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public User save(User entity) throws DaoException {
        return null;
    }

    @Override
    public Long update(User entity) throws DaoException {
        return null;
    }

    @Override
    public List<User> search(User entity) throws DaoException {
        return null;
    }

    @Override
    public int create(User entity) throws DaoException {
        return 0;
    }
}
