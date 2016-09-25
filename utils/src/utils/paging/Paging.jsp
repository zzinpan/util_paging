<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="pagination">
		  
	<!-- <<, < -->
	<c:if test="${paging.firstPageNo != paging.pageNo}">
	  <li class="">
	  	<a href="/pr/NoticeAction.do?method=list&menu=1&page=${paging.firstPageNo}" aria-label="Previous">
	  		<span aria-hidden="true">&laquo;&laquo;</span>
	  	</a>
	  </li>
	  <li class="">
	  	<c:choose>
	  		<c:when test="${paging.startPageNo-1 == 0}">
	  			<a href="/pr/NoticeAction.do?method=list&menu=1&page=1" aria-label="Previous">
	    		<span aria-hidden="true">&laquo;</span>
	    	</a>
	  		</c:when>
	  		<c:otherwise>
	    	<a href="/pr/NoticeAction.do?method=list&menu=1&page=${paging.startPageNo-1}" aria-label="Previous">
	    		<span aria-hidden="true">&laquo;</span>
	    	</a>
	  		</c:otherwise>
	  	</c:choose>
	 	</li>
	 </c:if>
	<!-- //<<, < -->
	
	<!-- 번호 -->
	<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
	        <c:choose>
	            <c:when test="${i eq paging.pageNo}">
	            	<li class="active"><a href="/pr/NoticeAction.do?method=list&menu=1&page=${i}">${i}<span class="sr-only">(current)</span></a></li>
	            </c:when>
	            <c:otherwise>
	            	<li class=""><a href="/pr/NoticeAction.do?method=list&menu=1&page=${i}">${i}<span class="sr-only">(current)</span></a></li>
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	 <!-- //번호 -->
	 
	 <!-- >, >> -->
	 <c:if test="${paging.finalPageNo != paging.pageNo}">
		<li class="">
	  	<c:choose>
	  		<c:when test="${paging.endPageNo+1 > paging.finalPageNo}">
		    	<a href="/pr/NoticeAction.do?method=list&menu=1&page=${paging.endPageNo}" aria-label="Previous">
		    		<span aria-hidden="true">&raquo;</span>
		    	</a>
	  		</c:when>
	  		<c:otherwise>
		    	<a href="/pr/NoticeAction.do?method=list&menu=1&page=${paging.endPageNo+1}" aria-label="Previous">
		    		<span aria-hidden="true">&raquo;</span>
		    	</a>
	  		</c:otherwise>
	  	</c:choose>
	  </li>
	  <li class="">
	  	<a href="/pr/NoticeAction.do?method=list&menu=1&page=${paging.finalPageNo}" aria-label="Previous">
	  		<span aria-hidden="true">&raquo;&raquo;</span>
	  	</a>
	 	</li>
	 </c:if>
	 <!-- //>, >> -->
	  				   
</ul>