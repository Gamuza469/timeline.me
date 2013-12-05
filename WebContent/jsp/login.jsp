<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Timeline.me</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/demo.css'/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/animate-custom.css'/>" />
		<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery.validate.1.5.2.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/messages_es.js'/>"></script>
    	<script>
	$(document).ready(function(){
	$("#signin").validate();
							  });
		</script>
		<script>
	$(document).ready(function(){
	$("#signin").validate();
							  });
		</script>
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
            <header>
                <h1>BIENVENIDO A <span>TIMELINE.ME</span></h1>
				<nav class="codrops-demos">
					<span>Ingrese al sistema mediante el siguiente login</span>
				</nav>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form id="signin" action="login.do" autocomplete="on" method="POST"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <div class="error"></div>
                                    <label for="username" class="uname" data-icon="u" >email o username </label>
                                    <input id="username" name="username" class="required" type="text" placeholder="ej.: myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                	<div class="error"></div>
                                    <label for="password" class="youpasswd" data-icon="p">password </label>
                                    <input id="password" name="password" class="required" required="required" type="password" placeholder="ej.: X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">recordar mi sesion</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Agente no registrado?
									<a href="#toregister" class="to_register">únase a nosotros</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  id="signup" action="mysuperscript.php" autocomplete="on" method="post"> 
                                <h1> Sign up </h1> 
                                <p>
                                	<div class="error"></div> 
                                    <label for="usernamesignup" class="uname" data-icon="u">usuario</label>
                                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="ej.: mysuperusername690" />
                                </p>
                                <p> 
                                    <div class="error"></div>
                                    <label for="emailsignup" class="youmail" data-icon="e" >email</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="ej: mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                	<div class="error"></div>
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">password</label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="ej.: X8df!90EO"/>
                                </p>
                                <p> 
                                	<div class="error"></div>
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">confirme password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="ej.: X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Agente registrado?
									<a href="#tologin" class="to_register">Log in</a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>