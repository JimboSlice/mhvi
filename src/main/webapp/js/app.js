/*
Core JavaScript functionality for the application.  Performs the required
Restful calls, validates return values, and populates the patient table.
 */

/* Get the patient template */
function getpatientTemplate() {
    $.ajax({
        url: "tmpl/patient.tmpl",
        dataType: "html",
        success: function( data ) {
            $( "head" ).append( data );
            updatepatientTable();
        }
    });
}

/* Builds the updated table for the patient list */
function buildpatientRows(patients) {
    return _.template( $( "#patient-tmpl" ).html(), {"patients": patients});
}

/* Uses JAX-RS GET to retrieve current patient list */
function updatepatientTable() {
    $.ajax({
        url: "rest/patients",
        cache: false,
        success: function(data) {
            $('#patients').empty().append(buildpatientRows(data));
        },
        error: function(error) {
            //console.log("error updating table -" + error.status);
        }
    });
}

/*
Attempts to register a new patient using a JAX-RS POST.  The callbacks
the refresh the patient table, or process JAX-RS response codes to update
the validation errors.
 */
function registerpatient(patientData) {
    //clear existing  msgs
    $('span.invalid').remove();
    $('span.success').remove();

    $.ajax({
        url: 'rest/patients',
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        data: JSON.stringify(patientData),
        success: function(data) {
            //console.log("patient registered");

            //clear input fields
            $('#reg')[0].reset();

            //mark success on the registration form
            $('#formMsgs').append($('<span class="success">Patient Registered</span>'));

            updatepatientTable();
        },
        error: function(error) {
            if ((error.status == 409) || (error.status == 400)) {
                //console.log("Validation error registering user!");

                var errorMsg = $.parseJSON(error.responseText);

                $.each(errorMsg, function(index, val) {
                    $('<span class="invalid">' + val + '</span>').insertAfter($('#' + index));
                });
            } else {
                //console.log("error - unknown server issue");
                $('#formMsgs').append($('<span class="invalid">Unknown server error</span>'));
            }
        }
    });
}
