export var Drawable;
(function (Drawable) {
    function union(drawables) {
        return {
            draw(ctx) {
                drawables.forEach(d => d.draw(ctx));
            }
        };
    }
    Drawable.union = union;
})(Drawable || (Drawable = {}));