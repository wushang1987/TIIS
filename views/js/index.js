
$("#leftNav a").on('click', function() {
	$(this).addClass('active').siblings().removeClass('active');
});

routie({
	'': function() {
		appendPage ("importFile.html");
		leftNavActive (0);
    },
    'importFile': function() {
    	appendPage ("importFile.html");
    	leftNavActive (0);
    },
    'creatFile': function() {
    	appendPage ("creatFile.html");
    	leftNavActive (1);
    },
    'setting': function() {
    	appendPage ("setting.html");
    	leftNavActive (2);
    }
});

function leftNavActive (index) {
	$("#leftNav a").eq(index).addClass('active').siblings().removeClass('active');
}


function appendPage (pageName,parentCon) {
	if (parentCon == null);
	parentCon = "rightCon";

	$.ajax({
		url: pageName,
		type: 'GET',
	})
	.done(function(data) {
		$("#"+ parentCon).empty();
		$("#"+ parentCon).append(data);
	})
	
	
}