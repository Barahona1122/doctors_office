package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsersModel;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {

    /**
     * @return
     */
    List<UsersModel> findByType(Optional<Integer> type);

    /**
     * @return
     */
    List<UsersModel> findByName(String name);
}
