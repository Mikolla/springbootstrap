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





    modalForm.append(idForm);

    modalBody.append(modalForm);

    $('.1234').html(modalBody);


    /* modal form block */






});