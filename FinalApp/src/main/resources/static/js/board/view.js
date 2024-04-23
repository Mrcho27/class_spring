{
    let $modifyBtn =document.querySelector('.btn-modify');
    let $removeBtn=document.querySelector('.btn-remove');
    let $backBtn=document.querySelector('.btn-back');

    $removeBtn.addEventListener("click", function (){
        let boardId = this.dataset.id;
        location.href = `/board/remove?boardId=${boardId}`;
    });

    $modifyBtn.addEventListener('click', function (){
        let boardId = this.dataset.id;
        console.log(boardId)
        location.href = `/board/modify?boardId=${boardId}`;
    });

    $backBtn.addEventListener('click', function (){
        window.history.back();
    });
}

displayImgAjax();

// Ajax : Asynchronous JavaScript and XML
// JS와 XML을 활용하여 비동기 통신으로 데이터를 교환하는 기법
// Ajax라는 기술을 활용하는 방법은 여러가지가 있지만 우리는 fetchAPI를 사용한다.
function displayImgAjax(){
    let boardId = document.querySelector('#boardId').value;

    // fetch()함수는 js에 내장된 함수이므로 바로 사용하면된다.
    /*

    fetch('api주소', {설정객체})
        .then(함수)       // api에서 보낸 응답을 then으로 받는다.
        .then(함수);      // 위의 then에서 반환하는 값을 여기서 받는다.

     */
    // fetch(`/v1/boards/${boardId}/files`, {method: 'GET'})
    //     .then(res => res.json()) //응답을 받아서 데이터를 변환하고 다음 then으로 넘겨준다.
    //     .then(data => console.log(data)) // 위에서 넘겨준 데이터를 올바르게 처리한다.

    fetch(`/v1/boards/${boardId}/files`, {method: 'GET'})
        .then(res => res.json())
        .then(list =>{
            let tags = '';

            for (let i=0; i<list.length; i++){
                let fileName = list[i].uploadPath + '/' + list[i].uuid + '_' + list[i].name;

                tags += `<img src="/v1/files?fileName=${fileName}"/>`;
            }

            let $postImgs = document.querySelector('.post-images');

            $postImgs.innerHTML = tags;
        });
}