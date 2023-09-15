//validation of user login using json object
function check(event){
    event.preventDefault();
var data ={
        "Username":"john", 
        "Password":"john123", 
        "UserId":"101", 
        "FullName": "John Doe", 
        "DOJ":"2023-05-07",
        "DOB":"1996-06-02", 
        "Department":"IT",
        "Mobile": "9485736253",
        "Email":"john@gmail.com",
        "Location": "D-303, B-wing, Phoenix Appartment, 150 ft. Ring Road, Pune", 
        "Status":"active"
    };

var Username =document.getElementById("name").value;

var Password =document.getElementById("password").value;

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

window.location.replace("userhome.html");
return false;

}

else

{

window.location.replace("userlogin.html");

return false;
}
}


//view profile page

//fetching data from json file and displaying in the form
function view(){
    fetch('../js/user.json')
    .then(res=>res.json())
    .then(data=>{

    document.getElementById("userid").value=data.users[0].UserId;
    document.getElementById("name").value=data.users[0].FullName;
    document.getElementById("username").value=data.users[0].Username;
    document.getElementById("password").value=data.users[0].Password;
    // document.getElementById("doj").value=data.users[0].DOJ;
    document.getElementById("dob").value=data.users[0].DOB;
    // document.getElementById("department").value=data.users[0].Department;
    document.getElementById("mobile").value=data.users[0].Mobile;
    document.getElementById("email").value=data.users[0].Email;
    document.getElementById("address").value=data.users[0].Location;
    document.getElementById(data.users[0].Status).checked;
});
}

//edit mobile, email, address of user 
function changeData(){
    fetch('../projectjs/user.json')
    .then(res=>res.json())
    .then(data=>{
      data.users[0].Mobile=document.getElementById("mobile").value;
      data.users[0].Email=document.getElementById("email").value;
      data.users[0].Location=document.getElementById("address").value;
      alert("Data is saved");
      window.location.replace("viewprofile.html");
  
    });
  }