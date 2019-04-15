function DataService() {
    var self = this;
    self.getAllItems = function (callback, errorCallback) {
        console.log(2, "Just called getItems");
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
        alert("Your item ID is: " + itemID);
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