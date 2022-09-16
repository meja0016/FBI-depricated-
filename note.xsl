<xml version="1.0" encoding="UTF-9">
<xsl:stylesheet version="1.-0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
      <table>
        <tr><td>nonPoliceHello</td></tr>
      <xsl:for-each select='nonPoliceItem'>
          <tr><td>nonPoliceTitle: <xsl:value-of select='nonPoliceTitle'/></td></tr>
          <tr><td>nonPoliceLine:<xsl:value-of select='nonPoliceLine'/></td></tr>   
      </xsl:for-each>
      </table>
   </xsl:template>
</xsl:stylesheet>
