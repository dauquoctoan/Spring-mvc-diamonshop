<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 
	Upper Header Section 
-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a href="#"><span class="icon-twitter"></span></a>
					<a href="#"><span class="icon-facebook"></span></a>
					<a href="#"><span class="icon-youtube"></span></a>
					<a href="#"><span class="icon-tumblr"></span></a>
				</div>
				<a class="active" href="<c:url value="/trang-chu"/>"> <span class="icon-home"></span> Home</a> 
				<a href="#"><span class="icon-user"></span><c:if test="${user != null}">-${user.display_name}</c:if></a> 
				<c:if test="${user == null}"><a href="<c:url value="/dang-ky"/>"><span class="icon-edit"></span> Đăng ký </a> </c:if>
				<c:if test="${user != null}"><a href="<c:url value="/dang-xuat"/>"><span class="icon-edit"></span> Đăng xuất </a> </c:if>
				<a href="contact.html"><span class="icon-envelope"></span> Contact us</a>
				<a href="<c:url value="/ToCart"/>"><span   class="icon-shopping-cart">  ${TotalQuantyCart} Item(s) -</span> <span id="quan-ty" class="badge badge-warning"> <fmt:formatNumber type = "number" 
         				maxFractionDigits = "3" value = "${TotalPriceCart}" /> đ</span></a>
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="<c:url value="/trang-chu"/>"><span>Twitter Bootstrap ecommerce template</span> 
		<img src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png"/>" alt="bootstrap sexy shop">
	</a>
	</h1>
	</div>
	<div class="span4">
	<div class="offerNoteWrapper">
	<h1 class="dotmark">
	<i class="icon-cut"></i>
	Twitter Bootstrap shopping cart HTML template is available @ $14
	</h1>
	</div>
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) :  0800 1234 678 </strong><br><br></p>
	<span id="ketqua" class="btn btn-mini">${TotalQuantyCart}</span>
	<span class="btn btn-warning btn-mini">$</span>
	<span class="btn btn-mini">&pound;</span>
	<span class="btn btn-mini">&euro;</span>
	</div>
</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
				<c:forEach var="item" items="${menus}" varStatus="index">
					<c:if test="${index.first}">
					<li class="active"><a href="<c:url value="${item.url}"/>">${item.name}</a></li>
					</c:if>
					<c:if test="${not index.first}">
					<li class=""><a href="<c:url value="${item.url}"/>">${item.name}</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<form action="#" class="navbar-search pull-left">
			  <input type="text" placeholder="Search" class="search-query span2">
			</form>
			<ul class="nav pull-right">
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="icon-lock"></span> Login <b class="caret"></b></a>
				<div class="dropdown-menu">
				<form class="form-horizontal loginFrm">
				  <div class="control-group">
					<input type="text" class="span2" id="inputEmail" placeholder="Email">
				  </div>
				  <div class="control-group">
					<input type="password" class="span2" id="inputPassword" placeholder="Password">
				  </div>
				  <div class="control-group">
					<label class="checkbox">
					<input type="checkbox"> Remember me
					</label>
					<button type="submit" class="shopBtn btn-block">Sign in</button>
				  </div>
				</form>
				</div>
			</li>
			</ul>
		  </div>
		</div>
	  </div>
	</div>