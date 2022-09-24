function checkX() {
    const xCoordinatesArray = document.querySelectorAll('input[name="x[]"]:checked');
    if (xCoordinatesArray.length === 1) {
        return setSuccessFor(xCoordinatesArray[0]);
    } else {
        return setErrorFor(document.querySelectorAll('input[name="x[]"]')[0], "Please, select one checkbox");
    }
}

function checkY() {
    const yEl = document.getElementById("y");
    const yVal = yEl.value
    if (isNaN(parseFloat(yVal)) || yVal === "") {
        return setErrorFor(yEl, "Please, input number");
    } else if (parseFloat(yVal) < -3 || parseFloat(yVal) > 5) {
        return setErrorFor(yEl, "Please, input number in specified range");
    } else {
        return setSuccessFor(yEl);
    }
}

function checkR() {
    const r = document.getElementById("r")
    const rVal = r.value

    if (isNaN(parseFloat(rVal)) || rVal === "") {
        return setErrorFor(r, "Please, input number");
    } else if (parseFloat(rVal) < 1 || parseFloat(rVal) > 4) {
        return setErrorFor(r, "Please, input number in specified range");
    } else {
        return setSuccessFor(r);
    }
}

function validateForm() {
    let x = checkX()
    let y = checkY();
    let r = checkR();

    return x && y && r;
}

function setSuccessFor(input) {
    const formField = input.parentElement;
    const small = formField.querySelector('small');

    small.innerText = "";

    formField.className = 'form-field success';

    return true;
}

function setErrorFor(input, message) {
    const formField = input.parentElement;
    const small = formField.querySelector('small');

    small.innerText = message;

    formField.className = 'form-field error';

    return false;
}
