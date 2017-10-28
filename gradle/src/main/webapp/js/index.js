/**
 * Created by klas on 2017-10-28.
 */
function search() {
    $.post("counties.jsp", {keyWords: $("#searchFor").val() },
        function(data) {
            var ads = data.matchningslista.matchningdata;
            if (data.matchningslista.antal_platserTotal > 0) {
                var rows = '<tr><th>Rubrik</th><th>Företag</th><th>Publicerad</th><th>Sök senast</th><th>Relevans</th><th></th></tr>';
                $.each(ads, function (index, ad) {
                    var row = '<tr>';
                    row += '<td>' + ad.annonsrubrik + '</td>';
                    row += '<td>' + ad.arbetsplatsnamn + '</td>';
                    row += '<td>' + ad.publiceraddatum.split('T')[0] + '</td>';
                    row += '<td>' + ad.sista_ansokningsdag.split('T')[0] + '</td>';
                    row += '<td>' + ad.relevans + '</td>';
                    row += '<td><button onclick="rate(' + ad.annonsid + ')">Betyg sätt</button></td>';
                    rows += row + '<tr>';
                });
                $('#result').html(rows);
            } else {
                alert("Hittade inga annonser!")
            }
        }
    );
}

function rate(id) {
    $.post("rateAd.jsp", {id: id, keys: getRaings()},
        function(data) {
            alert(data);
        }
    );
}

function getRaings() {
    var ratings = '{';
    if($("#key1").val() !== '') {
        ratings += '"';
        ratings += $("#key1").val();
        ratings += '": ';
        ratings += $("#rate1").val();
    }
    if($("#key2").val() !== '') {
        ratings += ', "';
        ratings += $("#key2").val();
        ratings += '": ';
        ratings += $("#rate2").val();
    }
    if($("#key3").val() !== '') {
        ratings += ', "';
        ratings += $("#key3").val();
        ratings += '": ';
        ratings += $("#rate3").val();
    }
    if($("#key4").val() !== '') {
        ratings += ', "';
        ratings += $("#key4").val();
        ratings += '": ';
        ratings += $("#rate4").val();
    }
    ratings += '}';

    return ratings;
}