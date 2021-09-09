$(document).ready(function () {
  $(window).scroll(function () {
    var st = $(window).scrollTop();
    console.log(st);

    if (st > 300) {
      $('.header-wrapper').addClass('active');
    } else {
      $('.header-wrapper').removeClass('active');
    }

    if (st > 500) {
      $('.section1').addClass('active');
    } else {
      $('.section1').removeClass('active');
    }

    if (st > 1300) {
      $('.section2').addClass('active');
    } else {
      $('.section2').removeClass('active');
    }

    if (st > 1800) {
      $('.section3').addClass('active');
    } else {
      $('.section3').removeClass('active');
    }
  });
});
