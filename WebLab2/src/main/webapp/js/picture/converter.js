function convertToCanvasPoint(coordinateData, radiusData, canvasRadius) {
    return (coordinateData * (canvasRadius / radiusData)).toPrecision(3);
}

function convertToDto(coordinateData, radiusData, canvasRadius) {
    return ((coordinateData * radiusData) / canvasRadius).toPrecision(3);
}
