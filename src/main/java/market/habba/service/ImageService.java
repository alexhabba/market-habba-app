package market.habba.service;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Image;
import market.habba.repository.ImageRepository;
import market.habba.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {

        Image image = Image.builder()
                .name(file.getOriginalFilename())
                .data(ImageUtils.compressImage(file.getBytes()))
                .build();

        Image save = repository.save(image);

        if (save != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

//    public byte[] downloadImage(String fileName){
//        Optional<Image> dbImageData = repository.findByName(fileName);
//        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return null;
//    }
}
