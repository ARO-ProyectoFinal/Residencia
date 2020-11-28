$(document).ready(function() {

if ($("body").find(".accountManagementPanel").length > 0){
	//Verifica si se encuentra en la pagina de Login

   // $(this).attr("title", "ARO RESIDENCIA");
    //Esto cambia el titulo de la pagina

    $('body').css('background-color', '#426ab2');
    $('body').css('background-image', 'url("/images/Fondo.jpg")');
    $('body').css('color', '#ffffff');
    $('body').css('position', 'relative');
    $('body').css('height', 'calc(100vh)');
    $('body').css('background-size', 'cover');
    $('body').css('background-repeat', 'no-repeat');
    $('body').css('background-position', 'center center');
    //Esto aplica color de letra, color de fondo e imagen de fondo

    $('h4').css('margin-top', '-20px');
    //Esto ajusta un poco mas arriba el titulo Iniciar Sesion

    $("form:not(.filter) :input:visible:enabled").eq(0).attr("placeholder", "Ingrese nombre de usuario");
    $("form:not(.filter) :input:visible:enabled").eq(1).attr("placeholder", "Ingrese contraseña");
    //Esto cambia el placeholder que no se pudo traducir

    //$("form:not(.filter) :input:visible:enabled").eq(0).attr("value", "admin");
    //$("form:not(.filter) :input:visible:enabled").eq(1).attr("value", "admin");
    //$("button.btn[type=submit]").click();
    //Esto sirve para autocompletar los campos del Login y apreta Ingresar automaticamente

    $("img[src$='/images/aroLogo.png']").wrap("<a href='/'> </a>");
    //Esto aplica un HREF a la imagen del logo

    $("button.btn[type=submit]").removeClass("btn-primary").addClass("btn-info");
    //Esto cambia el css del boton Ingresar para que sea del color deseado

    $("button.btn[type=reset]").hide();
    //Esto oculta el boton blanquear del formulario

	}else{
    $('body').css('background-color', 'white');
    $('body').css('background-image', 'url("/images/FondoAzul.png")');
    $('body').css('background-repeat', 'repeat-y');
    $('body').css('color', 'black');
    $('body').css('position', 'relative');
    $('body').css('height', 'calc(100vh)');
    $('body').css('background-size', 'cover');
    $('body').css('background-position', 'center center');
	} //end IF Pagina Login


});