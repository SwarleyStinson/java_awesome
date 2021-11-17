package ru.stepanov.core.thirdParty.jpos

import org.jpos.iso.*

/**
 * ISO 8583 v1987 BINARY Packager
 */
internal open class SvfePackager : ISOBasePackager() {
    companion object {
        var fields = arrayOf( /*000*/
                IFA_NUMERIC(4, "MESSAGE TYPE INDICATOR"),  /*001*/
                IFA_BITMAP(8, "BIT MAP"),  /*002*/
                IFA_LLNUM(19, "PAN - PRIMARY ACCOUNT NUMBER"),  /*003*/
                IFA_NUMERIC(6, "PROCESSING CODE"),  /*004*/
                IFA_NUMERIC(12, "AMOUNT, TRANSACTION"),  /*005*/
                IFA_AMOUNT(13, "AMOUNT, SETTLEMENT"),  /*006*/
                IFA_NUMERIC(12, "AMOUNT, CARDHOLDER BILLING"),  /*007*/
                IFA_NUMERIC(10, "TRANSMISSION DATE AND TIME"),  /*008*/
                IFA_NUMERIC(8, "AMOUNT, CARDHOLDER BILLING FEE"),  /*009*/
                IFA_NUMERIC(8, "CONVERSION RATE, SETTLEMENT"),  /*010*/
                IFA_NUMERIC(8, "CONVERSION RATE, CARDHOLDER BILLING"),  /*011*/
                IFA_NUMERIC(6, "SYSTEM TRACE AUDIT NUMBER"),  /*012*/
                IFA_NUMERIC(12, "TIME, LOCAL TRANSACTION"),  /*013*/
                IFA_NUMERIC(4, "DATE, LOCAL TRANSACTION"),  /*014*/
                IFA_NUMERIC(4, "DATE, EXPIRATION"),  /*015*/
                IFA_NUMERIC(6, "DATE, SETTLEMENT"),  /*016*/
                IFA_NUMERIC(4, "DATE, CONVERSION"),  /*017*/
                IFA_NUMERIC(4, "DATE, CAPTURE"),  /*018*/
                IFA_NUMERIC(4, "MERCHANTS TYPE"),  /*019*/
                IFA_NUMERIC(3, "ACQUIRING INSTITUTION COUNTRY CODE"),  /*020*/
                IFA_NUMERIC(3, "PAN EXTENDED COUNTRY CODE"),  /*021*/
                IFA_NUMERIC(3, "FORWARDING INSTITUTION COUNTRY CODE"),  /*022*/
                IFA_NUMERIC(3, "POINT OF SERVICE ENTRY MODE"),  /*023*/
                IFA_NUMERIC(3, "CARD SEQUENCE NUMBER"),  /*024*/
                IFA_NUMERIC(3, "FUNCTION CODE"),  /*025*/
                IFA_NUMERIC(2, "POINT OF SERVICE CONDITION CODE"),  /*026*/
                IFA_NUMERIC(2, "POINT OF SERVICE PIN CAPTURE CODE"),  /*027*/
                IFA_NUMERIC(1, "AUTHORIZATION IDENTIFICATION RESP LEN"),  /*028*/
                IFA_AMOUNT(9, "AMOUNT, TRANSACTION FEE"),  /*029*/
                IFA_AMOUNT(3, "RECONCILIATION INDICATOR"),  /*030*/
                IFA_AMOUNT(13, "AMOUNTS ORIGINAL"),  /*031*/
                IFA_LLLCHAR(999, "SECURITY ADDITIONAL DATA – PRIVATE"),  /*032*/
                IFA_LLNUM(11, "ACQUIRING INSTITUTION IDENT CODE"),  /*033*/
                IFA_LLNUM(11, "FORWARDING INSTITUTION IDENT CODE"),  /*034*/
                IFA_LLCHAR(28, "PAN EXTENDED"),  /*035*/
                IFA_LLCHAR(37, "TRACK 2 DATA"),  /*036*/
                IFA_LLLCHAR(104, "TRACK 3 DATA"),  /*037*/
                IF_CHAR(12, "RETRIEVAL REFERENCE NUMBER"),  /*038*/
                IF_CHAR(6, "AUTHORIZATION IDENTIFICATION RESPONSE"),  /*039*/
                IF_CHAR(3, "RESPONSE CODE"),  /*040*/
                IF_CHAR(3, "SERVICE RESTRICTION CODE"),  /*041*/
                IF_CHAR(8, "CARD ACCEPTOR TERMINAL IDENTIFICACION"),  /*042*/
                IF_CHAR(15, "CARD ACCEPTOR IDENTIFICATION CODE"),  /*043*/
                IF_CHAR(40, "CARD ACCEPTOR NAME/LOCATION"),  /*044*/
                IFA_LLCHAR(99, "ADITIONAL RESPONSE DATA"),  /*045*/
                IFA_LLCHAR(76, "TRACK 1 DATA"),  /*046*/
                IFA_LLLCHAR(999, "ADITIONAL DATA - ISO"),  /*047*/
                IFA_LLLCHAR(999, "ADITIONAL DATA - NATIONAL"),  /*048*/
                IFA_LLLCHAR(999, "ADITIONAL DATA - PRIVATE"),  /*049*/
                IFA_NUMERIC(3, "CURRENCY CODE, TRANSACTION"),  /*050*/
                IF_CHAR(3, "CURRENCY CODE, SETTLEMENT"),  /*051*/
                IF_CHAR(3, "CURRENCY CODE, CARDHOLDER BILLING"),  /*052*/
                IFB_BINARY(8, "PIN DATA"),  /*053*/
                IFA_LLBINARY(16, "SECURITY RELATED CONTROL INFORMATION"),  /*054*/
                IFA_LLLCHAR(120, "ADDITIONAL AMOUNTS"),  /*055*/
                IFA_LLLCHAR(999, "ICC DATA"),  /*056*/
                IFA_LLNUM(35, "ORIGINAL DATA ELEMENTS"),  /*057*/
                IF_CHAR(3, "AUTHORISATION LIFE CYCLE CODE"),  /*058*/
                IFA_LLNUM(11, "AUTHORIZING AGENT INSTITUTION ID"),  /*059*/
                IFA_LLLBINARY(999, "ADDITIONAL DATA"),  /*060*/
                IFA_LLLCHAR(999, "ORIGINAL DATA ELEMENTS"),  /*061*/
                IFA_LLLCHAR(999, "RESERVED PRIVATE"),  /*062*/
                IFA_LLLCHAR(999, "RESERVED PRIVATE"),  /*063*/
                IFA_LLLCHAR(999, "ADDITIONAL DATA"),  /*064*/
                IFA_BINARY(4, "MESSAGE AUTHENTICATION CODE FIELD"),  /*065*/
                IFA_BINARY(1, "BITMAP, EXTENDED"),
                IFA_NUMERIC(1, "SETTLEMENT CODE"),
                IFA_NUMERIC(2, "EXTENDED PAYMENT CODE"),
                IFA_NUMERIC(3, "RECEIVING INSTITUTION COUNTRY CODE"),
                IFA_NUMERIC(3, "SETTLEMENT INSTITUTION COUNTRY CODE"),
                IFB_NUMERIC(3, "NETWORK MANAGEMENT INFORMATION CODE", true),
                IFB_NUMERIC(4, "MESSAGE NUMBER", true),
                IFB_NUMERIC(4, "MESSAGE NUMBER LAST", true),
                IFB_NUMERIC(6, "DATE ACTION", true),
                IFB_NUMERIC(10, "CREDITS NUMBER", true),
                IFB_NUMERIC(10, "CREDITS REVERSAL NUMBER", true),
                IFB_NUMERIC(10, "DEBITS NUMBER", true),
                IFB_NUMERIC(10, "DEBITS REVERSAL NUMBER", true),
                IFB_NUMERIC(10, "TRANSFER NUMBER", true),
                IFB_NUMERIC(10, "TRANSFER REVERSAL NUMBER", true),
                IFB_NUMERIC(10, "INQUIRIES NUMBER", true),
                IFB_NUMERIC(10, "AUTHORIZATION NUMBER", true),
                IFB_NUMERIC(12, "CREDITS, PROCESSING FEE AMOUNT", true),
                IFB_NUMERIC(12, "CREDITS, TRANSACTION FEE AMOUNT", true),
                IFB_NUMERIC(12, "DEBITS, PROCESSING FEE AMOUNT", true),
                IFB_NUMERIC(12, "DEBITS, TRANSACTION FEE AMOUNT", true),
                IFB_NUMERIC(16, "CREDITS, AMOUNT", true),
                IFB_NUMERIC(16, "CREDITS, REVERSAL AMOUNT", true),
                IFB_NUMERIC(16, "DEBITS, AMOUNT", true),
                IFB_NUMERIC(16, "DEBITS, REVERSAL AMOUNT", true),
                IFB_NUMERIC(42, "ORIGINAL DATA ELEMENTS", true),
                IF_CHAR(1, "FILE UPDATE CODE"),
                IF_CHAR(2, "FILE SECURITY CODE"),
                IF_CHAR(6, "RESPONSE INDICATOR"),
                IF_CHAR(7, "SERVICE INDICATOR"),
                IF_CHAR(42, "REPLACEMENT AMOUNTS"),
                IFB_BINARY(16, "MESSAGE SECURITY CODE"),
                IFB_AMOUNT(17, "AMOUNT, NET SETTLEMENT", false),
                IF_CHAR(25, "PAYEE"),
                IFB_LLNUM(11, "SETTLEMENT INSTITUTION IDENT CODE", false),
                IFB_LLNUM(11, "RECEIVING INSTITUTION IDENT CODE", false),
                IFB_LLCHAR(17, "FILE NAME"),
                IFB_LLCHAR(28, "ACCOUNT IDENTIFICATION 1"),
                IFB_LLCHAR(28, "ACCOUNT IDENTIFICATION 2"),
                IFB_LLLCHAR(100, "TRANSACTION DESCRIPTION"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED ISO USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED NATIONAL USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE"),
                IFB_LLLCHAR(999, "RESERVED PRIVATE USE")
        )
    }

    init {
        setFieldPackager(fields)
    }
}