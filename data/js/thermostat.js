/* 
    Created on : Jun 22, 2014
    Author     : Jeff Bean
*/


/**
 * I don't use this. I just put in here to show that I am familiar with Ajax. But
 * since the spec sheet said data persistence was not required I didn't see a need 
 * to update the server.
 */
$.ajaxSetup({
	url: "/thermostat/control",
	type: "POST",
	dataType: "JSON"
});

/**
 * Turns the A/C on and furnace off.
 */
function turnACOn()
{
	$('.onOffControls button').removeClass("selected");
	$('#cool').addClass("selected");
}

/**
 * Turns the furnace on and A/C off.
 */
function turnFurnaceOn()
{
	$('.onOffControls button').removeClass("selected");
	$('#heat').addClass("selected");
}

/**
 * Turns both A/C and furnace off.
 */
function turnOff()
{
	$('.onOffControls button').removeClass("selected");
	$('#off').addClass("selected");
}

/**
 * Increases temperature for the A/C or furnace. Whichever is currently on. This
 * function also validates that the temperature does not go too high.
 */
function increaseTemp()
{
	var temp = parseInt($('#currentTemp').val());
				
	if (temp < 85)
	{
		temp += 1;
		$('#currentTemp').val(temp);
		$('#tempDisplay').text(temp);
	}
	else
	{
		$('#currentTemp').val("86");
		$('#tempDisplay').text("Hi");
	}
}

/**
 * Decreases temperature for the A/C or furnace. Whichever is currently on. This
 * function also validates that the temperature does not go too low.
 */
function decreaseTemp()
{
	var temp = parseInt($('#currentTemp').val());
				
	if (temp > 65)
	{
		temp -= 1;
		$('#currentTemp').val(temp);
		$('#tempDisplay').text(temp);
	}
	else
	{
		$('#currentTemp').val("64");
		$('#tempDisplay').text("Lo");
	}
}
