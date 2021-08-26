$(function () {
  let imgWidth = $('.slide > li').outerWidth();
  let slideWidth = imgWidth * $('.slide > li').length;
  $('.slide').width(slideWidth);
  $('button.next').on('click', playNext);

  $('button.prev').on('click', playPrev);

  let move = setInterval(playNext, 3000);

  $('button').on({
    mouseenter: function () {
      clearInterval(move);
      console.log('stop');
    },
    mouseleave: function () {
      move = setInterval(playNext, 3000);
      console.log('play');
    },
  });

  // 슬라이드 다음 이미지로 넘기기
  function playNext() {
    $('.slide')
      .stop()
      .animate({ left: -imgWidth }, 1000, function () {
        $('.slide > li:first').insertAfter('.slide > li:last');
        $('.slide').css('left', 0);
        let idx = $('.slide > li:first').children('img').attr('alt');
        $('.dotList>li')
          .eq(idx - 1)
          .addClass('on')
          .siblings('li')
          .removeClass('on');
      });
  }

  // 슬라이트 이전 이미지로 돌리기
  function playPrev() {
    $('.slide').css('left', -imgWidth);
    $('.slide > li:last').insertBefore('.slide > li:first');
    $('.slide')
      .stop()
      .animate({ left: 0 }, 1000, function () {
        let idx = $('.slide > li:first').children('img').attr('alt');
        $('.dotList>li')
          .eq(idx - 1)
          .addClass('on')
          .siblings('li')
          .removeClass('on');
      });
  }
});
