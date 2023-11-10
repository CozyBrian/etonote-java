package me.briannewton.etonote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.briannewton.etonote.model.List;

@Repository
public interface ListRepository extends JpaRepository<List, String> {
  public java.util.List<List> findByUserId(String userId);
}
