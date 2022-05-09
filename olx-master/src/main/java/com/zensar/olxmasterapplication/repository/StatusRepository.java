package com.zensar.olxmasterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olxmasterapplication.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}
