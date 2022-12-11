import com.arslanka.weblab2.models.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class GraphHitTest {


    @Test
    fun `Should return true, point is in area`() {
        val graph = Graph(
            topRight = Rectangle(xDistance = Distance.R, yDistance = Distance.HALF_R),
            botLeft = Triangle(xDistance = Distance.R, yDistance = Distance.R),
            botRight = Circle(radius = Distance.HALF_R)
        )
        assertThat(graph.isHit(radius = BigDecimal.ONE, x = BigDecimal.ZERO, y = BigDecimal.ZERO)).isTrue
        assertThat(graph.isHit(radius = BigDecimal(4), x = BigDecimal(4), y = BigDecimal(2))).isTrue
        assertThat(graph.isHit(radius = BigDecimal(4), x = BigDecimal(-4), y = BigDecimal(0))).isTrue
        assertThat(graph.isHit(radius = BigDecimal(4), x = BigDecimal(0), y = BigDecimal(-2))).isTrue
        assertThat(graph.isHit(radius = BigDecimal(4), x = BigDecimal(0), y = BigDecimal(2))).isTrue
    }
}