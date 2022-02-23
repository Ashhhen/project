function validate() {
    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var password2 = document.getElementById("password2").value;

    var nameSurnamePattern = /[A-Z][a-z]+/;
    var loginPassPattern = /.{2}.*/

    if(!nameSurnamePattern.test(name)) {
        return false;
    }

    if(!nameSurnamePattern.test(surname)) {
        return false;
    }

    if(!loginPassPattern.test(login)) {
        return false;
    }

    if(!loginPassPattern.test(password)) {
        return false;
    }

    if(password != password2) {
        return false;
    }

    return true;
}