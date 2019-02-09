$(document).ready(function() {
    $('#createVenueForm').bootstrapValidator({
        fields: {
            nameinput: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 15,
                        message: 'the venue name is has to be less than 15 characters',
                    },
                    notEmpty: {
                        message: 'Please supply your venue name',
                    },
                    regexp: {
                        regexp: /^[\w\d\s]+$/i,
                        message: 'The full name can consist of alphabetical characters, number and spaces only'
                    }
                }
            },
            descriptioninput: {
                validators: {
                    stringLength: {
                        max: 20,
                    },
                    notEmpty: {
                        message: 'Please supply your venue description',
                    }
                }
            },
            placenameinput: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 15,
                        message: 'the venue place name has to be less than 15 characters',
                    },
                    notEmpty: {
                        message: 'Please supply your venue place',
                    }
                }
            },
            addressinput: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 15,
                        message: 'the venue address has to be less than 15 characters',
                    },
                    notEmpty: {
                        message: 'Please supply your venue address',
                    }
                }
            },
            feeinput: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 10,
                        message: 'the venue fee has to be less than 10 characters',
                    },
                    notEmpty: {
                        message: 'Please supply your venue fee',
                    }
                }
            },
            datetimeinput: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your venue date',
                    },
                    regexp: {
                        regexp: /\d{4}[-]\d{2}[-]\d{2}\s*\d{2}:\d{2}:\d{2}\s*$/i,
                        message: 'the date time patter is yyyy-mm-dd hh:mm:ss, please use the picker'
                    }
                }
            },

        }
    });
});