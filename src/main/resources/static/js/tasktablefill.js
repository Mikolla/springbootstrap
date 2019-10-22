$(document).ready(function() {

    var userIdForTask = document.querySelector("#userIdForTask").innerHTML;
    console.log(userIdForTask);

    $.ajax({
        url: "http://localhost:8080/rest/usertasks/" + userIdForTask
    }).then(function(data) {
        var userTaskList = data;
        console.log(userTaskList);




        for(var i = 0; i < userTaskList.length; i++) {

            console.log(userTaskList[i].id + ' ' + userTaskList[i].taskName + ' ' + userTaskList[i].isDone + ' '  + '\r\n');

            $('#taskTable').append(
                '<tr>' +
                '<td>' + userTaskList[i].id + '</td>' +
                '<td>' + userTaskList[i].taskName + '</td>' +
                '<td>' + userTaskList[i].done + '</td>' +

                '<td>' +
                        '<button class="btn btn-success" id="edButton" data-toggle="modal" data-target="#myModal">Edit</button>' +
                        ' ' +
                        '<button type="button" class="btn btn-primary" id="delTaskButton">Delete</button>'
                + '</td>'
                + '</tr>'
            );
        }
    });
});
