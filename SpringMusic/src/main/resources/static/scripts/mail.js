const button = document.querySelector('#mail_message');

button.addEventListener('click',(e)=>{
    fetch("http://localhost:8083/mail").then(response=>response.json()).then(data=>console.log(data));
})