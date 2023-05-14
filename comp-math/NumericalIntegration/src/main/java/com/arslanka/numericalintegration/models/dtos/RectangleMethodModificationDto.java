package com.arslanka.numericalintegration.models.dtos;

import com.arslanka.numericalintegration.models.daos.RectangleMethodModification;

public enum RectangleMethodModificationDto {
    LEFT,
    MIDDLE,
    RIGHT;

    public RectangleMethodModification toDomain() {
        return RectangleMethodModification.valueOf(this.name());
    }
}
