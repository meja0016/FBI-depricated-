<?xml version="1.0" encoding="UTF-8"?>
<!-- https://www.w3schools.com/xml/tryxslt.asp?xmlfile=cdcatalog&xsltfile=cdcatalog -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<script>
	function nonPoliceVocabulary(){
            var map = {'ABCD': "soviet union,Mikhail Gorbachov",'a': "governent",'a': "governent"}
            var str= document.getElementById("id3").innerHTML;
            var arr = map[document.getElementById("id3").innerHTML].split(",");
            var str = (arr[Math.floor(Math.random() * arr.length)]);
            document.getElementById("id3").innerHTML = str;
	}
</script> 
<body>
  <h2>nonPoliceWebService</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">nonPoliceConvert</th>
      <th style="text-align:left">nonPoliceTite</th>
      <th style="text-align:left">nonPoliceDescription</th>
    </tr>
    <xsl:for-each select="nonPoliceWebService/nonPoliceOperation">
    <tr>
       <td ><button onClick=" nonPoliceVocabulary()">nonPolcietest</button></td>
       <td id="id2"><xsl:value-of select="nonPoliceOperationTitle"/></td>
       <td id="id3"><xsl:value-of select="nonPoliceOperationDescription"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
