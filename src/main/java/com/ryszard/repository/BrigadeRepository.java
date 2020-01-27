package com.ryszard.repository;

import com.ryszard.domain.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrigadeRepository extends JpaRepository<Brigade,Long>, CrudRepository<Brigade,Long>,
        PagingAndSortingRepository<Brigade,Long> {
}
