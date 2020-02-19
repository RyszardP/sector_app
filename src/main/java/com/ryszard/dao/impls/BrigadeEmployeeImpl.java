package com.ryszard.dao.impls;

import com.ryszard.dao.BrigadeDao;
import com.ryszard.domain.vo.Brigade;
import com.ryszard.exception.DaoException;

import java.util.List;

public class BrigadeEmployeeImpl implements BrigadeDao {
    @Override
    public List<Brigade> findAll() throws DaoException {
        return null;
    }

    @Override
    public Brigade findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public Brigade save(Brigade entity) throws DaoException {
        return null;
    }

    @Override
    public Long update(Brigade entity) throws DaoException {
        return null;
    }

    @Override
    public List<Brigade> search(Brigade entity) throws DaoException {
        return null;
    }

    @Override
    public int create(Brigade entity) throws DaoException {
        return 0;
    }
}
