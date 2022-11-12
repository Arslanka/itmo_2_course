package com.arslanka.weblab2

import com.arslanka.weblab2.models.view.*
import com.arslanka.weblab2.services.TableCreationService
import com.arslanka.weblab2.services.HitCheckService

class Backend {
    val tableCreationService: TableCreationService
    val hitCheckService: HitCheckService
    private val graph: Graph

    init {
        graph = Graph(
            topRight = Rectangle(xDistance = Distance.R, yDistance = Distance.HALF_R),
            botLeft = Triangle(xDistance = Distance.R, yDistance = Distance.R),
            botRight = Circle(radius = Distance.HALF_R)
        )
        hitCheckService = HitCheckService(graph = graph)
        tableCreationService = TableCreationService()
    }
}