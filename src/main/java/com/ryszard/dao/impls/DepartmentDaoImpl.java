package com.ryszard.dao.impls;

import com.ryszard.dao.DepartmentDao;
import com.ryszard.domain.vo.Department;
import com.ryszard.exception.DaoException;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public List<Department> findAll() throws DaoException {
        return null;
    }

    @Override
    public Department findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public Department save(Department entity) throws DaoException {
        return null;
    }

    @Override
    public Long update(Department entity) throws DaoException {
        return null;
    }

    @Override
    public List<Department> search(Department entity) throws DaoException {
        return null;
    }

    @Override
    public int create(Department entity) throws DaoException {
        return 0;
    }
}
