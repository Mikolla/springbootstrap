$(document).on("click", '#addTaskButton', function() {


console.log("ADD Task Button clicked!!!")


    /* modal form block */


    var modalBody = $('<div id="modalContent"></div>');
    var modalForm = $('<form id="formoid" role="form" name="modalForm" action="/adminrest" method="POST" ></form>');

    var idForm = $('<div class="form-group"></div>');

    idForm.append('<label for="title" style="margin-top: 5%">title</label>');
    idForm.append('<input class="form-control" name="title" id="title" value="" ref="title"/>');


    var sel = $('<select class="form-control" name="taskState" id="taskState"></select>');

        sel.append('<option value="false">false</option>');
    //    sel.append('<option value="true">true</option>');

    idForm.append('<label for="state" style="margin-top: 5%">state</label>')
    idForm.append(sel);

    modalForm.append(idForm);

    modalBody.append(modalForm);



    $('.1234').html(modalBody);


   // document.querySelector("#myModalLabel").innerHTML = 'Add task';
    document.querySelector("#buttonPanel").removeChild(document.getElementById("saveTaskButton"))
   // document.querySelector("#saveTaskButton").id = "addTaskButton";

    var btn = document.createElement("BUTTON");
    var textAddButton = document.createTextNode("Save task");
    btn.setAttribute("class","btn btn-primary");
    btn.setAttribute("id","addTaskSaveButton");
    btn.appendChild(textAddButton);
    document.querySelector("#buttonPanel").appendChild(btn);

    /* modal form block */
});



$(document).on("click", '#addTaskSaveButton', function() {
    console.log('add and save button clicked')

    var myform = document.getElementById("formoid");
    var formData = new FormData(myform);
    var data =  $('#formoid').serialize();

    var queryString = $('#formoid').serialize();
    console.log(queryString);
    var userId = document.querySelector("#userIdForTask").innerHTML;
    console.log(userIdForTask);

    let
        url = 'http://localhost:8080/rest/usertasks/addtask',
        taskData = {
              userId: userId,
            taskName: formData.get('title')
           // taskState: formData.get('taskState')
        };



    $.ajax({
        type: 'POST',
        url: url,
        data: taskData,
        beforeSend: function(){
           // td2[1].style.color = "darkorange";
           // td2[1].textContent = "Загрузка...";
        },
        success: function (data) {
            console.log("New task = " + data);
            $('#taskTable').append(
                '<tr>' +
                '<td>' + data.id + '</td>' +
                '<td>' + data.taskName + '</td>' +
                '<td>' + data.done + '</td>' +

                '<td>' +
                '<button class="btn btn-success" id="editTaskButton" data-toggle="modal" data-target="#myModal">Edit</button>' +
                ' ' +
                '<button type="button" class="btn btn-primary" id="delTaskButton">Delete</button>'
                + '</td>'
                + '</tr>'
            );

        },
        error: function (error) {
            console.log(error.responseText);
           // td2[1].textContent = "Ошибка сохранения. " + error.responseText;
           // td2[1].style.color = "red";
        }
    });


});