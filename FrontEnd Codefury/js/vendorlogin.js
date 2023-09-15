//vendor login page

//validation of vendor login
function vcheck(event){
    event.preventDefault();
var data ={"Username":"john", "Password":"john123"};

var Username =document.getElementById("vname").value;

var Password =document.getElementById("vpassword").value;

//check the value of name is empty or not
if(Username==''){
    document.getElementById("name-msg").innerHTML="Please enter the User Name";
    document.getElementById("password-msg").innerHTML="";
    return false;
}
//check the value of password is empty or not
if(Password==''){
    document.getElementById("password-msg").innerHTML="Please enter the Password";
    document.getElementById("name-msg").innerHTML="";
    return false;
}

if (Username === data.Username && Password === data.Password)

{

window.location.replace("vendorhome.html");
return false;

}

else

{

window.location.replace("vendorlogin.html");

return false;
}
}
