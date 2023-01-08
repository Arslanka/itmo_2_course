import {Point} from "./picture/figure/point.js";
import {Polygon} from "./picture/figure/polygon.js";

export class Canvas {
    constructor(canvas, origin) {
        this.canvas = canvas;
        this.origin = origin;
    }

    draw(drawable) {
        const ctx = this.canvas.getContext("2d");
        ctx.save();
        ctx.translate(this.origin.x, this.origin.y);
        ctx.scale(1, -1);
        drawable.draw(ctx);
        ctx.restore();
        return this;
    }

    clear() {
        const INF = 9999;
        this.draw(new Polygon("#FFFFFF", [
            new Point(-INF, -INF),
            new Point(INF, -INF),
            new Point(INF, INF),
            new Point(-INF, INF)
        ]));
    }

    setMouseClickListener(callback) {
        this.canvas.onclick = ((e) => {
            const mousePosition = new Point(e.clientX, e.clientY);
            callback(this.translate(mousePosition));
        }).bind(this);
        return this;
    }

    translate(point) {
        const topLeftCorner = this.topLeftCorner();
        return new Point(point.x - topLeftCorner.x - this.origin.x, -(point.y - topLeftCorner.y - this.origin.y));
    }

    topLeftCorner() {
        const rectangle = this.canvas.getBoundingClientRect();
        return new Point(rectangle.left, rectangle.top);
    }
}