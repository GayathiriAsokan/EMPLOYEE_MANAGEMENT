function getResult() {
    var numbers = document.getElementById("result-value").value;
    var evaluate = eval(numbers);
    document.getElementById("final-result").value = evaluate;
}
function getOperation(operator) {
            document.getElementById("result-value").value += operator;
            getResult(); 
}
function getClear() {
    document.getElementById("final-result").value = "";
    document.getElementById("result-value").value="";
}
