$(".edit-cart").on("click", function(){
	var id = $(this).data("id");
	var quanty = $("#quanty-cart-" + id).val();
	window.location = "edit-cart/"+id+"/"+quanty;
});