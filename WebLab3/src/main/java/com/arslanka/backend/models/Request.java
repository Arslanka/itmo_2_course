package com.arslanka.backend.models;

import java.time.LocalDateTime;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jooq.sources.tables.records.RequestsRecord;

@Named("requestBean")
@RequestScoped
@Data
@NoArgsConstructor
public class Request {
    private Long id;
    @Inject
    private Point2D point2D;
    private Double radius;
    private LocalDateTime requestTime = LocalDateTime.now();
    private Boolean hit = true;

    public Request(Long id, Point2D point2D, Double radius, LocalDateTime requestTimestamp, Boolean hit) {
        this.id = id;
        this.point2D = point2D;
        this.radius = radius;
        this.requestTime = requestTimestamp;
        this.hit = hit;
    }

    public RequestsRecord toRecord() {
        return new RequestsRecord(RandomGenerator.getDefault().nextLong(), point2D.getX(), point2D.getY(), radius,
                LocalDateTime.now(), true
        );
    }
}

