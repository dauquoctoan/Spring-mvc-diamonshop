<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
<title>Chi tiết-sản phẩm</title>
<style>
.product-content{
	overflow-x:hidden;
}
</style>
</head>
<body>
<!-- 
Body Section 
-->
<p>${Cart.size()}</p>
	<div class="row product-content">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
				<c:forEach var="item" items="${categorys}">
					<li><a href="<c:url value="/san-pham/${item.id}"/>"><span
							class="icon-chevron-right"></span>${item.name}</a></li>
				</c:forEach>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="<c:url value="/assets/user/img/paypal.jpg"/>" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="Thêm vào giỏ hàng"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="<c:url value="/assets/user/img/bootstrap-template.png"/>" alt="bootstrap ecommerce templates">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<img src="<c:url value="/assets/user/img/bootstrap-template.png"/>" alt="shopping cart template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="<c:url value="/assets/user/img/bootstrap-template.png"/>" alt="bootstrap template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
		  </ul>

	</div>
	<div class="span9">
    <ul class="breadcrumb">
    <li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
    <li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
    <li class="active">Chi tiết sản phẩm</li>
    </ul>
    
   
    <div class="well well-small">
	<div class="row-fluid">
			<div class="span5">
			<div id="myCarousel" class="carousel slide cntr">
                <div class="carousel-inner">
                  <div class="item active">
                   <a href="#"> <img src="<c:url value="/assets/user/img/${product.img}"/>" alt="" style="width:100%"></a>
                  </div>
                </div>
            </div>
			</div>
			<div class="span7">
				<h3>${product.name}</h3>
				<hr class="soft"/>
				
				<div class="control-group">
					<label class="control-label"><span>Giá:<fmt:formatNumber type = "number" 
         				maxFractionDigits = "3" value = "${product.price}" /> VND	</span></label>
				  </div>
				
				<form class="form-horizontal qtyFrm" action="<c:url value="/AddCart/${product.id_product}"/>" method="get">
				  <div class="control-group">
					<label class="control-label"><span>Số lượng:</span></label>
					<div class="controls">
					<input type="number" min="0" class="span6" placeholder="0">
					</div>
				  </div>
				   
				
				  <div class="control-group">
					<label class="control-label"><span>màu sắc:</span></label>
					<div class="controls">
					  <select class="span11">
						  <option>Red</option>
						  <option>Purple</option>
						  <option>Pink</option>
						  <option>Red</option>
						</select>
					</div>
				  </div>
				  <div class="control-group">
				  </div>
				  <p>${product.title}<p>
				  <button  type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span> Thêm vào giỏ hàng</button>
				</form>
			</div>
			</div>
				<hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
              <li class=""><a href="#profile" data-toggle="tab">Sản phẩm tương tự</a></li>
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
            <div class="tab-pane fade active in" id="home">
			  <h4>Thông tin sản phẩm</h4>
                <table class="table table-striped">
				</table>
				<p>${product.details}</p>

			</div>
			<div class="tab-pane fade" id="profile">
			
			<c:forEach var="item" items="${products}">
			<div class="row-fluid">	  
			<div class="span2">
				<img src="<c:url value="/assets/user/img/${item.img}"/>" alt="">
			</div>
			<div class="span6">
				<h5>${item.name }</h5>
				<p>
				${item.title }
				</p>
			</div>
			<div class="span4 alignR">
			<form class="form-horizontal qtyFrm">
			<h3><fmt:formatNumber type = "number" 
         				maxFractionDigits = "3" value = "${product.price}" /> VND</h3>
			<div class="btn-group">
			  <a href="product_details.html" class="defaultBtn"><span class=" icon-shopping-cart"></span>Thêm vào giỏ hàng</a>
			  <a href="product_details.html" class="shopBtn">Xem</a>
			 </div>
				</form>
			</div>
		     </div>
			</c:forEach>
			
		
			</div>
			</div>

</div>
  
	
</div>
</div>
</body>