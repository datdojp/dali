function enlargeImage(imgLink) {
	$(".realSizeImg").attr("src", imgLink);
	var realSizeImgHeight = $(window).height() - 30;
	$(".realSizeImg").css("max-height", realSizeImgHeight + "px");
	$(".productImageRealSizeBkgr").show();
}