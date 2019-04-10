function DataService() {
    var self = this;
    self.getDvds = function (callback) {
        console.log(2, "just called getDvds");
        $.ajax({
            url: 'http://localhost:8080/dvds',
            method: 'GET',
            headers: {
                'accept': 'application/json'
            }
        }).done(callback);

    };
    self.getDvdById = function (dvdId, callback) {
        alert('your dvd is:' + dvdId);
        $.ajax({
            url: 'http://localhost:8080/dvd/' + dvdId,
            method: 'GET',
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json'
            },
            success: callback
        });
    };
    self.createDvd = function (dvd, callback) {
        $.ajax({
            url: 'http://localhost:8080/dvd/',
            method: 'POST',
            data: JSON.stringify(dvd),
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json'
            },
            success: callback
        });
    };
    self.editDvd = function (dvd, callback) {
        $.ajax({
            url: 'http://localhost:8080/dvd/' + dvd.dvdId,
            method: 'PUT',
            data: JSON.stringify(dvd),
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json'
            },
            success: callback
        });
    };
    self.deleteDvd = function (dvdId, callback) {

        $.ajax({
            url: 'http://localhost:8080/dvd/' + dvdId,
            method: 'DELETE',
            headers: {
                'accept': 'application/json'
            }
        }).done(callback);


    };
    self.searchDvd = function (searchTerm, query, callback) {
        $.ajax({
            url: 'http://localhost:8080/dvds/' + searchTerm + '/' + query,
            method: 'GET',
            headers: {
                'accept': 'application/json'
            }
        }).done(callback);
    }
}