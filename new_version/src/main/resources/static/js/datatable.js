$(document).ready(function () {
    var table = $('#ingredientsTable').DataTable({
        "sAjaxSource": "/ingredients-list-all",
        "sAjaxDataProp": "",
        "aoColumns": [
            {"mData": "id"},
            {"mData": "name"},
            {"mData": "description"},
            {"mData": "category"},
            {"mData": "amountProtins"},
            {"mData": "amountCarbs"},
            {"mData": "amountFats"}
        ],
        "oLanguage": {
            "sProcessing": "Dane są przetwarzane...",
            "sLengthMenu": "Ilość pozycji na stronie _MENU_",
            "sZeroRecords": "Brak danych do wyświetlenia",
            "sInfo": "Pozycja _START_ z _END_ na _TOTAL_",
            "sInfoEmpty": "Strona 0 na 0 na wpisów  0",
            "sInfoFiltered": "(Wyfiltrowano z  _MAX_ rekordów)",
            "sInfoPostFix": "",
            "sSearch": "Szukaj:",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "Pierwsza",
                "sPrevious": "Cofnij",
                "sNext": "Dalej",
                "sLast": "Cofnij",
            }
        },
        initComplete: function () {
            this.api().columns().every(function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                    .appendTo($(column.footer()).empty())
                    .on('change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );

                        column
                            .search(val ? '^' + val + '$' : '', true, false)
                            .draw();
                    });

                column.data().unique().sort().each(function (d, j) {
                    select.append('<option value="' + d + '">' + d + '</option>')
                });
            });
        }
    })
});