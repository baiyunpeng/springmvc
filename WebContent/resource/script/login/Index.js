$(function(){
    $('#loginFrom').bootstrapValidator({
        message: '数据没有通过验证',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                	notEmpty: {},
                    emailAddress: {}
                }
            },
            password: {
                validators: {
                    notEmpty: {}
                }
            }
        }
    });
});