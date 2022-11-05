package com.example.app.model;

import com.example.app.dto.ImageStoreDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image_storage")
public class ImageStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "imageStore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<Image>();

    public void addImage(Image image)  {
        images.add(image);
    }

    public void removeImage(Image image) {
        images.remove(image);
        image.setImageStore(null);
    }

    public static ImageStorage from(ImageStoreDTO imageStoreDTO) {
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.setId(imageStoreDTO.getId());
        imageStorage.setImages(imageStoreDTO.getImages().stream().map(Image::from).collect(Collectors.toList()));
        return imageStorage;
    }
}
