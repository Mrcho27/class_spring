{
    let $msgBox = document.querySelector('.login-id-msg')
    let $loginIdInput = document.querySelector('input[name=loginId]');

    $loginIdInput.addEventListener('change', function (){
        let loginId = this.value;

        fetch(`/users?loginId=${loginId}`, {method: "GET"})
            .then(resp => resp.text())
            .then(text => {
                $msgBox.innerText = text;
            });



    });
}

{
    fetch("/users", {method: "GET"})
        .then(resp => resp.text())
        .then(text => console.log(text));

    fetch("/users", {method: "GET"})
        .then(function (resp){
            return resp.text();
        })
        .then(function (text) {
            console.log(text)
        });
}
