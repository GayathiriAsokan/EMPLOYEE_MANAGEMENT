// function getResult() {
//     var numbers = document.getElementById("result-value").value;
//     var evaluate = eval(numbers);
//     document.getElementById("final-result").value = evaluate;
// }
// function getOperation(operator) {
//             document.getElementById("result-value").value += operator;
//             getResult(); 
// }
// function getClear() {
//     document.getElementById("final-result").value = "";
//     document.getElementById("result-value").value="";
// }
'use strict';
function codeButton() {
    for ( var index = 0; index < 18; index++) {
        var array = ['%', '+/-','C','/','7','8','9','x','4','5','6','-','1','2','3','+','0',','];
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
document.addEventListener('click', function(event) {
    console.log(event);
    document.getElementById('result-value').value += event.target.value;
    var variable = document.getElementById('result-value').value ;
//    // if (|| variable.contains('-')|| variable.contains('x'|| variable.contains('/')||variable.contains('/'))) {
//         switch (variable) {
//            case variable.includes('+'):
//                 var array  = variable.split('+');
//                 var firstValue = Integer.parseInt(array.charAt(0));
//                 var secondValue = Integer.parseInt(array.charAt(1));
//                 document.getElementById('final-result').value = firstValue + secondValue;
//         }

//     //}
});

