package com.arslanka.backend.models.daos;

import java.time.OffsetDateTime;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Named("tableRowBean")
@RequestScoped
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRow {
    private Long id;
    private Point2D point2D;
    private Double radius;
    private OffsetDateTime requestTime;
    private Boolean hit;
}
