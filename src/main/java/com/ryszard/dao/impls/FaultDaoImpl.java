package com.ryszard.dao.impls;

import com.ryszard.dao.FaultDao;
import com.ryszard.domain.vo.Fault;
import com.ryszard.exception.DaoException;

import java.util.List;

public class FaultDaoImpl implements FaultDao {
    @Override
    public List<Fault> findAll() throws DaoException {
        return null;
    }

    @Override
    public Fault findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public Fault save(Fault entity) throws DaoException {
        return null;
    }

    @Override
    public Long update(Fault entity) throws DaoException {
        return null;
    }

    @Override
    public List<Fault> search(Fault entity) throws DaoException {
        return null;
    }

    @Override
    public int create(Fault entity) throws DaoException {
        return 0;
    }
}
