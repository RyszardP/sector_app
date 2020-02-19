package com.ryszard.dao.impls;

import com.ryszard.dao.SectorDao;
import com.ryszard.domain.vo.Sector;
import com.ryszard.exception.DaoException;

import java.util.List;

public class SectorDaoImpl implements SectorDao {
    @Override
    public List<Sector> findAll() throws DaoException {
        return null;
    }

    @Override
    public Sector findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public Sector save(Sector entity) throws DaoException {
        return null;
    }

    @Override
    public Long update(Sector entity) throws DaoException {
        return null;
    }

    @Override
    public List<Sector> search(Sector entity) throws DaoException {
        return null;
    }

    @Override
    public int create(Sector entity) throws DaoException {
        return 0;
    }
}
