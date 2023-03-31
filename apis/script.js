    var pizzaTable = document.querySelector('#pizza-table');
    fetch('http://localhost:8080/api/all')
        .then(res => res.json())
        .then( data => { 
            for (var pizza of data) {
                pizzaTable.innerHTML += `<tr><td>${pizza.toppings}</td><td>${pizza.crust}</td><td><button class="delete" id="${pizza.id}" onclick="delPizza(this)">DELETE</button></td></tr>`
            }
        })


    var pizzaForm = document.querySelector("#new-pizza-form");
    pizzaForm.addEventListener("submit", function(e){
        e.preventDefault();
        var formData = new FormData(pizzaForm);
        var toppings = formData.get('toppings');
        var crust = formData.get('crust');
        var pizza = {toppings: toppings, crust: crust};
        fetch("http://localhost:8080/api/new", {
            method: "POST",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(pizza)
        })
        .then (res => res.json())
        .then( data => {
            pizzaTable.innerHTML += `<tr><td>${data.toppings}</td><td>${data.crust}</td><td><button class="delete" id="${data.id}" onclick="delPizza(this)">DELETE</button></td></tr>`
            pizzaForm.reset();
        })
    })


    function delPizza(element){
        console.log(element.id);
        var id = element.id;
        fetch("http://localhost:8080/api/" + id, {
            method: "DELETE"
        })
        .then( response => response)
        .then( data => {
            var i = element.parentNode.parentNode.rowIndex;
            console.log(element.parentNode.parentNode);
            console.log(i-1);
            pizzaTable.deleteRow(i-1);

        })
    }