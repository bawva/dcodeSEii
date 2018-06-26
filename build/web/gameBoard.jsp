

<%@page import="controller.GameStatus"%>
<%@page import="m.JDBC"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="controller.getStockValues"%>
<%@page import="controller.ValueChangeAlgorithm"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SB Admin - Start Bootstrap Template</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <script type="text/javascript">
            var xmlHttp;
            function createRequest() {
                if (window.XMLHttpRequest) {
                    xmlHttp = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    xmlHttp = new ActiveXObject();
                } else {
                    alert("Please Update Your Browser!!!!");
                }
            }

            function loadProducts() {
                createRequest();
                var url = "getStocks";
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                        var s = xmlHttp.responseText;
                        document.getElementById("stockView").innerHTML = s;
                    }
                }
            }
            window.setInterval(loadProducts, 4000);
            loadProducts();


            function loadPrice(stock_id, s_name, name, price) {
                //alert(s_name);
                document.getElementById("s_name").innerHTML = s_name;
                document.getElementById("name").innerHTML = name;
                document.getElementById("price").innerHTML = price;
                document.getElementById("h_price").value = price;
                document.getElementById("h_stock").value = stock_id;
            }

            function setTotal() {
                var price = Number(document.getElementById("price").innerHTML);
                var qty = Number(document.getElementById("qty").value);
                var total = price * qty;
                document.getElementById("total").innerHTML = total;
            }

        </script>
    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <%
            String s = request.getSession().getAttribute("un").toString();
        %>
        <!-- Navigation-->
        <%@include file="navbar.jsp" %>
        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>
                <!-- Icon Cards-->

                <!-- Area Chart Example-->
                <div id="stockView">

                </div>

                <!-- Example DataTables Card-->

            </div>
            <!-- /.container-fluid-->
            <!-- /.content-wrapper-->
            <footer class="sticky-footer">
                <div class="container">
                    <div class="text-center">
                        <small>Copyright © Your Website 2018</small>
                    </div>
                </div>
            </footer>
            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fa fa-angle-up"></i>
            </a>
            <!-- Logout Modal-->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="trade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Broker</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <form action="purchase" method="POST">
                            <div class="modal-body">
                                <label id="s_name"></label><br>
                                <label id="name"></label><br>
                                <input type="hidden" id="h_stock" name="stock_id">
                                <label id="price"></label><br>
                                <input type="hidden" id="h_price" name="price">
                                <label id="name"></label><br>
                                <input type="hidden" name="tradeType" value="1">
                                <input id="qty" oninput="setTotal();" name="qty" type="number" class="form-control-sm"><br>
                                <label id="total">0</label><br>
                                <button class="btn btn-outline-info" type="submit">Proceed</button>
                            </div>
                        </form>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
            <!-- Page level plugin JavaScript-->
            <script src="vendor/chart.js/Chart.min.js"></script>
            <script src="vendor/datatables/jquery.dataTables.js"></script>
            <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin.min.js"></script>
            <!-- Custom scripts for this page-->
            <script src="js/sb-admin-datatables.min.js"></script>
            <script src="js/sb-admin-charts.min.js"></script>
            <script>
            function loadPrice() {
                createRequest();
                var url = "updateBalance";
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                        var s = xmlHttp.responseText;
                        document.getElementById("bank_amount").innerHTML = s;
                    }
                }
                window.setInterval(loadPrice, 1000);
            }
            loadPrice();
            </script>
        </div>
    </body>

</html>

