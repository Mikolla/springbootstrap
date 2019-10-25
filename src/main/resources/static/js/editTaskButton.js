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

    var queryString = $('#formoid').serialize();
    console.log(queryString);


    let wrap = {
        taskId: formData.get('id'),
        taskTitle: formData.get('title'),
        taskState: formData.get('taskState')
    };
    let data = JSON.stringify(wrap);





});