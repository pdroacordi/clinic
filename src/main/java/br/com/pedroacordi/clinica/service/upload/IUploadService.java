package br.com.pedroacordi.clinica.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    public String uploadFile(MultipartFile file);

    public boolean deleteFile(String path);
}
