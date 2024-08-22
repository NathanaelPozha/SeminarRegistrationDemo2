/**
 * 
 */

$(document).ready(function(){
	
	$('.table .eBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(p, status){
			$('.myForm #id').val(p.id);
			$('.myForm #nama').val(p.nama);
			$('.myForm #nim').val(p.nim);
			$('.myForm #email').val(p.email);
			$('.myForm #nomorTelepon').val(p.nomorTelepon);
			$('.myForm #idLine').val(p.idLine);
			$('.myForm #jurusan').val(p.jurusan);
			$('.myForm #fakultas').val(p.fakultas);
			$('.myForm #angkatan').val(p.angkatan);
			$('.myForm #nomorKursi').val(p.nomorKursi);
		});
		
		$('.myForm #exampleModal').modal();
	});
});