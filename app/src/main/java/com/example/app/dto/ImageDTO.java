package com.example.app.dto;


import com.example.app.model.Image;
import com.example.app.model.ImageStorage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    private Integer id;
    private String url;
    private ImageStorage imageStorage;

    public static ImageDTO from(Image image) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(image.getId());
        imageDTO.setUrl(image.getUrl());
        imageDTO.setImageStorage(image.getImageStore());
        return imageDTO;
    }
}
