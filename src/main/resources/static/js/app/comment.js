// 데이터 전송 객체 생성!
var comment = {
  // 이벤트 등록
  init: function() {
    var _this = this;
    // 생성 버튼 클릭 시!
    const createBtn = document.querySelector('#comment-create-btn');

    // 이벤트 감시 시, 수행할 메소드 연결!
    createBtn.addEventListener('click', function(){
      _this.create();
    });
  },

  // 댓글 등록
  create: function() {
    // 데이터
    var data = {
      author: document.querySelector('#comment-author').value,
      content: document.querySelector('#comment-content').value,
    };

    // url에서 article의 id를 추출!
    var split = location.pathname.split('/');
    var articleId = split[split.length - 1];

    // Ajax 통신
    // - https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
    // - https://t.ly/Vrrz
    fetch('/api/comments/' + articleId, { // 요청을 보냄
      method: 'POST',
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(function(response) { // 응답 처리
      if (response.ok) { // 성공
        alert('댓글이 등록되었습니다.');
        window.location.reload(`/articles/${articleId}#comment`);
      } else { // 실패
        alert('댓글 등록 실패..!');
      }
    });
  }
};

// 객체 초기화!
comment.init();