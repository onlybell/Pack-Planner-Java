<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Pack Planner</title>
    <link rel="stylesheet" href="resources/style.css"/>
    <script type="text/javascript">
     	function isDecimalKey(evt, elem) {
    	    var charCode = (evt.which) ? evt.which : evt.keyCode;
    	    if (charCode > 31 && (charCode != 46 && (charCode < 48 || charCode > 57)))
    	        return false;
    	    else {
    	        var dot = 0;
    	        for (var i = 0; i < elem.value.toString().length; i++) {
    	            if (elem.value.toString()[i] == 46)
    	                dot++;
    	        }
    	        if (charCode == 46 && dot == 1)
    	            return false;
    	    }
    	    return true;
    	}
 	</script>
</head>
<body>  
    <div class="container">
        <form id="frm" name="frm" method="post" action="/PackCheck">
            <table class="board_detail">
                <tr>
                	<td width="10%">Sort Order</td>
                	<td width="18%">
                		<select name="sortOrder" name="sortOrder">
                			<option value="NATURAL">NATURAL</option>
                			<option value="SHORT_TO_LONG">SHORT TO LONG</option>
                			<option value="LONG_TO_SHORT">LONG TO SHORT</option>
                		</select>
                	</td>
                	<td width="17%">Max Pieces per Pack</td>
                	<td width="20%"><input type="text" id="maxPieces" name="maxPieces" onkeypress="return isDecimalKey(event,this)" required/></td>
                	<td width="17%">Max weight per Pack</td>
                    <td><input type="text" id="maxWeight" name="maxWeight" onkeypress="return isDecimalKey(event,this)" required/></td>
                </tr>
                <tr>
                	<td colspan="3" style="text-align:top;">
	                	#Input format:<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						...<br>
                	</td>
                    <td colspan="3">
                        <textarea id="items" name="items"></textarea>
                    </td>
                </tr>
            </table>
            <input type="submit" id="submit" value="Submit" class="btn">
        </form>
    </div>
</body>
</html>
