$(document).ready(function() {
	
	show_order_summary();
	
	// place order
	$('div.cart-detail').on('click', '.btn-place-order',function(evt) {
		evt.preventDefault();
		
		// receiver info obj
		let receiverInfo = {
			name: $('#r-name').val(),
			email: $('#r-email').val(),
			phone : $('#r-phone').val(),
			address: $('#r-address').val()
		}
		
		// ordered items
		let cartItemList = localStorage.getItem('cart-item-data');
		let cartItemList_obj = JSON.parse(cartItemList);
		
		// order info
		let orderInfo = {
			receiver: receiverInfo,
			orderItems : cartItemList_obj,
			
		};
		
		// call server with ajax
		$.ajax({
			beforeSend: function(xhr) {
    			xhr.setRequestHeader('X-CSRF-Token', $('meta[name="csrf-token"]').attr('content'))
  			},
			type: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(orderInfo),
			url: '/cart/place-order',
			success: function(result) {
				if(result == "") {
					alert("Somethins is wrong. Try again.")
				}else {
					localStorage.clear();
					alert("Your order has been successfully placed. Your OrderId is " + result +"\n Thanks")
					window.location.href = "/";// <a href="/" />
				}
				
			},
			error: function(result) {
				alert("Something is wrong");
			}
		});
		
		
	})
	
	function show_order_summary() {
		let cartItemList = localStorage.getItem('cart-item-data');
		let cartItemList_obj = JSON.parse(cartItemList);
		let total = 0;
		$.each(cartItemList_obj, function(i, prod) {
			let sub_total = prod.qty * prod.price;
			total += sub_total;
		});
		
		$('.total').text(total + " ks.");
		$('.grand-total').text(total + " ks.");
	}
});