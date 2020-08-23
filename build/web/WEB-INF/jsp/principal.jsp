<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html dir="ltr" lang="en">

    <%@include file="template/scripts_header.jsp" %>

    <body>


        <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">

            <%@include file="template/menu_superior.jsp" %>
            <%@include file="template/menu.jsp" %>


            <div class="page-wrapper">

                <div class="container-fluid">

                    ESTOY EN LA PANTALLA PRINCIPAL                    

                </div>
                <%@include file="template/footer.jsp" %>
            </div>

        </div>



        <%@include file="template/scripts_js.jsp" %>
    </body>

</html>