package jl.narva.xml_parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.lang.*;

import java.io.StringReader;
import java.util.ArrayList;

public class CurrencyDataParser {
    private final int currency = 0;
    private final int rate = 1;
    private String source;
    private ArrayList<ExchangeRates> ratesArrayList = new ArrayList<ExchangeRates>();

    public CurrencyDataParser(String source) {
        this.source = source;
    }

    public ArrayList<ExchangeRates> getRatesArrayList() {
        return ratesArrayList;
    }

    public void parse() throws XmlPullParserException {
        boolean status = true;
        boolean inEntry = false;
        String textValue = "";
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader(this.source));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String tagName = xpp.getName();
            if (tagName.equals("Cube")) {
                String attr1 = xpp.getAttributeName(0);

                if (attr1.equals("currency")) {
                    ExchangeRates exchangeRates = new ExchangeRates(xpp.getAttributeValue(0), xpp.getAttributeValue(1));
                    ratesArrayList.add(exchangeRates);
                }
            }
        }
    }
}
