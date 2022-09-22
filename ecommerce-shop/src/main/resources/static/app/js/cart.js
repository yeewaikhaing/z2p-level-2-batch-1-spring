$(document).ready(function() {
	initializeLocalStorage();
	showCartCount();
	
	$('div.product').on('click', '.add-to-cart', function(evt) {
		evt.preventDefault();
		
		let id_val = $(this).data('id');
		let name_val = $(this).data('name');
		let price_val = $(this).data('price');
		
		let cartItemList = localStorage.getItem('cart-item-data');
		let cartItemList_obj = JSON.parse(cartItemList);
		
		let flag = false;
		let found_index = -1;
		let old_product = '';
		$.each(cartItemList_obj, function(i, product) {
			if(id_val == product.productId) {
				flag = true;
				found_index = i;
				old_product = product;
			}
		});
		
		if(flag) { // old proudct
			old_product.qty = old_product.qty + 1;
			cartItemList_obj[found_index] = old_product;
		}
		else { // new proudct
			// new proudct
			let new_prod = {
				productId: id_val,
				name: name_val,
				price: price_val,
				qty: 1
			};
			cartItemList_obj.push(new_prod);
		}
		
		// store array obj to localStorage
		localStorage.setItem('cart-item-data', JSON.stringify(cartItemList_obj))
		
		showCartCount();	
	});
	
	function showCartCount() {
		let cartItemList = localStorage.getItem('cart-item-data');
		let cartItemList_obj = JSON.parse(cartItemList); // json to array obj
		$('.cart-count').text(cartItemList_obj.length);
	}
	function initializeLocalStorage() {
		let cartItemList = localStorage.getItem('cart-item-data');
		if(! cartItemList) {
			cartItemList = [];
			localStorage.setItem('cart-item-data', JSON.stringify(cartItemList) )
		}
		
		// {"id" : 1, "name" : product1},
		// {"id" : 2, "name": proudct2}
		// prouctObj = { id: 1, name: proudct2} => {"id" : 1, "name" : product1},
	}
});