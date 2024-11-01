package com.movies.download.services;


import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.movies.download.models.FileDb;
import com.movies.download.repositories.FileDbRepository;



@Service
public class FileStorageService {

  @Autowired
  private FileDbRepository fileDbRepository;

  public FileDb store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDb FileDb = new FileDb(fileName, file.getContentType(), file.getBytes());

    return fileDbRepository.save(FileDb);
  }

  public FileDb getFile(String id) {
    return fileDbRepository.findById(id).get();
  }
  
  public Stream<FileDb> getAllFiles() {
    return fileDbRepository.findAll().stream();
  }
}