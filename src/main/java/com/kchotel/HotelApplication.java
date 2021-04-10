package com.kchotel;

import com.kchotel.dao.RoomRepository;
import com.kchotel.dao.RoomTypeRepository;
import com.kchotel.entities.Room;
import com.kchotel.entities.RoomType;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class HotelApplication implements CommandLineRunner {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;


   // private RepositoryRestConfiguration repositoryRestConfiguration; //pour exposer l' id


    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
   // repositoryRestConfiguration.exposeIdsFor(Room.class, RoomType.class); //pour exposer l'id

        roomTypeRepository.save(new RoomType(null, "simple bed", null, null, null));
        roomTypeRepository.save(new RoomType(null, "double bed", null, null, null));
        roomTypeRepository.save(new RoomType(null, "triple bed", null, null, null));
        roomTypeRepository.save(new RoomType(null, "family", null, null, null));

    Random rnd = new Random();
        roomTypeRepository.findAll().forEach(c -> {
        for (int i = 0; i < 17; i++) {
            Room r = new Room();
            r.setRoomNumber(RandomString.make(4));
            r.setDescription(RandomString.make(6));
            r.setCurrentPrice(100 + rnd.nextInt(10000));
            r.setAvailable(rnd.nextBoolean());
            r.setPromotion(rnd.nextBoolean());
            r.setSelected(rnd.nextBoolean());
            r.setPhotoName("unknown.png");
            r.setRoomType(c);
            roomRepository.save(r);
        }
    });

}
}


