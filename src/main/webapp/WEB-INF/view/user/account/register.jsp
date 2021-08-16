<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<title>Đăng ký</title>
</head>
<body>
<div class="row">
	<div id="sidebar" class="span3">
		<div class="well well-small">
			<ul class="nav nav-list">
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Fashion</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Watches</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Fine Jewelry</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Fashion Jewelry</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Engagement & Wedding</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Men's Jewelry</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Vintage & Antique</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Loose Diamonds </a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>Loose Beads</a></li>
				<li><a href="products.html"><span
						class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
				<li style="border: 0">&nbsp;</li>
				<li><a class="totalInCart" href="cart.html"><strong>Total
							Amount <span class="badge badge-warning pull-right"
							style="line-height: 18px;">$448.42</span>
					</strong></a></li>
			</ul>
		</div>

		<div class="well well-small alert alert-warning cntr">
			<h2>50% Discount</h2>
			<p>
				only valid for online order. <br>
				<br>
				<a class="defaultBtn" href="#">Click here </a>
			</p>
		</div>
	</div>
	<div class="span9">
		<ul class="breadcrumb">
			<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
			<li class="active">Người dùng</li>
		</ul>
		<hr class="soft" />

		<div class="row">
			<div class="span4">
				<div class="well">
					<h5>Đăng ký tài khoản</h5>
					<br />
					<p>${status}</p>
					<form:form action="dang-ky" modelAttribute="users" accept-charset="utf-8">  
						<label>Email</label>
						<form:input class="span3" type="email" placeholder="Nhập vào email của bạn"  path="user"/>
						<label>Mật khẩu</label>
						<form:input class="span3" type="password" placeholder="Nhập vào password của bạn"  path="password"/>
						<label>Họ Tên</label>
						<form:input  class="span3" type="text" placeholder="Nhập vào tên của bạn"  path="display_name"/>
						<label>Địa chỉ</label>
						<form:input class="span3" type="text" placeholder="Nhập vào địa chỉ của bạn"  path="address"/>
						<button type="submit" class="defaultBtn">Đăng ký thành viên</button>
					</form:form>
				</div>
			</div>
			<div class="span1">&nbsp;</div>
			<div class="span4">
				<div class="well">
					<h5>Đăng nhập hệ thống</h5>
					<p>${loginStatus}</p>
					<form:form action="dang-nhap" modelAttribute="users">
						<div class="control-group">
							<label class="control-label" for="inputEmail">Tài khoản</label>
							<div class="controls">
								<form:input class="span3" type="text" placeholder="Email" path="user"/>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">Password</label>
							<div class="controls">
								<form:input type="password" class="span3" placeholder="Password" path="password"/>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="defaultBtn">Đăng nhập</button>
								<a href="#">Quên mật khẩu</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

	</div>
</div>
</body>