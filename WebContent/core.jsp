<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="service.LivrePOJO"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="/WEB-INF/jstl/c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eCom une nouvelle façon de lire</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/panier.js"></script>
</head>
<body>
<header>
<img class="logoGauche" alt="" src="images/eComOrange.png"/>
<img class="logoDroit" alt="" src="images/eComOrange.png"/><p>eCom la CENTRALE de livres informatique</p>
</header>
<nav><ul>
<li><a href="/Ecom">ACCUEIL</a></li>
<li><a href="system">SYSTEME</a></li>
<li><a href="languages">LANGAGES</a></li>
<li><a href="db">BASE DE DONNEES</a></li>
<li><a href="network">ADMINISTRATION</a></li>
</ul></nav>
	<div class="caddie">
	<section>
		<article>
			
			<table>
				<c:forEach var="livre" items="${model}">
				</c:forEach>
				<tr>
					<th class="id">ID</th>
					<th>Image</th>
					<th>Nom</th>
					<th class="description">Description</th>
					<th class="prix">Prix</th>
					<th>Quantit&eacute;</th>
					<th>Ajouter au panier</th>
				</tr>
				<c:forEach var="livre" items="${model}">
				<form action="add" method="post" name="add">
					<tr>
						<td class="id">${livre.getCle()}</td>
						<td><img alt="" src="images/${livre.getLivre().getImage()}"></td>
						<td>${livre.getLivre().getNom()}</td>
						<td class="description">${livre.getLivre().getDescription()}</td>
						<td class="prix">${livre.getLivre().getPrix()}&euro;</td>
						<td><input type="number" name="nombre" value="1" min="1" max="${livre.getLivre().getQte()}"></td>
						<td style="display: none"><input name="idLivre" value="${livre.getCle()}"/></td>
						<td><input class="addcart" type="submit" value=""/></td>
					</tr>
				</form>
				</c:forEach>
			</table>
		</article>
		<aside>
			<table id="panier" style="visibility:block;">
				<tr>
					<th colspan="4">Votre panier</th>
				</tr>
				<tr>
					<th colspan="2">Sous total</th>
					<td colspan="2">0&euro;</td>
				</tr>
				<tr>				
					<th colspan="2">Livraison</th>
					<td colspan="2">0&euro;</td>
				</tr>
				<tr>
					<th colspan="2">Total</th>
					<td colspan="2">0&euro;</td>
				</tr>				
			</table>
			<p class="bnt">
			<input type="button" onclick="visuPanier();" value="Ouvrir le panier">
			</p>
		</aside>
	</section>
		</div>
<p id="footer">Copyright 2016 - La boutique du programmeur</p>
</body>
</html>