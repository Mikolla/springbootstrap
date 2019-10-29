$(document).on("click", '#editTaskButton', function() {

    var $tr = $(this).closest('tr');
    console.log('form filler script');
    // Get array of column Headings
    var columnHeadings = $("thead th").map(function() {
        return $(this).text();
    }).get();
    // Remove the last column heading (for the Edit button)
    columnHeadings.pop();
    // Get array of column values from the row where the Edit button was clicked
    var columnValues = $(this).parent().siblings().map(function() {
        return $(this).text();
    }).get();
    var taskId = columnValues[0];
    var taskTitle = columnValues[1];
    var renderState = columnValues[2];

    console.log('id to del = ' + taskId);
    console.log('login to del = ' + taskTitle);
    console.log('name to del = ' + renderState);



    /* modal form block */


    var modalBody = $('<div id="modalContent"></div>');
    var modalForm = $('<form id="formoid" role="form" name="modalForm" action="/adminrest" method="POST" ></form>');


    var idForm = $('<div class="form-group"></div>');

    idForm.append('<label for="id" style="margin-top: 5%">id</label>');
    idForm.append('<input class="form-control"  disabled="disabled"  name="id" id="id" value="'+taskId+'" />');

    idForm.append('<input class="form-control"  type="hidden"  name="id" id="id" value="'+taskId+'" ref="id"/>');


    idForm.append('<label for="'+columnHeadings[1]+'" style="margin-top: 5%">title</label>');
    idForm.append('<input class="form-control" name="title" id="title" value="'+taskTitle+'" ref="title"/>');


    var sel = $('<select class="form-control" name="taskState" id="taskState"></select>');
    if (renderState == 'true') {
        sel.append('<option value="true">true</option>');
        sel.append('<option value="false">false</option>');
    } else {
        sel.append('<option value="false">false</option>');
        sel.append('<option value="true">true</option>');
    }


    idForm.append('<label for="state" style="margin-top: 5%">state</label>')
    idForm.append(sel);

    modalForm.append(idForm);

    modalBody.append(modalForm);

    $('.1234').html(modalBody);


    /* modal form block */


});








$(document).on("click", '#saveTaskButton', function() {
    console.log('save button clicked')

    var myform = document.getElementById("formoid");
    var formData = new FormData(myform);
    var data =  $('#formoid').serialize();

    var queryString = $('#formoid').serialize();
    console.log(queryString);

    let
        url = 'http://localhost:8080/rest/usertasks/edit',
        taskData = {
            taskId: formData.get('id'),
            taskName: formData.get('title'),
            taskState: formData.get('taskState')
        };
    $.ajax({
        type: 'POST',
        url: url,
        data: taskData,
        success: function () {
            console.log('WORKED!!!');
        },
        error: function (error) {
            console.log(error.responseText);
        }
    });





  /*  $.ajax({
        type: 'POST', // Use POST with X-HTTP-Method-Override or a straight PUT if appropriate.
      //  dataType: "json", // Set datatype - affects Accept header
      //  contentType: "application/json; charset=utf-8",
        url: "http://localhost:8080/rest/usertasks/edit", // A valid URL
        data: formData, // Some data e.g. Valid JSON as a string
        headers: {
            'Accept': 'form-data',
            'Content-Type': 'application/json; charset=utf-8'
        }

    }).then(function(data) {

        console.log("Ajax Works");
     //   $('form[name="modalForm"]').submit();
    }); */


  /*  $.ajax({
        type: 'POST', // Use POST with X-HTTP-Method-Override or a straight PUT if appropriate.
        dataType: "json", // Set datatype - affects Accept header
        contentType: "application/json; charset=utf-8",
        url: "http://localhost:8080/rest/usertasks/edit", // A valid URL
        data: jsondata, // Some data e.g. Valid JSON as a string
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    }).then(function(data) {
        console.log("Ajax Works");
        $('form[name="modalForm"]').submit();
    });

    jQuery.ajax({
        type: "POST",
        url: "http://localhost:8080/rest/usertasks/edit",
        contentType: "application/json; charset=utf-8",
        data: jsondata,
        success: function(data) {
            console.log('WORKED!!!');



        },
        error: function (e) {
            console.log("ERROR")
        }

    }); */




});