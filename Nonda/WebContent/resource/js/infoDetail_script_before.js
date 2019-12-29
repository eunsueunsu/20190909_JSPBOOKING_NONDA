// 리뷰쓰기버튼 클릭시 팝업
  $(document).ready(function () {
    $(".imgReview").on('click', function () {
      $('.popupR').show();
      $('.dim').show();
    });
    $(".CancelButton").on('click', function () {
      $('.popup_qna').hide();
      $('.popupR').hide();
      $('.dim').hide();
    });
    $(".qna_write").on('click', function () {
      $('.popup_qna').show();
      $('.dim').show();
    });
  });
  //버튼클릭시 화면이동해주는 메소드
  function fnMove(seq) {
    tabcontent = document.getElementsByClassName("tabcontent");
    var offset = $("#tContentdiv" + seq).offset();
    $('html,body').animate({ scrollTop: offset.top }, 400);
  }
  
    var tContentOffset = $('.tab').offset();
    $(window).scroll(function () {
      if ($(document).scrollTop() > tContentOffset.top) {
        $('.tab').addClass('tabFixed');
      } else {
        $('.tab').removeClass('tabFixed');
      }
    });
    $(window).scroll(function () {
      if ($(document).scrollTop() > tContentOffset.top) {
        $('.tab').addClass('tabFixed');
      } else {
        $('.tab').removeClass('tabFixed');
      }
    });
