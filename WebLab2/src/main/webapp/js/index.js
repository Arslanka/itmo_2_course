import {Canvas} from "./canvas.js";
import {Point} from "./picture/figure/point.js";
import {Ellipse} from "./picture/figure/ellipse.js";
import {Drawable} from "./picture/drawable.js";
import {Polygon} from "./picture/figure/polygon.js";
import {CoordinatesDrawable} from "./picture/coordinatesDrawable.js";

const DOT_RADIUS = 4
const R = 250
const SUCCEED = '#0F0'
const FAILED = '#F00'
let lastR = 4;

const canvas = new Canvas(
    document.getElementById('canvas'),
    new Point(250, 250)
);

const figure = Drawable.union([
        new Polygon("#FFBB98", [
            new Point(0, 0),
            new Point(0, -R),
            new Point(-R, 0)
        ]),
        new Ellipse("#FFBB98", new Point(0, 0), new Point(R / 2, R / 2)),
        new Polygon("#FFBB98", [
            new Point(0, 0),
            new Point(R, 0),
            new Point(R, R / 2),
            new Point(0, R / 2)
        ]),
        new Polygon("#FBE0C3", [
            new Point(0, 0),
            new Point(0, R / 2),
            new Point(-R / 2, R / 2),
            new Point(-R / 2, 0)
        ])
    ]
)


const background = new Polygon("#FBE0C3", [
    new Point(-R, -R),
    new Point(R, -R),
    new Point(R, R),
    new Point(-R, R)
])
canvas.draw(figure)
canvas.draw(new CoordinatesDrawable())

function createPoint(center, color) {
    return new Ellipse(
        color,
        new Point(center.x, center.y),
        new Point(DOT_RADIUS, DOT_RADIUS)
    )
}

function createPointsFromData(data) {
    console.log('createPointsFromData() was launched')
    if (data === null) return
    lastR = data[data.length - 1].radius
    for (let i = 0; i < data.length; ++i) {
        console.log(i + ' = ' + data[i].hit)
        if (data[i].radius === lastR) {
            const dataX = Number(data[i].x), dataY = Number(data[i].y), dataR = Number(data[i].radius)
            const x = convertToCanvasPoint(dataX, dataR, R)
            const y = convertToCanvasPoint(dataY, dataR, R)
            const point = new Point(x, y)
            console.log('point = ' + point)
            if (data[i].hit === true) {
                canvas.draw(createPoint(point, SUCCEED));
            } else {
                canvas.draw(createPoint(point, FAILED));
            }
        }
    }
}

function toDate(data) {
    let result = "";
    for (let i = 0; i < data.length; ++i) {
        result += data[i] + "-";
    }
    return result.slice(0, -1)
}

function fromJsonToHTMLTable(data) {
    let result = "";
    if (data === null) return;
    for (let i = 0; i < data.length; i++) {
        result += "<tr>" +
            "<td>" + data[i].x + "</td>" +
            "<td>" + data[i].y + "</td>" +
            "<td>" + data[i].radius + "</td>" +
            "<td>" + data[i].hit + "</td>" +
            "<td>" + toDate(data[i].local_time) + "</td>" +
            "</tr>";
    }
    return result;
}

$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: './table-request',
        success: (data) => {
            createPointsFromData(data)
            const htmlTable = fromJsonToHTMLTable(data)
            console.log(htmlTable)
            $("#result_table tbody").html(htmlTable)
        },
        error: (data) => console.log(data),
    });

    $("#form #submit").click(function () {
        if (!validateForm()) {
            return false;
        }
        let x_value = $('input[name="x_value"]:checked')[0].value
        let y_value = $('#y_value').val();
        let r_value = $('#r_value').val();
        console.log(x_value, y_value, r_value);
        postData(x_value, y_value, r_value);
    });

    canvas.setMouseClickListener((pos) => {
        console.log(pos)
        postData(convertToDto(pos.x, lastR, R), convertToDto(pos.y, lastR, R), lastR);
    })

    $("#form #clear").click(function () {
        $.ajax({
            type: 'POST',
            url: './clear',
            success: (data) => {
                const htmlTable = fromJsonToHTMLTable(data)
                $("#result_table tbody").html(htmlTable)
                clearAndDrawPlot()
            }
        });
    });
});

function postData(x_value, y_value, r_value) {
    console.log(x_value, y_value, r_value)
    $.ajax({
        type: 'POST',
        url: './main',
        data: JSON.stringify({
            "x": x_value,
            "y": y_value,
            "radius": r_value,
            "local_time": parseDate(new Date().toISOString())
        }),
        processData: false,
        contentType: "application/json; charset=UTF-8",
        error: (data) => console.log(data),
        success: (data) => {
            console.log(data)
            clearAndDrawPlot()
            createPointsFromData(data)
            const htmlTable = fromJsonToHTMLTable(data)
            console.log(htmlTable)
            $("#result_table tbody").html(htmlTable)
        }
    });
}

function parseDate(str) {
    return str.match(/\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}/)[0].replace('T', ' ');
}

function clearAndDrawPlot() {
    canvas.clear();
    canvas.draw(background)
    canvas.draw(figure)
    canvas.draw(new CoordinatesDrawable())
}