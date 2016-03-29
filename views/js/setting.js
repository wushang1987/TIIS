

var settingTable = $('#settingTable').DataTable( {
        "ordering": false,
    } );

$("#addCode").on('click', function() {
	console.log('ddd');
	settingTable.row.add([1,1,1]).draw( false );
	
});

   // settingTable.row.add(  ).draw( false );