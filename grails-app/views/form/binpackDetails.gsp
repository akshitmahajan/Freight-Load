<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Freight Details</title>
</head>
<body>
<br>
<div style="align: center;">
    <h2 style="color: #333333;">Freight Load Optimizer</h2>

<br>
<!-- <g:submitButton name="addTruck" value="" /> --> 
<g:actionSubmit value="Add Truck" onclick="addTruckRow()" />
<g:form action="pack">

<table id="table_truckDetails">
    <thead>
        <tr><th>No of Trucks</th>
            <th>Capacity of Trucks</th>
        </tr>
    </thead>
            <tr>
                    <td><input type="text" id="truck_count" name="truck_count" required="required" value="0" /></td>
                    <td><input type="text" id="truck_capacity" name="truck_capacity" required="required" value="0" /></td>
            </tr>
</table>
    
<table id="table_freightDetails">
    <thead>
        <tr>
            <th>No of Freights</th>
            <th>Weight of Freight</th>
        </tr>
    </thead>
            <tr>
                    <td><input type="text" id="freight_count" name="freight_count" required="required" value="0" /></td>
                    <td><input type="text" id="freight_weight" name="freight_weight" required="required" value="0" /></td>
            </tr>
</table>
    <g:submitButton name="create" value="LOAD" />&nbsp;&nbsp;
     
</g:form>

<g:actionSubmit value="Add Freight" onclick="addFreightRow()" />
</div>


<script>
function addTruckRow()
{
var table = document.getElementById("table_truckDetails");
var rowCount = table.rows.length;
var row = table.insertRow(rowCount);

var cell1 = row.insertCell(0);
			var element0 = document.createElement("input");
			element0.type = "text";
			element0.name = "truck_capacity";
                        /*for(var i=10; i>0;i--){
                            var d = document.getElementById("truck_capacity_row"+i);
                            var k;
                            try{
                                k = d.id;
                            }catch(ex){
                                element0.id = "truck_capacity_row"+i;
                            }
                        }*/
                        
			cell1.appendChild(element0);

                        var cell2 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "text";
			element1.name = "truck_count";
                        
                        /*for(var i=10; i>0;i--){
                            var d = document.getElementById("truck_count_row"+i);
                            var k;
                            try{
                                k = d.id;
                            }catch(ex){
                                element1.id = "truck_count_row"+i;
                            }
                        }*/
			cell2.appendChild(element1);
}

function addFreightRow()
{
var table = document.getElementById("table_freightDetails");
var rowCount = table.rows.length;
var row = table.insertRow(rowCount);

var cell1 = row.insertCell(0);
			var element0 = document.createElement("input");
			element0.type = "text";
			element0.name = "freight_weight";
                        /*for(var i=10; i>0;i--){
                            var d = document.getElementById("freight_weight_row"+i);
                            var k;
                            try{
                                k = d.id;
                            }catch(ex){
                                element0.id = "freight_weight_row"+i;
                            }
                        }*/
                        
			cell1.appendChild(element0);

                        var cell2 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "text";
			element1.name = "freight_count";
                        
                        /*for(var i=10; i>0;i--){
                            var d = document.getElementById("freight_count_row"+i);
                            var k;
                            try{
                                k = d.id;
                            }catch(ex){
                                element1.id = "freight_count_row"+i;
                            }
                        }*/
			cell2.appendChild(element1);
}
</script>

<br><br>
<h3 style="color: #333333;">${result_title}</h3>
<br>
<div>
<!-- Hard Score: ${hardscore}<br/>
Soft Score: ${softscore}<br/> -->
${result}<br/>
</div>


</body>
</html>