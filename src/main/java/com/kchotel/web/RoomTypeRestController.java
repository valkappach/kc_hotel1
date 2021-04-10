package com.kchotel.web;

import com.kchotel.dao.RoomRepository;
import com.kchotel.entities.Room;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;


@CrossOrigin("*")
@RestController
public class RoomTypeRestController {
    private RoomRepository roomRepository;

    public RoomTypeRestController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping(path = "/photoRoom/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Room r= roomRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/ecom/rooms/" + r.getPhotoName()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
        Room r = roomRepository.findById(id).get();
        r.setPhotoName(id + " .jpg,.png"); /// on peut mettre le nom original de la photo avec file.getOriginalFilename()
        Files.write(Paths.get(System.getProperty("user.home") + "/kchome/rooms/" + r.getPhotoName()), file.getBytes());
        roomRepository.save(r);
    }
}
