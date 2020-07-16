/* ----------------------------------------------------------------
 ltnav_btn
 -----------------------------------------------------------------*/
$(function() {
	var scrollHeight = 0;

	$("body").on("click", "#ltnav_btn", function() {

		$("#ltnav").css("display", "block").fadeIn("slow");
		$("#ltnav").css("overflow-x", "hidden");
		//$("#content").css('margin-left', '239px');
		$("#ltnav_mask, #lnav_close").css("display", "block").fadeIn("slow");

	});

	$("body").on("click", "#lnav_close", function() {

		$("#ltnav").css("display", "none");
		//$("#content").css('margin-left', '0px');
		$("#ltnav_mask, #lnav_close").css("display", "none").fadeOut("slow");

		$("body").css("overflow-y", "auto");

		$("#content_inner").css({
			"position" : "inherit", //최상위 div 고정해제
			"top" : 0 //top값 해제
		})

		$('html, body').animate({
			scrollTop : scrollHeight
		}, 10);
	});

	$(".carousel").swipe({

		swipe : function(event, direction, distance, duration, fingerCount, fingerData) {

			if (direction == 'left')
				$(this).carousel('next');
			if (direction == 'right')
				$(this).carousel('prev');

		},
		allowPageScroll : "vertical"

	});
});

