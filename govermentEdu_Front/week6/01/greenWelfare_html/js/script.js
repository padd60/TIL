$(function () {
  // 1. 팝업구현 -> 배너를 클릭하면 팝업이 나타난다.
  $('.box').click(function () {
    $('#popup').fadeIn(500);
    $('#popup').click(function () {
      $(this).fadeOut(500);
    });
    $('.modal').click(function (e) {
      e.stopPropagation(); // 이벤트 버블링 현상 차단
    });
    /* 
      $('.modal').click(function (e) {
        if($('.modal).has(e.target).length >= 0){ // 클릭하면 0
          $('#popup).show();
        }else{
          $('#popup).fadeOut();
        }
      });
    */
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
  /*
    1. 호버하면 대메뉴에 속해있는 서브만 슬라이드 다운으로 애니메이션
    2. 호버하면 서브메뉴가 통채로 다 슬라이드 다운
    3. 호버하면 서브메뉴가 통채로 다 슬라이드 다운 + bg가 같이
  */
  // 1번 메뉴
  // $('.gnb li').on({
  //   mouseenter: function () {
  //     $(this).children('ul').stop().slideDown(500);
  //   },
  //   mouseleave: function () {
  //     $(this).children('.submenu').stop().slideUp(500);
  //   },
  // });

  // 2번 메뉴
  // $('.gnb li').on({
  //   mouseenter: function () {
  //     $('.submenu').stop().slideDown(500);
  //   },
  //   mouseleave: function () {
  //     $('.submenu').stop().slideUp(500);
  //   },
  // });

  // 3번 메뉴
  $('header').append('<div class="bg"></div>');
  $('.gnb li').on({
    mouseenter: function () {
      $('.submenu, .bg').stop().slideDown(500);
    },
    mouseleave: function () {
      $('.submenu, .bg').stop().slideUp(500);
    },
  });
});
