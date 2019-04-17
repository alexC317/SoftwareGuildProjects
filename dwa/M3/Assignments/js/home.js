var runningTotal = 0;
var ds = new DataService();

function onItemClick(e) {
    e.preventDefault();

    var item = $(this);
    var itemID = item.data("itemid");
    $("#purchaseItem").val(itemID);
};

function onBalanceClick(e) {
    e.preventDefault();

    var balance = $(this);
    var balanceAmt = balance.data("balanceid");
    runningTotal = runningTotal + balanceAmt;

    $("#balanceInput").val((runningTotal / 100).toFixed(2));
}

function onPurchaseClick(e) {
    e.preventDefault();

    //Ajax call here probably
    runningTotal = 0;
    $("#balanceInput").val(runningTotal.toFixed(2));
}


function onGetAllItemsSuccess(reponse) {

}

function logError(err) {
    console.log(err);
}


$(document).ready(function () {
    //alert("All wired up!");

    ds.getAllItems(onGetAllItemsSuccess);

    $(document).on("click", ".vendingItem", onItemClick);
    $(document).on("click", ".balanceButton", onBalanceClick);
    $(document).on("click", ".purchaseButton", onPurchaseClick);
});