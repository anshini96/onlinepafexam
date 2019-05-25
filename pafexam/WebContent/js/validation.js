function isValidFormadd()
{
	if($.trim($("#customerid").val())=="")
	{	return "Enter customerid";	}
	
	if($.trim($("#totalprice").val())=="")
	{	return "Enter Totalprice";	}
	

	if($.trim($("#productname").val())=="")
	{	return "Enter ProductName";	}
	

	if($.trim($("#price").val())=="")
	{	return "Enter price";	}
	

	if($.trim($("#quantity").val())=="")
	{	return "Enter quantity";	}
	return "true";
}