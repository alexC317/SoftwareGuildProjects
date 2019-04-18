function DataService() {
    var self = this;
    self.getAllItems = function (callback, errorCallback) {
        $.ajax({
            url: "http://localhost:8080/items",
            method: "GET",
            headers: {
                "accept": "application/json"
            },
            success: callback,
            error: errorCallback
        });
    };

    self.getItemByID = function (itemID, amount, callback, errorCallback) {
        $.ajax({
            url: "http://localhost:8080/money/" + amount + "/item/" + itemID,
            method: "GET",
            headers: {
                "accept": "application/json"
            },
            success: callback,
            error: errorCallback
        });
    }
}