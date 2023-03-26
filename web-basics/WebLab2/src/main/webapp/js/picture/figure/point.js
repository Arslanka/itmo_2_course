export class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    equals(other) {
        return this.x === other.x
            && this.y === other.y;
    }

    toString() {
        return `(${this.x}, ${this.y})`;
    }
}

(function (Point) {
    function fromJson(json) {
        return new Point(json.get('x'), json.get('y'));
    }

    Point.fromJson = fromJson;
})(Point || (Point = {}));
