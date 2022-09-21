/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.controller;

import com.fstg.type_b.model.File;
import com.fstg.type_b.payload.response.doc.message.ResponseDocument;
import com.fstg.type_b.payload.response.doc.message.ResponseMessage;
import com.fstg.type_b.service.FileService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author USER
 */
@Api
@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    final FileService fileService;

@PostMapping("/upload")
public ResponseEntity<ResponseMessage> uploadFile(@RequestParam String libelle, @RequestPart("file") MultipartFile file){
String message= "";
try{
fileService.store(libelle, file);
message = "Document uploaded successfully : " + file.getOriginalFilename();
return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
}catch(Exception e){
message = "Could not upload the file: " + file.getOriginalFilename() + " !";
return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
}
}
@PostMapping("/upload/demande/{libelle}/{demandeId}")
public ResponseEntity<ResponseMessage> uploadFileDemande(@PathVariable String libelle, @RequestPart("file") MultipartFile file, @PathVariable Long demandeId){
String message= "";
try{
fileService.storeFileDemande(libelle, file, demandeId);
message = "Document uploaded successfully : " + file.getOriginalFilename();
return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
}catch(Exception e){
message = "Could not upload the file: " + file.getOriginalFilename() + " !";
return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
}
}


@GetMapping("/documents")
public ResponseEntity<List<ResponseDocument>> getListFiles(){
List<ResponseDocument> documents = fileService.getAllFiles().map(dbDocument -> {
String documentDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/documents/").path(dbDocument.getId()).toUriString();

return new ResponseDocument(
dbDocument.getLibelle(), dbDocument.getNom(),documentDownloadUri, dbDocument.getType(), dbDocument.getData().length);
}).collect(Collectors.toList());
return ResponseEntity.status(HttpStatus.OK).body(documents);
}


@GetMapping("/documents/demande/{demandeId}")
public ResponseEntity<List<ResponseDocument>> findAllFilesByDemande(@PathVariable Long demandeId){
List<ResponseDocument> documents = fileService.findAllFilesByDemande(demandeId).map(dbDocument -> {
String documentDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/documents/").path(dbDocument.getId()).toUriString();

return new ResponseDocument(
dbDocument.getLibelle(), dbDocument.getNom(),documentDownloadUri, dbDocument.getType(), dbDocument.getData().length);
}).collect(Collectors.toList());
return ResponseEntity.status(HttpStatus.OK).body(documents);
}




@GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id){
    File file  = fileService.getFile(id);
return ResponseEntity.ok()
.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ file.getNom()+"\"")
.body(file.getData());
}
}
