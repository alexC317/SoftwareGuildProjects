var runningTotal = 0;
var itemID = 0;
var ds = new DataService();

function onItemClick(e) {
    e.preventDefault();

    var item = $(this);
    itemID = item.data("itemid");
    $("#itemIDOutput").val(itemID);
};

function onBalanceClick(e) {
    e.preventDefault();

    var balance = $(this);
    var balanceAmt = balance.data("balanceid");
    runningTotal = runningTotal + balanceAmt;
    $("#balanceOutput").val((runningTotal / 100).toFixed(2));
}

function onPurchaseClick(e) {
    e.preventDefault();

    ds.getItemByID(itemID, (runningTotal / 100), onGetItemByIDSuccess, logError);
    $("#balanceOutput").val((runningTotal / 100).toFixed(2));
}

function onChangeClick(e) {
    e.preventDefault();

    runningTotal = 0;
    itemID = 0;
    resetForms();
    ds.getAllItems(onGetAllItemsSuccess, logError);
}


function onGetAllItemsSuccess(response) {
    $("#items").empty();
    for (var i = 0; i < response.length; i++) {
        var itemFormat =
            `<div class="vendingItem col-md-4" data-itemID="${response[i].id}">
            <p class="text-left">${response[i].id}</p>
            <p class="text-center">${response[i].name}</p>
            <p class="text-center">$${response[i].price}</p>
            <p class="text-center">Quantity Left: ${response[i].quantity}</p>
        </div>`;

        $("#items").append(itemFormat);
    }
}

function onGetItemByIDSuccess(response) {
    $("#messageOutput").val("Thank You!!!");
    $("#changeOutput").val(
        "Quarters: " + response.quarters +
        " Dimes: " + response.dimes +
        " Nickels: " + response.nickels
    );
}

function logError(err) {
    $("#messageOutput").val(err.responseJSON.message);
    calculateChange(runningTotal);
}

function resetForms() {
    $("#balanceOutput").val("");
    $("#messageOutput").val("");
    $("#itemIDOutput").val("");
    $("#changeOutput").val("");
}

function calculateChange(runningTotal) {
    var quarters = Math.floor(runningTotal / 25);
    runningTotal = runningTotal - (quarters * 25);

    var dimes = Math.floor(runningTotal / 10);
    runningTotal = runningTotal - (dimes * 10);

    var nickels = Math.floor(runningTotal / 5);
    runningTotal = runningTotal - (nickels * 5);

    $("#changeOutput").val(
        "Quarters: " + quarters +
        " Dimes: " + dimes +
        " Nickels: " + nickels
    );
}

$(document).ready(function () {
    runningTotal = 0;
    itemID = 0;

    resetForms();
    ds.getAllItems(onGetAllItemsSuccess, logError);

    $(document).on("click", ".vendingItem", onItemClick);
    $(document).on("click", ".balanceButton", onBalanceClick);
    $(document).on("click", ".purchaseButton", onPurchaseClick);
    $(document).on("click", "#changeButton", onChangeClick);
});