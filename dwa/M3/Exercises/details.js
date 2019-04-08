var ds = new DataService();

$(document).ready(function(){
    //alert("After ready");
    //alert(window.location.search);
    var urlParams = new URLSearchParams(window.location.search);
    console.log(urlParams.get('dvdid'));
    ds.getDvdById(urlParams.get('dvdid'), onSuccessGetDvd);
});

function onSuccessGetDvd(dvd){
    console.log(dvd);
    $("#title").text(dvd.title);
    $("#director").text(dvd.director);
    $("#year").text(dvd.releaseYear);
    $("#rating").text(dvd.rating);
    $("#notes").text(dvd.notes);

}