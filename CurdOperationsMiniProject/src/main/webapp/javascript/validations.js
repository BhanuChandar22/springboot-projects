function validate()
{
	let isValid = true;
	ename = document.getElementById("name").value;
	hiredate = document.getElementById("hiredate").value;
	salary = document.getElementById("salary").value;
	
	nameError.innerText = ""
	hiredateError.innerText = ""
	salaryError.innerText = ""
	
	nameError = document.getElementById("nameError")
	hiredateError = document.getElementById("hiredateError")
	salaryError = document.getElementById("salaryError")
	if(ename == "")
	{
		nameError.innerText = "name field required"
		isValid = false;
	}
	else if(ename.length < 4 || ename.length > 15)
	{
		nameError.innerText = "name should have min 5char's and max 14 char's"
		isValid = false;
	}
	
	if(hiredate == "")
	{
		hiredateError.innerText = "please select hiredate"
		isValid = false;
	}
	if(salary == ""){
		salaryError.innerText = "salary field required";
		isValid = false;
	}
	else if(isNaN(salary))
	{
		salaryError.innerText = "this field allows only number type value"
		isValid = false;
	}
	else if(salary < 20000.0 || salary > 140000.0){
		salaryError.innerText = "salary range must b/w 20000.0 to 140000.0";
	}
	
	return isValid;
}