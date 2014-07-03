/* 
    Created on : Jun 21, 2014
    Author     : Jeff Bean
*/

$(function(){
	loadCategory();
});

function loadCategory(page) 
{	
	var selectedPage = location.hash.substring(1);
	
	if (selectedPage === undefined || selectedPage === "")// Initial page load
	{
		// Show Thermostat as the default page
		selectedPage = "thermostat";
	}
	else if (page !== undefined)
	{
		selectedPage = page.id;
	}
	
	location.hash = selectedPage;
	
	$('#content').load(selectedPage +'.html');	
	$('#selected_page').val(selectedPage);
	$('.category').removeClass("selected");
	$('#'+ selectedPage).addClass("selected");
}

