function DataService() {
    var self = this;
    var myData = [{ 'id': 1, 'name': 'Alex' }, { 'id': 2, 'name': 'Jason' }];
    //Create - POST
    //ReadAll - GET
    self.readAll = function (callback, errorFunc) {
        //setTimeout(function () { callback(myData) }, 3000);
        setTimeout(function () { errorFunc("some message") }, 3000);
    }
    //ReadByID - GET
    self.readByID = function (characterID, callback, errorFunc) {
        //setTimeout(function () { callback(myData) }, 3000);
        setTimeout(function () { errorFunc("some message") }, 3000);
    }
    //Update - PUT
    //Delete - DELETE
}

function logError(err) {
    console.log(err);
}

function onCharacterCardClick(e) {
    //alert("This has been clicked!");
    e.preventDefault();

    var btn = $(this);
    console.log(btn);
    console.log(btn.data("characterid"));
    $(btn).css("background-color", "red");
    $(btn).empty();
    $(btn).append("This has been clicked.");
    ds.readByID(1, null, logError);
};

function onSuccessReadAll(response) {
    //Do something
    $("#cards").empty();
    for (var i = 0; i < response.length; i++) {
        console.log(response[i]);
        var cardFormat = `<div class="character-card col-md-4" data-characterid="${response[i].id}">${response[i].name}</div`
        $("#cards").append(cardFormat);
    }
}

var ds = new DataService();

$(document).ready(function () {
    //alert("Wired up!");
    $(document).on("click", ".character-card", onCharacterCardClick);
    ds.readAll(onSuccessReadAll, logError);
});