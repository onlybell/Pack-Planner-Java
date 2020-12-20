<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Pack Planner</title>
    <link rel="stylesheet" href="resources/style.css"/>

</head>
<body>  
    <div class="container">
        <form id="frm" name="frm" method="post" action="/PackCheck">
            <table class="board_detail" border="1">
                <tr>
                	<td width="10%">Sort Order:</td>
                	<td width="18%">${sortOrder}</td>
                	<td width="17%">Max Pieces per Pack:</td>
                	<td width="20%">${maxPieces}</td>
                	<td width="17%">Max weight per Pack:</td>
                    <td>${maxWeight}</td>
                </tr>
                <tr>
                	<td colspan="3">
	                	#Input format:<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						...<br>
                	</td>
                    <td colspan="3"><textarea id="items" name="items" readonly>${items}</textarea></td>
                </tr>
                <tr>
                	<td colspan="3">
	                	#Output format:<br>
						Pack number: [pack number]<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						[item id],[item length],[item quantity],[piece weight]<br>
						...<br>
						Pack Length: [pack length], Pack Weight: [pack weight]
                	</td>
                    <td colspan="3">
                       ${Package}
                    </td>
                </tr>
            </table>
            <input type="button" value="Back" class="btn" onclick="javascript:history.back();">
        </form>
    </div>
</body>
</html>
