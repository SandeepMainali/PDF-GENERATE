package org.example.crud.Repository;


import org.example.crud.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

}
