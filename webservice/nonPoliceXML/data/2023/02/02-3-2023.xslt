<?xml version="1.0" encoding="UTF-8"?>
<!-- https://www.w3schools.com/xml/tryxslt.asp?xmlfile=cdcatalog&xsltfile=cdcatalog -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<script>
	function nonPoliceVocabulary(){
	    alert("nonPoliceVocabulary")
            var words = str.split("nonPoliceHello nonPoliceWorld");
            var arr = ["soviet uninon", "governent", "defense", "Mikhail Gorbchev", "Grobechev", "Former Presdent Gorbachev"];
             alert(words[0]);
	}
</script> 
<body>
  <h2>nonPoliceWebService</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">nonPoliceConvert</th>
      <th style="text-align:left">nonPoliceDescription</th>
      <th style="text-align:left">nonPoliceDescription</th>
    </tr>
    <xsl:for-each select="nonPoliceWebService/nonPoliceOperation">
    <tr>
<td><button onClick=" nonPoliceVocabulary()">nonPolcietest</button></td>
      <td><xsl:value-of select="nonPoliceOperationTitle"/></td>
      <td><xsl:value-of select="nonPoliceOperationDescription"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>