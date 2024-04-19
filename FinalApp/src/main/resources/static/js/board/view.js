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
    })

    $backBtn.addEventListener('click', function (){
        window.history.back();
    })
}