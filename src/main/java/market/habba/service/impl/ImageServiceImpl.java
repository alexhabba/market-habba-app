package market.habba.service.impl;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Image;
import market.habba.service.ImageService;
import market.habba.service.ProductService;
import market.habba.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ProductService productService;

    @Override
    public void uploadImage(MultipartFile image, String productName) {
        productService.addImage(getImage(image), productName);
    }

    @Override
    public void uploadImages(List<MultipartFile> images, String productName) {
        List<Image> imageList = images.stream()
                .map(this::getImage)
                .collect(Collectors.toList());
        productService.addImagesProduct(imageList, productName);
    }

    private Image getImage(MultipartFile image) {
        try {
            return Image.builder()
                    .name(image.getOriginalFilename())
                    .data(ImageUtils.compressImage(image.getBytes()))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("Не удалась обработать изображение");
        }
    }

//    public byte[] downloadImage(String fileName){
//        Optional<Image> dbImageData = repository.findByName(fileName);
//        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return null;
//    }
}
