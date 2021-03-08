'use strict';
//Function that Dynamically created buttons using javascript
function codeButton() {
    for (var index = 0; index < 18; index++) {
        var array = ['%', '+/-', 'C', '/', '7', '8', '9', 'x', '4', '5', '6', '-', '1', '2', '3', '+', '0', ','];
        var element = document.createElement('input');
        element.type = 'button';
        document.getElementById('div-button').append(element);
        element.classList.add('button');
        element.value = array[index];
        if (3 === index || 7 == index || 11 === index || 15 == index) {
            element.classList.add('color');
        }
        if (16 === index) {
            element.classList.add('button-corner');
        }
    }
}
window.onload = codeButton;

//Function that attach event handlers to the dynamically created elements.
document.addEventListener('click', function (event) {
    if (event.target.value === 'C') {
        document.getElementById('result-value').value = '';
        document.getElementById('final-result').value = '';
    } else if (event.target.value === '+/-') {       
        document.getElementById('result-value').value += '*-1';
        document.getElementById('final-result').value *= '-1';
    } else {
        if (event.target.value === 'x') {
            document.getElementById('result-value').value += '*';
        } else if (event.target.value === '=') {
            document.getElementById('result-value').value += '';
        } else {
            document.getElementById('result-value').value += event.target.value;
        }
        var variable = document.getElementById('result-value').value;

         //function that evaluates the digit and return result using the Function-constructor:
        function calculate(fn) {
            return new Function('return ' + fn)();
        }
        document.getElementById('final-result').value = calculate(variable);
    }
});
