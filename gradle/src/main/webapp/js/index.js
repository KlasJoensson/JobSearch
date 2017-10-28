/**
 * Created by klas on 2017-10-28.
 */
function search() {
    $.post("counties.jsp", {keyWords: $("#searchFor").val() },
        function(data) {
            var adds = data.matchningslista.matchningdata;
            if (data.matchningslista.antal_platserTotal > 0) {
                var rows = '<tr><th>Rubrik</th><th>Företag</th><th>Publicerad</th><th>Sök senast</th><th>Relevans</th></tr>';
                $.each(adds, function (index, add) {
                    var row = '<tr>';
                    row += '<td>' + add.annonsrubrik + '</td>';
                    row += '<td>' + add.arbetsplatsnamn + '</td>';
                    row += '<td>' + add.publiceraddatum.split('T')[0] + '</td>';
                    row += '<td>' + add.sista_ansokningsdag.split('T')[0] + '</td>';
                    row += '<td>' + add.relevans + '</td>';
                    rows += row + '<tr>';
                });
                $('#result').html(rows);
            } else {
                alert("Hittade inga annonser!")
            }
        }
    );
}