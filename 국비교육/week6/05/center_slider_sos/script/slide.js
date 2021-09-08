$(function () {
  let imgWidth = $('.inner_slide > li').width();
  let imgCount = $('.inner_slide > li').length;
  $('.inner_slide').width(imgWidth * imgCount);

  let dotCount = $('.dot > li').length;

  // 이미지 개수에 맞춰서 도트 생성
  for (let i = 0; i < imgCount; i++) {
    $('.dot').append('<li></li>');
  }
  $('.dot>li:first').addClass('on');

  setInterval(play, 3000);

  function play() {
    $('.inner_slide')
      .stop()
      .animate({ marginLeft: -imgWidth }, 1000, function () {
        $('.inner_slide > li:first').insertAfter('.inner_slide > li:last');
        $('.inner_slide').css('marginLeft', 0);
        let num = $('.inner_slide > li:first').children('img').attr('alt');
        $('.dot > li').eq(num).addClass('on').siblings('li').removeClass('on');
      });
  }

  // 포스터 이미지 가운데오면 확대 효과 3장씩 돌아감
  setInterval(centerPlay, 3000);

  function centerPlay() {
    $('.p_img').animate({ marginLeft: -336 }, 1000, function () {
      $('.p_img > li:first').insertAfter('.p_img>li:last');
      $('.p_img').css('marginLeft', 0);
      $('.p_img > li').eq(1).addClass('on').siblings('li').removeClass('on');
    });
  }
});
