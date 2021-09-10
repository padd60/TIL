$(function () {
  let num = $('.list>li').length;
  $('.list>li').click(function () {
    $('#popup').fadeIn(500);
    let idx = $(this).index() + 1;
    let popName = $(this).children('img').attr('alt');
    $('.popimg').attr('src', 'images/0' + idx + '_pp.jpg');
    $('.name span').text(popName);

    $('.bigImg .next').click(function () {
      idx++;
      if (idx > num) {
        idx = 1;
      }
      console.log(num, idx);
      $('.popimg').attr('src', 'images/0' + idx + '_pp.jpg');
      popName = $('.list>li')
        .eq(idx - 1)
        .children('img')
        .attr('alt');
      $('.name span').text(popName);
    });

    $('.bigImg .prev').click(function () {
      idx--;
      if (idx < 1) {
        idx = num;
      }
      console.log(num, idx);
      $('.popimg').attr('src', 'images/0' + idx + '_pp.jpg');
      popName = $('.list>li')
        .eq(idx - 1)
        .children('img')
        .attr('alt');
      $('.name span').text(popName);
    });
  });
  $('.close').click(function () {
    $('#popup').fadeOut();
  });
});
