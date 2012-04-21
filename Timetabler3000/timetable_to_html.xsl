<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="rozvrh">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <title>Rozvrh</title>
            </head>
            <body bgcolor="white">
                <div>
                    <TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="2" border="1">
                        <xsl:apply-templates select="hodiny"/>
                        <xsl:apply-templates select="tabulka/den"/>
                
                    </TABLE>
                </div>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="hodiny">
        <TR>
            <TH WIDTH="8%">&#160;</TH>
            <xsl:for-each select="hodina">
                <TD>
                    <xsl:attribute name="COLSPAN">
                        <xsl:if test="position()!=last()">12</xsl:if>
                        <xsl:if test="position()=last()">10</xsl:if>
                    </xsl:attribute>
                    <xsl:attribute name="WIDTH">
                        <xsl:if test="position()!=last()">7%</xsl:if>
                        <xsl:if test="position()=last()">6%</xsl:if></xsl:attribute>
                    <xsl:value-of select="od"/>
                </TD>
            </xsl:for-each>
        </TR>    
    </xsl:template>
    
    <xsl:template match="tabulka/den">
        <xsl:for-each select="radek">
            <TR ALIGN="CENTER">
                <xsl:if test="@num &#60; 2">
                    <TH ROWSPAN="{../@rows}">
                        <xsl:value-of select="../@id"/>
                    </TH>
                </xsl:if>
                <xsl:apply-templates select="*"/>
            </TR>
        </xsl:for-each>
    </xsl:template>
    
    <xsl:template match="radek/*">
                    <xsl:if test="name(.)='break'">
                        <TD COLSPAN="{@diff}">
                            <xsl:attribute name="WIDTH"><xsl:value-of select="@pdiff"/>%</xsl:attribute>&#160;
                        </TD>
                    </xsl:if>
                    <xsl:if test="name(.)='slot'">
                        <TD COLSPAN="{@diff}">
                            <xsl:attribute name="WIDTH"><xsl:value-of select="@pdiff"/>%</xsl:attribute>
                            <div>
                                <FONT SIZE="-2">
                                    <xsl:value-of select="mistnosti/mistnost/mistnostozn"/>
                                </FONT>
                                <BR/>
                                <b>
                                    <a>
                                        <xsl:attribute name="href">https://is.muni.cz/auth/predmety/predmet.pl?id=<xsl:value-of select="akce/predmetid"/>
                                        </xsl:attribute>
                                        <xsl:value-of select="akce/kod"/>
                                    </a>
                                </b>
                                <br/>
                                <xsl:value-of select="akce/nazev"/>
                                <br/>
                                <xsl:value-of select="ucitele/ucitel/uciteljmeno"/>
                            </div>
                        </TD>
                    </xsl:if>
                </xsl:template>
</xsl:stylesheet>
