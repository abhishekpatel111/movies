package com.movies.download.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.download.models.FileDb;


@Repository
public interface FileDbRepository extends JpaRepository<FileDb, String> {

}