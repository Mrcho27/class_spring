// 모듈 가져오기
import * as reply from "../module/reply.js";

{   // 버튼 처리
    let $modifyBtn = document.querySelector('.btn-modify');
    let $removeBtn = document.querySelector('.btn-remove');
    let $backBtn = document.querySelector('.btn-back');

    $removeBtn?.addEventListener("click", function () {
        let boardId = this.dataset.id;
        location.href = `/board/remove?boardId=${boardId}`;
    });


    $modifyBtn?.addEventListener("click", function () {
        let boardId = this.dataset.id;
        console.log(boardId)
        location.href = `/board/modify?boardId=${boardId}`;
    });

    $backBtn?.addEventListener("click", function () {
        window.history.back();
    });
}


let boardId = document.querySelector('#boardId').value;

displayImgAjax();


//Ajax : Asynchronous JavaScript and XML
// JS와 XML을 활용하여 비동기 통신으로 데이터를 교환하는 기법
// Ajax라는 기술을 활용하는 방법은 여러가지가 있지만 우리는 fetchAPI를 사용한다.
function displayImgAjax() {
    // fetch()함수는 js에 내장된 함수이므로 바로 사용하면된다.
    /*

    fetch('api주소', {설정객체})
        .then(함수)       // api에서 보낸 응답을 then으로 받는다.
        .then(함수);      // 위의 then에서 반환하는 값을 여기서 받는다.

     */
    // fetch(`/v1/boards/${boardId}/files`, {method : 'GET'})
    //     .then(res => res.json()) // 응답을 받아서 데이터를 변환하고 다음 then으로 넘겨준다.
    //     .then(data => console.log(data))  // 위에서 넘겨준 데이터를 올바르게 처리한다.


    fetch(`/v1/boards/${boardId}/files`, {method: 'GET'})
        .then(res => res.json())
        .then(list => {
            let tags = '';

            for (let i = 0; i < list.length; i++) {
                let fileName = list[i].uploadPath + '/' + list[i].uuid + '_' + list[i].name;

                tags += `<a href="/download?fileName=${fileName}">
                         <img src="/v1/files?fileName=${fileName}" data-id="${list[i].fileId}" data-name="${fileName}"/>
                        </a>`;
            }

            let $postImgs = document.querySelector('.post-images');

            $postImgs.innerHTML = tags;
        });
}

// ------------------------댓글 메뉴 처리-------------------------------------------
{
    let $replyListWrap = document.querySelector('.reply-list-wrap');

    $replyListWrap.addEventListener('click', function (e){
        // console.log(e.target);
        let $target = e.target;

        if($target.classList.contains('reply-btns')){
            // closest('선택자') : 나의 상위 요소중에 찾기
            // querySelector('선택자') : 나의 하위 요소중에 찾기
            let $menu = $target.closest('.reply-btn-box').querySelector('.reply-btns__box');

            $menu.classList.toggle('none');
        }else if($target.classList.contains('reply-modify-btn')){
            $target.closest('.reply-btns__box').classList.add('none')

            let $contentBox = $target.closest('.reply').querySelector('.reply-box__content');
            let oldContent = $contentBox.innerText;

            $contentBox.innerHTML = `
                <div class="modify-box">
                    <textarea class="modify-content">${oldContent}</textarea>
                    <button type="button" class="modify-content-btn">수정 완료</button>
                </div>
            `;
        }else if($target.classList.contains('reply-remove-btn')){
            $target.closest('.reply-btns__box').classList.add('none');

            let replyId = $target.closest('.reply').dataset.id;
            reply.remove(replyId, () => {
                reply.getList(boardId, displayReply);
            });


        }else if($target.classList.contains('modify-content-btn')) {
            let replyId = $target.closest('.reply').dataset.id;
            let content = $target.closest('.modify-box').querySelector('.modify-content').value;

            let updateInfo = {replyId : replyId, content : content};

            reply.modify(updateInfo, () => {
                reply.getList(boardId, displayReply);
            });

        }else{
            document.querySelectorAll('.reply-btns__box')
                .forEach(ele => ele.classList.add('none'));
        }

    });


}


// ------------------------------댓글 처리-----------------------------
{
    let $btnReply = document.querySelector('.btn-reply');

    $btnReply?.addEventListener('click', function () {
        let content = document.querySelector('#reply-content').value;

        let replyInfo = {
            boardId : boardId,
            content : content
        };

        reply.register(replyInfo, () => {
            document.querySelector('#reply-content').value = '';
            reply.getList(boardId, displayReply);
        });
    });


    reply.getList(boardId, displayReply);
}




function displayReply(replyList){
    let $replyWrap = document.querySelector('.reply-list-wrap');

    let tags = '';

    replyList.forEach(r => {
        // console.log(reply)

        tags += `
            <div class="reply" data-id="${r.replyId}">
                <div class="reply-box">
                    <div class="reply-box__writer">${r.loginId}</div>
                    <div class="reply-box__content">${r.content}</div>
                </div>
                
                <div class="reply-time">
                    ${reply.timeForToday(r.modifiedDate)}
                </div>
                
                <div class="reply-btn-box">
                    <span class="reply-btns"></span>
                    <div class="reply-btns__box none">
                        <div class="reply-remove-btn">삭제</div>
                        <div class="reply-modify-btn">수정</div>
                    </div>
                </div>
            </div>
        `;
    });

    $replyWrap.innerHTML = tags;
}














