package com.example.app.dto;

import com.example.app.model.ImageStorage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageStoreDTO {
    private Integer id;
    private List<ImageDTO> images;

    public static ImageStoreDTO from(ImageStorage imageStorage) {
        ImageStoreDTO imageStoreDTO = new ImageStoreDTO();
        imageStoreDTO.setId(imageStorage.getId());
        imageStoreDTO.setImages(imageStorage.getImages().stream().map(ImageDTO::from).collect(Collectors.toList()));
        return imageStoreDTO;
    }
}
