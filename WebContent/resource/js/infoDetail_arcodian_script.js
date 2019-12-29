


  // ----------------문의게시판 쿼리
    $('.table .qtclick').on('click', function () {

    	function slideDown(target) {
    	    // slideUp();
    	    $(target).addClass('on').next().show();
    	}

    	function slideUp(target) {
    	    $(target).removeClass('on').next().hide();
    	}    

    	$(this).hasClass('on') ? slideUp($(this)) : slideDown($(this));

    	});



