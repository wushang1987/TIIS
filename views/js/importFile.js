var dc = $('#importFileTable').dataTable({
    "processing": true,
    "serverSide": true,
     "pagingType": "full_numbers",
    "ordering": false,
    searching:true,
    "ajax": {
        "url": "http://localhost/123/sf/list",
        "type": 'GET',
        "data":function  (d,a,b) {
            d.fileName =d.search.value;
            // console.log(d);
            // console.log(a);
            // console.log(b);
        }
    },
    "columns": [
            { "data": "fileName" },
            { "data": "uploadTime" },
            // { "data": "fileId" },
            // { "data": "id" },
            // { "data": "filePath" },
            { 
                "data":null,
                "defaultContent": '<button name="fenxi" type="button" class="btn btn-sm  btn-success">分析</button><button type="button" class="btn  btn-sm btn-danger">删除</button>'
                 },
        ]

});


$('#importFileTable tbody').on( 'click', 'button', function (e) {
   
        //删除部分代码OK
      // $.ajax({
      //     url: '123/sf/delete/1/d224fbb6-573f-4e2c-858e-f392debc4e58',
      //     type: 'GET',
      // })
      // .done(function() {
      //     console.log("success");
      // });

      window.location.href = '123/sf/analysis/5cbdf7db-7e1c-499c-bea1-3630f0f4f845/2015_12_1.xls';
      // $.ajax({
      //     url: '123/sf/analysis/8e1fba06-df49-4564-9681-6173005dfbb9/2015_11_1.xls',
      //     type: 'GET',
      // })
      // .done(function(data) {
      //     console.log("success");
      //     console.log(data);
      // });
      
      
    } );





$('#file-es').fileinput({
    uploadAsync:false,
    uploadUrl: 'http://localhost/123/upload/excel',

});

$('#file-es').on('filebatchuploadsuccess', function(event, data, previewId, index) {
    // var form = data.form, files = data.files, extra = data.extra,
    //     response = data.response, reader = data.reader;
    console.log('File batch upload success');

});


