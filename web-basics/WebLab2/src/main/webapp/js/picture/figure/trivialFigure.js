import {Figure} from "./figure.js";

export class TrivialFigure extends Figure {
    constructor(type, color) {
        super(type);
        this.color = color;
    }
}