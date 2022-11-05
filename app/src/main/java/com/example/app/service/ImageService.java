package com.example.app.service;

import com.example.app.dto.ImageDTO;

public interface ImageService {
    ImageDTO addImage(ImageDTO imageDTO);
    void removeImage(Integer id);
}
