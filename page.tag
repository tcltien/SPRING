<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="script" fragment="true" required="false"%>
<%@attribute name="stylesheet" fragment="true" required="false"%>
<%@attribute name="title"%>
<html>
<head>
    <meta charset="utf-8">
    <c:if test="${ not empty title }">
        <title>${ title }</title>
    </c:if>
    <c:if test="${ empty title }">
        <title>SDS</title>
    </c:if>
    <meta name="description" content="">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="width=860, minimal-ui, initial-scale=1, user-scalable=no">
    <meta http-equiv="cleartype" content="on">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/img/touch/apple-touch-icon-144x144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/img/touch/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/img/touch/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/img/touch/apple-touch-icon-57x57-precomposed.png">
    <link rel="shortcut icon" sizes="196x196" href="${pageContext.request.contextPath}/img/touch/touch-icon-196x196.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/touch/apple-touch-icon.png">
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/img/touch/apple-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#222222">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/materialdesignicons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slick-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stacktable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.7.1.min.js"></script>
    <jsp:invoke fragment="stylesheet" />
</head>
<body>
    <!-- TODO : Add header here -->	
    <div class="main-container">
    	<%@ include file="../pages/includes/header.jsp" %> 	
        <jsp:doBody />
    </div>
</body>

<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
    
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/stacktable.js"></script>
    <script src="${pageContext.request.contextPath}/js/helper.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    
    <jsp:invoke fragment="script" />
</body>
</html>