$(function() {

	$(".ValidateNull").blur(function() {
		var field = $(this).attr("field");
		if (isEmpty(field)) {
			field = $(this).attr("placeholder");
			$(this).attr("field", field);
		}
		if (isEmpty(field)) {
			field = "值";
		}

		$(this).attr("placeholder", field + "不能为空");
		if (!$(this).parent(".form-group").is(".has-error")) {
			$(this).parent(".form-group").addClass("has-error");
		}
	}).focus(function() {
		var field = $(this).attr("field");
		$(this).attr("placeholder", field);
		if ($(this).parent(".form-group").is(".has-error")) {
			$(this).parent(".form-group").removeClass("has-error");
		}
	});

	$(".ValidateEmail").blur(function() {
		var field = $(this).attr("field");
		if (isEmpty(field)) {
			field = $(this).attr("placeholder");
			$(this).attr("field", field);
		}
		if (isEmpty(field)) {
			field = "值";
		}
		if (!RegEx.Email.test($(this).val())) {
			$(this).attr("placeholder", "非法电子邮件格式");
		}

		if (!$(this).parent(".form-group").is(".has-error")) {
			$(this).parent(".form-group").addClass("has-error");
		}
	}).focus(function() {
		var field = $(this).attr("field");
		$(this).attr("placeholder", field);
		if ($(this).parent(".form-group").is(".has-error")) {
			$(this).parent(".form-group").removeClass("has-error");
		}
	});

	$(".ValidateMobile").blur(function() {
		var field = $(this).attr("field");
		if (isEmpty(field)) {
			field = $(this).attr("placeholder");
			$(this).attr("field", field);
		}
		if (isEmpty(field)) {
			field = "值";
		}
		if (!RegEx.Mobile.test($(this).val())) {
			$(this).attr("placeholder", "非法手机格式");
		}

		if (!$(this).parent(".form-group").is(".has-error")) {
			$(this).parent(".form-group").addClass("has-error");
		}
	}).focus(function() {
		var field = $(this).attr("field");
		$(this).attr("placeholder", field);
		if ($(this).parent(".form-group").is(".has-error")) {
			$(this).parent(".form-group").removeClass("has-error");
		}
	});
	$(".currentDate").val((new Date()).Format("YYYY-MM-DD"));
});

var RegEx = {
	"Email" : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	"Mobile" : /^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/
};

// 判断是否为空
function isEmpty(str) {
	if (str == undefined) {
		return true;
	} else if (str == null) {
		return true;
	} else if (str == "") {
		return true;
	} else {
		return false;
	}
}

// 提示层
function tips(tag, msg, type, color) {
	if (isEmpty(type)) {
		type = 1;

	}
	if (isEmpty(color)) {
		color = '#78BA32';
	}

	layer.tips(msg, tag, {
		tips : [ type, color ]
	});
}

/**
 * 加载层
 * @returns
 */
function loading() {
	var index = layer.load(1, {
		shade : [ 0.1, '#000' ]
	});
	return index;
}

/**
 * layer层关闭
 * @param index
 */
function closeLayer(index){
	layer.close(index); 
}

/**
 * 提示层
 * @param msg
 */
function  hintLayer(msg){
	layer.msg(msg);
}


