$(document).ready( function () {
    var table = $('#ingredientsTable').DataTable({
        "sAjaxSource": "/ingredients-list-all",
        "sAjaxDataProp": "",
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "description" },
            { "mData": "amountProtins" },
            { "mData": "amountCarbs" },
            { "mData": "amountFats" }
        ]
    })
});