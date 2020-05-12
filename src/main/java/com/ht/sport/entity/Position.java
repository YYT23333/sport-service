package com.ht.sport.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Position {
    private double longitude;
    private double latitudes;
}
