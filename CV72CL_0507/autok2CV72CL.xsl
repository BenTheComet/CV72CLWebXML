<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>

            <head>
                <title>30000 feletti autók</title>
            </head>

            <body>

                <h2>30000-nél drágább autók száma</h2>

                <p>

                    <xsl:value-of select="count(autok/auto[ar &gt; 30000])"/>

                </p>

            </body>

        </html>

    </xsl:template>

</xsl:stylesheet>