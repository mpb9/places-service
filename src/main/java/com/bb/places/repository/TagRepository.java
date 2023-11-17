package com.bb.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.places.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

}
