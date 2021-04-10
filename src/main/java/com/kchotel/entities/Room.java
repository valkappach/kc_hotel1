package com.kchotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bed;
    private String description;
    private String roomNumber;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    //private LocalDate releaseDate;
    //
    //	private LocalDate registerDate;

    // private totalExamplaries:int;
    @ManyToOne
    private RoomType roomType;
    @Transient
    private int quantity = 1;


}
