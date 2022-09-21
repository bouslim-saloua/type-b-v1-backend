/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.service;

import com.fstg.type_b.model.File;
import java.io.IOException;
import java.util.stream.Stream;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author USER
 */
public interface FileService {
    File store(String libelle, MultipartFile file) throws IOException;
File storeFileDemande(String libelle, MultipartFile file, Long idDemande) throws IOException;
Stream<File> findAllFilesByDemande( Long demandeId);
File getFile(String id);
    Stream<File> getAllFiles();
}
