package com.lakshmi.classregistration.repository;

import com.lakshmi.classregistration.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository  extends JpaRepository<StudentEntity, Integer>
{
}
