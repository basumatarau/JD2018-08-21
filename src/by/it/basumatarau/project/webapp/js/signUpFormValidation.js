$(document).ready(function() {
    $('#singUpForm').bootstrapValidator({
        fields: {
            logininput: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 15,
                        message: 'the login name must be less than 15 characters',
                    },
                    notEmpty: {
                        message: 'Please supply your login name',
                    },
                    regexp: {
                        regexp: /^[\w\d]+$/i,
                        message: 'The login name can consist of alphabetical characters and numbers only'
                    }
                }
            },
            emailinput: {
                validators: {
                    stringLength: {
                        max: 40,
                        message: 'the email is too long'
                    },
                    emailAddress: {
                        message: 'The value is not a valid email address'
                    },
                    notEmpty: {
                        message: 'Please supply your email',
                    }
                }
            },
            passwordinput: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 40,
                        message: 'the password length must not exceed 40 characters',
                    },
                    notEmpty: {
                        message: 'Please supply your password',
                    }
                }
            }
        }
    });
});