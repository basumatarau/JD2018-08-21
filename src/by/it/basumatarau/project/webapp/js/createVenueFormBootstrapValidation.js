$(document).ready(function() {

    console.log("test");

    $('#createVenueForm').bootstrapValidator({
        fields: {
            nameinput: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your venue name'
                    }
                }
            }
        }
    })
    .on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();
    });
});