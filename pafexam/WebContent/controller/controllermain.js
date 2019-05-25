$(document).on("click","#add", function()
{
	var result = isValidFormadd();//use client-Model
	if(result=="true")
	{	$("#formItems").submit();	}
	else
	{	$("#divStsMsgItem").html(result);	}
});