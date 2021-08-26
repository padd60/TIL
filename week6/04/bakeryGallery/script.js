$(function () {
  $('.list > li').on('click', function () {
    $(this).addClass('on').siblings('li').removeClass('on');
    let name = $(this).children('img').attr('alt');
    $('.name > span').text(name);
    let img = $(this).children('img').attr('src');
    $('.bigImg > img').attr('src', img);
  });
});
