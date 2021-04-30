package ru.stepanov.java_awesome.thirdParty.jpos;

import lombok.SneakyThrows;
import lombok.val;
import org.jpos.iso.ISOMsg;

public class Iso8583Decoder {
    @SneakyThrows
    public static void main(String[] args) {
        val m = new ISOMsg();
        m.setPackager(new SvfePackager() {{
//            headerLength = 4;
        }});
        m.setDirection(ISOMsg.INCOMING);

        val message = "02007224068028C0820016553691376269030900000000000000200003231037370000042211007000010037353533363931333736323639303330394432323131323031313739383732313130303030303030303030313030303030343832343834353339424750202020202020202020202020064301309F260868911D0C5CF0A1769F2701409F10120110904003220000000000000006220000FF9F37040FBFFE579F360200C8950500000000009A032103239C01009F02060000000020009F03060000000000005F2A020643820219809F1A0206439F33030008C85F3401018407A00000000410109F0607A00000000410109F34031F0302333333333333"
                .getBytes();

        val res = m.unpack(message);
        val field2 = m.getString(2);
        val field14 = m.getString(14);
        val field35 = m.getString(35);
        val field55 = m.getString(55);

        System.out.println(1);
    }
}
