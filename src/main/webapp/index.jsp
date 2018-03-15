<html>
<body>
<h2>Hello World!</h2>
<a test()>lianjie</a>
<script type="text/javascript">


    $.ajax({
        type: "POST",
        url: "some.php",
        data: "name=John&location=Boston",
        success: function(msg){
            alert( "Data Saved: " + msg );
        }
    });

</script>

</body>
</html>
