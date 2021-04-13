package com.kchotel;

import com.kchotel.dao.EmployeeRepository;
import com.kchotel.dao.RoomRepository;
import com.kchotel.dao.RoomTypeRepository;
import com.kchotel.entities.Employee;
import com.kchotel.entities.Room;
import com.kchotel.entities.RoomType;
import net.bytebuddy.utility.RandomString;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


@SpringBootApplication
public class HotelApplication implements CommandLineRunner {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    /*@Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter();
    }*/
    //private RepositoryRestConfiguration repositoryRestConfiguration; //pour exposer l' id


    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
    //repositoryRestConfiguration.exposeIdsFor(Room.class, RoomType.class); //pour exposer l'id

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
        /*for (int i =0; i< 5; i++){Employee e=new Employee();
            e.setName("mathy");
            e.setEmail("mianda@gmail.com");
            e.setJobTitle("CHEF");
            e.setPhone("0780024136");
            e.setImageUrl("https://bootdey.com/img/Content/user_2.jpg");
            employeeRepository.save(e);
        }*/


}


}


