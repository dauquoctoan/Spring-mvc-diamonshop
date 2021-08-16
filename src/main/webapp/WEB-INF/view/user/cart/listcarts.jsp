<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
<title>Giỏ-hàng</title>
</head>
<body>

<!-- 
Body Section 
-->
	<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Giỏ Hàng</li>
    </ul>
	<div class="well well-small">
		<h1>Sản Phẩm<small class="pull-right"> ${TotalQuantyCart} Sản phẩm trong giỏ hàng</small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Hình ảnh</th>
                  <th>Mô tả</th>
				  <th>màu sắc</th>
                  <th>Giá bán</th>
                  <th>Số lượng</th>
                  <th>Xóa</th>
                  <th>Tổng Tiền</th>
				</tr>
              </thead>
              <tbody>
              <c:if test="${Cart!=null}">
               		<c:forEach var="item" items="${Cart}">
              		<tr>
                  <td><img width="100" src="<c:url value="/assets/user/img/${item.value.product.img}"/>"alt=""></td>
                  
                  <td>${item.value.product.title}</td>
                  
                  
                  <td><span class="shopBtn" style="background-color:${item.value.product.code_color}" ><span class="icon-ok"></span></span> </td>
                  
                  <td><fmt:formatNumber type = "number" 
         				maxFractionDigits = "3" value = "${item.value.product.price}" /> VND</td>
                  
                  <td>
					<input class="span1" style="max-width:34px" placeholder="1" id="quanty-cart-${item.key}" min="0" size="16" type="number" value="${item.value.quanty}">
				  <div class="input-append">
					<button data-id="${item.key}" class="btn btn-mini btn-danger edit-cart" type="button"><span class="icon-edit"></span></button>
				</div>
				</td>
				 <td>
				  <div class="input-append">
					<a href="<c:url value="/delete-cart/${item.key}"/>" class="btn btn-mini btn-danger" type="button"><span class="icon-remove"></span></a>
				</div>
				</td>
                  <td><fmt:formatNumber type = "number" 
         				maxFractionDigits = "3" value = "${item.value.totalPrice}" /> VND</td>
                </tr> 
              		</c:forEach>
              </c:if>
                
				</tbody>
            </table><br/>
    <a href="products.html" class="shopBtn btn-large"><span class="icon-arrow-left"></span>Tiếp tục mua sắm</a>
	<a href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Thanh toán <span class="icon-arrow-right"></span></a>
	
</div>
</div>
</div>
</body>