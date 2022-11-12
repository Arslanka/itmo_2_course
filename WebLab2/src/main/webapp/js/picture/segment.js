export class Segment {
    constructor(start, end, width, color) {
        this.start = start;
        this.end = end;
        this.width = width;
        this.color = color;
    }

    draw(ctx) {
        ctx.fillStyle = this.color;
        ctx.lineWidth = this.width;
        ctx.beginPath();
        ctx.moveTo(this.start.x, this.start.y);
        ctx.lineTo(this.end.x, this.end.y);
        ctx.stroke();
        ctx.fill();
    }
}
