import {Point} from "./point.js";
import {TrivialFigure} from "./trivialFigure.js";

export class Polygon extends TrivialFigure {
    constructor(color, points) {
        super("polygon", color);
        this.points = points;
    }

    draw(ctx) {
        const points = this.points;
        ctx.beginPath();
        ctx.moveTo(points[0].x, points[0].y);
        for (let i = 1; i < points.length; i++) {
            ctx.lineTo(points[i].x, points[i].y);
        }
        ctx.closePath();
        ctx.fillStyle = this.color;
        ctx.fill();
    }
}

(function (Polygon) {
    function fromJson(json) {
        return new Polygon(json.get("color"), json.get('points')
            .map(Point.fromJson));
    }

    Polygon.fromJson = fromJson;
})(Polygon || (Polygon = {}));