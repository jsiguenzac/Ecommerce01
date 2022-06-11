
//para consumir api
$(document).ready(function() {   
	     var id= $("#idProducto").val();	    
	    let url = "http://localhost:8080/api/producto/"+id;
	    
	    const api = new XMLHttpRequest();
	    api.open('GET', url, true);
	    api.send();
	    
	    api.onreadystatechange = function(){
			if(this.status == 200 && this.readyState == 4){
				let data = JSON.parse(this.responseText);
				console.log(data);
				let resultado = document.querySelector('#cuerpo');
				resultado.innerHTML = `<td>${data.idProducto}</td>`;
				resultado.innerHTML += `<td>${data.nombre}</td>`;
				resultado.innerHTML += `<td>${data.descripcion}</td>`;
				
				let precio = document.querySelector('#precio');
				precio.innerHTML = `<p>S/.${data.precio}</p>`;														
			}
		}	
});


$(document).on("click",".btn-compra",function(){ 
Swal.fire({
  title: 'Seguro que desea hacer la Compra?',
  text: "No podrá revertir esto!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Sí, Seguro!'
}).then((result) => {
  if (result.isConfirmed) {
    Swal.fire(
      '¡Éxito!',
      'Compra Exitosa!',
      'success'
    )
  }
})

});
