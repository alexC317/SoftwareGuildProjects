$(document).ready(function () {
    $("H1").css({ "text-align": "center" });
    $("H2").css({ "text-align": "center" });

    $("H1").removeClass("myBannerHeading");
    $("H1").addClass("page-header");

    $("#yellowHeading").text("Yellow Team");
    $("#orangeTeamList").css({ "background-color": "orange" });
    $("#blueTeamList").css({ "background-color": "blue" });
    $("#redTeamList").css({ "background-color": "red" });
    $("#yellowTeamList").css({ "background-color": "yellow" });

    $("#yellowTeamList").append("<li>Joseph Banks</li>");
    $("#yellowTeamList").append("<li>Simon Jones</li>");

    $("#oops").hide();

    $("#footerPlaceholder").remove();

    $("#footer").append("<p id='newFooter'>Alex Cepeda alex.f.cepeda@gmail.com</p>").css({ "font-family": "24", "font-size": "24px" });
});