$(".addCart").on("click", function(){
	var id = $(this).data("id");
	$.ajax({
	    type : "GET",
	    url : "/DiamonShops/addcart",
	    data : {
	    	id : id
	    },
	    success: function(data){
	    	var ar = data.split("|");
	    	var price  = ar[1];
	    	var totalprice = new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'VND' }).format(price)
	    	document.getElementById("ketqua").innerHTML = ar[0];
	    	document.getElementById("quan-ty").innerHTML = totalprice;
	    }
	});
});
