package com.arslanka.weblab2.utils

import com.arslanka.weblab2.models.dao.Point2D
import com.arslanka.weblab2.models.dao.Point2DWithRadius
import com.arslanka.weblab2.models.dto.ClientRequestInfo
import com.arslanka.weblab2.models.dto.TableRow
import com.arslanka.weblab2.models.dao.TableRow as Table

fun ClientRequestInfo.toPointWithRadius() = Point2DWithRadius(
    point2D = Point2D(x = this.xCoor, y = this.yCoor),
    radius = this.radius
)

fun Table.toDtoTableRow() = TableRow(
    xCoor = this.xCoor,
    yCoor = this.yCoor,
    radius = this.radius,
    localTime = this.localTime,
    isHit = this.isHit,
)