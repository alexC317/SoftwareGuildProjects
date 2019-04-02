function createDvd() {
  var settings = {
    "url": "http://localhost:8080/dvd",
    "method": "POST",
    "data": JSON.stringify({
      "title": "Movie 1",
      "releaseYear": 2015,
      "director": "JJ Jones",
      "rating": "R",
      "notes": "Generic Movie!"
    }),
    "headers": {
      "accept": "application/json",
      "content-type": "application/json"
    }
  }

  $.ajax(settings).done(function(response) {
    console.log(response);

  });
}



$(document).ready(function() {
  $('h1').text("Hello Alex!");
  $('#movies').append('<li>movie 1</li>');

  $(document).on("click", "#changeName", function(e) {
    //alert('click worked');
    //$('#movies').append('<li>' + $("#movieName").val() + '</li>');

    createDvd();

    var settings = {
      "crossDomain": true,
      "url": "http://localhost:8080/dvds",
      "method": "GET",
      "headers": {
        "accept": "application/json"

      }
    }

    $.ajax(settings).done(function(response) {
      console.log(response);
      $("#movies").empty();
      for (var x = 0; x < response.length; x++) {
        $('#movies').append('<li>' + response[x].title + '</li>');

      }
    });
  });
});
