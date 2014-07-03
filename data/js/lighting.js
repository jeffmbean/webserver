/* 
    Created on : Jun 22, 2014
    Author     : Jeff Bean
*/

/**
 * This function gets the id from the provided zone and checks if it has the
 * 'on' class. If it does then the zones lights are turned off. If it does not, 
 * then the class is added and the zones lights are turned on.
 * @param element
 */
function turnOnOff(zone)
{
	var id = zone.id;
	
	if ($('#'+ id).hasClass("on"))
	{
		$('#'+ id).attr("src", "images/light_off.png");
		$('#'+ id).removeClass("on");
	}
	else
	{
		$('#'+ id).attr("src", "images/light.png");
		$('#'+ id).addClass("on");
	}
}
