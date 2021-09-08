$(function () {
  let count = $('.slide>li').length; // 4
  let slideWidth = count * 100 + '%';
  $('.slide').width(slideWidth); // 부모박스의 너비를 이미지 갯수 만큼 늘어나게
  console.log(count, slideWidth); // 3, 100%
  let slideListWidth = 100 / count + '%';
  $('.slide>li').width(slideListWidth);
  console.log(slideListWidth);

  $('#slider').append('<ul class="dotList"></ul>');

  for (let i = 0; i < count; i++) {
    $(`<li>${i + 1}</li>`).appendTo('.dotList');
  }
  $('.dotList > li').eq(0).addClass('on');
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
      .animate({ marginLeft: '-100%' }, 1000, function () {
        $('.slide > li:first').insertAfter('.slide > li:last');
        $('.slide').css('marginLeft', 0);
        let idx = $('.slide > li:first').children('img').attr('alt');
        $('.dotList>li')
          .eq(idx)
          .addClass('on')
          .siblings('li')
          .removeClass('on');
      });
  }

  // 슬라이트 이전 이미지로 돌리기
  function playPrev() {
    $('.slide').css('marginLeft', '-100%');
    $('.slide > li:last').insertBefore('.slide > li:first');
    $('.slide')
      .stop()
      .animate({ marginLeft: 0 }, 1000, function () {
        let idx = $('.slide > li:first').children('img').attr('alt');
        $('.dotList>li')
          .eq(idx)
          .addClass('on')
          .siblings('li')
          .removeClass('on');
      });
  }
});
