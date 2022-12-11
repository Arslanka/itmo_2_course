import {Point} from "./figure/point.js";
import {Segment} from "./segment.js";
import {Ellipse} from "./figure/ellipse.js";
import {Drawable} from "./drawable.js";

const INF = 999;

export class CoordinatesDrawable {
    constructor() {
        this.origin = Drawable.union([
            new Segment(new Point(-INF, 0), new Point(INF, 0), 2, '#FFBB98'),
            new Segment(new Point(0, -INF), new Point(0, INF), 2, '#FFBB98'),
            new Ellipse('#000000', new Point(0, 0), new Point(3, 3))
        ]);
    }

    draw(ctx) {
        this.origin.draw(ctx);
    }
}
