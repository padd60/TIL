$(function () {
  // 1. 팝업구현 -> 배너를 클릭하면 팝업이 나타난다.
  $('.box').click(function () {
    $('#popup').fadeIn(500);
  });
  $('.close').click(function () {
    $('#popup').fadeOut(500);
  });

  // 2. 슬라이더
  // 자동으로 돌림 - 타이머 함수 setInterval(함수, 시간);
  // 1. 좌우로 롤링
  // 2. 아래서 위로
  // 3. 제자리에서 fadin / out
  let imgWidth = $('.top_banner > li').width();
  console.log(imgWidth);
  let imgNum = $('.top_banner > li').length;
  console.log(imgNum);

  let num = 0;
  // setInterval(function () {
  //   num++;
  //   if (num == imgNum - 1) {
  //     num = 0;
  //   }
  //   $('.top_banner')
  //     .stop()
  //     .animate({ left: -num * boxWidth }, 2000, function () {
  //       console.log(num);
  //     });
  // }, 3000);

  // 가로 방향 슬라이더
  // setInterval(function () {
  //   $('.top_banner')
  //     .stop()
  //     .animate({ left: -imgWidth }, 2000, function () {
  //       $('.top_banner').css('left', 0);
  //       $('.top_banner > li:first').insertAfter('.top_banner > li:last');
  //     });
  // }, 3000);

  let imgHeight = $('.top_banner > li').height();
  //세로 방향 슬라이더
  // setInterval(function () {
  //   $('.top_banner')
  //     .stop()
  //     .animate({ top: -imgHeight }, 1000, function () {
  //       $('.top_banner').css('top', 0);
  //       $('.top_banner > li:first').insertAfter('.top_banner > li:last');
  //     });
  // }, 2000);

  //제자리 페이드 인 아웃
  $('.top_banner > li:first').siblings('li').hide();
  setInterval(function () {
    $('.top_banner > li:first').fadeOut(500).next('li').fadeIn(500);
    $('.top_banner > li:first').insertAfter('.top_banner > li:last');
  }, 2500);

  // 3. 탭메뉴
  $('#tab_menu a').click(function () {
    let num = $(this).index();
    $(this).addClass('on').siblings('a').removeClass('on');
    $('#tab_box ul').eq(num).show().siblings('ul').hide();
  });
  $('#tab_menu a').eq(0).trigger('click');

  // 4. 메뉴
  $('.gnb li').mouseover(function () {
    $(this).children('ul').slideDown(500).parent().siblings();
  });

  $().mouseout(function () {});
});
