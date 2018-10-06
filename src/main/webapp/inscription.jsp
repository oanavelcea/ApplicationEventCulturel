<%@page language="java" isELIgnored="false" isErrorPage="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<head>
<meta charset="UTF-8">

<title>Inscription</title>
</head>
<body>
	<h1>Inscription</h1>
<<<<<<< HEAD
	<form action="Inscription" method="post">
		<input type="text" id="firstName" name="firstName" value="" placeholder="Entrez votre prénom"/>
		<input type="text" id="lastName" name="lastName" value="" placeholder="Entrez votre nom"/>
	</form>
=======
	<div class="row col-lg-4 col-lg-offset-4">
>>>>>>> refs/remotes/origin/master

		<fieldset class="scheduler-border ">
			<legend class="scheduler-border">Remplissez tous les champs</legend>

			<form class="form-inline" action="Inscription" method="post">

				<div class="form-group">
					<label for="firstName">Prénom</label> <input class="form-control"
						type="text" id="firstName" name="firstName" value=""
						placeholder="Entrez votre prénom" />
				</div>

				<div class="form-group">
					<label for="lastName">Nom</label> <input class="form-control"
						type="text" id="lastName" name="lastName" value=""
						placeholder="Entrez votre nom" />
				</div>

				<div class="form-group">
					<label for="lastName">Nom</label> <input class="form-control"
						type="text" id="lastName" name="lastName" value=""
						placeholder="Entrez votre nom" />
				</div>

				<div class="row">
					<div class="radio">
						<label><input type="radio" name="sex" vlaue="H" checked>Homme</label>
					</div>
				

				<div class="radio">
					<label><input type="radio" name="sex" value="F">Femme</label>
				</div>
				

				<div class="form-group">
					<label for="adresse">Adresse</label> <input class="form-control"
						type="text" id="adresse" name="adress" value=""
						placeholder="Entrez votre nom" />
				</div>

				<div class="form-group">
					<label for="email">Adresse email :</label> <input type="email"
						class="form-control" id="email" name="email"
						placeholder="Entrez votre adresse email" />
				</div>

				<div class="form-group">
					<label for="pwd">Mot de passe :</label> <input type="password"
						class="form-control" id="pwd" name="password"
						placeholder="Mot de passe">
				</div>

				<div class="form-group">
					<label for="pwd">Password:</label> <input type="test"
						class="form-control" id="pwd">
				</div>

				<fieldset class="scheduler-border">
					<legend class="scheduler-border">Date de naissance</legend>
					<div class="form-group">
						<label for="sel1">Jour :</label> <select class="form-control"
							id="sel1">
							<c:forEach var="i" begin="1" end="31" step="1">
								<option>${i}</option>
							</c:forEach>

						</select>
					</div>
				</fieldset>
			</form>
		</fieldset>
	</div>


	<!--jQuery et Popper.js. Ce lien est toujours à placer avant celui de java-script-->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<!--java-script-->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>