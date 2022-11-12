function checkX() {
    const xCoordinatesArray = document.querySelectorAll('input[name="x_value"]:checked');
    if (xCoordinatesArray.length === 1) {
        return setSuccessFor(xCoordinatesArray[0]);
    } else {
        return setErrorFor(document.querySelectorAll('input[name="x_value"]')[0], "Please, select one checkbox");
    }
}

function checkY() {
    const yEl = document.getElementById("y_value");
    const yVal = yEl.value
    if (isNaN(yVal) || yVal === "") {
        return setErrorFor(yEl, "Please, input number");
    } else if (yVal.length > 5) {
        return setErrorFor(yEl, "Please, enter a number with no more than 5 digits");
    } else if (parseFloat(yVal) < -3 || parseFloat(yVal) > 5) {
        return setErrorFor(yEl, "Please, input number in specified range");
    } else {
        return setSuccessFor(yEl);
    }
}

function checkR() {
    const rEl = document.getElementById("r_value")
    const rVal = rEl.value

    if (isNaN(rVal) || rVal === "") {
        return setErrorFor(rEl, "Please, input number");
    } else if (rVal.length > 5) {
        return setErrorFor(rEl, "Please, enter a number with no more than 5 digits");
    } else if (parseFloat(rVal) < 1 || parseFloat(rVal) > 4) {
        return setErrorFor(rEl, "Please, input number in specified range");
    } else {
        return setSuccessFor(rEl);
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