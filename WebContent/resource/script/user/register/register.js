$(function() {
	$('#registerForm').bootstrapValidator({
		message : '不能为空',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			username : {
				message : '用户名没有验证',
				validators : {
					notEmpty : {
						message : '用户名不能为空'
					},
					stringLength : {
						min : 6,
						max : 20,
						message : '用户名长度必须大于6小于20'
					},
					regexp : {
						regexp : /^[a-zA-Z0-9_]+$/,
						message : '用户名不能包含特殊字符'
					}
				}
			},
			useralias : {
				message : '姓名没有验证',
				validators : {
					notEmpty : {
						message : '姓名不能为空'
					}
				}
			},
			password : {
				message : '密码没有验证',
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : {
						min : 6,
						max : 20,
						message : '密码长度必须大于6小于20'
					},
				}
			},

			confirmPassword : {
				message : '重复密码没有验证',
				validators : {
					notEmpty : {
						message : '重复密码不能为空'
					},
					stringLength : {
						min : 6,
						max : 20,
						message : '重复密码长度必须大于6小于20'
					},
				}
			},
			email : {
				validators : {
					notEmpty : {
						message : '电子邮件不能为空'
					},
					emailAddress : {
						message : '非法的电子邮件地址'
					}
				}
			},
			phone : {
				validators : {
					notEmpty : {
						message : '电话号码不能为空'
					}
				}
			},
			birthdate : {
				validators : {
					notEmpty : {
						message : '出生日期不能为空'
					}
				}
			}
		}
	});
});