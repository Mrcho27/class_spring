// 이 파일은 모듈을 만들어 두는 파일로 사용한다.
// JS의 함수, 클래스를 모듈화 시켜 저장하는 공간이다. (모듈화 == 부품화)
// 우리는 함수를 부품처럼 만들어 두고 사용은 다른 파일에서 할 것이다.
// 이 모듈들을 밖에서 사용할 수 있도록 내보내는 키워드가 export이다.
/**
 * 댓글 작성 모듈
 *
 * @param replyInfo {Object} 댓글 등록에 필요한 정보 boardId, content가 필요하다.
 * @param callback {Function} 정상적으로 처리가 완료되면 실행할 함수
 */
export function register(replyInfo, callback){
    fetch(`/v1/boards/${replyInfo.boardId}/reply`,
        {
            method : "POST",
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify({content: replyInfo.content}),
        }).then(resp => {
        if (resp.status === 200){
           callback();
        }
    });
}

export function getList(boardId,callback){
    fetch(`/v1/boards/${boardId}/replies`, {
        method : 'get'
    }).then(resp => resp.json())
        .then(dataList => {callback(dataList)});
}

export function modify(){}

export function remove(){}