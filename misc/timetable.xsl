<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="timetable">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <title>Rozvrh</title>
            </head>
            <body bgcolor="white">
                <div>
                    <TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="2" border="1" BGCOLOR="{hours/@bgcolor}">
                        <xsl:apply-templates select="hours"/>
                        <xsl:apply-templates select="days/day"/>
                    </TABLE>
                    <P>
                    <xsl:apply-templates select="notes/note"/>
                    </P>
                </div>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="hours">
        <TR>
            <TH WIDTH="8%">&#160;</TH>
            <xsl:for-each select="hour">
                <TD COLSPAN="{@diff}">
                    <xsl:attribute name="WIDTH">
                        <xsl:value-of select="@pdiff"/>%
                    </xsl:attribute>
                    <xsl:value-of select="."/>
                </TD>
            </xsl:for-each>
        </TR>    
    </xsl:template>
    
    <xsl:template match="days/day">
        <xsl:for-each select="row">
            <TR ALIGN="CENTER">
                <xsl:if test="@num &#60; 2">
                    <TH ROWSPAN="{../@rows}">
                        <xsl:value-of select="../@id"/>
                    </TH>
                </xsl:if>
                <xsl:apply-templates select="cell"/>
            </TR>
        </xsl:for-each>
    </xsl:template>
    
    <xsl:template match="row/cell">
        <xsl:if test="name(./*)='break'">
            <TD COLSPAN="{@diff}">
                <xsl:attribute name="WIDTH">
                    <xsl:value-of select="@pdiff"/>%
                </xsl:attribute>&#160;
            </TD>
        </xsl:if>
        <xsl:if test="name(./*)='course'">
            <TD BGCOLOR="{course/@color}" COLSPAN="{@diff}">
                <xsl:attribute name="WIDTH">
                    <xsl:value-of select="@pdiff"/>%
                </xsl:attribute>
                    <FONT SIZE="-2">
                        <xsl:apply-templates select="course/rooms/room"/>
                    </FONT>
                    <BR/>
                    <b>
                        <a>
                            <xsl:attribute name="href">https://is.muni.cz/auth/predmety/predmet.pl?id=<xsl:value-of select="course/courseid"/>
                            </xsl:attribute>
                            <xsl:value-of select="course/code"/>
                        </a>
                    </b>
                    <br/>
                    <xsl:value-of select="course/name"/>
                    <br/>
                    <a>
                        <xsl:if test="course/teacher/@id">
                            <xsl:attribute name="href">https://is.muni.cz/auth/osoba/<xsl:value-of select="course/teacher/@id"/>
                            </xsl:attribute>
                        </xsl:if>
                        <xsl:value-of select="course/teacher"/>
                    </a>
                <xsl:if test="course/@note">&#160;
                    <FONT COLOR="red">
                        <SUP>
                            <xsl:value-of select="course/@note"/>
                        </SUP>
                    </FONT>
                </xsl:if>
            </TD>
        </xsl:if>
    </xsl:template>
                
    <xsl:template match="course/rooms/room">
        <a>
            <xsl:if test="@id">
                <xsl:attribute name="href">https://is.muni.cz/kontakty/mistnost.pl?id=<xsl:value-of select="@id"/>
                </xsl:attribute>
            </xsl:if>
            <xsl:value-of select="."/>
        </a>&#160;
        <xsl:value-of select="course/rooms/room"/>
    </xsl:template>
    
    <xsl:template match="notes/note">
            <SUP><xsl:value-of select="@id"/></SUP><xsl:value-of select="."/><BR/>
    </xsl:template>
        
</xsl:stylesheet>
