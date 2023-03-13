package market.habba.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Сервис для работы с изображениями.
 */
public interface ImageService {

    void uploadImage(MultipartFile image, String productName);

    void uploadImages(List<MultipartFile> images, String productName);


}
