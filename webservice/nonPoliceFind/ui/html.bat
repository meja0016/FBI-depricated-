<!-- :: Batch section
@echo of
setlocal
echo Select an option:
for /F "delims=" %%a in ('mshta.exe "%~F0"') do set "HTAreply=%%a"
echo End of HTA window, reply: "%HTAreply%"
goto :EOF
-->

<HTML>
<HEAD>
<HTA:APPLICATION  ICON="lib/police.ico" SCROLL="no" SYSMENU="no" MAXIMIZEBUTTON="no" border="thin" showInTaskbar="yes" innerBorder="no" reseize="no" scroll="no" singleInstance="yes" selection="no" version="1.0">

<TITLE>nonPolicePayments</TITLE>
<SCRIPT language="JavaScript">
window.resizeTo(250,350);
function closeHTA(reply){
   var fso = new ActiveXObject("Scripting.FileSystemObject");
   fso.GetStandardStream(1).WriteLine(reply);
   window.close();
}
</SCRIPT>

</HEAD>
<BODY style="margin: 0px"><div style='background-color:black'>&nbsp;<font color=white>FBI</font></div>
> Partner</h2><br>
<table>
<tr><td>ID</td><td><input type=text id></input></td></tr>
<tr><td>Card Number</td><td><input type=text id></input></td></tr>
<tr><td>Expire Date</td><td><input type=text id></input></td></tr>
<tr><td>Amount</td><td><input type=text id></input></td></tr>
<td></tr>
</table>
<br>
   <button onclick="closeHTA(1);">Close</button>
     <input type="button" value="Run Script" name="run_button"  onClick="TestSub">
<button onclick="RunProgram">nonPoliceReport</button> <p>
</BODY>
</HTML>