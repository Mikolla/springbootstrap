$(document).ready(function () {


    var btn = document.createElement("BUTTON");
    var textAddButton = document.createTextNode("Play");
    btn.setAttribute("class", "btn btn-success");
    btn.setAttribute("id", "PlayButton");
    btn.setAttribute("data-toggle", "modal");
    btn.setAttribute("data-target", "#myModal");
    btn.appendChild(textAddButton);
    document.querySelector("#placeToInsertPlayButton").appendChild(btn);

    $.ajax({
        url: "http://localhost:8080/rest/exercise/all"
    }).then(function (data) {
        var allExercises = data;
        console.log(allExercises);

        for (var i = 0; i < allExercises.length; i++) {

            console.log(allExercises[i].id + ' ' + allExercises[i].firstNum + ' ' + allExercises[i].secondNum + allExercises[i].action +
            allExercises[i].processingTime + allExercises[i].done +   '\r\n'
            )
            ;

            $('#exerciseTable').append(
                '<tr>' +
                '<td>' + allExercises[i].id + '</td>' +
                '<td>' + allExercises[i].firstNum + '</td>' +
                '<td>' + allExercises[i].secondNum + '</td>' +
                '<td>' + allExercises[i].action + '</td>' +
                '<td>' + allExercises[i].done + '</td>' +
                '<td>' + allExercises[i].processingTime + '</td>' +

                '<td>' +
                '<button class="btn btn-success" id="editExerciseButton" data-toggle="modal" data-target="#myModal">Edit</button>' +
                ' ' +
                '<button type="button" class="btn btn-primary" id="delExerciseButton">Delete</button>'
                + '</td>'
                + '</tr>'
            );
        }


    });

});
