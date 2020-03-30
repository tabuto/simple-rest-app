$(document).ready(function() {
    $.ajax({
        url: "http://localhost:7001/shoppingList/shoppinglist/get"
    }).then(function(data) {
        $('.list-id').append(data.id);
        $('.list-company').append(data.company);
        $('.list-owner').append(data.owner);
        $('.list-title').append(data.title);
        $('.list-shared').append(data.shared);
        $('.list-createdBy').append(data.createdBy);
    });
});