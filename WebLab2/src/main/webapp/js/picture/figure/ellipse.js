import {Point} from "./point.js";
import {TrivialFigure} from "./trivialFigure.js";

export class Ellipse extends TrivialFigure {
    constructor(color, center, radius) {
        super("ellipse", color);
        this.center = center;
        this.radius = radius;
    }

    draw(ctx) {
        ctx.fillStyle = this.color;
        ctx.beginPath();
        ctx.ellipse(this.center.x, this.center.y, this.radius.x, this.radius.y, 0, 0, 2 * Math.PI);
        ctx.fill();
    }
}

(function (Ellipse) {
    function fromJson(json) {
        return new Ellipse(json.get("color"), Point.fromJson(json.get('center')), Point.fromJson(json.get('radius')));
    }

    Ellipse.fromJson = fromJson;
})(Ellipse || (Ellipse = {}));