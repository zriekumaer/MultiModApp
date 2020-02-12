package com.ust.user.repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.common.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    List<UserEntity> findByFirstNameIgnoreCaseContaining(String firstName);

    List<UserEntity> findByLastNameIgnoreCaseContaining(String lastName);

    List<UserEntity> findByEmailIgnoreCaseContaining(String email);

    @Query("SELECT t FROM User t WHERE " +
            "LOWER(t.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<UserEntity> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
    
    public void deleteById(Long id);
    
    @Override
    public Optional<UserEntity> findById(Long id);
}