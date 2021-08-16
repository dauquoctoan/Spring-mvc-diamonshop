<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>Sản - phẩm</title>
<style>
.pagination {
	  display: flex;
    	justify-content: center;
	}
	.pagination a {
	  color: black;
	  float: left;
	  padding: 8px 16px;
	  text-decoration: none;
	  transition: background-color .3s;
	  border: 1px solid #ddd;
	}
	.pagination a.active {
	  background-color: #4CAF50;
	  color: white;
	  border: 1px solid #4CAF50;
	}
	.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<body>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>
		<c:if test="${product.size()>0}">
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach var="item" items="${product}" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="<c:url value="/product-detail/${item.id_product}"/>"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="<c:url value="/product-detail/${item.id_product}"/>"><img
									src="<c:url value="/assets/user/img/${item.img}"/>" alt=""></a>
								<div class="caption cntr">
									<p>${item.name }</p>
									<p>
										<strong><fmt:formatNumber type="number"
												maxFractionDigits="3" value="${item.price}" /> VND</strong>
									</p>
									<h4>
										<a class="shopBtn" href="#" title="add to cart"> Thêm vào giỏ hàng </a>
									</h4>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if
							test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == product.size()}">
				</ul>
			</div>
			<c:if test="${(loop.index + 1) < product.size()}"></c:if>
			<div class="row-fluid">
				<ul class="thumbnails">
		</c:if>
		</c:forEach>
		</c:if>

	</div>
	
<div class="pagination">
<c:forEach var="item" begin="1" end="${paginateInfor.totalPage}" varStatus="loop">
  <c:if test="${loop.index == paginateInfor.currentPage}">
  	<a href="#" class="active">${loop.index}</a>
  </c:if>
  <c:if test="${loop.index != paginateInfor.currentPage}">
  	<a href='<c:url value="/san-pham/${id}/${loop.index}"/>'>${loop.index}</a>
  </c:if>
</c:forEach>
</div>
</body>