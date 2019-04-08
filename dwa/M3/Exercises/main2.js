var ds = new DataService();

function onDeleteDvd(e) {
    //alert("You've clicked a delete button");
    e.preventDefault();
    // get meta data
    var dvdId = $(e.target).attr('data-dvdId');
    var row = $(e.target).parent().parent();
    ds.deleteDvd(dvdId, function () {
        $(row).fadeOut(1000, function () {
            $(this).remove();
        });
    });
    alert(dvdId);
}

function onEditDvd(e) {
    //alert("You've clicked a edit button");
    var dvdId = $(e.target).attr('data-dvdId');
    alert(dvdId);
    ds.getDvdById(dvdId, function (dvd) {
        console.log('my dvd', dvd);
        //alert('whhhhhy');
        $("#editDvd").show();
        $("#createDvd").hide();
        $("#dvdId").val(dvd.dvdId);
        $("#title").val(dvd.title);
        $("#releaseYear").val(dvd.releaseYear);
        $("#director").val(dvd.director);
        $("#rating").val(dvd.rating);
        $("#notes").val(dvd.notes);
    })
}

function onDvdDetails(e) {
    alert("You've clicked a details button");
}

function onSaveEditDvd(e) {
    //alert('save');
    e.preventDefault();
    var dvd = {
        dvdId: $("#dvdId").val(),
        title: $("#title").val(),
        releaseYear: $("#releaseYear").val(),
        director: $("#director").val(),
        rating: $("#rating").val(),
        notes: $("#notes").val()
    };
    console.log(dvd);

    ds.editDvd(dvd, function () {
        $("form").trigger("reset");;
        $("#editDvd").hide();
        $("#createDvd").show();
        ds.getDvds(onSuccessGetDvds);
    });
}

function onSaveCreateDvd(e) {
    e.preventDefault();
    var dvd = {
        title: $("#title").val(),
        releaseYear: $("#releaseYear").val(),
        director: $("#director").val(),
        rating: $("#rating").val(),
        notes: $("#notes").val()
    };
    console.log(dvd);

    ds.createDvd(dvd, function () {
        $("form").trigger("reset");
        ds.getDvds(onSuccessGetDvds);
    });
}

function onSuccessGetDvds(dvds) {
    console.log(4, "Finished the call");
    console.log(5, dvds);
    $("tbody").empty();
    for (let i = 0; i < dvds.length; i++) {
        var dvd = dvds[i];
        var row = `<tr>
                    <td>${dvd.title}</td>
                    <td>${dvd.releaseYear}</td>
                    <td>${dvd.director}</td>
                    <td>${dvd.rating}</td>
                    <td>
                        <a href="#" class="btn btn-danger" data-dvdId='${dvd.dvdId}'>Delete</a>
                        <a href="#" class="btn btn-secondary" data-dvdId='${dvd.dvdId}'>Edit</a>
                        <a href="details.html?dvdid=${dvd.dvdId}" class="btn btn-primary" data-dvdId='${dvd.dvdId}'>Details</a>
                    </td>
              </tr>`;
        $("tbody").append(row);
    }

}

function onClickFilter(e) {
    e.preventDefault();
    //alert("You have clicked the search button.");
    ds.searchDvd($("#field").val(), $("#search").val(), onSuccessGetDvds);
}

$(document).ready(function () {

    //WIRE up all click events
    $(document).on("click", ".btn-danger", onDeleteDvd);
    $(document).on("click", ".btn-secondary", onEditDvd);
    //$(document).on("click", ".btn-primary", onDvdDetails);
    $(document).on("click", "#editDvd", onSaveEditDvd);
    $(document).on("click", "#createDvd", onSaveCreateDvd);
    $(document).on("click", "#filter", onClickFilter);

    console.log(1, 'Before getting a dvd');
    ds.getDvds(onSuccessGetDvds);

    console.log(3, "I'm walking here");

});