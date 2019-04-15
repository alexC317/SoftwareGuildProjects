function onItemClick(e) {
    alert("This item has been clicked!");
};

function onPurchaseClick(e) {
    alert("This button has been clicked!");
}

function onPurchaseClick(e) {
    alert("This button has been clicked!");
}

$(document).ready(function () {
    //alert("All wired up!");
    $(document).on("click", ".vendingItem", onItemClick);
    $(document).on("click", ".balanceButton", onPurchaseClick);
    $(document).on("click", ".purchaseButton", onPurchaseClick)
});