/* 
    Created on : Jun 22, 2014
    Author     : Jeff Bean
*/

/**
 * This function gets the id from the provided zone and checks if it has the
 * 'secure' class. If it does then the zone is unlocked. If it does not, then the
 * class is added and the zone is locked.
 * @param element
 */
function toggleSecurity(zone)
{
	var id = zone.id;
	
	if ($('#'+ id).hasClass("secure"))
	{
		$('#'+ id).attr("src", "images/unlocked.png");
		$('#'+ id).removeClass("secure");
	}
	else
	{
		$('#'+ id).attr("src", "images/locked.png");
		$('#'+ id).addClass("secure");
	}
}
