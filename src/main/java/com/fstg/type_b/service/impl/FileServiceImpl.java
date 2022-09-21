/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.service.impl;

import com.fstg.type_b.model.Demande;
import com.fstg.type_b.model.File;
import com.fstg.type_b.repository.DemandeRepository;
import com.fstg.type_b.repository.FileRepository;
import com.fstg.type_b.service.FileService;
import java.io.IOException;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService{
     final FileRepository fileRepository;
final DemandeRepository demandeRepository;

@Override
 public File store(String libelle, MultipartFile file) throws IOException{
String documentName = StringUtils.cleanPath(file.getOriginalFilename());
File fileDb = new File(libelle, documentName, file.getContentType(), file.getBytes());

return fileRepository.save(fileDb);
}

@Override
public File getFile(String id){
return fileRepository.findById(id).get();
}

@Override
 public Stream<File> getAllFiles(){
return fileRepository.findAll().stream();
}

@Override
public File storeFileDemande(String libelle, MultipartFile file, Long idDemande) throws IOException{
String fileName = StringUtils.cleanPath(file.getOriginalFilename());
File fileDb = new File(libelle, fileName, file.getContentType(), file.getBytes());
    Demande demandeDb = demandeRepository.findById(idDemande).orElse(null);
fileDb.setDemande(demandeDb);
return fileRepository.save(fileDb);
}



@Override
public Stream<File> findAllFilesByDemande(Long demandeId){
return fileRepository.findAllFilesByDemande(demandeId).stream();
}


}
