package com.example.app.service;

import com.example.app.dto.ImageDTO;
import com.example.app.model.Image;
import com.example.app.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageDTO addImage(ImageDTO imageDTO) {
        imageRepository.save(Image.from(imageDTO));
        return imageDTO;
    }

    @Override
    public void removeImage(Integer id) {
        imageRepository.deleteById(id);
    }
}
